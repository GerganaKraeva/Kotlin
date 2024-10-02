package com.example.kotlinbasic.bankAccount

fun main() {
    val gerganasAccount = BankAccount("Gergana Kraeva", 1300.0)
    println("${gerganasAccount.accountHolder}`s balance is ${gerganasAccount.balance}")
    println("${gerganasAccount.accountHolder}`s balance is ${gerganasAccount.acctBalance()}")
    gerganasAccount.deposit(2000.0)
    gerganasAccount.withdraw(500.0)
    println("${gerganasAccount.accountHolder}`s balance is ${gerganasAccount.acctBalance()}")
    gerganasAccount.displayTransactionHistory()
}