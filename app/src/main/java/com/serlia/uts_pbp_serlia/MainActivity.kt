package com.serlia.uts_pbp_serlia

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val satu = findViewById<EditText>(R.id.etSatu)
        val dua = findViewById<EditText>(R.id.etDua)
        val jumlahView = findViewById<EditText>(R.id.etJumlah)
        val tombol = findViewById<Button>(R.id.btnHitung)

        tombol.setOnClickListener {

            val teksSatu = satu.text.toString().trim()
            val teksDua = dua.text.toString().trim()

            // PERBAIKAN: Mengubah input menjadi Int secara aman.
            val jumlah: Int? = jumlahView.text.toString().toIntOrNull()

            // PENJELASAN: Memeriksa apakah nama peserta kosong.
            if (teksSatu.isEmpty()) {
                satu.error = getString(R.string.error_nama_peserta)
                return@setOnClickListener
            }

            // PENJELASAN: Memeriksa apakah nama event kosong.
            if (teksDua.isEmpty()) {
                dua.error = getString(R.string.error_nama_event)
                return@setOnClickListener
            }

            // PENJELASAN: Memeriksa apakah jumlah tiket berupa angka.
            if (jumlah == null) {
                jumlahView.error = getString(R.string.error_jumlah_tidak_valid)
                return@setOnClickListener
            }

            // PENJELASAN: Jumlah tiket harus antara 1 sampai 10.
            if (jumlah < 1 || jumlah > 10) {
                jumlahView.error = getString(R.string.error_batas_tiket)
                return@setOnClickListener
            }

            val tarif: Int = 75000

            // PERBAIKAN: Menghitung total menggunakan perkalian Int.
            val total: Int = jumlah * tarif

            // PENJELASAN: Membuat Intent untuk membuka ResultActivity.
            val intent = Intent(this, ResultActivity::class.java)

            // PERBAIKAN: Mengirim data menggunakan putExtra().
            intent.putExtra("nama_peserta", teksSatu)
            intent.putExtra("nama_event", teksDua)
            intent.putExtra("jumlah_tiket", jumlah)
            intent.putExtra("total", total)

            // PENJELASAN: Membuka halaman hasil.
            startActivity(intent)
        }
    }
}
