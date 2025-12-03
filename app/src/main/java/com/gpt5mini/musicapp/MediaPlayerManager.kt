package com.gpt5mini.musicapp

/**
 * 简单的媒体管理器（示例，不依赖系统 MediaSession）。
 * 处理播放/暂停/下一曲的状态（UI 控制示例）
 */
object MediaPlayerManager {
    var isPlaying = false
        private set

    fun play() {
        isPlaying = true
        // 实际应在这里启动 MediaPlayer 或 ExoPlayer
    }

    fun pause() {
        isPlaying = false
        // 停止播放
    }

    fun togglePlay() {
        if (isPlaying) pause() else play()
    }

    fun next() {
        // 切换下一曲（示例）
        // 实际逻辑：切换播放列表索引并开始播放
    }
}
