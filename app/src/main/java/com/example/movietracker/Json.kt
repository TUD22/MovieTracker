package com.example.movietracker

import android.content.Context
import com.google.gson.GsonBuilder
import java.io.File

object JsonManager {
    private const val FILE_NAME = "movie_data.json"

    fun saveMovieListToJson(context: Context, movieList: List<Movies>) {
        val gson = GsonBuilder().setPrettyPrinting().create()
        val jsonString = gson.toJson(movieList)
        val file = File(context.filesDir, FILE_NAME)


        file.writeText(jsonString)
    }
}