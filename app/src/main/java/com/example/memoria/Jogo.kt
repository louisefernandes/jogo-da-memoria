package com.example.memoria

class Jogo {
    private var numeroMaximoTentativas = 10
    private var tentativasErradas = 0
    var paresEncontrados = 0
    private var cartas = arrayOf("alexandre", "alexandre", "gustavo", "gustavo",
        "luiz", "luiz", "maxsuel", "maxsuel", "francisco", "francisco", "edemberg", "edemberg",
        "heremita", "heremita", "valeria", "valeria")

    private var atrasoExibicaoCartas = 2000L
    constructor() {
       this.cartas.shuffle()
    }
    fun verificarTentativa(carta: String): Boolean {
        if (!cartas.contains(carta)) {
            return false
        }

        if (numeroMaximoTentativas > 0) {
            val cartasIguais = cartas.filter { it == carta }

            if (cartasIguais.size >= 2) {
                paresEncontrados++
            } else {
                tentativasErradas++
            }

            numeroMaximoTentativas--
            return true
        }
        return false
    }
    fun registrarTentativaErrada() {
        tentativasErradas++
    }
    fun verificarFimDoJogo(): Boolean {
        return paresEncontrados == 8 || tentativasErradas >= numeroMaximoTentativas
    }
    fun registrarParEncontrado() {
        paresEncontrados++
    }
    fun novoJogo() {
        numeroMaximoTentativas = 10
        tentativasErradas = 0
        paresEncontrados = 0

        cartas.shuffle()
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