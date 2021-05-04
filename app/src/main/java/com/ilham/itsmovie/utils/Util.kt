package com.ilham.itsmovie.utils

import android.content.res.Resources

object Util {
    val Int.dp: Int
        get() = (this * Resources.getSystem().displayMetrics.density + 0.5f).toInt()
}