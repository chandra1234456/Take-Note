package com.chandra.coding.takenote.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.chandra.coding.takenote.MainActivity
import com.chandra.coding.takenote.R
import com.chandra.coding.takenote.databinding.FragmentCreateNoteBinding


class CreateNoteFragment : Fragment() {
   private lateinit var createNoteBinding : FragmentCreateNoteBinding
   private lateinit var  callback :OnBackPressedCallback
    override fun onCreateView(
        inflater : LayoutInflater , container : ViewGroup? ,
        savedInstanceState : Bundle?
                             ) : View {
        createNoteBinding = FragmentCreateNoteBinding.inflate(layoutInflater)
        (activity as MainActivity).supportActionBar?.setDisplayHomeAsUpEnabled(false)
        //back press
        val callback = object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                Log.d("YES" , "handleOnBackPressed: YES")
                findNavController().navigate(R.id.homeFragment)
            }
        }
        requireActivity().onBackPressedDispatcher.addCallback(requireActivity(), callback)
        return createNoteBinding.root
    }


}