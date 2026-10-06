package com.example.a25172012060_p6

import android.graphics.drawable.AnimationDrawable
import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.content.Intent

class SplashActivity : AppCompatActivity(), Animation.AnimationListener {
    lateinit var guni_frame_animation: AnimationDrawable
    lateinit var img_logo: ImageView
    lateinit var guni_animation: Animation

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_splash)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        img_logo = findViewById(R.id.imgLogo)
        img_logo.setBackgroundResource(R.drawable.uvpce_animation_list)
        guni_frame_animation = img_logo.background as AnimationDrawable
        guni_animation = AnimationUtils.loadAnimation(this, R.anim.twinanimation)
        guni_animation.setAnimationListener(this)
    }

    override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)
        if(hasFocus){
            guni_frame_animation.start()
            img_logo.startAnimation(guni_animation)
        }
        else{
            guni_frame_animation.stop()
        }
    }

    override fun onAnimationEnd(animation: Animation?) {
        startActivity(Intent(this, MainActivity::class.java))
        finish()
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
    }

    override fun onAnimationRepeat(animation: Animation?) {

    }

    override fun onAnimationStart(animation: Animation?) {

    }
}