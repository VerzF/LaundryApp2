package com.trisulaforce.laundryapp.ui.screen.masuk

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
class LoginViewModel @Inject constructor(
    private val repository: AuthRepository
) : ViewModel() {
    private val _state = Channel<SignInState>()
    val loginState = _state.receiveAsFlow()

    fun loginUser(email: String, password: String, Beranda: () -> Unit) {
        viewModelScope.launch {
            repository.loginUser(email = email, password = password).collect { result ->
                when (result) {
                    is Resource.Success -> {
                        _state.send(SignInState(success = "Login Berhasil"))
                        Beranda()
                    }

                    is Resource.Loading -> {
                        _state.send(SignInState(loading = true))
                    }

                    is Resource.Error -> {
                        _state.send(SignInState(error = result.message))
                    }
                }
            }
        }
    }
}