package com.example.wetherapp.cache

import com.example.wetherapp.model.Weather
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type
import java.util.*

class TypeConverter {

    companion object {
        var gson = Gson()
        @androidx.room.TypeConverter
        @JvmStatic
        fun stringToListOfObj(data: String?): List<Weather?>? {
            if (data == null) {
                return Collections.emptyList()
            }
            val listType: Type = object : TypeToken<List<Weather?>?>() {}.type
            return gson.fromJson<List<Weather?>>(data, listType)
        }

        @androidx.room.TypeConverter
        @JvmStatic
        fun objectsListToString(objects: List<Weather>): String {
            return gson.toJson(objects)
        }
    }
}