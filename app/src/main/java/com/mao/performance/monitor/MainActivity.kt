package com.mao.performance.monitor

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.mao.performance.monitor.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle ? ) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initView()
    }

    private fun initView() {
        binding.iconImage.setImageResource(R.mipmap.ic_launcher)
    }

}