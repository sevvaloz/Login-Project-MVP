package com.sevvalozdamar.loginprojectwithmvp.presenter

import com.sevvalozdamar.loginprojectwithmvp.contract.LoginContract
import com.sevvalozdamar.loginprojectwithmvp.model.LoginModel
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class LoginPresenter(
    private val view: LoginContract.View
) : LoginContract.Presenter {

    private val model: LoginContract.Model = LoginModel()

    override fun loginClick(email: String, password: String) {
        view.showProgressbar()
        val loginResult = model.checkLoginInfo(email, password)

        MainScope().launch {
            delay(1200)
            if(loginResult){
                view.showSuccessLoginResult()
                view.hideProgressbar()
            } else {
                view.showFailLoginResult()
                view.hideProgressbar()
            }
        }
    }

    override fun validateEmail(email: String) {
        if (email.isEmpty()) {
            view.showEmailErrorMessage()
        } else {
            view.clearEmailErrorMessage()
        }
    }

    override fun validatePassword(password: String) {
        if (password.isEmpty()) {
            view.showPasswordErrorMessage()
        } else {
            view.clearPasswordErrorMessage()
        }
    }

}