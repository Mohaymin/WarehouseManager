package com.baba_abdullah.warehousemanager

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.baba_abdullah.warehousemanager.databinding.ActivityAddWarehouseBinding

class AddWarehouseActivity : AppCompatActivity() {

    private val binding: ActivityAddWarehouseBinding by lazy {
        ActivityAddWarehouseBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.saveButton.setOnClickListener {
            Toast.makeText(this, "Saved", Toast.LENGTH_SHORT).show()
            finish()
        }
    }
}