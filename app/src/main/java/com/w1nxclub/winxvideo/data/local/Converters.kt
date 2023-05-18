package com.w1nxclub.winxvideo.data.local

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.w1nxclub.winxvideo.data.model.credits.Credits
import com.w1nxclub.winxvideo.data.model.genre.Genre

class Converters {

    @TypeConverter
    fun fromGenreList(genreList: List<Genre>?): String? {
        return Gson().toJson(genreList)
    }

    @TypeConverter
    fun toGenreList(json: String?): List<Genre>? {
        val type = object : TypeToken<List<Genre>>() {}.type
        return Gson().fromJson(json, type)
    }

    @TypeConverter
    fun fromCredits(credits: Credits?): String? {
        return Gson().toJson(credits)
    }

    @TypeConverter
    fun toCredits(json: String?): Credits? {
        val type = object : TypeToken<Credits>() {}.type
        return Gson().fromJson(json, type)
    }
}