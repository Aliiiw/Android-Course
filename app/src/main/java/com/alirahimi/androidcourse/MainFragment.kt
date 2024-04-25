package com.alirahimi.androidcourse

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.alirahimi.androidcourse.databinding.FragmentMainBinding


class MainFragment : Fragment() {

    //region properties
    private lateinit var binding: FragmentMainBinding
    //endregion

    //region lifecycle
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainBinding.inflate(layoutInflater)
        return binding.root
    }
    //endregion

    //region methods
    //endregion

}