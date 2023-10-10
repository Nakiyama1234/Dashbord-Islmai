package com.naufal.idnsolo.dashboardislmai.doa

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.naufal.idnsolo.dashboardislmai.databinding.ActivityDetailDoaBinding
import com.naufal.idnsolo.dashboardislmai.doa.model.DoaModel

class DetailDoaActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailDoaBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailDoaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val doa = intent.getParcelableExtra<DoaModel>(EXTRA_DOA) as DoaModel
        val actionBar = supportActionBar
        actionBar!!.title = doa.title
        actionBar.setDisplayHomeAsUpEnabled(true)

        binding.tvTitle.text = doa.title
        binding.tvArabic.text = doa.title
        binding.tvLatin.text = doa.title
        binding.tvRiwayat.text = doa.title
        binding.tvTerjemahan.text = doa.title

    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    companion object {
        const val EXTRA_DOA = "extra_doa"
    }
}