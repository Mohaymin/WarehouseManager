package com.baba_abdullah.warehousemanager.add_warehouse

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.baba_abdullah.warehousemanager.ValueOf
import com.baba_abdullah.warehousemanager.data.local.AppDatabase
import com.baba_abdullah.warehousemanager.data.local.WarehouseEntity
import com.baba_abdullah.warehousemanager.databinding.ActivityAddWarehouseBinding

class AddWarehouseActivity : AppCompatActivity() {

    private val binding: ActivityAddWarehouseBinding by lazy {
        ActivityAddWarehouseBinding.inflate(layoutInflater)
    }

    private val viewModel: AddWarehouseViewModel by viewModels {
        AddWarehouseViewModel.Factory(
            AppDatabase.getInstance(this).getWarehouseDao()
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.saveButton.setOnClickListener {
            val input = binding.warehouseNameInputField.text.toString().trim()
            if (input.length < 2) {
                binding.warehouseNameContainer.error = "Invalid input"
                return@setOnClickListener
            }
            viewModel.saveWarehouse(
                WarehouseEntity(
                    null,
                    input,
                    ValueOf.USER_ID_PLACEHOLDER
                )
            )
        }

        viewModel.isInsertSuccessful.observe(this) { isInsertSuccessful ->
            if (isInsertSuccessful) {
                Toast.makeText(this, "Successfully saved data", Toast.LENGTH_SHORT).show()
                finish()
            } else Toast.makeText(this, "Couldn't save", Toast.LENGTH_SHORT).show()
        }
    }
}