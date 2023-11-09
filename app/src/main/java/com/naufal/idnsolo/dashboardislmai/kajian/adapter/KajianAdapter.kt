package com.naufal.idnsolo.dashboardislmai.kajian.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.naufal.idnsolo.dashboardislmai.R
import com.naufal.idnsolo.dashboardislmai.doa.DetailDoaActivity
import com.naufal.idnsolo.dashboardislmai.kajian.DetailKajianActivity
import com.naufal.idnsolo.dashboardislmai.kajian.model.KajianModel

class KajianAdapter(private val listkajian: ArrayList<KajianModel>) :
    RecyclerView.Adapter<KajianAdapter.ListViewHolder>() {
    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var imgThumbnail: ImageView = itemView.findViewById(R.id.thumbnail)
        var tvPenceramah: TextView = itemView.findViewById(R.id.tv_penceramah)
        var tvChannel: TextView = itemView.findViewById(R.id.tv_channel_youtube)
        var tvJudul: TextView = itemView.findViewById(R.id.judul_kajian)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_row_kajian, parent, false)

        return ListViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listkajian.size
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val kajian = listkajian[position]

        holder.tvPenceramah.text = kajian.speaker
        holder.tvChannel.text = kajian.speaker
        holder.tvJudul.text = kajian.title
        Glide.with(holder.itemView)
            .load(kajian.thumbnail)
            .into(holder.imgThumbnail)

        holder.itemView.setOnClickListener{
            val intent = Intent(it.context, DetailKajianActivity::class.java)
            intent.putExtra(DetailKajianActivity.EXTRA_KAJIAN, kajian)
            it.context.startActivity(intent)
        }
    }
}