package com.example.meterial

import android.graphics.Color
import android.graphics.Paint
import android.os.Bundle
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.example.myapplication.R
import com.google.android.material.shape.*

class MaterialShapeDrawableActivity : BaseActivity() {
    private lateinit var textView01: TextView
    private lateinit var textView02: TextView
    private lateinit var textView03: TextView
    private lateinit var textView04: TextView
    private lateinit var textView05: TextView
    private lateinit var textView06: TextView
    private lateinit var textView07: TextView
    private lateinit var textView08: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_material_shape_drawable)
        textView01 = findViewById(R.id.textView01)
        textView02 = findViewById(R.id.textView02)
        textView03 = findViewById(R.id.textView03)
        textView04 = findViewById(R.id.textView04)
        textView05 = findViewById(R.id.textView05)
        textView06 = findViewById(R.id.textView06)
        textView07 = findViewById(R.id.textView07)
        textView08 = findViewById(R.id.textView08)

        test1()
        test2()
        test3()
        test4()
        test5()
        test6()
        test7()
        test8()
    }

    private fun test1() {
        val shapeModel = ShapeAppearanceModel.builder()
            .setAllCorners(RoundedCornerTreatment())
            .setAllCornerSizes(dp2px(10F))
            .build()
        val backgroundDrawable = MaterialShapeDrawable(shapeModel).apply {
            setTint(Color.GRAY)
            paintStyle = Paint.Style.FILL
        }
        textView01.background = backgroundDrawable
    }

    private fun test2() {
        val shapeModel = ShapeAppearanceModel.builder()
            .setAllCorners(RoundedCornerTreatment())
            .setAllCornerSizes(dp2px(10F))
            .setAllEdges(TriangleEdgeTreatment(dp2px(10F), true))
            .build()
        val backgroundDrawable = MaterialShapeDrawable(shapeModel).apply {
            setTint(Color.GRAY)
            paintStyle = Paint.Style.FILL_AND_STROKE
            strokeWidth = dp2px(2F)
            strokeColor = ContextCompat.getColorStateList(context, R.color.red)
        }
        textView02.background = backgroundDrawable
    }

    private fun test3() {
        val shapeModel = ShapeAppearanceModel.builder()
            .setAllCorners(RoundedCornerTreatment())
            .setAllCornerSizes(dp2px(10F))
            .setAllEdges(TriangleEdgeTreatment(dp2px(10F), false))
            .build()
        val backgroundDrawable = MaterialShapeDrawable(shapeModel).apply {
            setTint(Color.GRAY)
            paintStyle = Paint.Style.FILL_AND_STROKE
            strokeWidth = dp2px(2F)
            strokeColor = ContextCompat.getColorStateList(context, R.color.red)
        }
        (textView03.parent as ViewGroup).clipChildren = false
        textView03.background = backgroundDrawable
    }

    private fun test4() {
        val shapeModel = ShapeAppearanceModel.builder()
            .setAllCornerSizes(dp2px(6F))
            .setBottomEdge(
                OffsetEdgeTreatment(
                    TriangleEdgeTreatment(dp2px(6F), false),
                    dp2px(30F)
                )
            )
            .build()
        val backgroundDrawable = MaterialShapeDrawable(shapeModel).apply {
            setTint(Color.parseColor("#FA4B05"))
            paintStyle = Paint.Style.FILL
        }
        (textView04.parent as ViewGroup).clipChildren = false
        textView04.background = backgroundDrawable
    }

    private fun test5() {
        val shapeModel = ShapeAppearanceModel.builder()
            .setAllCornerSizes(dp2px(6F))
            .setRightEdge(
                OffsetEdgeTreatment(
                    TriangleEdgeTreatment(dp2px(6F), false),
                    dp2px(0F)
                )
            )
            .build()
        val backgroundDrawable = MaterialShapeDrawable(shapeModel).apply {
            setTint(Color.parseColor("#FA4B05"))
            paintStyle = Paint.Style.FILL
        }
        (textView05.parent as ViewGroup).clipChildren = false
        textView05.background = backgroundDrawable
    }

    private fun test6() {
        val shapeModel = ShapeAppearanceModel.builder()
            .setAllCorners(CutCornerTreatment())
            .setAllCornerSizes(dp2px(10F))
            .build()
        val backgroundDrawable = MaterialShapeDrawable(shapeModel).apply {
            setTint(Color.GRAY)
            paintStyle = Paint.Style.FILL
        }
        textView06.background = backgroundDrawable
    }

    private fun test7() {
        val shapeModel = ShapeAppearanceModel.builder()
            .setAllCorners(RoundedCornerTreatment())
            .setAllCornerSizes(dp2px(10F))
            .setAllEdges(MarkerEdgeTreatment(dp2px(10F)))
            .build()
        val backgroundDrawable = MaterialShapeDrawable(shapeModel).apply {
            setTint(Color.GRAY)
            paintStyle = Paint.Style.FILL_AND_STROKE
            strokeWidth = dp2px(2F)
            strokeColor = ContextCompat.getColorStateList(context, R.color.red)
        }
        textView07.background = backgroundDrawable
    }

    /**
     * 阴影效果
     */
    private fun test8() {
        val shapeModel = ShapeAppearanceModel.builder()
            .setAllCorners(RoundedCornerTreatment())
            .setAllCornerSizes(dp2px(16F))
            .build()
        val backgroundDrawable = MaterialShapeDrawable(shapeModel).apply {
            setTint(Color.parseColor("#05BEBEBE"))
            paintStyle = Paint.Style.FILL
            shadowCompatibilityMode = MaterialShapeDrawable.SHADOW_COMPAT_MODE_ALWAYS
            initializeElevationOverlay(context)
            shadowRadius = dp2px(16F).toInt()
            setShadowColor(Color.RED)
            shadowVerticalOffset = dp2px(2F).toInt()
        }
        (textView08.parent as ViewGroup).clipChildren = false
        textView08.background = backgroundDrawable
    }
}