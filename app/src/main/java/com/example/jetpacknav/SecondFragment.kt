package com.example.jetpacknav

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.example.jetpacknav.databinding.FragmentFirstBinding
import com.example.jetpacknav.databinding.FragmentSecondBinding
import java.text.FieldPosition

class SecondFragment() : Fragment() {

    private var _binding : FragmentSecondBinding? = null
    private val binding get() = _binding!!

    companion object{
        const val numberInArray = "number"
        const val name = "name"
        const val desc = "desc"
        const val url = "url"
        const val fullDesc = "fullDesc"
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Glide.with(view).load(arguments?.getString(url)).fitCenter().into(binding.tvPhoto)
        binding.tvName.text = arguments?.getString(name)
        binding.tvDescription.text = arguments?.getString(desc)
        binding.tvFullDesc.text = arguments?.getString(fullDesc)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}