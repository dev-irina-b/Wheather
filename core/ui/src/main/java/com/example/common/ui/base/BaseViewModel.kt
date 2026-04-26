package com.example.common.ui.base

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

abstract class BaseViewModel<S>(initial: S) : ViewModel() {
    protected val _state = MutableStateFlow(initial)
    val state = _state.asStateFlow()

    protected fun setState(new: S) {
        _state.value = new
    }

    protected fun updateState(reducer: (S) -> S) {
        _state.update(reducer)
    }
}