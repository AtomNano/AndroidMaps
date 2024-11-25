package com.example.myapplication.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R

class pariwisataAdapter(

    private val context: Context,
    private val pariwisataList: List<pariwisataViewHolder>,
    private val onItemClick: (pariwisataViewHolder) -> Unit
    ) : RecyclerView.Adapter<pariwisataAdapter.pariwisataViewHolder>() {

        inner class pariwisataViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): pariwisataViewHolder {
        val itemView = LayoutInflater.from(context).inflate(R.layout.detail_wisata, parent, false)
        return pariwisataViewHolder(itemView)

        }

    override fun onBindViewHolder(holder: pariwisataViewHolder, position: Int) {
        val pariwisata = pariwisataList[position]
        holder.itemView.setOnClickListener { onItemClick(pariwisata) }
    }

    override fun getItemCount(): Int {
        return pariwisataList.size
    }


}



