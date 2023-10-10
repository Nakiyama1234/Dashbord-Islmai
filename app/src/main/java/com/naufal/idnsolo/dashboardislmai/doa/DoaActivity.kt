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

        val actionBar = supportActionBar
        actionBar!!.title = "Doa Harian"
        actionBar.setDisplayHomeAsUpEnabled(true)

        intentToListActivity()

        binding = ActivityDoaBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    private fun intentToListActivity() {
        binding.cardDoaPagiMalam.setOnClickListener {
            val intent = Intent (this, ListDoaActivity::class.java)
            intent.putExtra(ListDoaActivity.EXTRA_TITLE, getString(R.string.pagi_dan_malam))
            intent.putExtra(ListDoaActivity.ETRA_IMAGE, R.drawable.ic_doa_pagi_malam)
        }
    }
    //button back action bar

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }

    companion object{
        const val EXTRA_TITLE = "extra-title"
        const val EXTRA_IMAGE = "extra-image"


    }
}