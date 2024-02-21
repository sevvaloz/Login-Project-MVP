package com.sevvalozdamar.loginprojectwithmvp.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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
        }
    }

    override fun showSuccessLoginResult() {
        Toast.makeText(this, "Login successful.", Toast.LENGTH_LONG).show()
        startActivity(Intent(this, HomeActivity::class.java))
    }

    override fun showFailLoginResult() {
        Toast.makeText(this, "Login failed.", Toast.LENGTH_LONG).show()
    }

}