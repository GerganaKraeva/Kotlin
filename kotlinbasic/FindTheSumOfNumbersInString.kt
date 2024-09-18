package com.example.kotlinbasic

import java.util.regex.Pattern

fun main() {
    val input= readln()
    var sum :Double = 0.0
    val regex= "[1-6]+\\.?[0-9]*"
    val pattern = Pattern.compile(regex)
    val matcher =pattern.matcher(input)

    while (matcher.find()) {
        var number = matcher.group().toDouble();
        sum += number
    }
    println(sum)
}