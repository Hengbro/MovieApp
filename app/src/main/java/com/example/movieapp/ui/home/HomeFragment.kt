package com.example.movieapp.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.movieapp.core.source.remote.network.State
import com.example.movieapp.databinding.FragmentHomeBinding
import com.example.movieapp.ui.base.BaseFragment
import com.example.movieapp.ui.home.adapter.HomeAdapter
import com.example.movieapp.ui.home.adapter.MovieUpcomingAdapter
import com.example.movieapp.ui.home.adapter.TopMovieAdapter
import com.inyongtisto.myhelper.extension.toGone
import com.inyongtisto.myhelper.extension.toVisible
import com.inyongtisto.myhelper.extension.toastError
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeFragment : BaseFragment() {

    private val viewModel: HomeViewModel by viewModel()
    private val adapterPopuler = HomeAdapter()
    private val adapterToprate = TopMovieAdapter()
    private val adapterUpcoming = MovieUpcomingAdapter()

    private var _binding: FragmentHomeBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        setupAdepter()
        getPopuler()
        getSlider()
        getUpcoming()
        return root
    }

    private fun setupAdepter(){
        binding.rvTop.adapter = adapterToprate
        binding.rvPopuler.adapter = adapterPopuler
        binding.rvRecomended.adapter = adapterUpcoming
    }

    private fun getUpcoming(){
        viewModel.getUpcoming().observe(requireActivity()){
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
        viewModel.getListMovie().observe(requireActivity()){
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

    private fun getPopuler(){
        viewModel.getPopuler().observe(requireActivity()){
            when (it.state) {
                State.SUCCESS -> {
                    binding.pdPopuler.toGone()
                    val data = it.results?: emptyList()
                    adapterPopuler.addItems(data)
                }
                State.ERROR -> {
                    binding.pdPopuler.toGone()
                    toastError(it?.message ?: "Error")

                }
                State.LOADING -> {
                    binding.pdPopuler.toVisible()
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}