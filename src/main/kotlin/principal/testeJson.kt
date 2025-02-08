package org.example.principal

import org.example.services.ConsumoApi

fun main() {
    val consumo = ConsumoApi()
    val listaGamers = consumo.buscaGamers()

    println(listaGamers)
}