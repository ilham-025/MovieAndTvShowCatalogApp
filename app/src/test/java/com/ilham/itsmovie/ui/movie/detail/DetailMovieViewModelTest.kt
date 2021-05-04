package com.ilham.itsmovie.ui.movie.detail

import com.ilham.itsmovie.utils.DataDummy
import org.junit.Before
import org.junit.Test

import org.junit.Assert.*

class DetailMovieViewModelTest {

    private lateinit var detailMovieViewModel: DetailMovieViewModel
    private val dummyMovie = DataDummy.generateDummyMovies()[0]
    private val movieId = dummyMovie.movieId

    @Before
    fun setUp() {
        detailMovieViewModel = DetailMovieViewModel()
        detailMovieViewModel.setSelectedMovie(movieId)
    }

    @Test
    fun getMovie() {
        val movie = detailMovieViewModel.getMovie()
        assertNotNull(movie)
        assertEquals(dummyMovie.movieId, movie.movieId)
        assertEquals(dummyMovie.title, movie.title)
        assertEquals(dummyMovie.review, movie.review)
        assertEquals(dummyMovie.time, movie.time)
        assertEquals(dummyMovie.releaseDate, movie.releaseDate)
        assertEquals(dummyMovie.director, movie.director)
        assertEquals(dummyMovie.userScore, movie.userScore)
        assertEquals(dummyMovie.imagePath, movie.imagePath)
        assertEquals(dummyMovie.genres, movie.genres)
    }
}