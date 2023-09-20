package com.example.memoria

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class GanhouActivity : AppCompatActivity() {
    private lateinit var btnGanhou: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ganhou)

        this.btnGanhou = findViewById(R.id.btnGanhouVolta)
        this.btnGanhou.setOnClickListener{ voltar() }
    }

    fun voltar(){
        finish()
    }
}