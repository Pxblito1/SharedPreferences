package com.example.mysharedpreferences

import android.content.Context
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import java.sql.Connection

class Prefs(val context : Context) {
    val DATABASE = "MyDB"
    val USER_NAME = "UserName"
    val CHECK_COLOR = "Color"
    val storage = context.getSharedPreferences(DATABASE,Context.MODE_PRIVATE)
    fun saveName (name:String){
        storage.edit().putString(USER_NAME, name).apply()
    }
    fun saveColor(color:Boolean){
        storage.edit().putBoolean(CHECK_COLOR,color).apply()
    }
    fun getName():String{
        return storage.getString(USER_NAME,"")!!
    }
    fun getColorCheck(): Boolean{
        return storage.getBoolean(CHECK_COLOR,false)
    }
    fun wipeData() {
        storage.edit().clear().apply()
    }

}