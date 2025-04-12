package com.sequeniatest.movies.data.helper

fun Int?.orDefault(default: Int = 0): Int = this ?: default

fun Short?.orDefault(default: Short = 0): Short = this ?: default

fun Double?.orDefault(default: Double = .0): Double = this ?: default
