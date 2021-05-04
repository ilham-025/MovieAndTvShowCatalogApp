package com.ilham.itsmovie.ui.tvshow.detail

import androidx.lifecycle.ViewModel
import com.ilham.itsmovie.data.TvShow
import com.ilham.itsmovie.utils.DataDummy

class DetailTvShowViewModel : ViewModel() {
    private lateinit var tvShowId: String

    fun setSelectedTvShow(tvShowId: String) {
        this.tvShowId = tvShowId
    }

    fun getTvShow(): TvShow {
        lateinit var tvShow: TvShow
        val tvShows = DataDummy.generateDummyTvShow()
        for (tvShowEntity in tvShows) {
            if (tvShowEntity.tvShowId == tvShowId) {
                tvShow = tvShowEntity
                break
            }
        }
        return tvShow
    }
}