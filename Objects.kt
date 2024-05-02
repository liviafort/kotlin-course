package org.example

data class Cliente(val nome: String, val endereco: String)

data class ItemMenu(val nome: String, val preco: Double)

class Pedido(val cliente: Cliente) {
    private val itens = mutableListOf<ItemMenu>()
    var status: String = "Em preparação"
        private set //You can see but not change

    fun adicionarItem(item: ItemMenu) {
        itens.add(item)
    }

    fun finalizarPedido() {
        status = "Finalizado"
        println("Pedido finalizado. Total: R$ ${calcularTotal()}")
    }

    fun calcularTotal(): Double = itens.sumOf { it.preco }

    fun exibirPedido() {
        println("Pedido para ${cliente.nome}:")
        itens.forEach { println("${it.nome} - R$${it.preco}") }
        println("Status: $status")
    }
}

class Restaurante(val nome: String) {
    private val pedidos = mutableListOf<Pedido>()

    fun adicionarPedido(pedido: Pedido) {
        pedidos.add(pedido)
        println("Pedido adicionado para ${pedido.cliente.nome}")
    }

    fun exibirPedidos() {
        println("Pedidos do Restaurante $nome:")
        pedidos.forEach { it.exibirPedido() }
    }
}

fun main() {
    val cliente1 = Cliente("João Silva", "Rua das Flores, 123")
    println(cliente1);

    val item1 = ItemMenu("Hambúrguer", 22.90)
    val item2 = ItemMenu("Batata Frita", 10.50)
    val item3 = ItemMenu("Refrigerante", 5.00)

    val pedido1 = Pedido(cliente1)
    pedido1.adicionarItem(item1)
    pedido1.adicionarItem(item2)
    pedido1.adicionarItem(item3)

    val restaurante = Restaurante("Restaurante Saboroso")
    restaurante.adicionarPedido(pedido1)

    pedido1.finalizarPedido()
    restaurante.exibirPedidos()
}