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
import com.example.myapplication.model.modelpariwisata

class wisataActivity : AppCompatActivity() {

    private var recyclerView: RecyclerView? = null
    private var pariwisataAdapter: pariwisataAdapter? = null
    private var pariwisataList: List<modelpariwisata>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_wisata)

        // Initialize sample data
        pariwisataList = listOf(
            modelpariwisata("Wisata A", "Deskripsi wisata A", R.drawable.ic_launcher_foreground),
            modelpariwisata("Wisata B", "Deskripsi wisata B", R.drawable.ic_launcher_foreground),
            modelpariwisata("Wisata C", "Deskripsi wisata C", R.drawable.ic_launcher_foreground)
        )

        recyclerView = findViewById(R.id.rv_pariwisata)
        pariwisataAdapter = pariwisataAdapter(this, pariwisataList!!) { pariwisata ->
            // Navigate to MapsActivity instead of non-existent pariwisataDetail
            val intent = Intent(this, MapsActivity::class.java)
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