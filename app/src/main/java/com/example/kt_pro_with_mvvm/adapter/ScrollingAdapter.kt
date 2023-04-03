package com.example.kt_pro_with_mvvm.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.kt_pro_with_mvvm.R
import com.example.kt_pro_with_mvvm.models.ScrollModel

class ScrollingAdapter(val movieList: ArrayList<ScrollModel>) :
    RecyclerView.Adapter<ScrollingAdapter.ViewMyHolder>() {

    class ViewMyHolder(view: View) : RecyclerView.ViewHolder(view) {

        var titless: TextView = view.findViewById(R.id.tv_scroll)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewMyHolder {
        val inflateView: View =
            LayoutInflater.from(parent.context).inflate(R.layout.scroll_list_item, parent,
                false)
        return ViewMyHolder(inflateView)
    }

    override fun getItemCount(): Int {
        return movieList.size
    }

    override fun onBindViewHolder(holder: ViewMyHolder, position: Int) {
        val movie = movieList[position]
        holder.titless.text = movie.title
    }
}