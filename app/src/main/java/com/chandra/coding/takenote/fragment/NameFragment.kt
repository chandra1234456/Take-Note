package com.chandra.coding.takenote.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.chandra.coding.takenote.MainActivity
import com.chandra.coding.takenote.R
import com.chandra.coding.takenote.databinding.FragmentNameBinding
import com.chandra.coding.takenote.util.setOnSingleClickListener


class NameFragment : Fragment() {
    private lateinit var nameBinding : FragmentNameBinding
    override fun onCreateView(
        inflater : LayoutInflater , container : ViewGroup? ,
        savedInstanceState : Bundle?
                             ) : View {
        nameBinding = FragmentNameBinding.inflate(layoutInflater)
        nameBinding.buttonContinue.setOnSingleClickListener {
            findNavController().navigate(R.id.action_nameFragment_to_homeFragment)
        }
        return nameBinding.root
    }
}