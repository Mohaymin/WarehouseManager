package com.baba_abdullah.warehousemanager.view_warehouse_details

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.baba_abdullah.warehousemanager.data.local.AppDatabase
import com.baba_abdullah.warehousemanager.databinding.ActivityWarehouseDetailsBinding
import com.baba_abdullah.warehousemanager.view_warehouse_list.MainActivityViewModel
import com.google.android.material.tabs.TabLayoutMediator

class WarehouseDetailsActivity : AppCompatActivity() {

    companion object {
        fun getIntentForNavigation(context: Context): Intent {
            return Intent(context, WarehouseDetailsActivity::class.java)
        }
    }

    private val binding: ActivityWarehouseDetailsBinding by lazy {
        ActivityWarehouseDetailsBinding.inflate(layoutInflater)
    }

    private val viewModel: MainActivityViewModel by viewModels {
        MainActivityViewModel.Factory(AppDatabase.getInstance(this))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val tabList = listOf("Scan")

        binding.pager.adapter = WarehouseViewPagerAdapter(supportFragmentManager, lifecycle)
            .addFragment(ScannerFragment.newInstance())

        TabLayoutMediator(binding.tabLayout, binding.pager) { tab, position ->
            tab.text = tabList[position]
        }.attach()
    }
}