package com.example.memoria

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.GridLayout
import androidx.core.view.children

class MainActivity : AppCompatActivity() {

    private lateinit var jogo: Jogo
    private lateinit var imageViews: MutableList<ImageView>
    private lateinit var tvTentativas: TextView
    private lateinit var progressBar1: ProgressBar
    private lateinit var memoria: GridLayout
    private var listaCartasClicadas = mutableListOf<ImageView>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.tvTentativas = findViewById(R.id.tvTentativas)
        this.progressBar1 = findViewById(R.id.progressBar1)
        this.memoria = findViewById(R.id.gridLayout)

        this.jogo = Jogo()

        for (carta in jogo.cartas) {
            var imageProf = ImageView(this)
            this.memoria.addView(imageProf)
            imageProf.layoutParams.height = 150
            imageProf.layoutParams.width = 150
            imageProf.setImageResource(carta)
            imageProf.tag = carta
        }

        object : CountDownTimer(5000, 50) {
            override fun onTick(millisUntilFinished: Long) {
                progressBar1.progress += 1
            }
            override fun onFinish() {
                virarTodasCartas()
            }
        }.start()
    }

    private fun virarTodasCartas() {
        for (image in memoria.children) {
            val novaImagem = image as ImageView
            novaImagem.setImageResource(R.drawable.ic_launcher_background)
            image.setOnClickListener({cliqueCarta(image)})
        }
    }

    private fun desvirarCarta(cartas: MutableList<ImageView>) {
        for (carta in cartas) {
            carta.setImageResource(R.drawable.ic_launcher_background)
        }
    }
    private fun cliqueCarta(carta: ImageView) {
        carta.setImageResource(carta.tag as Int)
        this.listaCartasClicadas.add(carta)
        if (this.listaCartasClicadas.size == 2) {
            if (!this.jogo.verificarTentativa(this.listaCartasClicadas)) {
                val cartasClicadas = this.listaCartasClicadas.toMutableList()
                object : CountDownTimer(1000, 10) {
                    override fun onTick(millisUntilFinished: Long) {
                    }
                    override fun onFinish() {
                        desvirarCarta(cartasClicadas)
                    }
                }.start()
            }
            this.listaCartasClicadas.clear()
            tvTentativas.setText("Tentativas restantes: ${this.jogo.numeroMaximoTentativas}")
            this.atualizarInterface()
        }
    }

    private fun atualizarInterface() {

        if (this.jogo.verificarFimDoJogo() == "Ganhou!") {
            this.indoTelaGanhou()
        } else if (this.jogo.verificarFimDoJogo() == "Perdeu!") {
            this.indoTelaPerdeu()
        }
    }
    private fun indoTelaPerdeu() {
        val intent = Intent(this, PerdeuActivity::class.java)
      startActivity(intent)
   }

   private fun indoTelaGanhou() {
       val intent = Intent(this, GanhouActivity::class.java)
       startActivity(intent)
   }
    private fun reiniciarJogo () {
        this.jogo.novoJogo()
        this.atualizarInterface()
        this.memoria.removeAllViews()
        for (carta in jogo.cartas) {
            var imageProf = ImageView(this)
            this.memoria.addView(imageProf)
            imageProf.layoutParams.height = 150
            imageProf.layoutParams.width = 150
            imageProf.setImageResource(carta)
            imageProf.tag = carta
        }

        this.progressBar1.progress = 0
        tvTentativas.setText("Tentativas restantes: ${this.jogo.numeroMaximoTentativas}")

        object : CountDownTimer(10000, 100) {
            override fun onTick(millisUntilFinished: Long) {
                progressBar1.progress += 1
            }
            override fun onFinish() {
                virarTodasCartas()
            }
        }.start()

    }
    override fun onRestart() {
        super.onRestart()
        this.reiniciarJogo()
    }
}