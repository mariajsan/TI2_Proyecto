package com.example.ti2_proyecto

import android.content.Intent
import android.media.AudioManager
import android.media.MediaPlayer
import android.media.SoundPool
import android.os.Bundle
import android.os.Handler
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.ui.AppBarConfiguration
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.content_main.*


class MainActivity : AppCompatActivity() {


    private var soundPool: SoundPool? = null
    private var soundId = 0
    private var click1 = 0
    private var click2 = 0
    private var click3 = 0
    private var click4 = 0
    private var click5 = 0
    var mp1: MediaPlayer? = null
    var mp2: MediaPlayer? = null
    var mp3: MediaPlayer? = null
    var mp4: MediaPlayer? = null
    var mp5: MediaPlayer? = null
    private val handler = Handler()

    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        soundPool = SoundPool(6, AudioManager.STREAM_MUSIC, 0)
        soundPool!!.load(baseContext, R.raw.lug_casa, 1)
        soundPool!!.load(baseContext, R.raw.lug_instituto, 1)
        soundPool!!.load(baseContext, R.raw.lug_kiosko, 1)
        soundPool!!.load(baseContext, R.raw.obj_balon, 1)
        soundPool!!.load(baseContext, R.raw.obj_biberon, 1)
        soundPool!!.load(baseContext, R.raw.obj_foco, 1)
        soundPool!!.load(baseContext, R.raw.obj_fuego, 1)
        soundPool!!.load(baseContext, R.raw.obj_galleta, 1)
        soundPool!!.load(baseContext, R.raw.obj_kiwi, 1)
        soundPool!!.load(baseContext, R.raw.obj_lampara, 1)
        soundPool!!.load(baseContext, R.raw.obj_lapiz, 1)
        soundPool!!.load(baseContext, R.raw.obj_lata, 1)
        soundPool!!.load(baseContext, R.raw.obj_libro, 1)
        soundPool!!.load(baseContext, R.raw.obj_limon, 1)
        soundPool!!.load(baseContext, R.raw.obj_luna, 1)
        soundPool!!.load(baseContext, R.raw.obj_mano, 1)
        soundPool!!.load(baseContext, R.raw.obj_mesa, 1)
        soundPool!!.load(baseContext, R.raw.obj_naranja, 1)
        soundPool!!.load(baseContext, R.raw.obj_nube, 1)
        soundPool!!.load(baseContext, R.raw.obj_ojo, 1)
        soundPool!!.load(baseContext, R.raw.obj_olla, 1)
        soundPool!!.load(baseContext, R.raw.obj_oreja, 1)
        soundPool!!.load(baseContext, R.raw.obj_oso, 1)
        soundPool!!.load(baseContext, R.raw.obj_pato, 1)
        soundPool!!.load(baseContext, R.raw.obj_payaso, 1)
        soundPool!!.load(baseContext, R.raw.obj_pelota, 1)
        soundPool!!.load(baseContext, R.raw.obj_pera, 1)
        soundPool!!.load(baseContext, R.raw.obj_pez, 1)
        soundPool!!.load(baseContext, R.raw.obj_queso, 1)
        soundPool!!.load(baseContext, R.raw.obj_rana, 1)
        soundPool!!.load(baseContext, R.raw.obj_sandia, 1)
        soundPool!!.load(baseContext, R.raw.obj_sandwich, 1)
        soundPool!!.load(baseContext, R.raw.obj_silla, 1)
        soundPool!!.load(baseContext, R.raw.obj_sol, 1)
        soundPool!!.load(baseContext, R.raw.obj_sonaja, 1)
        soundPool!!.load(baseContext, R.raw.obj_taza, 1)
        soundPool!!.load(baseContext, R.raw.obj_telefono, 1)
        soundPool!!.load(baseContext, R.raw.obj_uva, 1)
        soundPool!!.load(baseContext, R.raw.obj_vaca, 1)
        soundPool!!.load(baseContext, R.raw.obj_vela, 1)
        soundPool!!.load(baseContext, R.raw.obj_ventana, 1)
        soundPool!!.load(baseContext, R.raw.obj_wafle, 1)
        soundPool!!.load(baseContext, R.raw.obj_wifi, 1)
        soundPool!!.load(baseContext, R.raw.obj_zanahoria, 1)
        soundPool!!.load(baseContext, R.raw.obj_zapato, 1)
        soundPool!!.load(baseContext, R.raw.per_gato, 1)
        soundPool!!.load(baseContext, R.raw.per_madre, 1)
        soundPool!!.load(baseContext, R.raw.per_ninio, 1)
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


    }
    private fun setUpBtn(v:View, name:Int){
        when(click1){
            0 -> {btn1.background = v.background; click1 = name}
            else -> when (click2){
                0 -> {btn2.background = v.background; click2 = name}
                else -> when (click3){
                    0 -> {btn3.background = v.background; click3 = name}
                    else -> when (click4){
                        0 -> {btn4.background = v.background; click4 = name}
                        else -> when (click5){
                            0 -> {btn5.background = v.background; click5 = name;
                                handler.postDelayed(Runnable {
                                    soundPool?.play(click1, 1F, 1F, 0, 0, 1F)
                                }, 1000)

                                handler.postDelayed(Runnable {
                                    soundPool?.play(click2, 1F, 1F, 0, 0, 1F)
                                }, 2000)
                                handler.postDelayed(Runnable {
                                    soundPool?.play(click3, 1F, 1F, 0, 0, 1F)
                                }, 3000)
                                handler.postDelayed(Runnable {
                                    soundPool?.play(click4, 1F, 1F, 0, 0, 1F)
                                }, 4000)
                                handler.postDelayed(Runnable {
                                    soundPool?.play(click5, 1F, 1F, 0, 0, 1F)
                                }, 5000)
                                handler.postDelayed(Runnable {
                                    click1 = 0;
                                    click2 = 0;
                                    click3 = 0;
                                    click4 = 0;
                                    click5 = 0;
                                    btn1.background = resources.getDrawable(R.drawable.ic_launcher_foreground);
                                    btn2.background = resources.getDrawable(R.drawable.ic_launcher_foreground);
                                    btn3.background = resources.getDrawable(R.drawable.ic_launcher_foreground);
                                    btn4.background = resources.getDrawable(R.drawable.ic_launcher_foreground);
                                    btn5.background = resources.getDrawable(R.drawable.ic_launcher_foreground);
                                }, 6000)

                            }
                        }
                    }
                }
            }
        }
    }

    fun playPile(view: View){
        var count: Int = 1000
        if(click1 != 0){
            count += 1000
            handler.postDelayed(Runnable {
                soundPool?.play(click1, 1F, 1F, 0, 0, 1F)
            }, 1000)
        }
        if(click2 != 0){
            count += 1000
            handler.postDelayed(Runnable {
                soundPool?.play(click2, 1F, 1F, 0, 0, 1F)
            }, 2000)
        }
        if(click3 != 0){
            count += 1000
            handler.postDelayed(Runnable {
                soundPool?.play(click3, 1F, 1F, 0, 0, 1F)
            }, 3000)
        }
        if(click4 != 0){
            count += 1000
            handler.postDelayed(Runnable {
                soundPool?.play(click4, 1F, 1F, 0, 0, 1F)
            }, 4000)
        }
        if(click5 != 0){
            count += 1000
            handler.postDelayed(Runnable {
                soundPool?.play(click5, 1F, 1F, 0, 0, 1F)
            }, 1000)
        }
        handler.postDelayed(Runnable {
            click1 = 0;
            click2 = 0;
            click3 = 0;
            click4 = 0;
            click5 = 0;
            btn1.background = resources.getDrawable(R.drawable.ic_launcher_foreground);
            btn2.background = resources.getDrawable(R.drawable.ic_launcher_foreground);
            btn3.background = resources.getDrawable(R.drawable.ic_launcher_foreground);
            btn4.background = resources.getDrawable(R.drawable.ic_launcher_foreground);
            btn5.background = resources.getDrawable(R.drawable.ic_launcher_foreground);
        }, count.toLong())
    }

    fun playSound(v:View) {
        when (v.id) {
            R.id.lug_casa -> {soundId = 1; setUpBtn(v, soundId)}
            R.id.lug_instituto -> {soundId  = 2; setUpBtn(v, soundId)}
            R.id.lug_kiosko -> {soundId  = 3; setUpBtn(v, soundId)}
            R.id.obj_balon -> {soundId  = 4; setUpBtn(v, soundId)}
            R.id.obj_biberon -> {soundId  = 5; setUpBtn(v, soundId)}
            R.id.obj_foco -> {soundId  = 6; setUpBtn(v, soundId)}
            R.id.obj_fuego -> {soundId  = 7; setUpBtn(v, soundId)}
            R.id.obj_galleta -> {soundId  = 8; setUpBtn(v, soundId)}
            R.id.obj_kiwi -> {soundId  = 9; setUpBtn(v, soundId)}
            R.id.obj_lampara -> {soundId  = 10; setUpBtn(v, soundId)}
            R.id.obj_lapiz -> {soundId  = 11; setUpBtn(v, soundId)}
            R.id.obj_lata -> {soundId  = 12; setUpBtn(v, soundId)}
            R.id.obj_libro -> {soundId  = 13; setUpBtn(v, soundId)}
            R.id.obj_limon -> {soundId  = 14; setUpBtn(v, soundId)}
            R.id.obj_luna -> {soundId  = 15; setUpBtn(v, soundId)}
            R.id.obj_mano -> {soundId  = 16; setUpBtn(v, soundId)}
            R.id.obj_mesa -> {soundId  = 17; setUpBtn(v, soundId)}
            R.id.obj_naranja -> {soundId  = 18; setUpBtn(v, soundId)}
            R.id.obj_nube -> {soundId  = 19; setUpBtn(v, soundId)}
            R.id.obj_ojo -> {soundId  = 20; setUpBtn(v, soundId)}
            R.id.obj_olla -> {soundId  = 21; setUpBtn(v, soundId)}
            R.id.obj_oreja -> {soundId  = 22; setUpBtn(v, soundId)}
            R.id.obj_oso -> {soundId  = 23; setUpBtn(v, soundId)}
            R.id.obj_pato -> {soundId  = 24; setUpBtn(v, soundId)}
            R.id.obj_payaso -> {soundId  = 25; setUpBtn(v, soundId)}
            R.id.obj_pelota -> {soundId  = 26; setUpBtn(v, soundId)}
            R.id.obj_pera -> {soundId  = 27; setUpBtn(v, soundId)}
            R.id.obj_pez -> {soundId  = 28; setUpBtn(v, soundId)}
            R.id.obj_queso -> {soundId  = 29; setUpBtn(v, soundId)}
            R.id.obj_rana -> {soundId  = 30; setUpBtn(v, soundId)}
            R.id.obj_sandia -> {soundId  = 31; setUpBtn(v, soundId)}
            R.id.obj_sandwich -> {soundId  = 32; setUpBtn(v, soundId)}
            R.id.obj_silla -> {soundId  = 33; setUpBtn(v, soundId)}
            R.id.obj_sol -> {soundId  = 34; setUpBtn(v, soundId)}
            R.id.obj_sonaja -> {soundId  = 35; setUpBtn(v, soundId)}
            R.id.obj_taza -> {soundId  = 36; setUpBtn(v, soundId)}
            R.id.obj_telefono -> {soundId  = 37; setUpBtn(v, soundId)}
            R.id.obj_uva -> {soundId  = 38; setUpBtn(v, soundId)}
            R.id.obj_vaca -> {soundId  = 39; setUpBtn(v, soundId)}
            R.id.obj_vela -> {soundId  = 40; setUpBtn(v, soundId)}
            R.id.obj_ventana -> {soundId  = 41; setUpBtn(v, soundId)}
            R.id.obj_waffle -> {soundId  = 42; setUpBtn(v, soundId)}
            R.id.obj_wifi -> {soundId  = 43; setUpBtn(v, soundId)}
            R.id.obj_zanahoria -> {soundId  = 44; setUpBtn(v, soundId)}
            R.id.obj_zapato -> {soundId  = 45; setUpBtn(v, soundId)}
            R.id.per_gato -> {soundId  = 46; setUpBtn(v, soundId)}
            R.id.per_madre -> {soundId  = 47; setUpBtn(v, soundId)}
            R.id.per_ninio -> {soundId  = 48; setUpBtn(v, soundId)}
        }
        soundPool?.play(soundId, 1F, 1F, 0, 0, 1F)
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
    }



    //override fun onSupportNavigateUp(): Boolean {
        //val navController = findNavController(R.id.nav_host_fragment)
        //return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    //}
}
