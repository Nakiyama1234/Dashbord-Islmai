package com.naufal.idnsolo.dashboardislmai.adapter

import android.content.Intent
import android.icu.text.CaseMap.Title
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.view.menu.MenuView.ItemView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.naufal.idnsolo.dashboardislmai.R
import com.naufal.idnsolo.dashboardislmai.doa.DetailDoaActivity
import com.naufal.idnsolo.dashboardislmai.doa.model.DoaModel

class DoaListAdapter (
    private val listDoa: ArrayList<DoaModel>,
    private val title: String,
    private val logo : Int
) : RecyclerView.Adapter<DoaListAdapter.ListViewHolder>() {
    inner class ListViewHolder(itemView: View) :RecyclerView.ViewHolder(itemView) {
        var imgDoa: ImageView = itemView.findViewById(R.id.imgDoa)
        var tvDoa: TextView = itemView.findViewById(R.id.tvDoa)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_row_doa, parent,false)
        return ListViewHolder((view)
    }

    override fun getItemCount(): Int {
        return listDoa.size
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val doa = listDoa[position]

        holder.tvDoa.text = doa.title
        Glide.with(holder.itemView.context)
            .load(logo)
            .into(holder.imgDoa)

        holder.itemView.setOnClickListener {
            val intent = Intent(it.context)
            intent.putExtra(DetailDoaActivity.EXTRA.DOA, doa)
            it.context.startActivities(intent)
        }

    }
}