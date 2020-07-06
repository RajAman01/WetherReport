package com.rajaman.wetherreport

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val cityName = findViewById<EditText>(R.id.main_city)

        main_btn.setOnClickListener {
            val name = cityName.text.toString()
            val intent = Intent(this, DetailsAct::class.java)
            intent.putExtra("Name",name)
            startActivity(intent)
        }

    }
}