package com.chandra.coding.takenote.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.chandra.coding.takenote.Constants
import com.chandra.coding.takenote.R
import com.chandra.coding.takenote.databinding.FragmentNameBinding
import com.chandra.coding.takenote.util.loginUserName
import com.chandra.coding.takenote.util.setOnSingleClickListener
import com.chandra.coding.takenote.util.showSnackBar


class NameFragment : Fragment() {
    private lateinit var nameBinding : FragmentNameBinding
    override fun onCreateView(
        inflater : LayoutInflater , container : ViewGroup? ,
        savedInstanceState : Bundle?
                             ) : View {
        nameBinding = FragmentNameBinding.inflate(layoutInflater)
        nameBinding.proceedBtn.setOnSingleClickListener {
            setNameHeader()
            findNavController().navigate(R.id.action_nameFragment_to_homeFragment)
        }
        return nameBinding.root
    }

    private fun setNameHeader() {
        if (nameBinding.edittext.text.toString().isNotEmpty()) {
            loginUserName(
                    Constants.USERNAME ,
                    nameBinding.edittext.text.toString() ,
                    Constants.LOGGED_IN ,
                    true ,
                    requireContext()
                         )

        } else {
            nameBinding.root.showSnackBar(requireView() , "Please Enter Your Name" , "" , {})
        }
    }
}