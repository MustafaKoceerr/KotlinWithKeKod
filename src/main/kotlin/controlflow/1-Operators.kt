package org.example.controlflow

fun main() {
    var numberOne = 10
    val numberTwo = 5

    println("NumberOne : ${numberOne}")
    println("NumberOne ++ : ${numberOne++}") // -> önce mevcut işlemi yapar sonra arttırır
    println("NumberOne : ${numberOne}")
    println("++ NumberOne : ${++numberOne}") // -> önce arttırır sonra mevcut işlemi yapar
    println("NumberOne : ${numberOne}")

    println("${numberOne + numberTwo} == ${numberOne.plus(numberTwo)}")
    println(numberOne.plus(numberTwo))

    println("${numberOne - numberTwo}")
    println(numberOne.minus(numberTwo))

    println("${numberOne * numberTwo}")
    println(numberOne.times(numberTwo))

    println("${numberOne / numberTwo}")
    println(numberOne.div(numberTwo))

    println("${numberOne % numberTwo}")
    println(numberOne.rem(numberTwo))

    println("---------------------------------------------------")

    print("Final notunu giriniz: ")
    //val grade = readLine()!!.toInt()
    val grade = 85
    val charNote = if (grade == 100) {
        "$grade = AA"
    } else if (grade <= 99 && grade >= 80) {
        "$grade = BB"
    } else {
        "$grade = Onemli degil veya bulunamadi"
    }

    println(charNote)
    println("---------------------------------------------------")

    // compareTo() fonksiyonu
    println(65.compareTo(100))
    /**
     * ilk sayi ikincisinden kucukse -1 alirsin
     * ilk sayi ikincisinden buyukse 1 alirsin
     * sayilar esitse 0 alirsin
     */

    println("grade.compareTo(100) == 1 -> ${grade.compareTo(100) == 1}") // ilk sayi, ikinciden büyüktür demektir
    println("grade.compareTo(100) == -1 -> ${grade.compareTo(100) == -1}") // ilk sayi, ikinciden büyüktür demektir
    println("grade.compareTo(100) == 0 -> ${grade.compareTo(100) == 0}") // sayilar esit demektir.
    println("grade.equals(100) -> ${grade.equals(100)}")
    println("!grade.equals(100) -> ${!grade.equals(100)}")

    /**
     * Eğer verdiğimiz 2 değer de non null ise bu şekilde kullanabiliyorz.
     * Eğer bir değişkenimiz veya 2 değişkenimiz de nullable ise bunu yapamıyoruz.
     * Bu durumda elvis ? operatörü sayesinde fonksiyon şeklinde kullanıyoruz.
     * Bu durumda !! operatörü sayesinde fonksiyon şeklinde kullanıyoruz.
     */

    val a: Int? = 10
    val b: Int? = null

    if (b !== null) {
        a?.compareTo(b)
    }
    println("---------------------------------------------------")

    var c = 20
    val d = 5
    c += d
    println("c += d : $c")
    c -= d
    println("c -= d : $c")
    c *= d
    println("c *= d : $c")
    c /= d
    println("c /= d : $c")
    c %= d
    println("c %= d : $c")
    //println("c %= d : ${c %=d}")  // -> Hata verir

    println("---------------------------------------------------")

    var numberOne2 = 10
    var numberTwo2 = 5
    var flag = true

    println("+a :" + +numberOne2) // unused operator
    println("-b: "+ -numberTwo2) // -b , sayiyi -1 ile

    println("++a : "+ ++numberOne2)
    println("a++ : "+ numberOne2++)
    println("a : "+numberOne2)

    println("--b : "+ --numberTwo2)
    println("!flag : "+ !flag)
    println("!flag : "+ flag.not()) // burada da önce islem yapilidr, sonra basilir.

    /**
     *  +a      a.unaryPlus()
     *  -a      a.unaryMinus()  -> sayiyi -1 ile çarpar
     *  ++a     a.inc() a = a+1
     *  --a     a.dec() a = a-1
     *  !a      a.not   a = !a
     */
    var m1 = 10
    var m2 = 5
    println("numberTwo2 + numberOne2.unaryMinus() : "+ (m2 + m1.unaryMinus()))
    // 5 + -1 * 10 = 14
    println("---------------------------------------------------")



}