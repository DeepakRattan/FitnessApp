package com.example.fitnessapptechugo.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.fitnessapptechugo.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_one.*
import kotlinx.android.synthetic.main.view_pager_content.*

class ViewPagerContentFragment :Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.view_pager_content,container,false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.takeIf {
            it.containsKey("banner_key")}?.apply {
           var ban = getString("banner_key")
            Picasso.with(requireContext()).load(ban).into(ivSlideScreen)
        }
        }

    }
