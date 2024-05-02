package org.example

class Autor(val nome: String, val anoNascimento: Int) {
    fun exibirInfo() {
        println("Autor: $nome, Ano de Nascimento: $anoNascimento")
    }
}

class Livro(val titulo: String, val autor: Autor, val anoPublicacao: Int) {
    fun exibirInfo() {
        println("Livro: \"$titulo\", Publicado em: $anoPublicacao")
        autor.exibirInfo()
    }
}

class Biblioteca(val nome: String) {
    private val livros = mutableListOf<Livro>()

    fun adicionarLivro(livro: Livro) {
        livros.add(livro)
        println("Livro \"${livro.titulo}\" adicionado à biblioteca \"$nome\".")
    }

    fun exibirAcervo() {
        println("Acervo da Biblioteca \"$nome\":")
        livros.forEach { it.exibirInfo() }
    }
}

fun main() {
    val autor1 = Autor("J.K. Rowling", 1965)
    val autor2 = Autor("George R.R. Martin", 1948)

    val livro1 = Livro("Harry Potter e a Pedra Filosofal", autor1, 1997)
    val livro2 = Livro("As Crônicas de Gelo e Fogo - A Guerra dos Tronos", autor2, 1996)

    val minhaBiblioteca = Biblioteca("Biblioteca Central")
    minhaBiblioteca.adicionarLivro(livro1)
    minhaBiblioteca.adicionarLivro(livro2)

    minhaBiblioteca.exibirAcervo()
}
