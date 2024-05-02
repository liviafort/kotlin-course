package org.example

class ContaBancaria(val numeroConta: String) {
    var saldo: Double = 0.0
        private set

    constructor(numeroConta: String, saldoInicial: Double) : this(numeroConta) {
        if (saldoInicial >= 0) {
            saldo = saldoInicial
        }
    }

    init {
        println("Conta $numeroConta criada com saldo $saldo")
    }

    fun depositar(valor: Double) {
        if (valor > 0) {
            saldo += valor
            println("Depósito de $valor realizado. Saldo atual: $saldo")
        }
    }

    fun sacar(valor: Double) {
        if (valor > 0 && saldo >= valor) {
            saldo -= valor
            println("Saque de $valor realizado. Saldo atual: $saldo")
        }
    }
}

fun main() {
    // Criação de uma conta com o construtor primário (sem saldo inicial)
    val conta1 = ContaBancaria("12345-6")
    conta1.depositar(1000.0)
    conta1.sacar(500.0)

    // Criação de uma conta com o construtor secundário (com saldo inicial)
    val conta2 = ContaBancaria("98765-4", 500.0)
    conta2.depositar(500.0)
    conta2.sacar(200.0)

    // Demonstração de tentativa de saque maior que o saldo
    val conta3 = ContaBancaria("11111-1", 100.0)
    conta3.sacar(150.0)
}