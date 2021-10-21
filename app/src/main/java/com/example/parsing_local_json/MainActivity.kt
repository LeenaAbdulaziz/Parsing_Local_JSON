package com.example.parsing_local_json

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager

import com.google.gson.Gson
import com.google.gson.JsonArray
import com.google.gson.reflect.TypeToken
import org.json.JSONArray

class MainActivity : AppCompatActivity() {
        private lateinit var recycle: RecyclerView
        lateinit var img: ArrayList<Image_details>
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_main)
            recycle=findViewById(R.id.rv)
            img= arrayListOf()

            val jsonFileString = Utils().getJsonDataFromAsset(applicationContext, "data.json")
            val jsonArray=JSONArray(jsonFileString)

            for(i in 0 until jsonArray.length()) {
                val url = jsonArray.getJSONObject(i).getString("url")

                img.add(Image_details(url))
                println(img[0].ulr)

            }
            recycle.adapter = RVAdapter(this, img)
            recycle.layoutManager = LinearLayoutManager(this)
        }
}