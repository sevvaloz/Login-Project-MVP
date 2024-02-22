package com.sevvalozdamar.loginprojectwithmvp.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.sevvalozdamar.loginprojectwithmvp.contract.LoginContract
import com.sevvalozdamar.loginprojectwithmvp.databinding.ActivityLoginBinding
import com.sevvalozdamar.loginprojectwithmvp.presenter.LoginPresenter

class LoginActivity : AppCompatActivity(), LoginContract.View {

    private lateinit var binding: ActivityLoginBinding
    private var loginPresenter = LoginPresenter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            btnLogin.setOnClickListener {
                val email = etEmail.text.toString()
                val password = etPassword.text.toString()
                loginPresenter.loginClick(email, password)
            }
            etEmail.setOnFocusChangeListener { _, hasFocus ->
                if(!hasFocus){
                    val email = etEmail.text.toString()
                    loginPresenter.validateEmail(email)
                }
            }
            etPassword.setOnFocusChangeListener { _, hasFocus ->
                if(!hasFocus){
                    val password = etPassword.text.toString()
                    loginPresenter.validatePassword(password)
                }
            }
        }
    }

    override fun showSuccessLoginResult() {
        Toast.makeText(this, "Login successful.", Toast.LENGTH_SHORT).show()
        startActivity(Intent(this, HomeActivity::class.java))
    }

    override fun showFailLoginResult() {
        Toast.makeText(this, "Login failed.", Toast.LENGTH_SHORT).show()
    }

    override fun showProgressbar() {
        binding.pbLogin.visibility = View.VISIBLE
    }

    override fun hideProgressbar() {
        binding.pbLogin.visibility = View.GONE
    }

    override fun showEmailErrorMessage() {
        binding.etEmail.error = "Email can not be empty"
    }

    override fun showPasswordErrorMessage() {
        binding.etPassword.error = "Password can not be empty"
    }

    override fun clearEmailErrorMessage() {
        binding.etEmail.error = null
    }

    override fun clearPasswordErrorMessage() {
        binding.etPassword.error = null
    }

}