package com.naufal.idnsolo.dashboardislmai.zakat

import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.naufal.idnsolo.dashboardislmai.databinding.ActivityZakatBinding
import java.text.NumberFormat
import java.util.Locale

class ZakatActivity : AppCompatActivity() {

    private lateinit var binding: ActivityZakatBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityZakatBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)
        initHitungZakat()

    }

    private fun initHitungZakat() {
        binding.btnHitung.setOnClickListener {
            var isEmptyField = false
            val localeID = Locale("in", "ID")
            val formatRupiah: NumberFormat = NumberFormat.getCurrencyInstance(localeID)
            var inputZakat = binding.totalHartaAll.text.toString().trim()

            if (inputZakat.isEmpty()) {
                isEmptyField = true
                binding.totalHartaAll.error = "Fild ini tidak boleh kosong"
            }

            if (!isEmptyField) {
                if (inputZakat.toInt()!! < 92395000) {
                    binding.TotalHartaKeseluruhan.text = formatRupiah.format(inputZakat.toInt()!!)
                    binding.status.text = "Tidak Wajib Zakat"
                    binding.zakatYangDikeluarkan.text = formatRupiah.format(0)
                    Toast.makeText(this, "Tidak Wajib Zakat", Toast.LENGTH_SHORT).show()
                } else {
                    //rumus zakat
                    //total harta / 2.5% = zakat yang di keluarkan
                    //total harta / 0.025 = zakat di keluarkanz
                    binding.zakatYangDikeluarkan.text = formatRupiah.format(
                        binding.totalHartaAll.text.toString().toDouble()!! * 0.025
                    )
                    Toast.makeText(this, "Wajib Zakat", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            onBackPressed()
        }
        return super.onOptionsItemSelected(item)
    }
}