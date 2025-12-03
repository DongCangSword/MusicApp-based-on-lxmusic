package com.gpt5mini.musicapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.gpt5mini.musicapp.databinding.ActivityAccountSettingsBinding

/**
 * 账户设置：作为可覆盖全屏的堆叠页面（从底部弹出）
 */
class AccountSettingsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAccountSettingsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAccountSettingsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnClose.setOnClickListener { finish() }
    }
}
