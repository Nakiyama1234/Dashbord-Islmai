package com.naufal.idnsolo.dashboardislmai.kajian

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.naufal.idnsolo.dashboardislmai.R
import com.naufal.idnsolo.dashboardislmai.databinding.ActivityDetailKajianBinding

class DetailKajianActivity : AppCompatActivity() {

    private lateinit var binding : ActivityDetailKajianBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailKajianBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}