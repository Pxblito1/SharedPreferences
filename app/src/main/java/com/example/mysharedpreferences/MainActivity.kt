package com.example.mysharedpreferences

import android.app.ActionBar
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import com.example.mysharedpreferences.SharedPreferences.Companion.prefs
import com.example.mysharedpreferences.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initUI()
        checkUserValues()
        val adaptador : ArrayAdapter<*> = ArrayAdapter.createFromResource(
            this,R.array.colores,android.R.layout.simple_spinner_item
        )
        binding.spinner.adapter = adaptador
        binding.spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ){
                Toast.makeText(this@MainActivity,"selección: ".plus(position.toString()),
                    Toast.LENGTH_SHORT).show()
            }

            override fun onNothingSelected(parent:AdapterView<*>?) {
                Toast.makeText(this@MainActivity, "sin selección", Toast.LENGTH_SHORT).show()
            }
        }


    }
    fun initUI(){
        binding.btniniciar.setOnClickListener {
            accessSharedPreferences()
        }
    }
    fun checkUserValues(){
        if(prefs.getName().isNotEmpty()){
            goAccess()
        }
    }
    fun accessSharedPreferences(){
        if (binding.etName.text.toString().isNotEmpty()){
            prefs.saveName(binding.etName.text.toString())
            prefs.saveColor(binding.checkBox.isChecked)
            goAccess()
        } else {
            Toast.makeText(this,"Rellena el nombre, porfavore",Toast.LENGTH_SHORT).show()
        }
    }
    private fun goAccess(){
        startActivity(Intent(this, AcessActivity::class.java))

    }
}