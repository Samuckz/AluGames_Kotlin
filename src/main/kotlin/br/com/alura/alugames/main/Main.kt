package br.com.alura.alugames.main

import br.com.alura.alugames.model.Jogo
import br.com.alura.alugames.service.ConsumoApi
import java.util.*

fun main() {

    val scanner = Scanner(System.`in`)
    var jogo: Jogo? = null

    println("Digite o id do jogo que deseja pesquisar")
    val id = scanner.nextLine()

    val buscaApi = ConsumoApi()
    val informacaoJogo = buscaApi.buscaJogo(id)

    val result = runCatching {
        if (informacaoJogo != null) {
            jogo = Jogo(
                informacaoJogo.info.title,
                informacaoJogo.info.thumb
            )
        }
    }

    result.onSuccess {
        println("Você deseja inserir alguma descrição personalizada sobre o jogo? y/n")
        val option = scanner.nextLine()

        if (option.equals("y", true)){
            println("Digite a descrição que você deseja inserir:")
            val description = scanner.nextLine()
            jogo?.descricao = description
        } else{
            jogo?.descricao = jogo?.titulo
        }

        println(jogo)
    }

    result.onFailure {
        println("Jogo inexistente. Por favor tente outro id!")
    }

}
