package com.chandra.coding.takenote.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.chandra.coding.takenote.R
import com.chandra.coding.takenote.adapter.NoteAdapter
import com.chandra.coding.takenote.data.Note
import com.chandra.coding.takenote.databinding.FragmentHomeBinding
import com.chandra.coding.takenote.util.setOnSingleClickListener


class HomeFragment : Fragment() {
    private lateinit var homeBinding : FragmentHomeBinding

    override fun onCreateView(
        inflater : LayoutInflater , container : ViewGroup? ,
        savedInstanceState : Bundle?
                             ) : View {
        homeBinding = FragmentHomeBinding.inflate(layoutInflater)

        homeBinding.createNote.setOnSingleClickListener {
            findNavController().navigate(R.id.createNoteFragment)
        }

        homeBinding.recyclerView.layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)

        val notes = listOf(
                Note("Title 1" , "Content 1") ,
                Note("Title 2", "Content 2"),
                Note("Title 3", "Content 3")
                          )

        homeBinding.recyclerView.adapter = NoteAdapter(notes)
        return homeBinding.root
    }


}