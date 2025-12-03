package com.gpt5mini.musicapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.gpt5mini.musicapp.adapters.HorizontalAdapter
import com.gpt5mini.musicapp.databinding.FragmentHomeBinding

/**
 * 主页：包含“专属精选推荐”、“最近播放”等横向滚动区域
 */
class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        // 设置横向列表（示例）
        val adapter = HorizontalAdapter(listOf("推荐1", "推荐2", "推荐3", "推荐4"))
        binding.recyclerRecommend.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        binding.recyclerRecommend.adapter = adapter

        val recentAdapter = HorizontalAdapter(listOf("歌手A", "歌手B", "专辑C"))
        binding.recyclerRecent.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        binding.recyclerRecent.adapter = recentAdapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
