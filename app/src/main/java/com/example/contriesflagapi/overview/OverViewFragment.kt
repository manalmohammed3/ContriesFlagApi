package com.example.contriesflagapi.overview

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.contriesflagapi.databinding.FragmentOverViewBinding


private val binding: FragmentOverViewBinding? = null
class OverViewFragment : Fragment() {

    private val viewModel: OverViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentOverViewBinding.inflate(inflater)

        binding.lifecycleOwner = this

        binding.viewModel = viewModel
//       binding.photosGrid.adapter = com.example.contriesflagapi.PhotoGridAdapter()
        return binding.root
    }
}


