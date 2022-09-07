package com.nice.cxonechat.sample

import android.net.Uri
import android.os.Bundle
import android.widget.MediaController
import androidx.appcompat.app.AppCompatActivity
import com.nice.cxonechat.sample.MainActivity.Companion.VIDEO_URL
import com.nice.cxonechat.sample.databinding.ActivityVideoPreviewBinding

class VideoPreviewActivity : AppCompatActivity() {
    private lateinit var binding: ActivityVideoPreviewBinding
    private val videoUrl: String? by lazy { intent.extras?.getString(VIDEO_URL) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityVideoPreviewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding) {
            val mediaController = MediaController(this@VideoPreviewActivity)
            mediaController.setAnchorView(videoView)

            videoView.setVideoURI(Uri.parse(videoUrl))
            videoView.setMediaController(mediaController)
            videoView.start()
        }
    }
}