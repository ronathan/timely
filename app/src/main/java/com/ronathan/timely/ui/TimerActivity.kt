package com.ronathan.timely.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.PersistableBundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import butterknife.BindView
import com.ronathan.timely.R
import com.ronathan.utils.Stopwatch

class TimerActivity : AppCompatActivity() {

    companion object {
        fun createIntent(context: Context): Intent {
            return Intent(context, TimerActivity::class.java)
        }
    }

    // region UI Properties
    @BindView(R.id.timer) lateinit var timerTextView: TextView
    // endregion

    // region Properties
    private val stopwatch = Stopwatch()
    // endregion

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)

        setContentView(R.layout.activity_timer)
    }
}