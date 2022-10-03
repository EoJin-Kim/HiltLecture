package com.ej.hiltlecture.ui.main

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.ej.hiltlecture.R
import com.ej.hiltlecture.ui.data.MyRepository
import com.ej.hiltlecture.ui.data.di.qualifier.ActivityHash
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_second.*
import javax.inject.Inject

@AndroidEntryPoint
class SecondFragment : Fragment() {

    private val activityViewModel by activityViewModels<MainViewModel> ()
    private val viewModel by viewModels<MainViewModel> ()

    @Inject
    lateinit var repository : MyRepository

    @ActivityHash
    @Inject
    lateinit var applicationHash : String

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_second, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d("hilt","${repository.hashCode()}")
        Log.d("hilt","${applicationHash}")
        Log.d("hilt","${viewModel.getRepositoryHash()}")
        Log.d("hilt","${activityViewModel.getRepositoryHash()}")


        button.setOnClickListener {
            findNavController().navigate(R.id.action_secondFragment_to_mainFragment)
        }

    }


}