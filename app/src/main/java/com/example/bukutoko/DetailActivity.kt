package com.example.bukutoko

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.ArrayAdapter
import android.widget.LinearLayout
import com.example.bukutoko.databinding.ActivityDetailBinding
import com.google.android.material.bottomsheet.BottomSheetDialog

class DetailActivity : AppCompatActivity() {

    var binding: ActivityDetailBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        val unit = resources.getStringArray(R.array.stok)
        val arrayAdapter = ArrayAdapter(this@DetailActivity,R.layout.dropdown_item, unit)
//        binding?.autoCompleteTextView?.setAdapter(arrayAdapter)

        binding?.efab?.setOnClickListener {
            val bottomSheetDialog = BottomSheetDialog(
                this@DetailActivity,R.style.BottomSheetDialogTheme
            )
            val bottomSheetView = LayoutInflater.from(applicationContext).inflate(
                R.layout.layout_bottom_sheet, findViewById<LinearLayout>(R.id.bottomSheet)
            )

            bottomSheetDialog.setContentView(bottomSheetView)
            bottomSheetDialog.show()
        }

    }
}