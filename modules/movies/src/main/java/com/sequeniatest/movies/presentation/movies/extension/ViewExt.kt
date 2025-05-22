package com.sequeniatest.movies.presentation.movies.extension

import android.view.View
import androidx.core.graphics.Insets
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.updatePadding

fun View.fitInsetsWithPadding() {
    ViewCompat.setOnApplyWindowInsetsListener(this) { view, insets ->
        val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
        view.updatePadding(
            top = systemBars.top + view.paddingTop,
            bottom = systemBars.bottom + view.paddingBottom,
        )

        WindowInsetsCompat.Builder().setInsets(
            WindowInsetsCompat.Type.systemBars(),
            Insets.of(
                systemBars.left,
                0,
                systemBars.right,
                0,
            ),
        ).build()
    }
}

fun View.fitBottomInsetsWithPadding() {
    ViewCompat.setOnApplyWindowInsetsListener(this) { view, insets ->
        val windowInsets = insets.getInsets(WindowInsetsCompat.Type.systemBars())
        view.updatePadding(
            bottom = windowInsets.bottom + view.paddingBottom,
        )
        WindowInsetsCompat.Builder().setInsets(
            WindowInsetsCompat.Type.systemBars(),
            Insets.of(
                windowInsets.left,
                windowInsets.top,
                windowInsets.right,
                0,
            ),
        ).build()
    }
}
