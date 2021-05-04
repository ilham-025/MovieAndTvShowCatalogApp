package com.ilham.itsmovie.ui.tvshow

import androidx.lifecycle.ViewModel
import com.ilham.itsmovie.data.TvShow
import com.ilham.itsmovie.utils.DataDummy

class TvShowViewModel : ViewModel() {
    fun getTvShows(): List<TvShow> = DataDummy.generateDummyTvShow()
}