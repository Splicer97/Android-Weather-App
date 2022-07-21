package com.splicer.androidweatherapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.splicer.androidweatherapp.databinding.ActivityMainBinding
import com.splicer.androidweatherapp.fragments.MainFragment
import org.json.JSONObject

const val API_KEY = "b0676713ebfe49efbf8174320221907"

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportFragmentManager.beginTransaction().replace(R.id.place, MainFragment.newInstance()).commit()
    }

    private fun getResult(name: String) {
        val url = "https://api.weatherapi.com/v1/current.json?key= $API_KEY&q=$name&aqi=no"
        val queue = Volley.newRequestQueue(this)
        val stringRequest = StringRequest(
            Request.Method.GET,
            url,
            { responce ->
                val obj = JSONObject(responce)
                val temp = obj.getJSONObject("current")
                Log.d("MyLog", "Responce $responce") },
            { Log.d("MyLog", "Volley Error $it") })
        queue.add(stringRequest)
    }
}