package com.example.ti2_proyecto.ui.user_config_class

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.ti2_proyecto.Adapter.ListUserAdapter
import com.example.ti2_proyecto.R
import com.example.ti2_proyecto.entities.DBHelper
import com.example.ti2_proyecto.entities.User
import kotlinx.android.synthetic.main.user_configuration.*

class Users_Activity : AppCompatActivity() {

    private var root: View? = null   // create a global variable which will hold your layout

    private lateinit var slideshowViewModel: SlideshowViewModel

    internal lateinit var db:DBHelper
    internal var lstUsers:List<User> = ArrayList<User>()

    fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        root = inflater.inflate(R.layout.user_configuration, container, false)  // initialize it here
        return root
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.user_select)
        db = DBHelper(this)
        refreshData()

        //Event
        add_user.setOnClickListener(
        ) {
            val user = User(
                Integer.parseInt(edt_id.text.toString()),
                edt_name.text.toString(),
                edt_gender.text.toString(),
                edt_color.text.toString(),
                edt_parent.text.toString(),
                edt_image.text.toString(),
                Integer.parseInt(edt_level.text.toString()),
                Integer.parseInt(edt_session.text.toString())
            )
            db.addUser(user)
            refreshData()
        }

        update_user.setOnClickListener(){
            val user = User(
                Integer.parseInt(edt_id.text.toString()),
                edt_name.text.toString(),
                edt_gender.text.toString(),
                edt_color.text.toString(),
                edt_parent.text.toString(),
                edt_image.text.toString(),
                Integer.parseInt(edt_level.text.toString()),
                Integer.parseInt(edt_session.text.toString())
            )
            db.updateUser(user)
            refreshData()
        }

        delete_user.setOnClickListener(){
            val user = User(
                Integer.parseInt(edt_id.text.toString()),
                edt_name.text.toString(),
                edt_gender.text.toString(),
                edt_color.text.toString(),
                edt_parent.text.toString(),
                edt_image.text.toString(),
                Integer.parseInt(edt_level.text.toString()),
                Integer.parseInt(edt_session.text.toString())
            )
            db.deleteUser(user)
            refreshData()
        }
    }

    private fun refreshData() {
        lstUsers = db.AllUsers
        val adapter = ListUserAdapter(this@Users_Activity,lstUsers,edt_id,edt_name,edt_gender,edt_color,edt_parent,edt_image,edt_level,edt_session)
        List_Users.adapter = adapter
    }

}
