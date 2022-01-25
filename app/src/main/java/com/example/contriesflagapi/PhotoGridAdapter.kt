package com.example.contriesflagapi

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.contriesflagapi.databinding.GridViewItemBinding
import com.example.contriesflagapi.network.CountryModel


class  PhotoGridAdapter : ListAdapter <CountryModel,
        PhotoGridAdapter.FlagViewHolder>(DiffCallback) {

    class FlagViewHolder(private var binding: GridViewItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(flagPhoto: CountryModel) {
            binding.modeldata = flagPhoto
            binding.executePendingBindings()
        }
    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FlagViewHolder {
       return FlagViewHolder(
           GridViewItemBinding.inflate(
               LayoutInflater.from(parent.context)
           )
       )
    }

    override fun onBindViewHolder(holder: FlagViewHolder, position: Int) {
        val flagPhoto = getItem(position)
        holder.bind(flagPhoto)
    }


companion object DiffCallback : DiffUtil.ItemCallback<CountryModel>() {
    override fun areItemsTheSame(oldItem: CountryModel, newItem: CountryModel): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: CountryModel, newItem: CountryModel): Boolean {
        return oldItem.flag == newItem.flag
    }
}

}