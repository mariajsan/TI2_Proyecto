package com.example.ti2_proyecto

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.ui.AppBarConfiguration
import com.google.android.material.navigation.NavigationView
import android.media.MediaPlayer
import kotlinx.android.synthetic.main.content_main.*
import android.view.MotionEvent
import com.example.ti2_proyecto.Adapter.ListUserAdapter
import com.example.ti2_proyecto.entities.DBHelper
import com.example.ti2_proyecto.entities.User
import com.example.ti2_proyecto.ui.user_config_class.Users_Activity
import kotlinx.android.synthetic.main.user_configuration.*

class MainActivity : AppCompatActivity() {

    internal lateinit var db:DBHelper
    internal var listUsers:List<User> = ArrayList<User>()

    private var mediaPlayer: MediaPlayer? = null
    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        val navView: NavigationView = findViewById(R.id.nav_view)
        //val navController = findNavController(R.id.nav_host_fragment)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        appBarConfiguration = AppBarConfiguration(setOf(
                R.id.nav_addbutton, R.id.nav_editbutton, R.id.nav_perfil), drawerLayout)
        //setupActionBarWithNavController(navController, appBarConfiguration)
       // navView.setupWithNavController(navController)

        mediaPlayer = MediaPlayer.create(this, R.raw.lug_casa)
        mediaPlayer?.setOnPreparedListener{

            db = DBHelper(this)

            refreshData()
        }

        lug_casa.setOnTouchListener {_, event ->
            handleTouch(event)
            true
        }

    }

    private fun refreshData(){
        listUsers = db.AllUsers
        val adapter = ListUserAdapter(this@MainActivity,listUsers,edt_id,edt_name,edt_gender,edt_color,edt_parent,edt_image,edt_level,edt_session)
        List_Users.adapter = adapter

    }

    private fun handleTouch(event: MotionEvent) {
        when(event.action) {
            MotionEvent.ACTION_DOWN -> {
                println("down")
                mediaPlayer?.start()
            }
            MotionEvent.ACTION_CANCEL, MotionEvent.ACTION_UP ->{
                println("up or cancel")
                mediaPlayer?.pause()
                mediaPlayer?.seekTo(0)
            }
            else ->{
                println("other")
            }
        }
    }


    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle item selection
        return when (item.itemId) {
            R.id.config -> {
                val intent = Intent(this, configuracion::class.java)
            startActivity(intent)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }

        return when (item.itemId) {
            R.id.nav_perfil -> {
                val intent = Intent(this, Users_Activity::class.java)
                startActivity(intent)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }



    fun abriropciones(){

    }

    //override fun onSupportNavigateUp(): Boolean {
        //val navController = findNavController(R.id.nav_host_fragment)
        //return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    //}
}
