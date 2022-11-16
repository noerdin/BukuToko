package com.example.bukutoko

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.bukutoko.databinding.ItemBarangBinding
import com.example.bukutoko.data.room.entity.ItemEntity

class DashboardAdapter(
) : RecyclerView.Adapter<DashboardAdapter.ViewHolder>() {

    class ViewHolder(val binding: ItemBarangBinding) : RecyclerView.ViewHolder(binding.root)

    var listItem : List<ItemEntity> = listOf()

    fun setData(listItem: List<ItemEntity>) {
        this.listItem = listItem
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemBarangBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = listItem[position]
        holder.binding.tvNamaBarang.text = item.namaBarang
        holder.binding.tvHarga.text = item.hargaJual.toString()
        holder.binding.tvSatuan.text = item.satuan.toString()
        holder.binding.tvStok.text = item.stok.toString()
    }

    override fun getItemCount(): Int {
        return listItem.size
    }
}