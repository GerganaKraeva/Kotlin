package com.example.kotlinbasic

fun main() {
    val name: String? = "Gery"

    name?.let{
        println(it.toUpperCase())
    }
    println(name)

}