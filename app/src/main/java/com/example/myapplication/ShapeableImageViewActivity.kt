package com.example.myapplication

import android.graphics.Outline
import android.graphics.Path
import android.os.Bundle
import android.view.View
import android.view.ViewOutlineProvider
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

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


        imageView03.apply {
            outlineProvider = object : ViewOutlineProvider() {
                override fun getOutline(view: View, outline: Outline) {
                    view.elevation = 10F
                    val gap = 20F
                    val path = Path()
                    path.moveTo(-gap, -gap)
                    path.lineTo(-gap, view.measuredHeight.toFloat() + gap) //左下点
                    path.lineTo(
                        (view.measuredWidth / 2).toFloat(),
                        (view.measuredHeight + 50).toFloat()
                    )
                    path.lineTo(
                        view.measuredWidth.toFloat() + gap,
                        view.measuredHeight.toFloat() + gap
                    )
                    path.lineTo(view.measuredWidth.toFloat() + gap, -gap) //右上点
                    path.close()
                    outline.setConvexPath(path)
                    view.scaleX = 0.5F
                    view.scaleY = 0.5F
                }
            }
        }
    }
}