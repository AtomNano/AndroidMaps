package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.adapter.pariwisataAdapter

class wisataActivity : AppCompatActivity() {

    private var recyclerView: RecyclerView? = null
    private var pariwisataAdapter: pariwisataAdapter? =  null
    private var pariwisataList: List<pariwisataAdapter.pariwisataViewHolder>? = null



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_wisata)

        recyclerView = findViewById(R.id.rv_pariwisata)
        pariwisataAdapter = pariwisataAdapter(this, pariwisataList) { pariwisata ->

            val intent = Intent(this, pariwisataDetail::class.java)
            intent.putExtra("namaWisata", pariwisata.namaWisata)
            intent.putExtra("deskripsiWisata", pariwisata.deskripsiWisata)
            intent.putExtra("gambarWisata", pariwisata.gambarWisata)
            startActivity(intent)

        }
        recyclerView!!.adapter = pariwisataAdapter
        recyclerView!!.layoutManager = LinearLayoutManager(this)
        recyclerView!!.setHasFixedSize(true)


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}