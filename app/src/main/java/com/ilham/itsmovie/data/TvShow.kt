package com.ilham.itsmovie.data

data class TvShow(
        var tvShowId: String,
        var title: String,
        var review: String,
        var time: String,
        var creator: String,
        var userScore: Int,
        var year: String,
        var episodeCount: Int,
        var imagePath: String,
        var genres: List<GenreEntity>? = null
)