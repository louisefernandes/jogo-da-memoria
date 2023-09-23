package com.example.memoria

class Jogo {
    var numeroMaximoTentativas = 20
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
    fun verificarTentativa(primeiraCarta: Int, segundaCarta: Int): Boolean {

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
    fun verificarFimDoJogo(): Boolean {
        return paresEncontrados == 8 || numeroMaximoTentativas == 0
    }
    fun getTentativasErradas(): Int {
        return tentativasErradas
    }
    fun novoJogo() {
        numeroMaximoTentativas = 20
        tentativasErradas = 0
        paresEncontrados = 0
        this.cartas.shuffle()
    }
}
//private var numeroMaximoTentativas = 10
//private var tentativasErradas = 0
//private var paresEncontrados = 0
//private var primeiraCarta: ImageView? = null
//private var segundaCarta: ImageView? = null

//constructor() {
//    this.numeroMaximoTentativas = 10
//    criarTabuleiro()
//}
//private fun criarTabuleiro() {
//    val totalDeCartas = 8
//    val nomesDasImagens = mutableListOf<String>()
//
//    for (i in 1..totalDeCartas) {
//        nomesDasImagens.add("imageProf$i")
//    }
//
//    nomesDasImagens.shuffle()
//}
//fun virarCarta(carta: ImageView, s: String) {
//    if (primeiraCarta == null) {
//        primeiraCarta = carta
//        carta.visibility = View.VISIBLE
//    } else if (segundaCarta == null) {
//        segundaCarta = carta
//        carta.visibility = View.VISIBLE
//        verificarPar()
//    }
//}
//fun verificarPar() {
//    if (primeiraCarta != null && segundaCarta != null) {
//        val imagemCarta1 = primeiraCarta!!.drawable
//        val imagemCarta2 = segundaCarta!!.drawable
//
//        if (imagemCarta1.constantState == imagemCarta2.constantState) {
//            registrarParEncontrado()
//        } else {
//            registrarTentativaErrada()
//        }
//
//        primeiraCarta = null
//        segundaCarta = null
//    }
//}
//private fun virarCartaDeVolta(carta: ImageView) {
//    carta.visibility = View.INVISIBLE
//}
//fun registrarTentativaErrada() {
//    tentativasErradas++
//}
//fun getTentativasErradas(): Int {
//    return tentativasErradas
//}
//fun verificarFimDoJogo(): Boolean {
//    return paresEncontrados == 8 || tentativasErradas >= numeroMaximoTentativas
//}
//fun registrarParEncontrado() {
//    paresEncontrados++
//}