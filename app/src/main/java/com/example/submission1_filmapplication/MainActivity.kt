package com.example.submission1_filmapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.submission1_filmapplication.adapter.AdapterPager
import com.example.submission1_filmapplication.adapter.AdapterTab
import com.example.submission1_filmapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        val page = AdapterPager(this, supportFragmentManager)
        setContentView(binding.root)

        supportActionBar?.title = "List Film"

        binding.Vp.adapter = page
        binding.tabLayout.setupWithViewPager(binding.Vp)
    }
}