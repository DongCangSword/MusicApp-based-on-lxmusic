package com.gpt5mini.musicapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.gpt5mini.musicapp.databinding.FragmentSearchBinding

class SearchFragment : Fragment() {
    private var _binding: FragmentSearchBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?) =
        FragmentSearchBinding.inflate(inflater, container, false).also { _binding = it }.root

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
