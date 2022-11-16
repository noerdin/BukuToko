package com.example.bukutoko.ui.add

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.bukutoko.R
import com.example.bukutoko.data.room.entity.ItemEntity
import com.example.bukutoko.databinding.ActivityAddProductBinding
import com.example.bukutoko.ui.dashboard.DashboardActivity
import com.example.bukutoko.ui.dashboard.DashboardViewModel

class AddProductActivity : AppCompatActivity() {

    var binding: ActivityAddProductBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddProductBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        setClickListener()

        val unit = resources.getStringArray(R.array.satuan)
        val arrayAdapter = ArrayAdapter(this@AddProductActivity, R.layout.dropdown_item, unit)
        binding?.autoCompleteTextView?.setAdapter(arrayAdapter)
    }

    private fun setClickListener() {
        binding?.ivBack?.setOnClickListener {
            startActivity(Intent(this@AddProductActivity,DashboardActivity::class.java))
            finish()
        }

        binding?.btnSimpan?.setOnClickListener {

        }

    }
}