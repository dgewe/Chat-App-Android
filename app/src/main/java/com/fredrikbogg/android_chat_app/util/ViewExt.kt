package com.fredrikbogg.android_chat_app.util

import android.content.Context
import android.view.View
import android.view.inputmethod.InputMethodManager
import com.fredrikbogg.android_chat_app.R
import com.google.android.material.snackbar.Snackbar

fun View.forceHideKeyboard() {
    val inputManager: InputMethodManager =
        this.context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    inputManager.hideSoftInputFromWindow(this.windowToken, InputMethodManager.HIDE_NOT_ALWAYS)
}

fun View.showSnackBar(text: String) {
    Snackbar.make(this.rootView.findViewById(R.id.container), text, Snackbar.LENGTH_SHORT).show()
}