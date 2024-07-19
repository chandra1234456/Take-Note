package com.chandra.coding.takenote.fragment

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.chandra.coding.takenote.R
import com.chandra.coding.takenote.databinding.FragmentSplashScreenBinding

class LoadingScreenFragment() : Fragment() {
    private lateinit var splashScreenBinding : FragmentSplashScreenBinding

    override fun onCreateView(
        inflater : LayoutInflater , container : ViewGroup? ,
        savedInstanceState : Bundle?
                             ) : View {
        splashScreenBinding = FragmentSplashScreenBinding.inflate(layoutInflater)
        Handler(Looper.getMainLooper()).postDelayed({
            findNavController().navigate(R.id.action_loadingScreenFragment_to_nameFragment)
        } , 2000)
        return splashScreenBinding.root
    }

}