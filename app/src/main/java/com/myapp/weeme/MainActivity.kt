package com.myapp.weeme

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import com.myapp.weeme.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //SystemClock.sleep(2000)//Establecemos un retardo para la carga de la activity
        setTheme(R.style.Theme_WeeMe)//Establecemos el tema para que deje de usar el de la Splash Screen
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

    }
}