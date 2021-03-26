package com.example.jetpackcomposeexample.utils

import android.app.Activity
import android.view.View
import androidx.core.view.ViewCompat

fun Activity.showLightStatusBar() {
    window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
    ViewCompat.setOnApplyWindowInsetsListener(
        window.decorView
    ) { _, insets ->
        ViewCompat.onApplyWindowInsets(
            window.decorView,
            insets.replaceSystemWindowInsets(
                insets.systemWindowInsetLeft, 0,
                insets.systemWindowInsetRight, insets.systemWindowInsetBottom
            )
        )
    }
}