package com.example.movietracker

data class Movies(
    val title: String,
    val desc: String,
    val isWatched: Boolean = false,
    val isMovie: Boolean = true,
    val comment: String,
    val score: Int
)
