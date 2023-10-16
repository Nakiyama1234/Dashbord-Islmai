package com.naufal.idnsolo.dashboardislmai.zakat

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.naufal.idnsolo.dashboardislmai.R
import com.naufal.idnsolo.dashboardislmai.databinding.ActivityZakatBinding
import java.text.NumberFormat
import java.util.Locale

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

            if (totalHarta.isEmpty()) {
                isEmptyField = true
                binding.totalHartaAll.error = "Fild ini tidak boleh kosong"
            }

            if (!isEmptyField) {
                val emas = 92395000
                val persen = 0.025
                val localeID = Locale("in", "ID")
                val formatRupiah: NumberFormat = NumberFormat.getCurrencyInstance(localeID)
                val totalHarta= binding.totalHartaAll.text.toString().trim()

                if (totalHarta.isEmpty()) {
                    isEmptyField = true
                    binding.status.text = "Belum wajib zakat"

                } else {
                    val zakat = totalHarta.toDouble() * persen
                    binding.status.text = "Wajib Zakat"
                    binding.zakatYangDikeluarkan.text = formatRupiah.format(zakat)
                }

            }
        }
    }
}