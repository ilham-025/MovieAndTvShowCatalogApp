package com.ilham.itsmovie.ui.movie.detail

import androidx.lifecycle.ViewModel
import com.ilham.itsmovie.data.Movie
import com.ilham.itsmovie.utils.DataDummy

class DetailMovieViewModel : ViewModel() {
    private lateinit var movieId: String

    fun setSelectedMovie(movieId: String) {
        this.movieId = movieId
    }

    fun getMovie(): Movie {
        lateinit var movie: Movie
        val movies = DataDummy.generateDummyMovies()
        for (movieEntity in movies) {
            if (movieEntity.movieId == movieId) {
                movie = movieEntity
                break
            }
        }
        return movie
    }
}