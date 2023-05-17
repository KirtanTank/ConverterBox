package com.androidman.converterbox

import android.graphics.drawable.AnimationDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.ImageView
import com.androidman.converterbox.MainActivity3.Companion.redirectActivity
import kotlinx.android.synthetic.main.activity_number.*

class Number : AppCompatActivity() {
    var imagebutton: ImageView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_number)

        val animDrawable = number_layout.background as AnimationDrawable
        animDrawable.setEnterFadeDuration(10)
        animDrawable.setExitFadeDuration(5000)
        animDrawable.start()

        val anim = AnimationUtils.loadAnimation(this,R.anim.stripe_anim)
        stripes23.startAnimation(anim)

        imagebutton = findViewById(R.id.backbutton)

        imagebutton!!.setOnClickListener(View.OnClickListener {

            redirectActivity(this, MainActivity4::class.java)
            finish()

        })
    }
}