package com.example.myapplication

import android.content.res.Resources
import android.util.TypedValue
import android.widget.Toast

fun String.showToast() {
    Toast.makeText(BaseApp.context, this, Toast.LENGTH_SHORT).show()
}

fun dp2px(dpValue: Float): Float {
    return TypedValue.applyDimension(
        TypedValue.COMPLEX_UNIT_DIP,
        dpValue,
        Resources.getSystem().displayMetrics
    )
}