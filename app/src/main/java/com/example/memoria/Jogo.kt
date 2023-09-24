package com.example.memoria

import android.widget.ImageView

class Jogo {
    var numeroMaximoTentativas = 10
    private var tentativasErradas = 0
    var paresEncontrados = 0
    var cartas = mutableListOf<Int>()
    init {
        this.cartas = mutableListOf<Int>(
            R.drawable.prof1, R.drawable.prof2,
            R.drawable.prof3, R.drawable.prof4,
            R.drawable.prof5, R.drawable.prof6,
            R.drawable.prof7, R.drawable.prof8,
            R.drawable.prof1, R.drawable.prof2,
            R.drawable.prof3, R.drawable.prof4,
            R.drawable.prof5, R.drawable.prof6,
            R.drawable.prof7, R.drawable.prof8
        )
        this.cartas.shuffle()
    }
    fun verificarTentativa(cartas: MutableList<ImageView>): Boolean {

        var primeiraCarta = cartas[0].tag as Int
        var segundaCarta = cartas[1].tag as Int

        if (numeroMaximoTentativas > 0) {
           if (primeiraCarta == segundaCarta) {
               paresEncontrados++
               return true
           } else {
               tentativasErradas++
               numeroMaximoTentativas--
               return false
           }
        }
        return false
    }
    fun verificarFimDoJogo(): String {
        if (paresEncontrados == 8) {
            return "Ganhou!"
        } else if (numeroMaximoTentativas == 0) {
            return "Perdeu!"
        } else {
            return "Continue jogando"
        }
    }
    fun novoJogo() {
        numeroMaximoTentativas = 10
        tentativasErradas = 0
        paresEncontrados = 0
        this.cartas.shuffle()
    }
}
