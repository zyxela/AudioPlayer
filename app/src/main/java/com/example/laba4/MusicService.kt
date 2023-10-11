package com.example.laba4

import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import android.os.IBinder
import android.widget.ProgressBar

class MusicService : Service() {
    lateinit var mp: MediaPlayer
    lateinit var pb:ProgressBar
    override fun onBind(p0: Intent?): IBinder? {
        return null
    }

    override fun onCreate() {
        mp = MediaPlayer.create(this, R.raw.music)
     //   pb = findViewById<ProgressBar>()
    }

    override fun onStart(intent: Intent?, startId: Int) {
        mp.start()
    }

    override fun onDestroy() {
        mp.stop()
    }


}