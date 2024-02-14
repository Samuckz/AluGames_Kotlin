import com.google.gson.Gson
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse.BodyHandlers
import java.util.*

fun main() {

    val leitura = Scanner(System.`in`)
    println("Digite o id do jogo que deseja pesquisar: ")
    val id = leitura.nextLine()

    val endereco = "https://www.cheapshark.com/api/1.0/games?id=$id"

    var meuJogo:Jogo? = null

    val resultado = runCatching {
        val client: HttpClient = HttpClient.newHttpClient()
        val request = HttpRequest.newBuilder().
        uri(URI.create(endereco))
            .build()

        val response = client.send(request, BodyHandlers.ofString())

        val json = response.body()

        val gson = Gson()

        val meuInfoJogo = gson.fromJson(json, Info::class.java)
        meuJogo = Jogo(
            meuInfoJogo.info.title,
            meuInfoJogo.info.thumb)
    }

    resultado.onSuccess {
        println("Você gostaria de fornecer uma descrição personalizada no game? s/n")
        val op = leitura.nextLine()
        if(op.equals("s", true)){
            println("Insira a descrição personalizada para o jogo: ")
            val descricaoPersonalizada = leitura.nextLine()
            meuJogo?.descricao = descricaoPersonalizada
        } else{
            meuJogo?.descricao = meuJogo?.titulo.toString()
        }

        println(meuJogo)
    }

    resultado.onFailure {
        println("Jogo inexistente. Tente outro id")
    }


}
