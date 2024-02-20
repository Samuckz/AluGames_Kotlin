import br.com.alura.alugames.model.Gamer

fun main(){
    val gamer1 = Gamer("Jacqueline", "jacqueline@email.com")
    println(gamer1)

    val gamer2 = Gamer(
        "Jennifer",
        "jennifer@email.com",
        "19/09/1992",
        "jeni")

    println(gamer2)

    gamer1.let {
        it.dataNascimento = "18/09/2000"
        it.usuario = "JacqueSkyWalker"
    }.also {
        println(gamer1.idInterno)
    }

    gamer1.usuario = "jacque"
    println(gamer1)
}