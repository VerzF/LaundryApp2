package com.trisulaforce.laundryapp.ui.screen.forgotpassword.daftar

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.trisulaforce.laundryapp.data.firebase.AuthRepository
import com.trisulaforce.laundryapp.data.firebase.Resource
import com.trisulaforce.laundryapp.ui.screen.masuk.LoginState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SIgnViewModel @Inject constructor(
    private val repository: AuthRepository
) : ViewModel() {
    private val _state = Channel<SIgnState>()
    val state = _state.receiveAsFlow()

    fun loginUser(email: String, password: String, home: () -> Unit) {
        viewModelScope.launch {
            repository.loginUser(email = email, password = password).collect { result ->
                when (result) {
                    is Resource.Success -> {
                        _state.send(SIgnState(success = "Daftar Berhasil"))
                        home()
                    }

                    is Resource.Loading -> {
                        _state.send(SIgnState(loading = true))
                    }

                    is Resource.Error -> {
                        _state.send(SIgnState(error = result.message))
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
                        _state.send(SIgnState(success = "Register Berhasil"))
                        home()
                    }

                    is Resource.Loading -> {
                        _state.send(SIgnState(loading = true))
                    }

                    is Resource.Error -> {
                        _state.send(SIgnState(error = result.message))
                    }
                }
            }
        }
    }
}
