package com.example.cadastro

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.google.firebase.auth.FirebaseAuth

class Inicio : AppCompatActivity() {
    private val autentication by lazy {
        FirebaseAuth.getInstance()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inicio)
        val email = findViewById<TextView>(R.id.idemail)
        val senha = findViewById<TextView>(R.id.idsenha)
        email.text = autentication.currentUser?.email
        val txtsenha = intent.getStringExtra("senha")
        senha.setText(txtsenha)
        val btnsair = findViewById<Button>(R.id.btnsair)
        btnsair.setOnClickListener {
            logout()
        }
    }

    fun logout() {
        autentication.signOut()
        finish()
    }
}
