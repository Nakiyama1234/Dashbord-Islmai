package com.naufal.idnsolo.dashboardislmai.doa

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.naufal.idnsolo.dashboardislmai.databinding.ActivityDetailListDoaBinding

class ListDoaActivity : AppCompatActivity() {


    private lateinit var binding: ActivityDetailListDoaBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailListDoaBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}