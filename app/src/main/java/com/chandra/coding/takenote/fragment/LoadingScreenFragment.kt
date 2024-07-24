package com.chandra.coding.takenote.fragment

import android.content.Context
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.chandra.coding.takenote.Constants
import com.chandra.coding.takenote.R
import com.chandra.coding.takenote.databinding.FragmentSplashScreenBinding
import com.chandra.coding.takenote.util.retrieveIsLoggedIn
import com.chandra.coding.takenote.util.toastMsg

class LoadingScreenFragment() : Fragment() {
    private lateinit var splashScreenBinding : FragmentSplashScreenBinding

    override fun onCreateView(
        inflater : LayoutInflater , container : ViewGroup? ,
        savedInstanceState : Bundle?
                             ) : View {
        splashScreenBinding = FragmentSplashScreenBinding.inflate(layoutInflater)
        Handler(Looper.getMainLooper()).postDelayed({
            try {
                val sharedPreferences = requireActivity().getSharedPreferences("Profile", Context.MODE_PRIVATE)
                val isLoggedIn = sharedPreferences.getBoolean(Constants.LOGGED_IN, false)
                if (isLoggedIn) {
                    findNavController().navigate(R.id.homeFragment)
                } else {
                    findNavController().navigate(R.id.action_loadingScreenFragment_to_nameFragment)
                }
            } catch (e: Exception) {
                e.printStackTrace() // Log the exception for debugging purposes
            }

        } , 2000)
        return splashScreenBinding.root
    }

}