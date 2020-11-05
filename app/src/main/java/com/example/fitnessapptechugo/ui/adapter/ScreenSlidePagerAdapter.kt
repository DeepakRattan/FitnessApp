package com.example.fitnessapptechugo.ui.adapter

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.fitnessapptechugo.ui.ViewPagerContentFragment
import kotlinx.android.synthetic.main.view_pager_content.*

class ScreenSlidePagerAdapter(
    fragment: Fragment,
    val slidingImages: ArrayList<String>,
    val numberOfPages: Int

) : FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int = numberOfPages

    override fun createFragment(position: Int): Fragment {
        var fragment = ViewPagerContentFragment()
        for (i in 1..numberOfPages) {
            fragment.arguments = Bundle().apply {
                putString("banner_key", slidingImages[position])
            }
        }
        return fragment
    }
}
