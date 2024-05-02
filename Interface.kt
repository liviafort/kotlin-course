package org.example

interface Pagável {
    fun processarPagamento(valor: Double)
    val valorMinimo: Double
}

// Interface para notificações
interface Notificável {
    fun enviarNotificacao(mensagem: String)
}

// Implementação das interfaces Pagável e Notificável
class Pagamento : Pagável, Notificável {
    override val valorMinimo = 10.0  // Valor mínimo para processamento

    override fun processarPagamento(valor: Double) {
        if (valor >= valorMinimo) {
            println("Processando pagamento de R$$valor")
            enviarNotificacao("Pagamento de R$$valor processado com sucesso.")
        } else {
            enviarNotificacao("Falha no processamento. O valor do pagamento deve ser pelo menos R$$valorMinimo.")
        }
    }

    override fun enviarNotificacao(mensagem: String) {
        println("Notificação: $mensagem")
    }
}

fun main() {
    val meuPagamento = Pagamento()
    meuPagamento.processarPagamento(50.0)  // Processa um pagamento válido
    meuPagamento.processarPagamento(5.0)   // Tenta processar um pagamento abaixo do valor mínimo
}