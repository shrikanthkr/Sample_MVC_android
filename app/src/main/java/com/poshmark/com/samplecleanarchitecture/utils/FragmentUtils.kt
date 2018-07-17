package com.poshmark.com.samplecleanarchitecture.utils

import android.support.v4.app.Fragment

fun Fragment.requireParentFragment(): Fragment {
    return parentFragment ?: error("Parent fragment is null.")
}