package org.example.Generics


fun main() {

    val a = calculate(5.toShort(), 5)


}

fun calculate(param1: Number, param2: Int): Number {
    return param1.toInt() + param2

}
