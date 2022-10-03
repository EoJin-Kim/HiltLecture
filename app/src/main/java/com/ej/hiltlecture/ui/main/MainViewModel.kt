package com.ej.hiltlecture.ui.main

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.ej.hiltlecture.ui.data.MyRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
//    private val savedStateHandle: SavedStateHandle,
    private val repository:MyRepository):ViewModel() {

        fun getRepositoryHash() = repository.toString()
}