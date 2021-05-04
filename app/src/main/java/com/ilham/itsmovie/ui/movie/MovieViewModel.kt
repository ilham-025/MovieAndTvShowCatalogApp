package com.ilham.itsmovie.ui.movie

import androidx.lifecycle.ViewModel
import com.ilham.itsmovie.data.Movie
import com.ilham.itsmovie.utils.DataDummy

class MovieViewModel : ViewModel() {
    fun getMovies(): List<Movie> = DataDummy.generateDummyMovies()
}