package com.gpt5mini.musicapp

import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.SeekBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.gpt5mini.musicapp.databinding.ActivityPlayerBinding

/**
 * 音乐播放全屏界面
 * - 支持显示/隐藏歌词、播放控制、音量、底部三个图标（显示/隐藏歌词、隔空投送、播放列表）
 * - 本示例实现 UI 和交互 stub，具体细节根据资源完善
 */
class PlayerActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPlayerBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPlayerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupControls()
    }

    private fun setupControls() {
        // 播放/暂停
        binding.btnPlay.setOnClickListener {
            MediaPlayerManager.togglePlay()
            updatePlayIcon()
        }

        // 上一曲/下一曲
        binding.btnPrev.setOnClickListener { Toast.makeText(this, "上一曲（示例）", Toast.LENGTH_SHORT).show() }
        binding.btnNext.setOnClickListener { Toast.makeText(this, "下一曲（示例）", Toast.LENGTH_SHORT).show() }

        // 音量 SeekBar（示例：无实际改变系统音量）
        binding.seekVolume.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(sb: SeekBar?, progress: Int, fromUser: Boolean) {}
            override fun onStartTrackingTouch(sb: SeekBar?) {}
            override fun onStopTrackingTouch(sb: SeekBar?) {}
        })

        // 三个底部图标
        binding.btnToggleLyrics.setOnClickListener {
            // 切换歌词显示/隐藏
            if (binding.lyricsContainer.visibility == View.VISIBLE) {
                binding.lyricsContainer.visibility = View.GONE
                // 图片放大居中等效果可用动画实现（此处为简化）
            } else {
                binding.lyricsContainer.visibility = View.VISIBLE
            }
        }

        binding.btnAirPlay.setOnClickListener {
            // 弹窗提示：暂未实现此功能
            Toast.makeText(this, "暂未实现此功能", Toast.LENGTH_SHORT).show()
        }

        binding.btnPlaylist.setOnClickListener {
            // 显示播放列表区域：这里简单切换可见性
            if (binding.playlistContainer.visibility == View.VISIBLE) {
                binding.playlistContainer.visibility = View.GONE
            } else {
                binding.playlistContainer.visibility = View.VISIBLE
            }
        }
    }

    private fun updatePlayIcon() {
        val isPlaying = MediaPlayerManager.isPlaying
        binding.btnPlay.setImageResource(if (isPlaying) R.drawable.ic_pause else R.drawable.ic_play)
    }
}
