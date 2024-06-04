package com.trisulaforce.laundryapp.model

import java.io.Serializable

data class User (
    val idUser: Long,
    val profileImage: Int = 0,
    val fullName: String,
    val email: String,
    val phoneNumber: String,
    val address: String,
    val password: String
) : Serializable