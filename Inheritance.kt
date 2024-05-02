package org.example

open class Veiculo(val marca: String, val modelo: String) {
    open fun acelerar() {
        println("O $modelo da marca $marca está acelerando.")
    }

    open fun frear() {
        println("O $modelo da marca $marca está freando.")
    }
}

class Carro(marca: String, modelo: String, val tipoDeCambio: String) : Veiculo(marca, modelo) {
    override fun acelerar() {
        super.acelerar() // Chama a implementação da superclasse
        println("O carro está acelerando rapidamente.")
    }

    fun trocarMarcha() {
        println("Trocando marcha do carro com câmbio $tipoDeCambio.")
    }
}

class Moto(marca: String, modelo: String, val cilindradas: Int) : Veiculo(marca, modelo) {
    override fun acelerar() {
        super.acelerar() // Chama a implementação da superclasse
        println("A moto de $cilindradas cilindradas está acelerando com agilidade.")
    }

    fun empinar() {
        println("A moto está empinando!")
    }
}

fun main() {
    val meuCarro = Carro("Toyota", "Corolla", "Automático")
    meuCarro.acelerar()
    meuCarro.trocarMarcha()

    val minhaMoto = Moto("Honda", "CB 500", 500)
    minhaMoto.acelerar()
    minhaMoto.empinar()
}