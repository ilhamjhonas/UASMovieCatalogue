package com.ilham.moviecatalogue

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ilham.moviecatalogue.R
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_detail_tv.view.*
import kotlinx.android.synthetic.main.tv_item.view.*
import kotlinx.android.synthetic.main.tv_item.view.tv_name

class TvAdapter(
    private val tvshow : List<TvShow>, val listener: OnAdapterListener
) : RecyclerView.Adapter<TvAdapter.TvViewHolder>() {

    class TvViewHolder(view : View) : RecyclerView.ViewHolder(view){
        fun bindMovie(tvshow: TvShow){
            itemView.tv_name.text = tvshow.name
            itemView.overviews.text = tvshow.overview
            itemView.tv_popularity.text = tvshow.popularity.toString()
            itemView.ratingsss.text = tvshow.vote_average.toString()
            Glide.with(itemView).load(IMAGE_BASE + tvshow.poster_path).into(itemView.tv_poster)
            Log.e("MovieAdapter","URL Image ==> $IMAGE_BASE${tvshow.poster_path}")
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TvViewHolder {
        return TvViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.tv_item, parent, false)
        )
    }

    override fun getItemCount(): Int = tvshow.size

    override fun onBindViewHolder(holder: TvViewHolder, position: Int) {
        holder.bindMovie(tvshow[position])
        holder.itemView.setOnClickListener { listener.onClick(tvshow[position]) }
    }

    interface OnAdapterListener {
        fun onClick(result: TvShow)
    }
}