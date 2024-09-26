package com.example.kotlinbasic.bankAccount

class BankAccount (val accountHolder: String, var balance: Double){
 private var transactions = mutableListOf<String>()

    fun deposit(amount: Double) {
        balance += amount
        transactions.add("$accountHolder deposited amount of $${amount}")
    }
    fun withdraw(amount: Double) {
        if(amount<=balance) {
            balance -= amount
            transactions.add("$accountHolder withdrew  $${amount}")
        } else {
            println("$accountHolder does not have the funds to withdraw $$amount")
        }
    }
    fun displayTransactionHistory() {
        for (transaction in transactions) {
            println(transaction)
        }
    }
fun acctBalance():Double {
    return balance
}
}