package com.example.fitnessapptechugo.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.fitnessapptechugo.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_one.*
import org.koin.android.viewmodel.ext.android.sharedViewModel
import org.koin.android.viewmodel.ext.android.viewModel

class FragmentOne : Fragment() {
    private val mainViewModel: MainViewModel by sharedViewModel()

    //lateinit var mainViewModel:MainViewModel
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_one, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //mainViewModel.getData()
        mainViewModel.isSuccess.observe(viewLifecycleOwner, Observer {
            Log.d("test", "onViewCreated: ${it.latitudes}")
            txtTitle.text = it.description_title
            txtDescription.text = it.description_body
            Picasso.with(requireContext()).load(it.decription_image).into(img)

        })
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState) //mainViewModel = ViewModelProvider(requireActivity()).get(MainViewModel::class.java)
        mainViewModel.getData()
        val res = mainViewModel.getResult()
        Log.d("test", "onActivityCreated: fragment $res")
        //val r=mainViewModel.isSuccess.value
        //Log.d("test", "onActivityCreated1:fragment$r ")
    }

    override fun onResume() {
        super.onResume()
    }


}