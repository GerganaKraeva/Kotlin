package com.example.kotlinbasic

fun main() {
    var customBook = Book("Carloson who lives on the roof","Astrid Lindgren" ,1955)

    var defaultBook = Book();
    println(customBook.title +" "+customBook.author+" "+customBook.yearPublished
    )

    println(defaultBook.title +" "+defaultBook.author+" "+defaultBook.yearPublished
    )
}