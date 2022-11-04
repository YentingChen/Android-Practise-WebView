package com.example.webviewplayground.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class WebViewModel : ViewModel()  {
    private val _url = MutableLiveData<String>("")
    val url: LiveData<String> = _url

    fun setUrl(url: String) {
        _url.value = url
    }
}