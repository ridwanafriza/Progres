package com.example.daftarhadir3a

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_profile)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val fullname = intent.getStringExtra("fullname")
        val nim = intent.getStringExtra("nim")
        val status = intent.getStringExtra("status")

        findViewById<TextView>(R.id.textViewFullname).text = "Nama: $fullname"
        findViewById<TextView>(R.id.textViewNim). text = "NIM: $nim"
        findViewById<TextView>(R.id.textViewStatus).text = "Status $status"


        val buttonWhatsapp = findViewById<Button>(R.id.buttonWhatsapp)
        buttonWhatsapp.setOnClickListener {
            val implicitWhatsapp = Intent(
                Intent.ACTION_VIEW,
                Uri.parse("https://wa.me/62083873330735")
            )

            startActivity(implicitWhatsapp)
        }
    }
}