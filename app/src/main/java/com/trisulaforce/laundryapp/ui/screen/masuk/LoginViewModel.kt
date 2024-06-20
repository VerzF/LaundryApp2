package com.trisulaforce.laundryapp.ui.screen.masuk

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.auth.AuthCredential
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
    private val _state = Channel<LoginState>()
    val state = _state.receiveAsFlow()

    fun loginUser(email: String, password: String, home: () -> Unit) {
        viewModelScope.launch {
            repository.loginUser(email = email, password = password).collect { result ->
                when (result) {
                    is Resource.Success -> {
                        _state.send(LoginState(success = "Login Berhasil"))
                        home()
                    }

                    is Resource.Loading -> {
                        _state.send(LoginState(loading = true))
                    }

                    is Resource.Error -> {
                        _state.send(LoginState(error = result.message))
                    }
                }
            }
        }
    }

    fun registerUser(email: String, password: String, home: () -> Unit) {
        viewModelScope.launch {
            repository.registerUser(email = email, password = password).collect { result ->
                when (result) {
                    is Resource.Success -> {
                        _state.send(LoginState(success = "Register Berhasil"))
                        home()
                    }

                    is Resource.Loading -> {
                        _state.send(LoginState(loading = true))
                    }

                    is Resource.Error -> {
                        _state.send(LoginState(error = result.message))
                    }
                }
            }
        }
    }
}