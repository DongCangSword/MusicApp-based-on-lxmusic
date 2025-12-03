package com.gpt5mini.musicapp

import android.content.Intent
import android.content.res.ColorStateList
import android.os.Bundle
import android.widget.TextView
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.gpt5mini.musicapp.databinding.ActivityMainBinding
import com.gpt5mini.musicapp.models.Song

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var currentSong: Song? = null

    /* ------------  1. 把文字+图标绑在一起  ------------ */
    private data class NavTab(val tv: TextView, val ic: ImageView)

    private lateinit var tabs: List<NavTab>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        /* ------------  2. 初始化 tab 列表  ------------ */
        tabs = listOf(
            NavTab(binding.navHome,     binding.icNavHome),
            NavTab(binding.navDiscover, binding.icNavDiscover),
            NavTab(binding.navBroadcast,binding.icNavBroadcast),
            NavTab(binding.navLibrary,  binding.icNavLibrary),
            NavTab(binding.navSearch,   binding.icNavSearch)
        )

        replaceFragment(HomeFragment())
        setupBottomNav()
        setupPlayBar()
    }

    private fun setupBottomNav() {
        /* ------------  3. 点击事件：整组高亮  ------------ */
        tabs.forEachIndexed { index, tab ->
            val fragment = when (index) {
                0 -> HomeFragment()
                1 -> DiscoverFragment()
                2 -> BroadcastFragment()
                3 -> LibraryFragment()
                else -> SearchFragment()
            }
            tab.tv.setOnClickListener { replaceFragment(fragment); setActiveNav(tab) }
            tab.ic.setOnClickListener { replaceFragment(fragment); setActiveNav(tab) }
        }

        binding.btnAccount.setOnClickListener {
            startActivity(Intent(this, AccountSettingsActivity::class.java))
        }

        // 默认选中首页
        setActiveNav(tabs[0])
    }

    /* ------------  4. 统一变色：文字 + 图标一起变  ------------ */
    private fun setActiveNav(activeTab: NavTab) {
        val selectedColor = getColor(R.color.colorNavActive)
        val normalColor   = getColor(R.color.colorNavNormal)

        tabs.forEach { tab ->
            tab.tv.setTextColor(normalColor)
            tab.ic.imageTintList = ColorStateList.valueOf(normalColor)
        }

        activeTab.tv.setTextColor(selectedColor)
        activeTab.ic.imageTintList = ColorStateList.valueOf(selectedColor)
    }

    /* ---------------------------------------------------------- */
    private fun replaceFragment(fragment: Fragment) =
        supportFragmentManager.beginTransaction()
            .setCustomAnimations(android.R.anim.slide_in_left, android.R.anim.slide_out_right)
            .replace(R.id.fragment_container, fragment)
            .commitAllowingStateLoss()

    private fun setupPlayBar() {
        currentSong = Song("示例歌曲", "示例歌手", "")
        updatePlayBarUI()
        binding.playBarRoot.setOnClickListener {
            startActivity(Intent(this, PlayerActivity::class.java))
        }
        binding.btnPlayPauseBar.setOnClickListener {
            MediaPlayerManager.togglePlay()
            updatePlayBarUI()
        }
        binding.btnNextBar.setOnClickListener {
            MediaPlayerManager.next()
            Toast.makeText(this, "切换下一曲（示例）", Toast.LENGTH_SHORT).show()
        }
    }

    private fun updatePlayBarUI() {
        binding.playBarTitle.text = currentSong?.title ?: ""
        binding.btnPlayPauseBar.setImageResource(
            if (MediaPlayerManager.isPlaying) R.drawable.ic_pause else R.drawable.ic_play
        )
    }
}