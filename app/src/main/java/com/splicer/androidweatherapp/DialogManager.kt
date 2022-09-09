package com.splicer.androidweatherapp

import android.app.AlertDialog
import android.content.Context

object DialogManager {
    fun locationSettngsDialog(context: Context, listener: Listener) {
        val builder = AlertDialog.Builder(context)
        val dialog = builder.create()
        dialog.setTitle("Enable location?")
        dialog.setMessage("Location disabled. Do you want enable location?")
        dialog.setButton(AlertDialog.BUTTON_POSITIVE, "OK") { _, _ ->
            dialog.dismiss()
            listener.onClick()
        }
        dialog.setButton(AlertDialog.BUTTON_NEGATIVE, "Cancel") { _, _ ->
            dialog.dismiss()
        }
        dialog.show()
    }
    interface Listener{
        fun onClick()
    }
}