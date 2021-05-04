package com.ilham.itsmovie.ui.movie.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.ilham.itsmovie.R
import com.ilham.itsmovie.data.Movie
import com.ilham.itsmovie.databinding.ActivityDetailMovieBinding

class DetailMovieActivity : AppCompatActivity(), View.OnClickListener {

    companion object {
        const val EXTRA_MOVIE = "extra_movie"
    }

    private lateinit var activityDetailMovieBinding: ActivityDetailMovieBinding
    private val detailMovieViewModel: DetailMovieViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityDetailMovieBinding = ActivityDetailMovieBinding.inflate(layoutInflater)
        setContentView(activityDetailMovieBinding.root)

        activityDetailMovieBinding.buttonBack.setOnClickListener(this)

        val extras = intent.extras
        if (extras != null) {
            val movieId = extras.getString(EXTRA_MOVIE)
            if (movieId != null) {
                detailMovieViewModel.setSelectedMovie(movieId)
                populateMovie(detailMovieViewModel.getMovie())
            }
        }
    }

    private fun populateMovie(movie: Movie) {
        with(activityDetailMovieBinding) {
            textTitle.text = movie.title
            textYear.text = resources.getString(
                    R.string.text_year, movie.releaseDate.substring(
                    6,
                    10
            )
            )
            val userScoreString = "${movie.userScore} %"
            textUserScore.text = userScoreString
            var genreText = ""
            for ((i, genre) in movie.genres!!.withIndex()) {
                genreText += if (i == movie.genres!!.size - 1 || movie.genres!!.size == 1) {
                    genre.genre!!
                } else {
                    genre.genre!! + " - "
                }
            }
            textGenres.text = genreText

            Glide.with(this@DetailMovieActivity)
                    .load(
                            resources.getIdentifier(
                                    movie.imagePath,
                                    "drawable",
                                    this@DetailMovieActivity.packageName
                            )
                    )
                    .apply(
                            RequestOptions.placeholderOf(R.drawable.ic_loading)
                                    .error(R.drawable.ic_error)
                    ).into(imagePoster)

            textReview.text = movie.review
            textDirector.text = resources.getString(R.string.text_director, "\n" + movie.director)
            textRelease.text = resources.getString(R.string.text_release, "\n" + movie.releaseDate)
            textTime.text = resources.getString(R.string.text_time, movie.time)
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