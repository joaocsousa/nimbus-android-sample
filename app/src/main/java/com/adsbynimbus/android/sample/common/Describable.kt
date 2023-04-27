package com.adsbynimbus.android.sample.common

interface Describable {
    val description: String

    val identifier: String get() = description
        .split(" ")
        .joinToString(separator = "") {
            it.toLowerCase().replaceRange(0, 1, "${it.first().toUpperCase()}")
        }
}
