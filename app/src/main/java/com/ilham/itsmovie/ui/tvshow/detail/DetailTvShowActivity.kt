package com.ilham.itsmovie.ui.tvshow.detail

import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.ilham.itsmovie.R
import com.ilham.itsmovie.data.TvShow
import com.ilham.itsmovie.databinding.ActivityDetailTvShowBinding

class DetailTvShowActivity : AppCompatActivity(), View.OnClickListener {

    companion object {
        const val EXTRA_TV_SHOW = "extra_tv_show"
    }

    private lateinit var activityDetailTvShowBinding: ActivityDetailTvShowBinding
    private val detailTvShowViewModel: DetailTvShowViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityDetailTvShowBinding = ActivityDetailTvShowBinding.inflate(layoutInflater)
        setContentView(activityDetailTvShowBinding.root)

        activityDetailTvShowBinding.buttonBack.setOnClickListener(this)

        val extras = intent.extras
        if (extras != null) {
            val tvShowId = extras.getString(EXTRA_TV_SHOW)
            if (tvShowId != null) {
                detailTvShowViewModel.setSelectedTvShow(tvShowId)
                populateMovie(detailTvShowViewModel.getTvShow())
            }
        }
    }

    private fun populateMovie(tvShow: TvShow) {
        with(activityDetailTvShowBinding) {
            textTitle.text = tvShow.title
            textYear.text = resources.getString(R.string.text_year, tvShow.year)
            val userScoreString = "${tvShow.userScore} %"
            textUserScore.text = userScoreString
            var genreText = ""
            for ((i, genre) in tvShow.genres!!.withIndex()) {
                genreText += if (i == tvShow.genres!!.size - 1 || tvShow.genres!!.size == 1) {
                    genre.genre!!
                } else {
                    genre.genre!! + " - "
                }
            }
            textGenres.text = genreText

            Glide.with(this@DetailTvShowActivity)
                    .load(
                            resources.getIdentifier(
                                    tvShow.imagePath,
                                    "drawable",
                                    this@DetailTvShowActivity.packageName
                            )
                    )
                    .apply(
                            RequestOptions.placeholderOf(R.drawable.ic_loading)
                                    .error(R.drawable.ic_error)
                    ).into(imagePoster)

            textReview.text = tvShow.review
            textCreator.text = resources.getString(R.string.text_creator, "\n" + tvShow.creator)
            textEpisodeCount.text = resources.getString(R.string.text_episode_count, "\n" + tvShow.episodeCount.toString())
            textTime.text = resources.getString(R.string.text_time, tvShow.time)
        }
    }

    override fun onClick(v: View?) {
        when (v!!.id) {
            R.id.button_back -> {
                finish()
            }
        }
    }
}