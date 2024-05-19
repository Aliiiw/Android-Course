package com.alirahimi.androidcourse


import android.net.Uri
import android.os.Bundle
import android.widget.MediaController
import androidx.appcompat.app.AppCompatActivity
import com.alirahimi.androidcourse.databinding.ActivityMainBinding
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.MediaItem


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var exoPlayer: ExoPlayer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initialBinding()
        //configVideo()
        configExoPlayer()
    }

    private fun initialBinding() {
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    private fun configVideo() {

        //TODO 1. VideoView

//        binding.videoView.setVideoURI(videoUri)
////        binding.playButton.setOnClickListener {
////            binding.videoView.start()
////        }
////        //TODO 2. Media Controller
//        val mediaController = MediaController(this)
//        mediaController.setMediaPlayer(binding.videoView)
//        binding.videoView.setMediaController(mediaController)
//        //TODO 3. Prepared
//        binding.videoView.setOnPreparedListener {
//            binding.videoView.start()
//        }
//        //TODO 4. OnComplete
//        binding.videoView.setOnCompletionListener {
//            it.stop()
//            it.seekTo(190000)
//        }
    }


    //TODO 5.  ExoPlayer
    private fun configExoPlayer() {
        val videoUri = Uri.parse("android.resource://" + packageName + "/" + R.raw.test)
        exoPlayer = ExoPlayer.Builder(this).build()

        val mediaItem = MediaItem.fromUri(videoUri)
        exoPlayer.setMediaItem(mediaItem)
//
        exoPlayer.prepare()
        exoPlayer.playWhenReady = true
        exoPlayer.play()
//
        binding.playerView.player = exoPlayer
    }
}