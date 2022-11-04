package com.example.bukutoko

import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import com.example.bukutoko.databinding.ActivityAddProductBinding

class AddProductActivity : AppCompatActivity() {

    var binding: ActivityAddProductBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddProductBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        val unit = resources.getStringArray(R.array.satuan)
        val arrayAdapter = ArrayAdapter(this@AddProductActivity,R.layout.dropdown_item, unit)
        binding?.autoCompleteTextView?.setAdapter(arrayAdapter)
    }
}