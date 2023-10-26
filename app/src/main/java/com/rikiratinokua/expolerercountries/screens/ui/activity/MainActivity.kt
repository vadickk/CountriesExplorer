package com.rikiratinokua.expolerercountries.screens.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.rikiratinokua.expolerercountries.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }
}