package com.sevvalozdamar.loginprojectwithmvp.model

import com.sevvalozdamar.loginprojectwithmvp.contract.LoginContract

class LoginModel: LoginContract.Model {

    private val userLoginData = mapOf(
        "user1@example.com" to "password1",
        "user2@example.com" to "password2",
        "user3@example.com" to "password3",
        "user4@example.com" to "password4",
        "user5@example.com" to "password5"
    )

    override fun checkLoginInfo(email: String, password: String): Boolean {
        userLoginData.forEach { (e, p) ->
            if(email == e && password == p) {
                return true
            }
        }
        return false
    }

}