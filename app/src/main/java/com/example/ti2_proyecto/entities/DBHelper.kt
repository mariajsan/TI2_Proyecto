package com.example.ti2_proyecto.entities

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import androidx.core.content.contentValuesOf

class DBHelper(context: Context): SQLiteOpenHelper (context, DATABASE_NAME, null, DATABASE_VER) {
    companion object {
        private val DATABASE_VER = 1
        private val DATABASE_NAME = "AndroidApp"

        private val TABLE_NAME = "User"
        private val COLUMN_ID = "id"
        private val COLUMN_NAME = "name"
        private val COLUMN_GENDER = "gender"
        private val COLUMN_COLOR = "color"
        private val COLUMN_PARENT = "parent"
        private val COLUMN_IMAGE = "image"
        private val COLUMN_LEVEL = "level"
        private val COLUMN_SESSION = "session"
    }

    override fun onCreate(db: SQLiteDatabase?) {
        val CREATE_TABLE_QUERY= ("CREATE TABLE IF NOT EXISTS $TABLE_NAME ($COLUMN_ID INTEGER PRIMARY KEY, $COLUMN_NAME TEXT," +
                "$COLUMN_GENDER TEXT, $COLUMN_COLOR TEXT, $COLUMN_PARENT TEXT, $COLUMN_IMAGE TEXT, $COLUMN_LEVEL TEXT," +
                "$COLUMN_SESSION INTEGER)")
        db!!.execSQL(CREATE_TABLE_QUERY)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db!!.execSQL("DROP TABLE IF EXISTS $TABLE_NAME")
    }

    val AllUsers:List<User>
    get(){
        val lstUsers = ArrayList<User>()
        val selectquery = "SELECT * FROM $TABLE_NAME"
        val db = this.writableDatabase
        val cursor = db.rawQuery(selectquery, null)
        if (cursor.moveToFirst()){
            do {
                val user = User()
                user.id = cursor.getInt(cursor.getColumnIndex(COLUMN_ID))
                user.name = cursor.getString(cursor.getColumnIndex(COLUMN_NAME))
                user.gender = cursor.getString(cursor.getColumnIndex(COLUMN_GENDER))
                user.color = cursor.getString(cursor.getColumnIndex(COLUMN_COLOR))
                user.parent = cursor.getString(cursor.getColumnIndex(COLUMN_PARENT))
                user.image = cursor.getString(cursor.getColumnIndex(COLUMN_IMAGE))
                user.level = cursor.getInt(cursor.getColumnIndex(COLUMN_LEVEL))
                user.session = cursor.getInt(cursor.getColumnIndex(COLUMN_SESSION))

                lstUsers.add(user)
            }
                while (cursor.moveToNext())
        }
        db.close()
        return lstUsers
    }

    fun addUser(user:User){
        val db = this.writableDatabase
        val values = ContentValues()
        values.put(COLUMN_ID, user.id)
        values.put(COLUMN_NAME, user.name)
        values.put(COLUMN_GENDER, user.gender)
        values.put(COLUMN_COLOR, user.color)
        values.put(COLUMN_PARENT, user.parent)
        values.put(COLUMN_IMAGE, user.image)
        values.put(COLUMN_LEVEL, user.level)
        values.put(COLUMN_SESSION, user.session)

        db.insert(TABLE_NAME, null, values)
        db.close()
    }

    fun updateUser(user:User): Int {
        val db = this.writableDatabase
        val values = ContentValues()
        values.put(COLUMN_ID, user.id)
        values.put(COLUMN_NAME, user.name)
        values.put(COLUMN_GENDER, user.gender)
        values.put(COLUMN_COLOR, user.color)
        values.put(COLUMN_PARENT, user.parent)
        values.put(COLUMN_IMAGE, user.image)
        values.put(COLUMN_LEVEL, user.level)
        values.put(COLUMN_SESSION, user.session)

        return db.update(TABLE_NAME, values, "$COLUMN_ID=?", arrayOf(user.id.toString()))
    }

    fun deleteUser(user:User) {
        val db = this.writableDatabase

        db.delete(TABLE_NAME, "$COLUMN_ID=?", arrayOf(user.id.toString()))
    }
}