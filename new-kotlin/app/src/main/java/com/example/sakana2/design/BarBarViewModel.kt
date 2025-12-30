package com.example.sakana2.design

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class BarBarViewModel : ViewModel() {
    private val _currentTab = MutableStateFlow("BHome")
    val currentTab: StateFlow<String> = _currentTab

    fun onTabSelected(route:String) {
        _currentTab.value = route
    }
}