package com.chandra.coding.takenote

import android.os.Bundle
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.chandra.coding.takenote.databinding.ActivityMainBinding
import com.chandra.coding.takenote.util.retrieveLoginUserName
import com.google.android.material.navigation.NavigationView
import com.google.android.material.textview.MaterialTextView


class MainActivity : AppCompatActivity() , NavigationView.OnNavigationItemSelectedListener {
    private lateinit var mainBinding : ActivityMainBinding
    private lateinit var appBarConfiguration : AppBarConfiguration
    private var loginUserName : String = ""


    override fun onCreate(savedInstanceState : Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)
        setSupportActionBar(mainBinding.toolbar)
        val drawerLayout = mainBinding.drawerLayout
        val navigationView : NavigationView = mainBinding.navigationView
        val navController = findNavController(R.id.nav_host_fragment)
        /*appBarConfiguration = AppBarConfiguration(
                setOf(
                        R.id.notes,
                        R.id.remainder,
                        R.id.archived,
                        R.id.delete,
                        R.id.settings
                     ), drawerLayout
                                                 )*/
        appBarConfiguration = AppBarConfiguration(
                setOf(
                        R.id.homeFragment ,
                        R.id.settingsFragment
                     ) , drawerLayout
                                                 )
        setupActionBarWithNavController(navController , appBarConfiguration)
        navigationView.setupWithNavController(navController)
        navigationView.setNavigationItemSelectedListener(this)
        navigationView.setCheckedItem(R.id.notes)
        // Hide or show the toolbar based on the destination
        navController.addOnDestinationChangedListener { _ , destination , _ ->
            when (destination.id) {
                R.id.loadingScreenFragment , R.id.nameFragment -> {
                    supportActionBar?.hide()
                }

                else -> {
                    supportActionBar?.show()
                }
            }
        }
        setUpNavigationHeader(navController)

    }

    private fun setUpNavigationHeader(navController : NavController) {
        // Listen for destination changes to update the header when navigating
        navController.addOnDestinationChangedListener { _ , destination , _ ->
            when (destination.id) {
                R.id.homeFragment , R.id.settingsFragment , R.id.createNoteFragment -> {
                    loginUserName = retrieveLoginUserName(Constants.USERNAME) ?: "Note"
                    val header : View = mainBinding.navigationView.getHeaderView(0)
                    val headerName : MaterialTextView = header.findViewById(R.id.headerName)
                    headerName.text = loginUserName.ifEmpty { "Note" }
                }
                // Add other fragments if needed
            }
        }
    }

    override fun onBackPressed() {
        if (mainBinding.drawerLayout.isDrawerOpen(GravityCompat.START)) {
            mainBinding.drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onSupportNavigateUp() : Boolean {
        val navController = findNavController(R.id.nav_host_fragment)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }

    override fun onNavigationItemSelected(item : MenuItem) : Boolean {
        val navController =
            findNavController(R.id.nav_host_fragment) // Ensure the correct view ID is used
        when (item.itemId) {
            R.id.notes -> {
                navController.navigate(R.id.homeFragment)
                return true
            }

            R.id.settings -> {
                navController.navigate(R.id.settingsFragment)
                return true
            }
        }
        return true
    }

}
