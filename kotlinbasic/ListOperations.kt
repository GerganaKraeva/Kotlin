package com.example.kotlinbasic

fun main() {
    val fruitList = mutableListOf("Banana", "Orange","Watermelon")
    fruitList.add("Kiwi")
    println(fruitList)
    fruitList.remove("Banana")
    println(fruitList)
    fruitList.add(0,"Banana")
    println(fruitList)
    val doesContainSuchFruit = fruitList.contains("Banana")
    println(doesContainSuchFruit)


}