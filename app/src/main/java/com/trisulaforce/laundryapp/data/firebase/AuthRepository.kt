package com.trisulaforce.laundryapp.data.firebase

import com.google.firebase.auth.AuthResult
import kotlinx.coroutines.flow.Flow

interface AuthRepository {
    //Fungsi untuk mendaftarkan pengguna baru menggunakan email dan kata sandi mereka.
    //Fungsi ini mengembalikan sebuah Flow yang memancarkan Resource yang berisi AuthResult.
    fun loginUser(email: String, password: String): Flow<Resource<AuthResult>>
    fun registerUser(email: String, password: String): Flow<Resource<AuthResult>>
}