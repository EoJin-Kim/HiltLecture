package com.ej.hiltlecture.ui.main

import android.content.Intent
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
import com.ej.hiltlecture.ui.data.di.qualifier.AppHash
import com.ej.hiltlecture.ui.second.SecondActivity
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_main.*
import javax.inject.Inject


@AndroidEntryPoint
class MainFragment : Fragment() {
    private val activityViewModel by activityViewModels<MainViewModel> ()
    private val viewModel by viewModels<MainViewModel> ()

    @Inject
    lateinit var repository : MyRepository

    @AppHash
    @Inject
    lateinit var applicationHash : String

    @ActivityHash
    @Inject
    lateinit var activityHash : String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Log.d("hilt","${repository.hashCode()}")
        Log.d("hilt","${applicationHash}")
        Log.d("hilt","${activityHash}")
        Log.d("hilt","${viewModel.getRepositoryHash()}")
        Log.d("hilt","${activityViewModel.getRepositoryHash()}")
        button_activity.setOnClickListener {
            val intent = Intent(requireContext(),SecondActivity::class.java)
            startActivity(intent)
        }

        button_fragment.setOnClickListener {
            findNavController().navigate(R.id.action_mainFragment_to_secondFragment)
        }
    }


}