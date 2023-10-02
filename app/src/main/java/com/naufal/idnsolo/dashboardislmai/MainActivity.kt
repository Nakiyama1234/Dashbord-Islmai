package com.naufal.idnsolo.dashboardislmai

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.naufal.idnsolo.dashboardislmai.databinding.ActivityMainBinding
import com.naufal.idnsolo.dashboardislmai.doa.DoaActivity
import com.naufal.idnsolo.dashboardislmai.inspiration.InspirationData
import com.naufal.idnsolo.dashboardislmai.inspiration.InspirationListAdapter
import com.naufal.idnsolo.dashboardislmai.inspiration.InspirationModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initRecyclerViewInspiration()

        showMenu()

    }

    private fun showMenu() {
        binding.btnDoa.setOnClickListener {
            startActivity(Intent(this, DoaActivity::class.java))
        }
    }

    private fun initRecyclerViewInspiration() {
        val list: ArrayList<InspirationModel> = arrayListOf()
        binding.rvInspiration.setHasFixedSize(true)
        list.addAll(InspirationData.listData)
        binding.rvInspiration.layoutManager = LinearLayoutManager(this)
        val inspirationaAdapter = InspirationListAdapter(list)
        binding.rvInspiration.adapter = inspirationaAdapter
    }
}