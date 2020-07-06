package com.rajaman.wetherreport

import android.app.DownloadManager
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import org.json.JSONObject


@Suppress("RECEIVER_NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
class DetailsAct : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        val i = intent.extras
        val myname = i?.getString("Name")
        val pressure = findViewById<TextView>(R.id.details_pressure)
        val Temp = findViewById<TextView>(R.id.details_temp)
        val name = findViewById<TextView>(R.id.details_city)
        name.text = myname

        val url =
            "https://api.openweathermap.org/data/2.5/weather?q=${myname}&appid=206004f784e605d4b88f4442a9132405"

        val queue = Volley.newRequestQueue(this)

        val jsonObjectRequest: JsonObjectRequest = JsonObjectRequest(
            Request.Method.GET, url, null,
            Response.Listener { response ->
                val main: JSONObject = response.getJSONObject("main")
                Temp.text = main.get("temp").toString() + "K^"
                pressure.text = main.get("pressure").toString()+ "Psc"

            },
            Response.ErrorListener {

                name.text = "Error Not found"
            }
        )

        queue.add(jsonObjectRequest)
    }
}