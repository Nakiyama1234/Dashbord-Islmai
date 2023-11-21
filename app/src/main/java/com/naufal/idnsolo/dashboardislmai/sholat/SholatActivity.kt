package com.naufal.idnsolo.dashboardislmai.sholat

import android.app.Activity
import android.opengl.Visibility
import android.os.Binder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import com.google.gson.JsonObject
import com.loopj.android.http.AsyncHttpClient
import com.loopj.android.http.AsyncHttpResponseHandler
import com.naufal.idnsolo.dashboardislmai.R
import com.naufal.idnsolo.dashboardislmai.databinding.ActivitySholatBinding
import cz.msebera.android.httpclient.Header
import org.json.JSONObject
import java.nio.channels.AsynchronousChannel
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.Locale

class SholatActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySholatBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySholatBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)
        initSholatView()
        getPrayTimeData("1505")
    }

    private fun getPrayTimeData(location: String) {
        val calendar = Calendar.getInstance()
        val tanggal = calendar.get(Calendar.DAY_OF_MONTH)
        val bulan = calendar.get(Calendar.MONTH)
        val tahun = calendar.get(Calendar.YEAR)
        val client = AsyncHttpClient()
        val url = "https://api.myquran.com/v1/sholat/jadwal/$location/$tahun/$bulan/$tanggal"
        Log.d("SholaActivity", "getPrayTimeData(): $url")

        client.get(url, object : AsyncHttpResponseHandler(){
            override fun onSuccess(
                statusCode: Int,
                headers: Array<out Header>?,
                responseBody: ByteArray?
            ) {
                binding.pbJadwalSholat.visibility = View.VISIBLE
                val responsData = responseBody?.let { String(it) }

//                Parsing JSON (Mengurang data JSON)
                try {
//                    take all JSON data
                    val responseSholat = JSONObject(responsData.toString())
//                    Cechk Data
                    Log.d("Jadwal Sholat Activity", "Data JSON : $responseSholat")
//                    Take Some Data
                    val data = responseSholat.getJSONObject("data")
//                    Show to Some UI
                    binding.tvLocation.text = data.getString("Lokasi")
                    val jadwal = responseSholat.getJSONObject("Jadwal")
//                    Chek Data
                    Log.d("Jadwal Sholat Activity","data jadwal : $jadwal")
                    binding.tvPrayTimeSubuh.text = jadwal.getString("shubuh")
                    binding.tvPrayTimeSunrise.text = jadwal.getString("sunrise")
                    binding.tvPrayTimeDzuhur.text = jadwal.getString("dzuhur")
                    binding.tvPrayTimeAshar.text = jadwal.getString("ashar")
                    binding.tvPrayTimeMaghrib.text = jadwal.getString("maghrib")
                    binding.tvPrayTimeIsya.text = jadwal.getString("shubuh")

                }catch (error : Exception){
                    Toast.makeText(this@SholatActivity, error.message, Toast.LENGTH_SHORT).show()
                    error.printStackTrace()
                }
            }

            override fun onFailure(
                statusCode: Int,
                headers: Array<out Header>?,
                responseBody: ByteArray?,
                error: Throwable?
            ) {
                Toast.makeText(this@SholatActivity, error?.message, Toast.LENGTH_SHORT).show()
            }

        })

    }

    private fun initSholatView() {
        val waktu = Calendar.getInstance().time
        val dateFormat = SimpleDateFormat("EEEE, dd MMMM yyyy", Locale.getDefault())
        val formattedDate = dateFormat.format(waktu)
//        Tanggal Tampilan
        binding.tvDatePray.text = formattedDate
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            finish()
        }
        return super.onOptionsItemSelected(item)
    }
}