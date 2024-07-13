package com.chandra.coding.takenote.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.chandra.coding.takenote.databinding.FragmentSettingsBinding


class SettingsFragment : Fragment() {
private lateinit var settingsBinding : FragmentSettingsBinding
    override fun onCreateView(
        inflater : LayoutInflater , container : ViewGroup? ,
        savedInstanceState : Bundle?
                             ) : View {
        settingsBinding = FragmentSettingsBinding.inflate(layoutInflater)
        return settingsBinding.root
    }


}