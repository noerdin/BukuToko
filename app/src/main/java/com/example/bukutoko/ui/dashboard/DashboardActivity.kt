package com.example.bukutoko.ui.dashboard

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.bukutoko.ui.add.AddProductActivity
import com.example.bukutoko.BukuTokoApplication
import com.example.bukutoko.DashboardAdapter
import com.example.bukutoko.SignInActivity
import com.example.bukutoko.databinding.ActivityDashboardBinding
import com.example.bukutoko.ui.dashboard.DashboardViewModel.DashboardViewModelFactory
import com.google.firebase.auth.FirebaseAuth

class DashboardActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

//    private val addProductActivityRequestCode = 1

    var binding: ActivityDashboardBinding? = null

    private val dashboardViewModel: DashboardViewModel by viewModels {
        DashboardViewModelFactory((application as BukuTokoApplication).repositori)
    }

    val adapter = DashboardAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDashboardBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        initData()
        setupRecyclerView()

        dashboardViewModel.allItem.observe(this@DashboardActivity) {
            adapter.setData(it)
        }

        binding?.efab?.setOnClickListener {
            startActivity( Intent(this@DashboardActivity, AddProductActivity::class.java))
//            startActivityForResult(intent, addProductActivityRequestCode)
        }
    }

    override fun onResume() {
        super.onResume()
        dashboardViewModel.getAllItem()
    }

    private fun initData() {
        auth = FirebaseAuth.getInstance()
        setUserEmail()
        clickListener()

    }

    private fun clickListener() {
        binding?.clLogout?.setOnClickListener {
            auth.signOut()
            startActivity(Intent(this, SignInActivity::class.java))
            finish()
        }
    }

    private fun getCurrentUserEmail(): String? {
        return auth.currentUser?.email
    }

    private fun setUserEmail() {
        binding?.tvUser?.text = "Hi, " + getCurrentUserEmail()
    }


    fun setupRecyclerView() {
        binding?.rvItem?.adapter = adapter
    }

//    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
//        super.onActivityResult(requestCode, resultCode, data)
//
//        if (requestCode == addProductActivityRequestCode && resultCode == Activity.RESULT_OK) {
//
//            }
//        }
//    }
}