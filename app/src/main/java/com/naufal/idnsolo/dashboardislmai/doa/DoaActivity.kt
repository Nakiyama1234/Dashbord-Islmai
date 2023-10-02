package com.naufal.idnsolo.dashboardislmai.doa

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.naufal.idnsolo.dashboardislmai.R
import com.naufal.idnsolo.dashboardislmai.databinding.ActivityDoaBinding
import com.naufal.idnsolo.dashboardislmai.databinding.ActivityMainBinding

class DoaActivity : AppCompatActivity() {

    private lateinit var binding : ActivityDoaBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val actionBar = supportActionBar
        actionBar!!.title = "Doa Harian"
        actionBar.setDisplayHomeAsUpEnabled(true)
        actionBar.setDisplayShowHomeEnabled(true)

        binding = ActivityDoaBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
    //button back action bar

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }
}