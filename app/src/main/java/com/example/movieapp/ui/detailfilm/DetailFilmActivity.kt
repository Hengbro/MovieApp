package com.example.movieapp.ui.detailfilm

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.movieapp.core.model.MovieModel
import com.example.movieapp.core.source.remote.network.State
import com.example.movieapp.databinding.ActivityDetailBinding
import com.example.movieapp.ui.detailfilm.adapter.GenreAdapter
import com.example.movieapp.ui.home.HomeViewModel
import com.example.movieapp.ui.home.adapter.MovieUpcomingAdapter
import com.example.movieapp.ui.home.adapter.TopMovieAdapter
import com.example.movieapp.util.Constans
import com.inyongtisto.myhelper.extension.extra
import com.inyongtisto.myhelper.extension.logs
import com.inyongtisto.myhelper.extension.setImagePicasso
import com.inyongtisto.myhelper.extension.toGone
import com.inyongtisto.myhelper.extension.toJson
import com.inyongtisto.myhelper.extension.toVisible
import com.inyongtisto.myhelper.extension.toastError
import org.koin.androidx.viewmodel.ext.android.viewModel

class DetailFilmActivity : AppCompatActivity() {

    private var _binding: ActivityDetailBinding? = null
    private val binding get() = _binding!!

    private val viewModel: HomeViewModel by viewModel()
    private val viewModelDetail: DetailViewModel by viewModel()
    private val adapterToprate = TopMovieAdapter()
    private val adapterGenre = GenreAdapter()
    private val adapterUpcoming = MovieUpcomingAdapter()
    private val film by extra<MovieModel>()

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mainButton()
        setUpData()
        setupAdepter()
        getSlider()
        getUpcoming()
        getGenre()
    }

    private fun mainButton(){
        binding.apply {
            btnClose.setOnClickListener{
                onBackPressedDispatcher.onBackPressed()
            }
        }
    }
    private fun setUpData(){
        binding.apply {
            film?.let {
                logs("Movie:" +it.toJson())
                tvName.text = it.title
                tvTgl.text = it.release_date + "(" + it.original_language + ")"
                tvReting.text = it.vote_average.toString()
                tvDeskripsi.text = it.overview
                imgFilm.setImagePicasso(Constans.IMAGE_BASE + it.backdrop_path)
            }
        }
    }

    private fun setupAdepter(){
        binding.apply {
            rvTop.adapter = adapterToprate
            rvRecomended.adapter = adapterUpcoming
            rvCategory.adapter = adapterGenre
        }
    }

    private fun getUpcoming(){
        viewModel.getUpcoming().observe(this){
            when (it.state) {
                State.SUCCESS -> {
                    binding.pdRekomended.toGone()
                    val data = it.results ?: emptyList()
                    adapterUpcoming.addItems(data)
                }
                State.ERROR -> {
                    binding.pdRekomended.toGone()
                    toastError(it?.message ?: "Error")
                }
                State.LOADING -> {
                    binding.pdRekomended.toVisible()
                }
            }
        }
    }

    private fun getSlider(){
        viewModel.getListMovie().observe(this){
            when (it.state) {
                State.SUCCESS -> {
                    binding.pdTop.toGone()
                    val data = it.results ?: emptyList()
                    adapterToprate.addItems(data)
                }
                State.ERROR -> {
                    binding.pdTop.toGone()
                    toastError(it?.message ?: "Error")
                }
                State.LOADING -> {
                    binding.pdTop.toVisible()
                }
            }
        }
    }

    private fun getGenre(){
        viewModelDetail.getGenre().observe(this){
            when (it.state) {
                State.SUCCESS -> {
                    val data = it.results ?: emptyList()
                    adapterGenre.addItems(data)
                }
                State.ERROR -> {
                    toastError(it?.message ?: "Error")
                }
                State.LOADING -> {
                }
            }
        }
    }
}