package com.example.bukutoko

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.bukutoko.databinding.ActivityRegisterBinding
import com.google.firebase.auth.FirebaseAuth

class RegisterActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth
    var binding: ActivityRegisterBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        auth = FirebaseAuth.getInstance()
        initData()
    }

    private fun initData(){
        auth = FirebaseAuth.getInstance()
        clickListener()
    }

    private fun clickListener(){
        binding?.btnRegister?.setOnClickListener {
            createUser()
        }
        binding?.llCreatAccount?.setOnClickListener {
            startActivity(Intent(this,SignInActivity::class.java))
            finish()
        }
    }

    private fun createUser(){
        val userName = binding?.etUsername?.text.toString()
        val email = binding?.etEmail?.text.toString()
        val password = binding?.etPassword?.text.toString()

        if(userName.isNotEmpty() && email.isNotEmpty() && password.isNotEmpty()){
            saveUser(email, password)

        }else{
            Toast.makeText(this, "All input required",Toast.LENGTH_LONG).show()
        }
    }

    private fun saveUser(email: String, password: String){
        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener {
                checkResult(it.isSuccessful)

            }
    }

    private fun checkResult(isSuccess: Boolean){
        if(isSuccess){
            Toast.makeText(this,"Create account success",Toast.LENGTH_LONG).show()
            startActivity(Intent(this,SignInActivity::class.java))
            finish()
        }else{
            Toast.makeText(this, "Create your account",Toast.LENGTH_LONG).show()
        }
    }
}