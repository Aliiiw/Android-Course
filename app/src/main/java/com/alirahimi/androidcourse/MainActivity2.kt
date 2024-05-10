package com.alirahimi.androidcourse

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.alirahimi.androidcourse.databinding.ActivityMain2Binding
import soup.neumorphism.NeumorphImageView
import soup.neumorphism.ShapeType

class MainActivity2 : AppCompatActivity() {
    lateinit var binding: ActivityMain2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.neumorphImageView.setOnClickListener {

            val shapeType = (it as NeumorphImageView).getShapeType()
            if (shapeType == ShapeType.PRESSED) {

                it.setShapeType(ShapeType.FLAT)
                it.setColorFilter(
                    ContextCompat.getColor(this, R.color.icon_default_color),
                    android.graphics.PorterDuff.Mode.SRC_IN
                )

            } else {

                it.setShapeType(ShapeType.PRESSED)
                it.setColorFilter(
                    ContextCompat.getColor(this, R.color.blue_light),
                    android.graphics.PorterDuff.Mode.SRC_IN
                )

                binding.neumorphImageView2.setShapeType(ShapeType.FLAT)
                binding.neumorphImageView3.setShapeType(ShapeType.FLAT)
                binding.neumorphImageView4.setShapeType(ShapeType.FLAT)

                binding.neumorphImageView2.setColorFilter(
                    ContextCompat.getColor(this, R.color.icon_default_color),
                    android.graphics.PorterDuff.Mode.SRC_IN
                )
                binding.neumorphImageView3.setColorFilter(
                    ContextCompat.getColor(this, R.color.icon_default_color),
                    android.graphics.PorterDuff.Mode.SRC_IN
                )
                binding.neumorphImageView4.setColorFilter(
                    ContextCompat.getColor(this, R.color.icon_default_color),
                    android.graphics.PorterDuff.Mode.SRC_IN
                )

            }

        }
        binding.neumorphImageView2.setOnClickListener {

            val shapeType = (it as NeumorphImageView).getShapeType()
            if (shapeType == ShapeType.PRESSED) {

                it.setShapeType(ShapeType.FLAT)
                it.setColorFilter(
                    ContextCompat.getColor(this, R.color.icon_default_color),
                    android.graphics.PorterDuff.Mode.SRC_IN
                )

            } else {

                it.setShapeType(ShapeType.PRESSED)
                it.setColorFilter(
                    ContextCompat.getColor(this, R.color.blue_light),
                    android.graphics.PorterDuff.Mode.SRC_IN
                )

                binding.neumorphImageView.setShapeType(ShapeType.FLAT)
                binding.neumorphImageView3.setShapeType(ShapeType.FLAT)
                binding.neumorphImageView4.setShapeType(ShapeType.FLAT)

                binding.neumorphImageView.setColorFilter(
                    ContextCompat.getColor(this, R.color.icon_default_color),
                    android.graphics.PorterDuff.Mode.SRC_IN
                )
                binding.neumorphImageView3.setColorFilter(
                    ContextCompat.getColor(this, R.color.icon_default_color),
                    android.graphics.PorterDuff.Mode.SRC_IN
                )
                binding.neumorphImageView4.setColorFilter(
                    ContextCompat.getColor(this, R.color.icon_default_color),
                    android.graphics.PorterDuff.Mode.SRC_IN
                )

            }

        }
        binding.neumorphImageView3.setOnClickListener {

            val shapeType = (it as NeumorphImageView).getShapeType()
            if (shapeType == ShapeType.PRESSED) {

                it.setShapeType(ShapeType.FLAT)
                it.setColorFilter(
                    ContextCompat.getColor(this, R.color.icon_default_color),
                    android.graphics.PorterDuff.Mode.SRC_IN
                )

            } else {

                it.setShapeType(ShapeType.PRESSED)
                it.setColorFilter(
                    ContextCompat.getColor(this, R.color.blue_light),
                    android.graphics.PorterDuff.Mode.SRC_IN
                )

                binding.neumorphImageView2.setShapeType(ShapeType.FLAT)
                binding.neumorphImageView.setShapeType(ShapeType.FLAT)
                binding.neumorphImageView4.setShapeType(ShapeType.FLAT)

                binding.neumorphImageView2.setColorFilter(
                    ContextCompat.getColor(this, R.color.icon_default_color),
                    android.graphics.PorterDuff.Mode.SRC_IN
                )
                binding.neumorphImageView.setColorFilter(
                    ContextCompat.getColor(this, R.color.icon_default_color),
                    android.graphics.PorterDuff.Mode.SRC_IN
                )
                binding.neumorphImageView4.setColorFilter(
                    ContextCompat.getColor(this, R.color.icon_default_color),
                    android.graphics.PorterDuff.Mode.SRC_IN
                )

            }

        }
        binding.neumorphImageView4.setOnClickListener {

            val shapeType = (it as NeumorphImageView).getShapeType()
            if (shapeType == ShapeType.PRESSED) {

                it.setShapeType(ShapeType.FLAT)
                it.setColorFilter(
                    ContextCompat.getColor(this, R.color.icon_default_color),
                    android.graphics.PorterDuff.Mode.SRC_IN
                )

            } else {

                it.setShapeType(ShapeType.PRESSED)
                it.setColorFilter(
                    ContextCompat.getColor(this, R.color.blue_light),
                    android.graphics.PorterDuff.Mode.SRC_IN
                )

                binding.neumorphImageView2.setShapeType(ShapeType.FLAT)
                binding.neumorphImageView3.setShapeType(ShapeType.FLAT)
                binding.neumorphImageView.setShapeType(ShapeType.FLAT)

                binding.neumorphImageView2.setColorFilter(
                    ContextCompat.getColor(this, R.color.icon_default_color),
                    android.graphics.PorterDuff.Mode.SRC_IN
                )
                binding.neumorphImageView3.setColorFilter(
                    ContextCompat.getColor(this, R.color.icon_default_color),
                    android.graphics.PorterDuff.Mode.SRC_IN
                )
                binding.neumorphImageView.setColorFilter(
                    ContextCompat.getColor(this, R.color.icon_default_color),
                    android.graphics.PorterDuff.Mode.SRC_IN
                )
            }
        }
    }
}