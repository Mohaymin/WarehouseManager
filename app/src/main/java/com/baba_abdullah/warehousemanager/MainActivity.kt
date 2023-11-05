package com.baba_abdullah.warehousemanager

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.baba_abdullah.warehousemanager.add_warehouse.AddWarehouseActivity
import com.baba_abdullah.warehousemanager.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.fabAddWarehouse.setOnClickListener {
            startActivity(Intent(this@MainActivity, AddWarehouseActivity::class.java))
        }
    }

}