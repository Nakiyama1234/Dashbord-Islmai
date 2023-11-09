package com.naufal.idnsolo.dashboardislmai.doa

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.naufal.idnsolo.dashboardislmai.R
import com.naufal.idnsolo.dashboardislmai.doa.adapter.DoaListAdapter
import com.naufal.idnsolo.dashboardislmai.databinding.ActivityListDoaBinding
import com.naufal.idnsolo.dashboardislmai.doa.data.DoaEtikaBaik
import com.naufal.idnsolo.dashboardislmai.doa.data.DoaMakananMinuman
import com.naufal.idnsolo.dashboardislmai.doa.data.DoaPagiMalam
import com.naufal.idnsolo.dashboardislmai.doa.data.DoaPerjalanan
import com.naufal.idnsolo.dashboardislmai.doa.data.DoaRumah
import com.naufal.idnsolo.dashboardislmai.doa.data.DoaSholat
import com.naufal.idnsolo.dashboardislmai.doa.model.DoaModel

class ListDoaActivity : AppCompatActivity() {
    private lateinit var binding: ActivityListDoaBinding
    lateinit var title: String
    var logo: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListDoaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        title = intent.getStringExtra(EXTRA_TITLE).toString()
        logo = intent.getIntExtra(EXTRA_IMAGE,0)

        val actionBar = supportActionBar
        actionBar?.title = intent.getStringExtra(EXTRA_TITLE)
        actionBar?.setDisplayHomeAsUpEnabled(true)

        initRecyclerView()
    }

    private fun initRecyclerView() {
        val list: ArrayList<DoaModel> = arrayListOf()
        when (title) {
            getString(R.string.pagi_dan_malam) -> {
                list.addAll(DoaPagiMalam.listDoaPagiMalam)
            }

            getString(R.string.rumah) -> {
                list.addAll(DoaRumah.listDoaRumah)
            }

            getString(R.string.makanan_amp_minuman) -> {
                list.addAll(DoaMakananMinuman.listDoaMakananMinuman)
            }

            getString(R.string.perjalanan) -> {
                list.addAll(DoaPerjalanan.listDoaPerjalanan)
            }

            getString(R.string.sholat) -> {
                list.addAll(DoaSholat.listDoaShalat)
            }
            
            getString(R.string.etika_baik) -> {
                list.addAll(DoaEtikaBaik.listDoaEtikaBaik)
            }
        }
        binding.rvListDoa.hasFixedSize()
        binding.rvListDoa.layoutManager= LinearLayoutManager(this)
        val adapter = DoaListAdapter(list, title, logo)
        binding.rvListDoa.adapter = adapter
    }

    companion object{
        const val EXTRA_TITLE = "extra-title"
        const val EXTRA_IMAGE = "extra-image"
    }

}