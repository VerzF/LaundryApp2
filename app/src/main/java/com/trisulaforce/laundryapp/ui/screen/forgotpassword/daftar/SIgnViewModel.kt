package com.trisulaforce.laundryapp.ui.screen.forgotpassword.daftar

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.trisulaforce.laundryapp.data.firebase.AuthRepository
import com.trisulaforce.laundryapp.data.firebase.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SIgnViewModel @Inject constructor(
    private val repository: AuthRepository
) : ViewModel() {
    private val _state = Channel<daftarState>()
    val SignUpState = _state.receiveAsFlow()

    fun registerUser(email: String, password: String, Masuk: () -> Unit) {
        viewModelScope.launch {
            repository.registerUser(email = email, password = password).collect { result ->
                when (result) {
                    is Resource.Success -> {
                        _state.send(daftarState(success = "Daftar Berhasil"))
                        Masuk()
                    }

                    is Resource.Loading -> {
                        _state.send(daftarState(loading = true))
                    }

                    is Resource.Error -> {
                        _state.send(daftarState(error = result.message))
                    }
                }
            }
        }
    }
}