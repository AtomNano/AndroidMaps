package com.example.myapplication.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.model.modelpariwisata

class pariwisataAdapter(
    private val context: Context,
    private val pariwisataList: List<modelpariwisata>,
    private val onItemClick: (modelpariwisata) -> Unit
) : RecyclerView.Adapter<pariwisataAdapter.pariwisataViewHolder>() {

    inner class pariwisataViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.imageView)
        val titleTextView: TextView = itemView.findViewById(R.id.titleTextView)
        val descriptionTextView: TextView = itemView.findViewById(R.id.descriptionTextView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): pariwisataViewHolder {
        val itemView = LayoutInflater.from(context).inflate(R.layout.detail_wisata, parent, false)
        return pariwisataViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: pariwisataViewHolder, position: Int) {
        val pariwisata = pariwisataList[position]
        
        holder.titleTextView.text = pariwisata.namaWisata
        holder.descriptionTextView.text = pariwisata.deskripsiWisata
        holder.imageView.setImageResource(pariwisata.gambarWisata)
        
        holder.itemView.setOnClickListener { onItemClick(pariwisata) }
    }

    override fun getItemCount(): Int {
        return pariwisataList.size
    }
}



