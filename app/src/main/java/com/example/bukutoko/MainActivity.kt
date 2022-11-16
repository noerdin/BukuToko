package com.example.bukutoko

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.bukutoko.databinding.ActivityMainBinding
import com.example.bukutoko.ui.dashboard.DashboardActivity
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    var binding: ActivityMainBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        initData()
    }

    private fun initData(){
        auth = FirebaseAuth.getInstance()
        auth.signOut()
        checkIfUserLogin()
    }

    private fun checkIfUserLogin(){
        val currentUser = auth.currentUser

        if(currentUser != null){
            startActivity(Intent(this, DashboardActivity::class.java))
            finish()
        }else{
            startActivity(Intent(this,SignInActivity::class.java))
            finish()
        }
    }
}