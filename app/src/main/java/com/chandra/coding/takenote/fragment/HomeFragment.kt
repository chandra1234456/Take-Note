package com.chandra.coding.takenote.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.chandra.coding.takenote.Constants
import com.chandra.coding.takenote.R
import com.chandra.coding.takenote.adapter.NoteAdapter
import com.chandra.coding.takenote.data.Note
import com.chandra.coding.takenote.databinding.FragmentHomeBinding
import com.chandra.coding.takenote.util.retrieveLoginUserName
import com.chandra.coding.takenote.util.setOnSingleClickListener
import com.chandra.coding.takenote.util.showSnackBar
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.textview.MaterialTextView


class HomeFragment : Fragment() {
    private lateinit var homeBinding : FragmentHomeBinding
    private var isHomeIconToggled = false
    private var dataList: MutableList<Note> = mutableListOf()
    private lateinit var noteAdapter : NoteAdapter


    override fun onCreateView(
        inflater : LayoutInflater , container : ViewGroup? ,
        savedInstanceState : Bundle?
                             ) : View {
        homeBinding = FragmentHomeBinding.inflate(layoutInflater)
        // it will add menu options
        setHasOptionsMenu(true)

        dataList.add(Note("Title 1" , "Content 1"))
        dataList.add(Note("Title 2" , "Content 2"))
        dataList.add(Note("Title 3" , "Content 3"))
        dataList.add(Note("Title 4" , "Content 4"))
        noteAdapter = NoteAdapter(requireContext(),dataList)
      //  val animation : LayoutAnimationController = AnimationUtils.loadLayoutAnimation(requireContext() , R.anim.layout_right_to_left)
        //homeBinding.recyclerView.layoutAnimation = animation
        homeBinding.recyclerView.layoutManager = StaggeredGridLayoutManager(2 , StaggeredGridLayoutManager.VERTICAL)
        homeBinding.recyclerView.adapter = noteAdapter
        homeBinding.createNote.setOnSingleClickListener {
            findNavController().navigate(R.id.createNoteFragment)
        }

        return homeBinding.root
    }

    override fun onCreateOptionsMenu(menu : Menu , inflater : MenuInflater) {
        // Do something that differs the Activity's menu here
        inflater.inflate(R.menu.home_menu , menu)
        super.onCreateOptionsMenu(menu , inflater)
    }

    override fun onOptionsItemSelected(item : MenuItem) : Boolean {
        // Handle item selection
        return when (item.itemId) {
            R.id.home_grid -> {
                toggleHomeIcon(item)
                true
            }

            R.id.home_list -> {
                materialAlertDialog()
                true
            }

            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun materialAlertDialog() {
        val singleItems = arrayOf("Ascending Order", "Descending Order", "By Created Date")
        var selectedItemIndex = -1

        MaterialAlertDialogBuilder(requireContext())
                .setTitle("Sort Your Order")
                .setSingleChoiceItems(singleItems, selectedItemIndex) { dialog, which ->
                    selectedItemIndex = which
                }
                .setPositiveButton("OK") { dialog, _ ->
                    if (selectedItemIndex != -1) {
                        val selectedItem = singleItems[selectedItemIndex]
                        Toast.makeText(requireContext(), "Selected: $selectedItem", Toast.LENGTH_SHORT).show()
                        homeBinding.root.showSnackBar(requireView(),"Selected: $selectedItem","",{})
                        if (selectedItem =="Ascending Order"){
                            sortDataAscending()
                        }else if(selectedItem =="Descending Order") {
                            sortDataDescending()
                        }
                    } else {
                        Toast.makeText(requireContext(), "No option selected", Toast.LENGTH_SHORT).show()
                       homeBinding.root.showSnackBar(requireView(),"No option selected","",{})
                    }
                }
                .setNegativeButton("Cancel") { dialog, _ ->
                    dialog.dismiss()
                }
                .show()

    }

    private fun toggleHomeIcon(item : MenuItem) {
        if (isHomeIconToggled) {
            item.icon = ContextCompat.getDrawable(
                    requireContext() ,
                    R.drawable.ic_list
                                                 ) // Set the original icon
            homeBinding.recyclerView.layoutManager =
                StaggeredGridLayoutManager(2 , StaggeredGridLayoutManager.VERTICAL)
        } else {
            item.icon = ContextCompat.getDrawable(
                    requireContext() ,
                    R.drawable.ic_grid_view
                                                 ) // Set the toggled icon
            homeBinding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        }
        isHomeIconToggled = ! isHomeIconToggled
    }

    private fun sortDataAscending() {
        val sortedList = dataList.sortedWith(compareBy<Note> { it.title }
                .thenBy { it.title })
        noteAdapter.updateData(sortedList)
    }

    private fun sortDataDescending() {
        val sortedList = dataList.sortedWith(compareByDescending<Note> { it.title}
                .thenByDescending { it.title })
        noteAdapter.updateData(sortedList)
    }
}