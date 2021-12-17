package com.example.myapplication

import android.content.res.Resources
import android.util.TypedValue

fun dp2px(dpValue: Float): Float {
    return TypedValue.applyDimension(
        TypedValue.COMPLEX_UNIT_DIP,
        dpValue,
        Resources.getSystem().displayMetrics
    )
}