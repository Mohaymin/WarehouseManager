package com.baba_abdullah.warehousemanager.view_warehouse_list

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.baba_abdullah.warehousemanager.add_warehouse.AddWarehouseActivity
import com.baba_abdullah.warehousemanager.data.local.AppDatabase
import com.baba_abdullah.warehousemanager.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private val viewModel: MainActivityViewModel by viewModels {
        MainActivityViewModel.Factory(AppDatabase.getInstance(this))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        viewModel.fetchActiveWarehouses()
        binding.rvWarehouse.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        binding.fabAddWarehouse.setOnClickListener {
            startActivity(Intent(this@MainActivity, AddWarehouseActivity::class.java))
        }

        viewModel.activeWarehouses.observe(this) {
            if (it.isEmpty()) {
                binding.rvWarehouse.visibility = View.GONE
                binding.tvEmptyWarehouseText.visibility = View.VISIBLE
                return@observe
            }
            binding.rvWarehouse.visibility = View.VISIBLE
            binding.tvEmptyWarehouseText.visibility = View.GONE
            binding.rvWarehouse.adapter = WarehouseListAdapter(it)
        }
    }

}