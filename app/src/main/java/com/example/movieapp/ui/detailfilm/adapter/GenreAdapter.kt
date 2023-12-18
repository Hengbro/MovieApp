package com.example.movieapp.ui.detailfilm.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.movieapp.core.model.GenreModel
import com.example.movieapp.databinding.MovieItemBinding

@SuppressLint("NotifyDataSetChanged")
class GenreAdapter () : RecyclerView.Adapter<GenreAdapter.ViewHolder>(){

    private var data = ArrayList<GenreModel>()

    inner class ViewHolder(private val itemBinding: MovieItemBinding): RecyclerView.ViewHolder(itemBinding.root){
        fun bind(item : GenreModel, position: Int){
            itemBinding.apply {
                tvName.text = item.name

            }
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    fun addItems(items: List<GenreModel>){
        data.clear()
        data.addAll(items)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(MovieItemBinding.inflate(
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