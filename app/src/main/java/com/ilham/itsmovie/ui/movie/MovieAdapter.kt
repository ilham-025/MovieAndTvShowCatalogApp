package com.ilham.itsmovie.ui.movie

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.ilham.itsmovie.R
import com.ilham.itsmovie.data.Movie
import com.ilham.itsmovie.databinding.ItemsMovieBinding
import com.ilham.itsmovie.ui.movie.detail.DetailMovieActivity

class MovieAdapter : RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {
    private val movies = ArrayList<Movie>()

    fun setMovies(movies: List<Movie>?) {
        if (movies == null) return
        this.movies.clear()
        this.movies.addAll(movies)
    }

    class MovieViewHolder(private val binding: ItemsMovieBinding) :
            RecyclerView.ViewHolder(binding.root) {
        fun bind(movie: Movie) {
            with(binding) {
                textTitle.text = movie.title
                textYear.text = itemView.resources.getString(
                        R.string.text_year, movie.releaseDate.substring(
                        6,
                        10
                )
                )
                val userScoreText = movie.userScore.toString() + "%"
                textUserScore.text = userScoreText
                var genreText = ""
                for ((i, genre) in movie.genres!!.withIndex()) {
                    genreText += if (i == movie.genres!!.size - 1 || movie.genres!!.size == 1) {
                        genre.genre!!
                    } else {
                        genre.genre!! + " - "
                    }
                }
                textGenres.text = genreText

                Glide.with(itemView.context)
                        .load(
                                itemView.resources.getIdentifier(
                                        movie.imagePath,
                                        "drawable",
                                        itemView.context.packageName
                                )
                        )
                        .apply(
                                RequestOptions.placeholderOf(R.drawable.ic_loading)
                                        .error(R.drawable.ic_error)
                        ).into(imagePoster)

                layout.setOnClickListener {
                    val intent = Intent(itemView.context, DetailMovieActivity::class.java)
                    intent.putExtra(DetailMovieActivity.EXTRA_MOVIE, movie.movieId)
                    itemView.context.startActivity(intent)
                }
            }
        }
    }

    override fun onCreateViewHolder(
            parent: ViewGroup,
            viewType: Int
    ): MovieViewHolder {
        val itemsMovieBinding = ItemsMovieBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
        )
        return MovieViewHolder(itemsMovieBinding)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie = movies[position]
        holder.bind(movie)
    }

    override fun getItemCount(): Int = movies.size
}