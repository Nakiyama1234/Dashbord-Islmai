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
import com.naufal.idnsolo.dashboardislmai.kajian.KajianActivity
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initRecyclerViewInspiration()
        moveActivity()
        initTimeForSholat()

    }

    private fun initTimeForSholat() {
        val timeNow = Calendar.getInstance()
        val timeFormat = SimpleDateFormat("HH:mm:ss", Locale.getDefault());
        val time = timeFormat.format(timeNow.time)


        when{
            time.toInt() in 0..5 -> binding.imageHeader.setImageResource(
                R.drawable.bg_header_dashboard_night
            )
            time.toInt() in 6..11 -> binding.imageHeader.setImageResource(
                R.drawable.bg_header_dashboard_morning
            )
            time.toInt() in 12..17 -> binding.imageHeader.setImageResource(
                R.drawable.bg_header_dashboard_afternoon
            )
            time.toInt() in 18..23 -> binding.imageHeader.setImageResource(
                R.drawable.bg_header_dashboard_night
            )
        }
    }

    private fun moveActivity() {
        binding.btnDoa.setOnClickListener {
            startActivity(Intent(this, DoaActivity::class.java))
        }
        binding.btnZakat.setOnClickListener{
            startActivity(Intent(this, DoaActivity::class.java))
        }
        binding.btnKajian.setOnClickListener{
            startActivity(Intent(this, KajianActivity::class.java))
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