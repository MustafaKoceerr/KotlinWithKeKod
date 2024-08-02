package org.example.loop

fun main() {

    /**
     *      Java'dan hiçbir farki yok. Diger dillerde nasil kullaniyorsaniz Kotlin'de de ayni sekilde kullaniyoruz.
     *      Eger bir donguye ihtiyaciniz varsa ve bu dongu sirasinda if else ile bir sartli duruma ihtiyaciniz varsa
     *      bu durumda for + if else kullanmak yerine while kullanabilirsiniz
     */

    var number = 0
    while (number < 5) {
        print("number : ${number++}, ")
    }
    println()
    number = 0
    while (number < 5) {
        print("number : $number, ")
        number++
    }

    println("--------------------")
    // While dediğin şey aslında for if'tir.
    for (value in 0..100){
        if (value<5){
            println("$value , ")
        }else{
            break
        }
    }

}