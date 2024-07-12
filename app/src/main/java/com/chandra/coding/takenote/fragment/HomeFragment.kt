package com.chandra.coding.takenote.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.chandra.coding.takenote.R
import com.chandra.coding.takenote.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {

    private lateinit var homeBinding : FragmentHomeBinding

    override fun onCreateView(
        inflater : LayoutInflater , container : ViewGroup? ,
        savedInstanceState : Bundle?
                             ) : View {
        homeBinding = FragmentHomeBinding.inflate(layoutInflater)
        return homeBinding.root
    }

}