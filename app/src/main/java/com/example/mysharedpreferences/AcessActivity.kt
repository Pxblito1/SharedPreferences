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
        if (prefs.getColorCheck()) {
            val theColor = getMyColor(prefs.getColor())
            binding.cv2.setBackgroundColor(
                ContextCompat.getColor(this, R.color.orange)
            )
        }
        }
        fun getMyColor(color:String):Int{
            val resourceColor = when(color){
                "lila1"-> R.color.purple_200
                "lila2"-> R.color.purple_500
                "lila3"-> R.color.purple_700
                "teal1"-> R.color.teal_200
                "teal2"-> R.color.teal_700
                "negro"-> R.color.black
                "naranja"-> R.color.orange
                else ->  R.color.white
            }
            return resourceColor
        }
    }