// [Template no Kotlin Playground](https://pl.kotl.in/WcteahpyN)

enum class Nivel { BASICO, INTERMEDIARIO, DIFICIL }

class Usuario(val nome: String)

data class ConteudoEducacional(var nome: String, val duracao: Int = 60)

data class Formacao(val nome: String, var conteudos: MutableList<ConteudoEducacional>) {

    val inscritos = mutableListOf<Usuario>()

    fun matricular(usuario: Usuario) {
        if (!inscritos.contains(usuario)) {
            inscritos.add(usuario)
            println("Matrícula realizada com sucesso para ${usuario.nome}.")
        } else {
            println("O usuário ${usuario.nome} já está matriculado nesta formação.")
        }
    }

    fun adicionarConteudo(conteudo: ConteudoEducacional) {
        conteudos.add(conteudo)
        println("Conteúdo '${conteudo.nome}' adicionado à formação.")
    }

    fun removerConteudo(nomeConteudo: String) {
        val conteudoRemovido = conteudos.removeIf { it.nome == nomeConteudo }
        if (conteudoRemovido) {
            println("Conteúdo '$nomeConteudo' removido da formação.")
        } else {
            println("Conteúdo '$nomeConteudo' não encontrado na formação.")
        }
    }

    fun removerInscrito(usuario: Usuario) {
        val removido = inscritos.remove(usuario)
        if (removido) {
            println("Usuário ${usuario.nome} removido da formação.")
        } else {
            println("Usuário ${usuario.nome} não encontrado na lista de inscritos.")
        }
    }
}

fun main() {
    val usuario1 = Usuario("John")
    val usuario2 = Usuario("Beatriz")

    val formacao = Formacao("Curso Kotlin", mutableListOf(ConteudoEducacional("Introdução ao Kotlin")))

    formacao.matricular(usuario1)
    formacao.matricular(usuario2)

    formacao.adicionarConteudo(ConteudoEducacional("Programação Orientada a Objetos", 90))
    formacao.removerConteudo("Introdução ao Kotlin")

    formacao.removerInscrito(usuario1)
    formacao.removerInscrito(usuario2)

    formacao.matricular(usuario1)  // Tentando matricular o mesmo usuário novamente
}
