package com.example.mysharedpreferences

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import com.example.mysharedpreferences.SharedPreferences.Companion.prefs
import com.example.mysharedpreferences.databinding.ActivityAcessBinding
import com.example.mysharedpreferences.databinding.ActivityMainBinding

class AcessActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAcessBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAcessBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initUI()
    }
    fun initUI(){
        binding.button2.setOnClickListener {
            prefs.wipeData()
            onBackPressed()
        }
        val userName = prefs.getName()
        binding.textView.text= "¡Hola $userName!"
        if (prefs.getColorCheck()){
            binding.cv2.setBackgroundColor(
                ContextCompat.getColor(this,R.color.orange)
            )
        }
    }
}