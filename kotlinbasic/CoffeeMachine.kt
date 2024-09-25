package com.example.kotlinbasic

data class CoffeeDetails(
    val sugarCount: Int,
    val name: String,
    val size: String,
    val creamAmount: Int
)
fun main() {
//    println("Enter number 1")
//    val num1 = readln().toInt()
//    println("Enter number 2")
//    val num2 = readln().toInt()
//    var myResult = add(num1,num2)
//    println("The result is $myResult")
//    println(divide(5,3))

     val coffeeGery = CoffeeDetails(0, "Gery", "l", 1)
     makeCoffee(coffeeGery)
}

//fun divide(num1: Int, num2:Int): Double{
//    return num1/num2.toDouble()
//}
//fun add(num1: Int, num2: Int): Int {
//    return num1 + num2


fun askCoffeeDetails() {
    println("Who is this coffee for?")
    val name = readln();

}
fun makeCoffee(coffeeDetails: CoffeeDetails) {
    when (coffeeDetails.sugarCount) {
        0 -> {
            println("Coffee with no sugar for ${coffeeDetails.name}" + " and cream: " +
                                     "${coffeeDetails.creamAmount}")
        }
        1 -> {
            println("Coffee with ${coffeeDetails.sugarCount} spoon of sugar for " +
                    "${coffeeDetails.name} + and cream: " +
                    "${coffeeDetails.creamAmount}")
        }
        else -> {
            println("Coffee with ${coffeeDetails.sugarCount} spoons of sugar " +
                    " ${coffeeDetails.name}" + "and cream: " +
                "${coffeeDetails.creamAmount}")
        }
    }
}