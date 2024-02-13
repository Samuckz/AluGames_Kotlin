data class Jogo(val titulo: String,
           val capa: String) {

    val descricao = ""

    override fun toString(): String {
        return "Meu jogo:\nTítulo: '$titulo' \nCapa: '$capa' \nDescricao: '$descricao'"
    }


}

/*
* var -> É possível atribuir um outro valor diferente do inicial
* val -> O valo inicial não pode ser alterado
* */