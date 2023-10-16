package com.naufal.idnsolo.dashboardislmai.zakat

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.naufal.idnsolo.dashboardislmai.R
import com.naufal.idnsolo.dashboardislmai.databinding.ActivityZakatBinding

class ZakatActivity : AppCompatActivity() {

    private lateinit var binding : ActivityZakatBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityZakatBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initHitungZakat()

    }

    private fun initHitungZakat() {
        var isEmpty = false

        binding.btnHitung.setOnClickListener {
            var isEmptyField = false
            val totalHarta = binding.totalHartaAll.text.trim().toString()

            if (!isEmpty) {
                binding.totalHartaAll.error = "Fild ini tidak boleh kosong"
            }

            if (isEmptyField) {
                val emas = 92395000
                val persen = 0.025

                if (totalHarta < emas.toString()) {
                    binding.status.text = "Belum wajib zakat"
                } else {
                    val zakat = totalHarta.toDouble() * persen
                    binding.status.text = "Wajib Zakat"
                    binding.zakatYangDikeluarkan.text = "Rp. $zakat"
                }

            }
        }
    }
}