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
        binding.tvTitle.text = doa.title
        binding.tvArabic.text = doa.doa
        binding.tvLatin.text = doa.latin
        binding.tvRiwayat.text = doa.profile
        binding.tvTerjemahan.text = doa.translate

    }

    companion object {
        const val EXTRA_DOA = "extra_doa"
    }
}