package com.chandra.coding.takenote.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.chandra.coding.takenote.databinding.FragmentCreateNoteBinding

class CreateNoteFragment : Fragment() {
   private lateinit var createNoteBinding : FragmentCreateNoteBinding
    override fun onCreateView(
        inflater : LayoutInflater , container : ViewGroup? ,
        savedInstanceState : Bundle?
                             ) : View {
        createNoteBinding = FragmentCreateNoteBinding.inflate(layoutInflater)
        return createNoteBinding.root
    }


}