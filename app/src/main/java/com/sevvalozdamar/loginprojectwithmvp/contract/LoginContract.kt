package com.sevvalozdamar.loginprojectwithmvp.contract

interface LoginContract {

    interface Model {
        fun checkLoginInfo(email: String, password: String): Boolean
    }

    interface Presenter {
        fun loginClick(email: String, password: String)
        fun validateEmail(email: String)
        fun validatePassword(password: String)
    }

    interface View {
        fun showSuccessLoginResult()
        fun showFailLoginResult()
        fun showProgressbar()
        fun hideProgressbar()
        fun showEmailErrorMessage()
        fun showPasswordErrorMessage()
        fun clearEmailErrorMessage()
        fun clearPasswordErrorMessage()
    }

}