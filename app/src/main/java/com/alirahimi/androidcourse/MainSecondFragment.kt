package com.alirahimi.androidcourse

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.alirahimi.androidcourse.databinding.FragmentMainSecondBinding


class MainSecondFragment : Fragment() {


    private lateinit var binding: FragmentMainSecondBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainSecondBinding.inflate(layoutInflater)
        return binding.root
    }


}