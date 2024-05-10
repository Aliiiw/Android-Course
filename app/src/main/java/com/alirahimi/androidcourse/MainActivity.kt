package com.alirahimi.androidcourse

import android.animation.ObjectAnimator
import android.annotation.SuppressLint
import android.media.AudioManager
import android.media.MediaPlayer
import android.os.Bundle
import android.view.animation.LinearInterpolator
import androidx.appcompat.app.AppCompatActivity
import com.alirahimi.androidcourse.databinding.ActivityMainBinding
import com.google.android.material.slider.Slider
import java.util.*

class MainActivity : AppCompatActivity() {

    //region properties
    private lateinit var binding: ActivityMainBinding
    private lateinit var mediaPlayer: MediaPlayer
    private lateinit var timer: Timer
    private lateinit var coverImageAnimator: ObjectAnimator
    private var isPlaying = true
    private var isUserChanging = false
    private var isMute = false
    //endregion

    //region lifecycle
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initialBinding()
        prepareMusic()
        configListeners()
        configSlider()
        setupCoverImageRotation()
    }

    override fun onDestroy() {
        super.onDestroy()
        timer.cancel()
        mediaPlayer.release()
    }
    //endregion

    //region methods
    private fun initialBinding() {
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    private fun prepareMusic() {

        mediaPlayer = MediaPlayer.create(this, R.raw.ranj8)

        mediaPlayer.start()
        isPlaying = true

        binding.buttonPlayPause.setImageResource(R.drawable.ic_pause)

        binding.sliderMain.valueTo = mediaPlayer.duration.toFloat()

        binding.textRight.text = convertMillisToString(mediaPlayer.duration.toLong())

        timer = Timer()
        timer.schedule(object : TimerTask() {
            override fun run() {
                runOnUiThread {
                    if (!isUserChanging) {
                        binding.sliderMain.value = mediaPlayer.currentPosition.toFloat()
                    }
                }
            }
        }, 1000, 1000)
    }

    private fun configListeners() {
        binding.buttonPlayPause.setOnClickListener { configureMusic() }
        binding.buttonGoBefore.setOnClickListener { goBeforeMusic() }
        binding.buttonGoAfter.setOnClickListener { goAfterMusic() }
        binding.buttonVolumeOnOff.setOnClickListener { configureVolume() }
        binding.sliderMain.addOnSliderTouchListener(object : Slider.OnSliderTouchListener {

            @SuppressLint("RestrictedApi")
            override fun onStartTrackingTouch(slider: Slider) {
            }

            @SuppressLint("RestrictedApi")
            override fun onStopTrackingTouch(slider: Slider) {
                mediaPlayer.seekTo(slider.value.toInt())
            }

        })

        //TODO apply
    }

    private fun configSlider() {
        binding.sliderMain.addOnChangeListener { _, value, fromUser ->
            binding.textLeft.text = convertMillisToString(value.toLong())
            isUserChanging = fromUser
        }
    }

    //    @SuppressLint("InlinedApi")
//    private fun configureVolume() {
//
//        val audioManager = getSystemService(AUDIO_SERVICE) as AudioManager
//
//        isMute = if (isMute) {
//            audioManager.adjustVolume(AudioManager.ADJUST_UNMUTE, AudioManager.FLAG_SHOW_UI)
//            binding.buttonVolumeOnOff.setImageResource(R.drawable.ic_volume_on)
//            false
//        } else {
//            audioManager.adjustVolume(AudioManager.ADJUST_MUTE, AudioManager.FLAG_SHOW_UI)
//            binding.buttonVolumeOnOff.setImageResource(R.drawable.ic_volume_off)
//            true
//        }
//    }

    @SuppressLint("InlinedApi")
    private fun configureVolume() {
        val audioManager = getSystemService(AUDIO_SERVICE) as AudioManager

        isMute = !isMute
        audioManager.adjustVolume(
            if (isMute) AudioManager.ADJUST_MUTE else AudioManager.ADJUST_UNMUTE,
            AudioManager.FLAG_SHOW_UI
        )
        binding.buttonVolumeOnOff.setImageResource(
            if (isMute) R.drawable.ic_volume_off else R.drawable.ic_volume_on
        )
    }

    //    private fun goAfterMusic() {
//        val now = mediaPlayer.currentPosition
//        val newValue = now + 15000
//        mediaPlayer.seekTo(newValue)
//    }
    private fun goAfterMusic() = mediaPlayer.seekTo(mediaPlayer.currentPosition + 15000)

    private fun goBeforeMusic() = mediaPlayer.seekTo(mediaPlayer.currentPosition - 15000)


//    private fun goBeforeMusic() {
//        val now = mediaPlayer.currentPosition
//        val newValue = now - 15000
//        mediaPlayer.seekTo(newValue)
//    }

    //    private fun configureMusic() {
//        isPlaying = if (isPlaying) {
//            mediaPlayer.pause()
//            binding.buttonPlayPause.setImageResource(R.drawable.ic_play)
//            binding.textTop.text = getString(R.string.now_pause)
//            false
//        } else {
//            mediaPlayer.start()
//            binding.buttonPlayPause.setImageResource(R.drawable.ic_pause)
//            binding.textTop.text = getString(R.string.now_playing)
//            true
//        }
//    }
    private fun configureMusic() {
        isPlaying = !isPlaying
        if (isPlaying) {
            mediaPlayer.start()
            binding.buttonPlayPause.setImageResource(R.drawable.ic_pause)
            binding.textTop.text = getString(R.string.now_playing)
            //coverImageAnimator.resume()
        } else {
            mediaPlayer.pause()
            binding.buttonPlayPause.setImageResource(R.drawable.ic_play)
            binding.textTop.text = getString(R.string.now_pause)
            //coverImageAnimator.pause()
        }
    }

    private fun convertMillisToString(duration: Long): String {
        val seconds = (duration / 1000) % 60
        val minutes = (duration / (1000 * 60)) % 60
        return "%02d:%02d".format(minutes, seconds)
    }


    private fun setupCoverImageRotation() {
        coverImageAnimator = ObjectAnimator.ofFloat(binding.coverMusic, "rotation", 0f, 360f)
        coverImageAnimator.duration = 20000
        coverImageAnimator.repeatCount = ObjectAnimator.INFINITE
        coverImageAnimator.interpolator = LinearInterpolator()
        coverImageAnimator.start()
    }

    //endregion

}