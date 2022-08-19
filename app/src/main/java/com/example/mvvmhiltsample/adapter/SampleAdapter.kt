package com.example.mvvmhiltsample.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvmhiltsample.R
import com.example.mvvmhiltsample.models.NetworkData
import dagger.hilt.android.scopes.FragmentScoped

@FragmentScoped
class SampleAdapter:ListAdapter<NetworkData,SampleAdapter.ViewHolder>(NetworkDataCallBack()) {

    class ViewHolder(view: View):RecyclerView.ViewHolder(view){
        private val name: TextView = view.findViewById(R.id.nameTextView)
        private val craft: TextView = view.findViewById(R.id.craftTextView)

        fun bind(nameData: String?,craftData: String?){
            name.text = nameData
            craft.text = craftData
        }

        companion object {
            fun create(parent: ViewGroup): ViewHolder {
                val view: View = LayoutInflater.from(parent.context)
                    .inflate(R.layout.sample_item, parent, false)
                return ViewHolder(view)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.create(parent)
    }

    override fun onBindViewHolder(holder:ViewHolder, position: Int) {
        holder.bind(getItem(position).name,getItem(position).craft)
    }
}

class NetworkDataCallBack:DiffUtil.ItemCallback<NetworkData>() {

    override fun areItemsTheSame(oldItem: NetworkData, newItem: NetworkData): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: NetworkData, newItem: NetworkData): Boolean {
        return oldItem.name == newItem.name
    }
}
