package org.example

import org.example.Sealed.Errorss

fun main() {
    println("Hello World!")
    val sealedKalitimAl = SealedKalitimAl()



    val greeting = { name: String -> "Hello, $name!" }
    val x = greeting("selam")
    println("selam x $x")
    val message = greeting.invoke("Naber ye yo u a ")
    println(message) // prints "Hello, Kotlin!

    val sum = ::add.invoke(3, 4)
    val sum2 = ::add.invoke(4,5)
    println(sum) // prints "7"

}

fun add(a: Int, b: Int) = a + b

class SealedKalitimAl : Errorss.ServerError(400)