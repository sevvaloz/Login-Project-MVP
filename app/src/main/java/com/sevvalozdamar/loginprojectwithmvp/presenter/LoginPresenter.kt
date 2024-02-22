package com.sevvalozdamar.loginprojectwithmvp.presenter

import com.sevvalozdamar.loginprojectwithmvp.contract.LoginContract
import com.sevvalozdamar.loginprojectwithmvp.model.LoginModel

class LoginPresenter(
    private val view: LoginContract.View
) : LoginContract.Presenter {

    private val model: LoginContract.Model = LoginModel()

    override fun loginClick(email: String, password: String) {
        view.showProgressbar()
        val loginResult = model.checkLoginInfo(email, password)
        if(loginResult){
            view.showSuccessLoginResult()
            view.hideProgressbar()
        } else {
            view.showFailLoginResult()
            view.hideProgressbar()
        }
    }

}