package org.example.services

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import org.example.modelo.InfoGamerJson
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse

class ConsumoApi {

    fun buscaGamers(): List<InfoGamerJson> {
        val endereco = "https://raw.githubusercontent.com/jeniblodev/arquivosJson/main/gamers.json"

        val client: HttpClient = HttpClient.newHttpClient()
        val request = HttpRequest.newBuilder()
            .uri(URI.create(endereco))
            .build()
        val response = client
            .send(request, HttpResponse.BodyHandlers.ofString())

        val json = response.body()

        val gson = Gson()
        val meuGamerTipo = object : TypeToken<List<InfoGamerJson>>() {}.type
        val listaGamer: List<InfoGamerJson> = gson.fromJson(json, meuGamerTipo)

        return listaGamer
    }
}