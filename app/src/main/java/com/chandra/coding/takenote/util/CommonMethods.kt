package com.chandra.coding.takenote.util

import android.content.Context
import android.content.SharedPreferences
import android.view.View
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar


private var sharedPreferencesLogin : SharedPreferences? = null

fun View.setOnSingleClickListener(delay : Long = 500L , block : () -> Unit) {
    setOnClickListener(OnSingleClickListener(delay , block))
}

// Method to show a Snackbar with an action button
fun View.showSnackBar(view : View , message : String , actionText : String? , action : () -> Unit) {
    Snackbar.make(view , message , Snackbar.LENGTH_LONG).setAction(actionText) {
        action()
    }.show()
}

fun loginUserName(
    savedName : String ,
    name : String ,
    isLoggedIn : String ,
    isLogged : Boolean ,
    context : Context
                 ) {
    sharedPreferencesLogin = context.getSharedPreferences("Profile" , Context.MODE_PRIVATE)
    val editor = sharedPreferencesLogin?.edit()
    editor?.putString(savedName , name)
    editor?.putBoolean(isLoggedIn , isLogged)
    editor?.apply()
}

fun retrieveLoginUserName(savedName : String) : String? {
    return sharedPreferencesLogin?.getString(savedName , null)
}

fun retrieveIsLoggedIn(isLoggedIn : String?) : Boolean? {
     return sharedPreferencesLogin?.getBoolean(isLoggedIn , false)
}

fun toastMsg(context : Context , message : String) {
    Toast.makeText(context , message , Toast.LENGTH_SHORT).show()
}