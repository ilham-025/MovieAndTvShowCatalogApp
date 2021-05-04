package com.ilham.itsmovie.ui.movie

import org.junit.Test

import org.junit.Assert.*
import org.junit.Before

class MovieViewModelTest {

    private lateinit var movieViewModel: MovieViewModel

    @Before
    fun setUp() {
        movieViewModel = MovieViewModel()
    }

    @Test
    fun getMovies() {
        val movies = movieViewModel.getMovies()
        assertNotNull(movies)
        assertEquals(10, movies.size)
    }
}