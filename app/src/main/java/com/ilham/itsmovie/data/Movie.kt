package com.ilham.itsmovie.data

data class Movie(
        var movieId: String,
        var title: String,
        var review: String,
        var time: String,
        var director: String,
        var userScore: Int,
        var releaseDate: String,
        var imagePath: String,
        var genres: List<GenreEntity>? = null
)