package com.example.movieapp.ui.home.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.movieapp.core.model.MovieModel
import com.example.movieapp.databinding.ItemRecomendedBinding
import com.example.movieapp.ui.detailfilm.DetailFilmActivity
import com.example.movieapp.util.Constans
import com.example.movieapp.util.toUrlImage
import com.inyongtisto.myhelper.extension.intentActivity
import com.inyongtisto.myhelper.extension.setImagePicasso

@SuppressLint("NotifyDataSetChanged")
class MovieUpcomingAdapter () : RecyclerView.Adapter<MovieUpcomingAdapter.ViewHolder>(){

    private var data = ArrayList<MovieModel>()

    inner class ViewHolder(private val itemBinding: ItemRecomendedBinding): RecyclerView.ViewHolder(itemBinding.root){

        fun bind(item : MovieModel, position: Int){
            itemBinding.apply {
                tvName.text = item.title
                tvTgl.text = item.release_date
                tvReting.text = item.vote_average.toString()
                tvDeskripsi.text = item.overview
                val splitImages = item.backdrop_path?.split("|")
                val imageFilm = if (splitImages.isNullOrEmpty()){
                    item.backdrop_path?:""
                }else {
                    splitImages[0]
                }

                imgFilm.setImagePicasso(imageFilm.toUrlImage())
                Glide.with(itemView).load(Constans.IMAGE_BASE + item.poster_path).into(imgFilm)

                val context = root.context
                layoutRek.setOnClickListener {
                    context.intentActivity(DetailFilmActivity::class.java, item)
                }
            }
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    fun addItems(items: List<MovieModel>){
        data.clear()
        data.addAll(items)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ItemRecomendedBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(data[position], position)
    }

    override fun getItemCount(): Int {
        return data.size
    }
}