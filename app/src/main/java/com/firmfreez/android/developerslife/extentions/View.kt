package com.firmfreez.android.developerslife.extentions

import android.os.CountDownTimer
import android.view.View

fun View.setCountDownListener(interval: Long, action: () -> Unit) {
    var canClick = true
    val countDownTimer: CountDownTimer = object : CountDownTimer(interval, 1L) {
        override fun onTick(millisUntilFinished: Long) {}

        override fun onFinish() {
            canClick = true
        }
    }

    this.setOnClickListener {
        if (canClick) {
            canClick = false
            countDownTimer.start()

            action.invoke()
        }
    }

}