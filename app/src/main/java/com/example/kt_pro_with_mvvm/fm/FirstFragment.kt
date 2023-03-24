package com.example.kt_pro_with_mvvm.fm

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kt_pro_with_mvvm.R
import com.example.kt_pro_with_mvvm.adapter.CustomAdapter
import com.example.kt_pro_with_mvvm.models.ItemsViewModel

class FirstFragment(emails: String?, passw: String?) : Fragment() {
    var e = emails.toString()
    var p = passw.toString()
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? { val view = inflater.inflate(R.layout.fragment_first, container, false)
        inilization(view)
        return view
    }

    private fun inilization(view: View?) {
        val tvEmail = view?.findViewById(R.id.inputIds) as TextView
        val tvSec = view.findViewById(R.id.tvSec) as TextView
        tvEmail.text = e
        tvSec.text = p

        val rvFF = view.findViewById(R.id.rvFirstFragment) as RecyclerView
        rvFF.layoutManager = LinearLayoutManager(context)
        val data = ArrayList<ItemsViewModel>()
        for (i in 1..20) {
            data.add(ItemsViewModel(R.drawable.baseline_5k_24, "Item " + i))
        }
        val adapter = context?.let { CustomAdapter(data, it) }
        rvFF.adapter = adapter

    }

}