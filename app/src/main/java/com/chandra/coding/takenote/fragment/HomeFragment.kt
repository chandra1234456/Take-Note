package com.chandra.coding.takenote.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.core.content.ContextCompat
import androidx.navigation.fragment.findNavController
import com.chandra.coding.takenote.R
import com.chandra.coding.takenote.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {

    private lateinit var homeBinding : FragmentHomeBinding

    override fun onCreateView(
        inflater : LayoutInflater , container : ViewGroup? ,
        savedInstanceState : Bundle?
                             ) : View {
        homeBinding = FragmentHomeBinding.inflate(layoutInflater)
        val icons = listOf(homeBinding.layoutMenu.ivHome, homeBinding.layoutMenu.ivArchived, homeBinding.layoutMenu.ivOthers, homeBinding.layoutMenu.ivSettings,homeBinding.layoutMenu.createNote)
        icons.forEach { icon ->
            icon.setOnClickListener {
                toggleIcon(icon,icons)
            }
        }
        return homeBinding.root
    }
    private fun toggleIcon(selectedIcon: ImageView, icons: List<ImageView>) {
        icons.forEach { icon ->
            when(selectedIcon){
                homeBinding.layoutMenu.ivSettings ->{
                    findNavController().navigate(R.id.settingsFragment)
                }
                homeBinding.layoutMenu.createNote ->{
                    findNavController().navigate(R.id.createNoteFragment)
                }
            }
            val isSelected = icon == selectedIcon
            icon.background = ContextCompat.getDrawable(
                    requireContext(),
                    if (isSelected) R.drawable.circle_background_selected else R.drawable.circle_background_unselected
                                                       )
            icon.isSelected = isSelected
            icon.setColorFilter(
                    ContextCompat.getColor(
                            requireContext(),
                            if (isSelected) R.color.black else R.color.white
                                          )
                               )
        }
    }

}