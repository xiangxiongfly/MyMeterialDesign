package com.example.myapplication

import android.graphics.Outline
import android.graphics.Path
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewOutlineProvider
import android.widget.ImageView

class ShapeableImageViewActivity : AppCompatActivity() {
    private lateinit var imageView01: ImageView
    private lateinit var imageView02: ImageView
    private lateinit var imageView03: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shapeable_image_view)
        imageView01 = findViewById(R.id.imageView01)
        imageView02 = findViewById(R.id.imageView02)
        imageView03 = findViewById(R.id.imageView03)

        //绘制圆角
        imageView01.apply {
            outlineProvider = object : ViewOutlineProvider() {
                override fun getOutline(view: View, outline: Outline) {
                    outline.setRoundRect(0, 0, view.width, view.height, dp2px(30F))
                }
            }
            clipToOutline = true
        }

        //绘制圆形
        imageView02.apply {
            outlineProvider = object : ViewOutlineProvider() {
                override fun getOutline(view: View, outline: Outline) {
                    outline.setOval(0, 0, view.width, view.height)
                }
            }
            clipToOutline = true
        }

        //绘制矩形
        imageView03.apply {
            outlineProvider = object : ViewOutlineProvider() {
                override fun getOutline(view: View, outline: Outline) {
                    val path = Path()
                    view.elevation = 10F
                    val gap = -30F
                    path.moveTo(-gap, -gap)
                    path.lineTo(-gap, view.height.toFloat() + gap)
                    path.lineTo(view.width.toFloat() + gap, view.height.toFloat() + gap)
                    path.lineTo(view.width.toFloat() + gap, -gap)
                    path.close()
                    outline.setConvexPath(path)
                }
            }
            clipToOutline = true
        }
    }
}