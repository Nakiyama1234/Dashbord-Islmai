package com.naufal.idnsolo.dashboardislmai.kajian

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import com.naufal.idnsolo.dashboardislmai.R
import com.naufal.idnsolo.dashboardislmai.databinding.ActivityKajianBinding
import com.naufal.idnsolo.dashboardislmai.kajian.adapter.KajianAdapter
import com.naufal.idnsolo.dashboardislmai.kajian.data.KajianData
import com.naufal.idnsolo.dashboardislmai.kajian.model.KajianModel

class KajianActivity : AppCompatActivity() {

    private lateinit var binding: ActivityKajianBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityKajianBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)
        initRecyclerView()
    }

    private fun initRecyclerView() {
        binding.rvKajian.layoutManager = LinearLayoutManager(this)
        binding.rvKajian.setHasFixedSize(true)
        val listKjian = ArrayList<KajianModel>()
        listKjian.addAll(KajianData.listData)
        binding.rvKajian.adapter = KajianAdapter(listKjian)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home){
            finish()
        }
        return super.onOptionsItemSelected(item)
    }
}
