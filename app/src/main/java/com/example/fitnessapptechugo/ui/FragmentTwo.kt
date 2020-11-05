package com.example.fitnessapptechugo.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.fitnessapptechugo.R
import com.example.fitnessapptechugo.data.models.Cupons
import com.example.fitnessapptechugo.ui.adapter.CouponAdapter
import com.example.fitnessapptechugo.ui.adapter.ScreenSlidePagerAdapter
import com.google.android.material.tabs.TabLayoutMediator
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_two.*
import org.koin.android.viewmodel.ext.android.sharedViewModel

class FragmentTwo : Fragment() {
    private val mainViewModel: MainViewModel by sharedViewModel()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_two, container, false)
        val rv = rootView.findViewById<RecyclerView>(R.id.rv)
        rv.layoutManager = LinearLayoutManager(activity)
        return rootView
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mainViewModel.isSuccess.observe(viewLifecycleOwner, Observer {
            rv.adapter = CouponAdapter(it.cupons as ArrayList<Cupons>)
            //Picasso.with(requireContext()).load(it.banner[0]).into(iv1)
            val pagerAdapter =
                ScreenSlidePagerAdapter(this, it.banner as ArrayList<String>, it.banner.size)
            viewPagerCirculatorIndicator.adapter = pagerAdapter

            TabLayoutMediator(
                tabLayoutCircularIndicator,
                viewPagerCirculatorIndicator
            ) { tab, position ->
            }.attach()


        })
    }
}