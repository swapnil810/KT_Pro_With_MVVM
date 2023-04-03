package com.example.kt_pro_with_mvvm.fm

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kt_pro_with_mvvm.R
import com.example.kt_pro_with_mvvm.adapter.ScrollingAdapter
import com.example.kt_pro_with_mvvm.models.ScrollModel

class ScrollingFragment : Fragment() {
    lateinit var scrollingAdapter: ScrollingAdapter
    val movieList = ArrayList<ScrollModel>()
    var page = 1
    var isLoading = false
    var limit = 10
    lateinit var progessBar: ProgressBar
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_scrolling, container, false)
        initializedView(view)
        return view

    }

    private fun initializedView(view: View?) {
        progessBar = view?.findViewById(R.id.idPBLoading) as ProgressBar
        val rvScrollViews = view?.findViewById(R.id.rvScrollFrag) as RecyclerView
        prepareMovieData()
        scrollingAdapter = ScrollingAdapter(movieList)
        val layoutManager = LinearLayoutManager(context)
        rvScrollViews.layoutManager = layoutManager
        rvScrollViews.adapter = scrollingAdapter




    }

//    fun getPage() {
//        progessBar.visibility = View.VISIBLE
//        val start: Int = (page - 1) * limit
//        val end: Int = (page) * limit
//
//        for (i in start..end) {
//        }
//    }

    private fun prepareMovieData() {
        var movie = ScrollModel("Mad Max: Fury Road", "Action & Adventure", "2015")
        movieList.add(movie)
        movie = ScrollModel("Inside Out", "Animation, Kids & Family", "2015")
        movieList.add(movie)
        movie = ScrollModel("Star Wars: Episode VII - The Force Awakens", "Action", "2015")
        movieList.add(movie)
        movie = ScrollModel("Shaun the Sheep", "Animation", "2015")
        movieList.add(movie)
        movie = ScrollModel("Inside Out", "Animation, Kids & Family", "2015")
        movieList.add(movie)
        movie = ScrollModel("Star Wars: Episode VII - The Force Awakens", "Action", "2015")
        movieList.add(movie)
        movie = ScrollModel("Shaun the Sheep", "Animation", "2015")
        movieList.add(movie)
        movie = ScrollModel("Inside Out", "Animation, Kids & Family", "2015")
        movieList.add(movie)
        movie = ScrollModel("Star Wars: Episode VII - The Force Awakens", "Action", "2015")
        movieList.add(movie)
        movie = ScrollModel("Shaun the Sheep", "Animation", "2015")
        movieList.add(movie)
        movie = ScrollModel("Inside Out", "Animation, Kids & Family", "2015")
        movieList.add(movie)
        movie = ScrollModel("Star Wars: Episode VII - The Force Awakens", "Action", "2015")
        movieList.add(movie)
        movie = ScrollModel("Shaun the Sheep", "Animation", "2015")
        movieList.add(movie)

    }
}