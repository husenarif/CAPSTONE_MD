package com.exemple.capstone.activity.ui.search

import android.view.LayoutInflater
import com.bumptech.glide.Glide
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.exemple.capstone.activity.ui.retrofit.DataItem
import com.exemple.capstone.databinding.ItemUserBinding



class SearchAdapter(private var items: List<DataItem>) :
    RecyclerView.Adapter<SearchAdapter.SearchViewHolder>() {

    class SearchViewHolder(private val binding: ItemUserBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: DataItem) {
            binding.tvDate.text = item.name
            binding.tvLabel.text = item.address
            Glide.with(binding.root.context)
                .load(item.photoUrl)
                .into(binding.savedImg)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchViewHolder {
        val binding = ItemUserBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SearchViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SearchViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size

    fun updateData(newItems: List<DataItem>) {
        items = newItems
        notifyDataSetChanged()
    }
}


//
//class SearchAdapter(private var items: List<DataItem>) :
//    RecyclerView.Adapter<SearchAdapter.SearchViewHolder>() {
//
//    class SearchViewHolder(private val binding: ItemUserBinding) : RecyclerView.ViewHolder(binding.root) {
//        fun bind(item: DataItem) {
//            binding.tvDate.text = item.name
//            binding.tvLabel.text = item.address
//            Glide.with(binding.root.context)
//                .load(item.photoUrl)
//                .into(binding.savedImg)
//        }
//    }
//
//
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchViewHolder {
//        val binding = ItemUserBinding.inflate(LayoutInflater.from(parent.context), parent, false)
//        return SearchViewHolder(binding)
//    }
//
//    override fun onBindViewHolder(holder: SearchViewHolder, position: Int) {
//        holder.bind(items[position])
//    }
//
//    override fun getItemCount(): Int = items.size
//
//    fun updateData(newItems: List<DataItem>) {
//        items = newItems
//        notifyDataSetChanged()
//    }
//}
//
