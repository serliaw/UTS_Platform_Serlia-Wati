package com.serlia.uts_pbp_serlia

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ResultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val ringkasan = findViewById<TextView>(R.id.tvRingkasan)
        val totalView = findViewById<TextView>(R.id.tvTotal)

        // PERBAIKAN: Menerima data nama peserta.
        val satu: String = intent.getStringExtra("nama_peserta") ?: ""

        // PERBAIKAN: Menerima data nama event.
        val dua: String = intent.getStringExtra("nama_event") ?: ""

        // PERBAIKAN: Menerima jumlah tiket sebagai Int.
        val jumlah: Int = intent.getIntExtra("jumlah_tiket", 0)

        // PERBAIKAN: Menerima total pembayaran sebagai Int.
        val total: Int = intent.getIntExtra("total", 0)

        // PENJELASAN: getStringExtra digunakan untuk mengambil String,
        // sedangkan getIntExtra digunakan untuk mengambil Int.

        // PERBAIKAN: Menampilkan ringkasan pendaftaran.
        val namaPeserta = getString(R.string.hasil_nama_peserta, satu)
        val namaEvent = getString(R.string.hasil_nama_event, dua)
        val jumlahTiket = getString(R.string.hasil_jumlah_tiket, jumlah)

        ringkasan.text = "$namaPeserta\n$namaEvent\n$jumlahTiket"

        // PERBAIKAN: Menampilkan total pembayaran.
        totalView.text = getString(R.string.hasil_total, total)
    }
}
