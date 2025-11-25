package com.example.daftarhadir3a

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class LoginActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val editTextEmailAddress: EditText = findViewById<EditText>(R.id.editTextTextEmailAddress)
        val editTextTextPassword: EditText = findViewById<EditText>(R.id.editTextTextPassword)
        val buttonLogin = findViewById<Button>(R.id.buttonLogin)

        // handle login
        // 1. pakai interface
        //buttonLogin.setOnClickListerner(this)

        // 2. pakai lambda

        buttonLogin.setOnClickListener {
            val email: String = editTextEmailAddress.text.toString()
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra(KEY_USERNAME, email)
            startActivity(intent)

            Toast.makeText(this,
                "Button Login clicked",
                Toast.LENGTH_SHORT)
                .show()
        }
    }


    override fun onClick(view: View) {

        when (view.id) {
            R.id.buttonLogin -> {
                Toast
                    .makeText(this, "Button Login Clicked", Toast.LENGTH_SHORT).show()
            }
        }
        TODO("Not yet implemented")

    }


    companion object{
        const val KEY_USERNAME = "username"
    }

}