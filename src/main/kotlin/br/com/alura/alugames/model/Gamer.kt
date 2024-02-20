package br.com.alura.alugames.model

import kotlin.random.Random

data class Gamer(
    var nome: String,
    var email: String
)

{
    var dataNascimento: String? = null
    var usuario: String? = null
        set(value){
            field = value
            if(this.idInterno.isNullOrBlank()){
                generateId()
            }
        }
    var idInterno: String? = null
        private set

    constructor(nome: String, email: String, dataNascimento: String, usuario: String):
            this(nome, email){
                this.dataNascimento = dataNascimento
                this.usuario = usuario
                generateId()
    }



    override fun toString(): String {
        return "Gamer(nome='$nome', email='$email', dataNascimento=$dataNascimento, usuario=$usuario, idInterno=$idInterno)"
    }

    fun generateId(){
        val numero = Random.nextInt(10000)
        val tag = String.format("%04d", numero)

        this.idInterno = "$usuario#$tag"
    }


}
