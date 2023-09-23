package com.example.memoria

import android.content.Intent
import android.opengl.Matrix
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import android.os.Handler
import android.widget.GridLayout
import androidx.core.view.marginBottom

class MainActivity : AppCompatActivity() {

    private lateinit var jogo: Jogo
    private lateinit var imageViews: MutableList<ImageView>
    private lateinit var tvTentativas: TextView
    private lateinit var progressBar1: ProgressBar
    private lateinit var memoria: GridLayout

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
            imageProf.layoutParams.height = 250
            imageProf.layoutParams.width = 250
            imageProf.setBackgroundColor(R.drawable.ic_launcher_background)
            imageProf.setImageResource(carta)
            imageProf.imageAlpha = 0 //pesquisar como colocar margem
        }
    }

//    private fun esconderCarta() {

    }

//    private fun virarCarta(carta: ImageView) {
//        val imagemResource = jogo.cartas[carta.id]
//        if (imagemResource != 0) {
//            carta.setImageResource(imagemResource)
//        } else {
//            carta.setImageResource(R.drawable.ic_launcher_background)
//        }
//
//        if (primeiraCartaVirada == null) {
//            primeiraCartaVirada = carta
//        } else {
//            segundaCartaVirada = carta
//            bloquearToque = true
//
//            Handler().postDelayed({
//                val primeiroId = primeiraCartaVirada!!.id
//                val segundoId = segundaCartaVirada!!.id
//
//                val match = jogo.verificarTentativa(primeiroId, segundoId)
//
//                if (!match) {
//                    primeiraCartaVirada?.setImageResource(R.drawable.ic_launcher_background)
//                    segundaCartaVirada?.setImageResource(R.drawable.ic_launcher_background)
//                }
//
//                primeiraCartaVirada = null
//                segundaCartaVirada = null
//                bloquearToque = false
//
//                if (jogo.verificarFimDoJogo()) {
//                    exibirMensagemFimDoJogo()
//                }
//            }, 1000)
//        }
//    }
//
//    private fun progress() {
//        Thread {
//            while (this.progressBar1.progress < 100) {
//                this.progressBar1.progress += 1
//                Thread.sleep(100)
//            }
//            runOnUiThread {
//                this.progressBar1.visibility = View.INVISIBLE
//            }
//        }.start()
//    }
//
//    private fun exibirMensagemFimDoJogo() {
//        val mensagem = if (jogo.paresEncontrados == jogo.cartas.size / 2) {
//            "Você ganhou!"
//        } else {
//            "Fim de jogo! Você perdeu."
//        }
//
//        Toast.makeText(this, mensagem, Toast.LENGTH_SHORT).show()
//
//        if (jogo.paresEncontrados == jogo.cartas.size / 2) {
//            indoTelaGanhou()
//        } else {
//            indoTelaPerdeu()
//        }
//    }
//    private fun novoJogo() {
//        val imagensEmbaralhadas = criarListaDeImagens().shuffled()
//        jogo.novoJogo()
//        tvTentativas.text = "Tentativas: ${jogo.numeroMaximoTentativas}"
//        progressBar1.progress = 0
//
//        for (i in imageViews.indices) {
//            imageViews[i].setImageResource(R.drawable.ic_launcher_background)
//        }
//    }
//
//    private fun criarListaDeImagens(): List<String> {
//        return List(imageViews.size / 2) { "prof${it + 1}" } + List(imageViews.size / 2) { "prof${it + 1}" }
//    }
//
//    private fun indoTelaPerdeu() {
//        val intent = Intent(this, PerdeuActivity::class.java)
//      startActivity(intent)
//   }
//
//   private fun indoTelaGanhou() {
//       val intent = Intent(this, GanhouActivity::class.java)
//       startActivity(intent)
//    }
//
//}
//

//class MainActivity: AppCompatActivity() {
//
//    private lateinit var jogo: Jogo
//    private lateinit var imageViews: MutableList<ImageView>
//    private lateinit var tvTentativas: TextView
//    private lateinit var progressBar1: ProgressBar
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//
//        this.tvTentativas = findViewById(R.id.tvTentativas)
//        this.progressBar1 = findViewById(R.id.progressBar1)
//
//        this.jogo = Jogo()
//
//        this.imageViews = mutableListOf(
//            findViewById(R.id.imageProf1),
//            findViewById(R.id.imageProf2),
//            findViewById(R.id.imageProf3),
//            findViewById(R.id.imageProf4),
//            findViewById(R.id.imageProf5),
//            findViewById(R.id.imageProf6),
//            findViewById(R.id.imageProf7),
//            findViewById(R.id.imageProf8),
//            findViewById(R.id.imageProf9),
//            findViewById(R.id.imageProf10),
//            findViewById(R.id.imageProf11),
//            findViewById(R.id.imageProf12),
//            findViewById(R.id.imageProf13),
//            findViewById(R.id.imageProf14),
//            findViewById(R.id.imageProf15),
//            findViewById(R.id.imageProf16)
//        )
//
//        for (imageView in imageViews) {
//            imageView.setOnClickListener {
//                if (podeVirarCarta(imageView)) {
//                    virarCarta(imageView)
//                }
//            }
//        }
//        progress()
//    }
//    private fun podeVirarCarta(carta: ImageView): Boolean {
//        return jogo.verificarTentativa(carta.tag as String)
//    }
//    private fun virarCarta(carta: ImageView) {
//        val nomeCarta = carta.tag as String
//        val imagemResource = getImageResourceByName(nomeCarta)
//        if (imagemResource != 0) {
//            carta.setImageResource(imagemResource)
//        } else {
//            carta.setImageResource(R.drawable.ic_launcher_background)
//        }
//
//        if (jogo.verificarFimDoJogo()) {
//            if (jogo.paresEncontrados == 8) {
//                Toast.makeText(this, "Você ganhou!", Toast.LENGTH_SHORT).show()
//                this.indoTelaGanhou()
//            } else {
//                Toast.makeText(this, "Você perdeu!", Toast.LENGTH_SHORT).show()
//                this.indoTelaPerdeu()
//            }
//            novoJogo()
//        }
//    }
//    private fun progress() {
//        Thread {
//            while (this.progressBar1.progress < 100) {
//                this.progressBar1.progress += 1
//                Thread.sleep(100)
//            }
//            this.progressBar1.visibility = View.INVISIBLE
//        }.start()
//    }
//    private fun indoTelaPerdeu() {
//        val intent = Intent(this, PerdeuActivity::class.java)
//      startActivity(intent)
//   }
//
//   private fun indoTelaGanhou() {
//       val intent = Intent(this, GanhouActivity::class.java)
//       startActivity(intent)
//    }
//
//    private fun novoJogo() {
//        this.jogo.novoJogo()
//        tvTentativas.text = "Tentativas: ${jogo.numeroMaximoTentativas}"
//        progressBar1.progress = 0
//
//        for (imageView in imageViews) {
//            imageView.setImageResource(R.drawable.ic_launcher_background)
//        }
//    }
//    private fun getImageResourceByName(name: String): Int {
//        return resources.getIdentifier(name, "drawable", packageName)
//    }
//}
//    private lateinit var jogo: Jogo
//    private lateinit var imageViews: List<ImageView>
//    private lateinit var tvTentativas: TextView
//    private lateinit var progressBar1: ProgressBar
//    private var primeiraCarta: ImageView? = null
//    private var segundaCarta: ImageView? = null
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//
//        this.tvTentativas = findViewById(R.id.tvTentativas)
//        this.progressBar1 = findViewById(R.id.progressBar1)
//
//        primeiraCarta?.setOnClickListener { jogo.virarCarta(primeiraCarta!!, "imageProf1") }
//        segundaCarta?.setOnClickListener { jogo.virarCarta(segundaCarta!!, "imageProf2") }
//
//        this.jogo = Jogo()
//        imageViews = listOf(
//            findViewById(R.id.imageProf1),
//            findViewById(R.id.imageProf2),
//            findViewById(R.id.imageProf3),
//            findViewById(R.id.imageProf4),
//            findViewById(R.id.imageProf5),
//            findViewById(R.id.imageProf6),
//            findViewById(R.id.imageProf7),
//            findViewById(R.id.imageProf8)
//        )
//
//        for (imageView in imageViews) {
//            imageView.setOnClickListener {
//                if (podeVirarCarta()) {
//                    jogo.virarCarta(imageView, "imageProf1")
//                }
//            }
//        }
//        progress()
//    }
//    private fun podeVirarCarta(): Boolean {
//        return segundaCarta == null
//    }
//
//    private fun progress(){
//        Thread{
//            while (this.progressBar1.progress < 100){
//                this.progressBar1.progress += 1
//                Thread.sleep(100)
//            }
//            this.progressBar1.visibility = View.INVISIBLE
//        }.start()
//    }
//    private fun tentativaErrada() {
//        jogo.registrarTentativaErrada()
//        val tentativasErradas = jogo.getTentativasErradas()
//        tvTentativas.text = "Tentativas: $tentativasErradas"
//    }
//    private fun indoTelaPerdeu() {
//        val intent = Intent(this, PerdeuActivity::class.java)
//        startActivity(intent)
//    }
//
//    private fun indoTelaGanhou() {
//        val intent = Intent(this, GanhouActivity::class.java)
//        startActivity(intent)
//    }
//    override fun onRestart() {
//        super.onRestart()
//        this.jogo.novoJogo()
//    }
//}