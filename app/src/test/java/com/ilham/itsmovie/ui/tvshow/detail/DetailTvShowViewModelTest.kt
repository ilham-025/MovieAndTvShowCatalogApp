package com.ilham.itsmovie.ui.tvshow.detail

import com.ilham.itsmovie.utils.DataDummy
import org.junit.Before
import org.junit.Test

import org.junit.Assert.*

class DetailTvShowViewModelTest {

    private lateinit var detailTvShowViewModel: DetailTvShowViewModel
    private val dummyTvShow = DataDummy.generateDummyTvShow()[0]
    private val tvShowId = dummyTvShow.tvShowId

    @Before
    fun setUp() {
        detailTvShowViewModel = DetailTvShowViewModel()
        detailTvShowViewModel.setSelectedTvShow(tvShowId)
    }

    @Test
    fun getTvShow() {
        val tvShow = detailTvShowViewModel.getTvShow()
        assertNotNull(tvShow)
        assertEquals(dummyTvShow.tvShowId, tvShow.tvShowId)
        assertEquals(dummyTvShow.title, tvShow.title)
        assertEquals(dummyTvShow.review, tvShow.review)
        assertEquals(dummyTvShow.time, tvShow.time)
        assertEquals(dummyTvShow.year, tvShow.year)
        assertEquals(dummyTvShow.creator, tvShow.creator)
        assertEquals(dummyTvShow.episodeCount, tvShow.episodeCount)
        assertEquals(dummyTvShow.userScore, tvShow.userScore)
        assertEquals(dummyTvShow.imagePath, tvShow.imagePath)
        assertEquals(dummyTvShow.genres, tvShow.genres)
    }
}