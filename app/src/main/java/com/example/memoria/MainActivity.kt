package com.example.memoria

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast

class MainActivity<GridLayout : View?> : AppCompatActivity() {

    private lateinit var jogo: Jogo
    private lateinit var imageViews: List<ImageView>
    private lateinit var tvTentativas: TextView
    private lateinit var progressBar1: ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.tvTentativas = findViewById(R.id.tvTentativas)
        this.progressBar1 = findViewById(R.id.progressBar1)

        this.jogo = Jogo()
        val gridLayout = findViewById<GridLayout>(R.id.gridLayout)

        imageViews = listOf(
            findViewById(R.id.imageProf1),
            findViewById(R.id.imageProf2),
            findViewById(R.id.imageProf3),
            findViewById(R.id.imageProf4),
            findViewById(R.id.imageProf5),
            findViewById(R.id.imageProf6),
            findViewById(R.id.imageProf7),
            findViewById(R.id.imageProf8)
        )

        for (imageView in imageViews) {
            imageView.setOnClickListener {
                if (podeVirarCarta(imageView)) {
                    virarCarta(imageView)
                }
            }
        }
        progress()
    }
    private fun podeVirarCarta(carta: ImageView): Boolean {
        return jogo.verificarTentativa(carta.tag as String)
    }

    private fun virarCarta(carta: ImageView) {
        val nomeCarta = carta.tag as String
        val imagemResource = getImageResourceByName(nomeCarta)
        if (imagemResource != 0) {
            carta.setImageResource(imagemResource)
        } else {
            carta.setImageResource(R.drawable.ic_launcher_background)
        }

        if (jogo.verificarFimDoJogo()) {
            if (jogo.paresEncontrados == 8) {
                Toast.makeText(this, "Você ganhou!", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Você perdeu!", Toast.LENGTH_SHORT).show()
            }
            novoJogo()
        }
    }
    private fun progress() {
        Thread {
            while (this.progressBar1.progress < 100) {
                this.progressBar1.progress += 1
                Thread.sleep(100)
            }
            this.progressBar1.visibility = View.INVISIBLE
        }.start()
    }
    private fun indoTelaPerdeu() {
        val intent = Intent(this, PerdeuActivity::class.java)
      startActivity(intent)
   }

   private fun indoTelaGanhou() {
       val intent = Intent(this, GanhouActivity::class.java)
       startActivity(intent)
    }

    private fun novoJogo() {
        jogo.novoJogo()
        tvTentativas.text = "Tentativas: 10"
        progressBar1.progress = 0

        for (imageView in imageViews) {
            imageView.setImageResource(R.drawable.ic_launcher_background)
        }
    }
    private fun getImageResourceByName(name: String): Int {
        return resources.getIdentifier(name, "drawable", packageName)
    }
}
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