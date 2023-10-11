package com.example.laba4

import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import android.widget.Button
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.GlobalScope


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val playBtn = findViewById<Button>(R.id.button)
        val progressBar = findViewById<ProgressBar>(R.id.progressBar)
        var mediaPlayer = MediaPlayer()
        mediaPlayer = MediaPlayer.create(this, R.raw.music)

        playBtn.setOnClickListener {
            if (playBtn.text == "Play") {
                startService(Intent(this, MusicService::class.java))
                playBtn.text = "Stop"
                /*GlobalScope.launch {
                    val x = mediaPlayer.duration.toFloat()
                    while (true) {
                        if (mediaPlayer.isPlaying)
                            progressBar.progress = (mediaPlayer.currentPosition.toFloat() / x * 100).toInt()

                    }
                }*/
            } else {
                stopService(Intent(this, MusicService::class.java))
                playBtn.text = "Play"
            }
        }


    }
}