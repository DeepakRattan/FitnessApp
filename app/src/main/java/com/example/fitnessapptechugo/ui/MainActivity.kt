package com.example.fitnessapptechugo.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.viewpager2.widget.ViewPager2
import com.example.fitnessapptechugo.R
import com.example.fitnessapptechugo.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {
    private val mainViewModel: MainViewModel by viewModel()
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("test", "onCreate: Activity ")
        binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        binding.mainViewModel = mainViewModel
        binding.lifecycleOwner = this
        binding.executePendingBindings()

        mainViewModel.getData()

        mainViewModel.isSuccess.observe(this, Observer {
            Log.d("lat", "latitude${it.latitudes}")
        })
        val viewPagerAdapter = ViewPagerAdapter(supportFragmentManager, lifecycle)
        viewPager.adapter = viewPagerAdapter
        var names: Array<String> = arrayOf("Offers", "Details")
        TabLayoutMediator(binding.tabLayout, viewPager) { tab, position ->
            tab.text = names[position]
        }.attach()
    }
}