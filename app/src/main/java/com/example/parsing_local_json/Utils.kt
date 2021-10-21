package com.example.parsing_local_json
import android.content.Context
import java.io.IOException

class Utils {
    fun getJsonDataFromAsset(context: Context, data: String): String? {
        val jsonString: String
        try {
            jsonString = context.assets.open(data).bufferedReader().use { it.readText() }
        } catch (ioException: IOException) {
            ioException.printStackTrace()
            return null
        }
        return jsonString
    }

}