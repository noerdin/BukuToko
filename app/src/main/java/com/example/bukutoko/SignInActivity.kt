package com.example.bukutoko

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.bukutoko.databinding.ActivitySignInBinding
import com.example.bukutoko.ui.dashboard.DashboardActivity
import com.google.firebase.auth.FirebaseAuth

class SignInActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth
    var binding: ActivitySignInBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignInBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        initData()
    }
    private fun initData(){
        auth = FirebaseAuth.getInstance()
        clickListener()
    }
    private fun clickListener(){
        binding?.llCreatAccount?.setOnClickListener {
            startActivity(Intent(this,RegisterActivity::class.java))
            finish()
        }

        binding?.btnSignin?.setOnClickListener {
            getUserData()
        }
    }

    private fun getUserData(){
        var email = binding?.etEmail?.text.toString()
        var password = binding?.etPassword?.text.toString()

        if(email.isNotEmpty() && password.isNotEmpty()){
            authUser(email,password)
        }else{
            Toast.makeText(this, "All inputs required",Toast.LENGTH_LONG).show()
        }
    }

    private fun authUser(email: String, password: String){
        auth.signInWithEmailAndPassword(email,password)
            .addOnCompleteListener {
                checkResult(it.isSuccessful)
            }
    }

    private fun checkResult(isSuccess: Boolean){
        if(isSuccess){
            startActivity(Intent(this, DashboardActivity::class.java))
            finish()
        }else{
            Toast.makeText(this, "Your account doesn't exist",Toast.LENGTH_LONG).show()
        }
    }
}