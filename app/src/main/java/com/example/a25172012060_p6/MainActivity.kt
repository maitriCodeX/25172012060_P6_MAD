package com.example.a25172012060_p6

import android.graphics.drawable.AnimationDrawable
import android.os.Bundle
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private lateinit var alarmClockFrames: AnimationDrawable
    private lateinit var heartAnimationDrawable: AnimationDrawable

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val root = findViewById<View>(R.id.main)
        ViewCompat.setOnApplyWindowInsetsListener(root) { v, insets ->
            val bars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(bars.left, bars.top, bars.right, bars.bottom)
            insets
        }

        val ivClock = findViewById<ImageView>(R.id.ivAlarmClock)
        ivClock.setBackgroundResource(R.drawable.alarm_clock_animation)
        alarmClockFrames = ivClock.background as AnimationDrawable

        val ivHeart = findViewById<ImageView>(R.id.ivHeart)
        ivHeart.setBackgroundResource(R.drawable.heart_favorite_animation)
        heartAnimationDrawable = ivHeart.background as AnimationDrawable

        val btnCreate = findViewById<Button>(R.id.btnCreateAlarm)
        val btnCancel = findViewById<Button>(R.id.btnCancelAlarm)

        btnCreate.setOnClickListener {
            it.startAnimation(AnimationUtils.loadAnimation(this, R.anim.create_alarm_anim))
            Toast.makeText(this, "Alarm Created", Toast.LENGTH_SHORT).show()
        }

        btnCancel.setOnClickListener {
            Toast.makeText(this, "Alarm Cancelled", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)
        if (hasFocus) {
            if (::alarmClockFrames.isInitialized) {
                alarmClockFrames.start()
            }
            if (::heartAnimationDrawable.isInitialized) {
                heartAnimationDrawable.start()
            }
        }
    }
}