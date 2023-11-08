package com.naufal.idnsolo.dashboardislmai.doa

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.naufal.idnsolo.dashboardislmai.R
import com.naufal.idnsolo.dashboardislmai.databinding.ActivityDoaBinding
import com.naufal.idnsolo.dashboardislmai.databinding.ActivityMainBinding

class DoaActivity : AppCompatActivity() {

    private lateinit var binding : ActivityDoaBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//        val actionBar = supportActionBar
//        actionBar!!.title = "Doa Harian"
//        actionBar.setDisplayHomeAsUpEnabled(true)

        intentToListActivity()

        binding = ActivityDoaBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    private fun intentToListActivity() {
        binding.cardDoaPagiMalam.setOnClickListener {
            val intent = Intent (this, ListDoaActivity::class.java)
            intent.putExtra(ListDoaActivity.EXTRA_TITLE, getString(R.string.pagi_dan_malam))
            intent.putExtra(ListDoaActivity.EXTRA_IMAGE, R.drawable.ic_doa_pagi_malam)
            startActivity(intent)
        }
        binding.doaRumah.setOnClickListener {
            val intent = Intent (this, ListDoaActivity::class.java)
            intent.putExtra(ListDoaActivity.EXTRA_TITLE, getString(R.string.rumah))
            intent.putExtra(ListDoaActivity.EXTRA_IMAGE, R.drawable.ic_doa_rumah)
            startActivity(intent)
        }
        binding.makananMinuman.setOnClickListener {
            val intent = Intent (this, ListDoaActivity::class.java)
            intent.putExtra(ListDoaActivity.EXTRA_TITLE, getString(R.string.makanan_amp_minuman))
            intent.putExtra(ListDoaActivity.EXTRA_IMAGE, R.drawable.ic_doa_makanan_minuman)
            startActivity(intent)
        }
        binding.doaPerjalanan.setOnClickListener {
            val intent = Intent (this, ListDoaActivity::class.java)
            intent.putExtra(ListDoaActivity.EXTRA_TITLE, getString(R.string.perjalanan))
            intent.putExtra(ListDoaActivity.EXTRA_IMAGE, R.drawable.ic_doa_perjalanan)
            startActivity(intent)
        }
        binding.sholat.setOnClickListener {
            val intent = Intent (this, ListDoaActivity::class.java)
            intent.putExtra(ListDoaActivity.EXTRA_TITLE, getString(R.string.sholat))
            intent.putExtra(ListDoaActivity.EXTRA_IMAGE, R.drawable.ic_doa_sholat)
            startActivity(intent)
        }
        binding.etikaBaik.setOnClickListener {
            val intent = Intent (this, ListDoaActivity::class.java)
            intent.putExtra(ListDoaActivity.EXTRA_TITLE, getString(R.string.etika_baik))
            intent.putExtra(ListDoaActivity.EXTRA_IMAGE, R.drawable.ic_doa_etika_baik)
            startActivity(intent)
        }
    }
    //button back action bar

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }
}