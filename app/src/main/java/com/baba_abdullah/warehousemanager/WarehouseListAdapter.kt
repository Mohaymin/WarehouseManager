package com.baba_abdullah.warehousemanager

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.baba_abdullah.warehousemanager.data.local.WarehouseEntity
import com.baba_abdullah.warehousemanager.databinding.ItemWarehouseBinding

class WarehouseListAdapter(private val warehouseList: List<WarehouseEntity>) :
    RecyclerView.Adapter<WarehouseListAdapter.ViewHolder>() {

    inner class ViewHolder(val binding: ItemWarehouseBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemWarehouseBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return warehouseList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.txtWarehouseName.text = warehouseList[position].name
    }
}