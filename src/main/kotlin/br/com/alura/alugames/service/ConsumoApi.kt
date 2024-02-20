package br.com.alura.alugames.service

import br.com.alura.alugames.model.Info
import com.google.gson.Gson
import java.lang.RuntimeException
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse

class ConsumoApi {
    fun buscaJogo(id: String): Info? {
        val connect = runCatching {
            val url = "https://www.cheapshark.com/api/1.0/games?id=$id"
            val httpClient = HttpClient.newHttpClient()
            val httpRequest = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build()

            val httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString())
            val json = httpResponse.body()
            val gson = Gson()
            val meuInfoJogo = gson.fromJson(json, Info::class.java)

            return meuInfoJogo
        }

        connect.onFailure {
            throw RuntimeException("Erro ao procurar jogo")
        }

        return null
    }
}