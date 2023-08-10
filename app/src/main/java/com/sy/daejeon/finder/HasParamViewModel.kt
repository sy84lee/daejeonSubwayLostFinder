package com.sy.daejeon.finder

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class HasParamViewModelFactory(private val repository: LostFinderRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(LostFinderViewModel::class.java)) {
            LostFinderViewModel(repository) as T
        } else {
            throw IllegalArgumentException()
        }
    }
}