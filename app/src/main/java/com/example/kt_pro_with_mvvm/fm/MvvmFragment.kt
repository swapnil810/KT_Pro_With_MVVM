package com.example.kt_pro_with_mvvm.fm

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.kt_pro_with_mvvm.R

class MvvmFragment : Fragment() {

    companion object {
        fun newInstance() = MvvmFragment()
    }

    private lateinit var viewModel: MvvmViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_mvvm, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MvvmViewModel::class.java)
        // TODO: Use the ViewModel
    }

}