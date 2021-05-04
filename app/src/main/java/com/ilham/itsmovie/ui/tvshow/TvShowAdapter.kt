package com.ilham.itsmovie.ui.tvshow

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.ilham.itsmovie.R
import com.ilham.itsmovie.data.TvShow
import com.ilham.itsmovie.databinding.ItemsTvShowBinding
import com.ilham.itsmovie.ui.tvshow.detail.DetailTvShowActivity

class TvShowAdapter : RecyclerView.Adapter<TvShowAdapter.TvShowViewHolder>() {
    private val tvShow = ArrayList<TvShow>()

    fun setTvShows(tvShow: List<TvShow>?) {
        if (tvShow == null) return
        this.tvShow.clear()
        this.tvShow.addAll(tvShow)
    }

    class TvShowViewHolder(private val binding: ItemsTvShowBinding) :
            RecyclerView.ViewHolder(binding.root) {
        fun bind(tvShow: TvShow) {
            with(binding) {
                textTitle.text = tvShow.title
                val userScoreText = tvShow.userScore.toString() + "%"
                textUserScore.text = userScoreText

                var genreText = ""
                for ((i, genre) in tvShow.genres!!.withIndex()) {
                    genreText += if (i == tvShow.genres!!.size - 1 || tvShow.genres!!.size == 1) {
                        genre.genre!!
                    } else {
                        genre.genre!! + " - "
                    }
                }
                textGenres.text = genreText

                Glide.with(itemView.context)
                        .load(
                                itemView.resources.getIdentifier(
                                        tvShow.imagePath,
                                        "drawable",
                                        itemView.context.packageName
                                )
                        )
                        .apply(
                                RequestOptions.placeholderOf(R.drawable.ic_loading)
                                        .error(R.drawable.ic_error)
                        ).into(imagePoster)

                itemView.setOnClickListener {
                    val intent = Intent(itemView.context, DetailTvShowActivity::class.java)
                    intent.putExtra(DetailTvShowActivity.EXTRA_TV_SHOW, tvShow.tvShowId)
                    itemView.context.startActivity(intent)
                }
            }
        }
    }

    override fun onCreateViewHolder(
            parent: ViewGroup,
            viewType: Int
    ): TvShowViewHolder {
        val itemsTvShowBinding = ItemsTvShowBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
        )
        return TvShowViewHolder(itemsTvShowBinding)
    }

    override fun onBindViewHolder(holder: TvShowViewHolder, position: Int) {
        val tvShow = tvShow[position]
        holder.bind(tvShow)
    }

    override fun getItemCount(): Int = tvShow.size
}