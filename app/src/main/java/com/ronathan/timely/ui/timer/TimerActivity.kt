package com.ronathan.timely.ui.timer

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.text.format.DateUtils
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.FragmentManager
import butterknife.BindView
import butterknife.ButterKnife
import butterknife.OnClick
import com.ronathan.timely.R
import com.ronathan.timely.ui.category.CategoryPromptFragment
import com.ronathan.utils.Stopwatch

class TimerActivity : AppCompatActivity() {

    companion object {

        const val TIMER_DELAY = 1000L
        fun createIntent(context: Context): Intent {
            return Intent(context, TimerActivity::class.java)
        }
    }

    // region UI Properties
    @BindView(R.id.timer_container) lateinit var timerContainer: ConstraintLayout
    @BindView(R.id.timer) lateinit var timerTextView: TextView

    @OnClick(R.id.startButton)
    fun onStartClicked() {
        stopwatch.start()
        isRunning = true
        handler.post(stopwatchTimer)
    }

    @OnClick(R.id.stopButton)
    fun onStopClicked() {
        isRunning = false
        stopwatch.stop()
        showCategoryPrompt()
    }
    // endregion

    // region Properties
    private val fm: FragmentManager = supportFragmentManager

    private val stopwatch = Stopwatch()
    private val handler = Handler()
    private var isRunning = false
    private val stopwatchTimer = object : Runnable {
        override fun run() {
            if (isRunning) {
                setTimerText(stopwatch.elapsedTime)
                handler.postDelayed(this, TIMER_DELAY)
            }
        }
    }
    // endregion

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_timer)
        ButterKnife.bind(this)
    }

    private fun setTimerText(time: Long) {
        timerTextView.text = DateUtils.formatElapsedTime(time / TIMER_DELAY)
    }

    private fun showCategoryPrompt() {
        fm.beginTransaction().add(R.id.timer_container, CategoryPromptFragment()).commit()
    }
}