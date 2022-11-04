package com.example.bukutoko

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.bukutoko.databinding.ActivityDashboardBinding
import com.google.firebase.auth.FirebaseAuth

class DashboardActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    var binding: ActivityDashboardBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDashboardBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        initData()
        setupRecyclerView()
    }

    private fun initData(){
        auth = FirebaseAuth.getInstance()
        setUserEmail()
        clickListener()

    }

    private fun clickListener(){
        binding?.clLogout?.setOnClickListener {
            auth.signOut()
            startActivity(Intent(this, SignInActivity::class.java))
            finish()
        }
    }

    private fun getCurrentUserEmail():String? {
        return auth.currentUser?.email
    }

    private fun setUserEmail(){
        binding?.tvUser?.text = "Hi, "+getCurrentUserEmail()
    }

    val adapter = DashboardAdapter()
    fun setupRecyclerView(){
        binding?.rvItem?.adapter = adapter
    }
}