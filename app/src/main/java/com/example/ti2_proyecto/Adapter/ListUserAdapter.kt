package com.example.ti2_proyecto.Adapter

import android.app.Activity
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.EditText
import com.example.ti2_proyecto.R
import com.example.ti2_proyecto.entities.User
import kotlinx.android.synthetic.main.user_select.view.*
import java.util.zip.Inflater

class ListUserAdapter (internal var activity:Activity,
                       internal var lstUser:List<User>,
                       internal var edt_id:EditText,
                       internal var edt_name:EditText,
                       internal var edt_gender:EditText,
                       internal var edt_color:EditText,
                       internal var edt_parent:EditText,
                       internal var edt_image:EditText,
                       internal var edt_level:EditText,
                       internal var edt_session:EditText) : BaseAdapter(){

    internal var inflater:LayoutInflater

    init {
        inflater = activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val rowView:View
        rowView = inflater.inflate(R.layout.user_select, null)

        rowView.txt_row_id.text = lstUser[position].id.toString()
        rowView.txt_name.text = lstUser[position].name.toString()
        rowView.txt_gender.text = lstUser[position].gender.toString()
        rowView.txt_color.text = lstUser[position].color.toString()
        rowView.txt_parent.text = lstUser[position].parent.toString()
        rowView.txt_image.text = lstUser[position].image.toString()
        rowView.txt_level.text = lstUser[position].level.toString()
        rowView.txt_session.text = lstUser[position].session.toString()

        rowView.setOnClickListener{
            edt_id.setText(rowView.txt_row_id.text.toString())
            edt_name.setText(rowView.txt_name.text.toString())
            edt_gender.setText(rowView.txt_gender.text.toString())
            edt_color.setText(rowView.txt_color.text.toString())
            edt_parent.setText(rowView.txt_parent.text.toString())
            edt_image.setText(rowView.txt_image.text.toString())
            edt_level.setText(rowView.txt_level.text.toString())
            edt_session.setText(rowView.txt_session.text.toString())
        }
        return rowView
    }

    override fun getItem(position: Int): Any {
        return lstUser[position]
    }

    override fun getItemId(position: Int): Long {
        return lstUser[position].id.toLong()
    }

    override fun getCount(): Int {
        return lstUser.size
    }

}