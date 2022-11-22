package com.example.myvatapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        iv_Saudia.setOnClickListener {

            val intent = Intent(applicationContext, SaudiaActivity::class.java)
            startActivity(intent)
        }
        iv_egypt.setOnClickListener {
            val intent = Intent(applicationContext, EgyptActivity::class.java)
            startActivity(intent)
        }
        iv_europe.setOnClickListener {
            val intent = Intent(applicationContext, EuropeActivity::class.java)
            startActivity(intent)
        }
        iv_usa.setOnClickListener {
            val intent = Intent(this, USAActivity::class.java)
            startActivity(intent)
        }
        iv_india.setOnClickListener {

            val intent = Intent(this, IndiaActivity::class.java)
            startActivity(intent)
        }
    }
}
