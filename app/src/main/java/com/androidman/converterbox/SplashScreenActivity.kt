package com.androidman.converterbox

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.WindowManager
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.TextView

class SplashScreenActivity : AppCompatActivity() {

    val SPLASH_SCREEN = 2000

    private lateinit var topanimation: Animation
    private  lateinit var bottomanimation: Animation

    private lateinit var imageView: ImageView
    private lateinit var title_txt : TextView



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //hide status bar
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)

        setContentView(R.layout.activity_splash_screen)

        val actionBar = supportActionBar

        topanimation = AnimationUtils.loadAnimation(this,R.anim.top_animation)
        bottomanimation = AnimationUtils.loadAnimation(this,R.anim.bottom_animation)

        imageView = findViewById(R.id.hr_image)
        title_txt = findViewById(R.id.title_text)

        imageView.animation = topanimation
        title_txt.animation = bottomanimation

        Handler().postDelayed({

            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
            finish()

        },SPLASH_SCREEN.toLong())

    }
}