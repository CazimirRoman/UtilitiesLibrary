package com.cazimir.utilitieslibrary

import android.graphics.Color
import android.view.ViewGroup
import com.google.android.material.snackbar.Snackbar

fun String.pluralize(count: Int): String? {
    return if (count > 1) {
        this + 's'
    } else {
        this
    }
}

fun showSnackbar(coordinator: ViewGroup, message: String) {
    Snackbar.make(coordinator, message, Snackbar.LENGTH_SHORT).setTextColor(Color.WHITE).show()

}



