package com.ronathan.timely.ui

import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.ronathan.timely.R.layout

/**
 * Landing page for Timely
 */
class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout.activity_splash)

        //
        Handler().postDelayed({
            startActivity(TimerActivity.createIntent(this))
            finish()
        }, 1000)
    }
}
