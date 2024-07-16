package org.example.functions

/**
 *      Android projelerinde göreceğimiz bu dosyadaki kadar, detaylarını da öğreneceğiz ama sadece bilmek için
 *      veya uygun durum olursa kullanılsın diye ama android projelerinde bundan fazlası muhtemelen olmaz
 *
 *      Java tarafına baktığında ise function'un instance (nesne)'si oluşturuluyor ve siz onu parametre olarak veriyorsunuz.
 */
fun main() {

    calculateAndPrintNormal(2, 4, 'x')
    calculateAndPrintNormal(2, 4, '+')
    calculateAndPrintNormal(2, 4, '-')

    calculateAndPrint(
        2,
        4,
        { numberOne, numberTwo ->
            // pseudo code
            // pseudo code
            // pseudo code
            numberOne + numberTwo
        }
    )

    calculateAndPrint(2, 4, { numberOne, numberTwo ->
        // pseudo code
        // pseudo code
        // pseudo code
        numberOne * numberTwo
    }
    )

    /**
     * High order funciton ile yaptığın kod diğer koda göre niye daha güzel?
     *
     * Çünkü if kullanmıyorsun ve yeni bir fonksiyon ekleyeceğinde hemen ekleyebiliyorsun.
     *
     */

    calculateAndPrint(2, 4, { numberOne, numberTwo -> numberOne % numberTwo })
    calculateAndPrint(2, 4, { numberOne, numberTwo -> numberOne / numberTwo })

    // 1. yöntem
    val someFunction = { numberOne: Int, numberTwo: Int -> numberOne / numberTwo }
    calculateAndPrint(2, 4, someFunction)
    /**
     * Invoke kullanimi
     */
    val someFunResult = someFunction.invoke(22, 20)
    println("someFunResult : $someFunResult")
    // 2. yöntem
    val anonymousFunction2 = fun(numberOne: Int, numberTwo: Int): Int {
        return numberOne / numberTwo
    }
    calculateAndPrint(2, 4, anonymousFunction2)

    // 2.2. yöntem
    val anonymousFunction = fun(numberOne: Int, numberTwo: Int): Int = numberOne / numberTwo
    calculateAndPrint(2, 4, anonymousFunction)

    // 3. yöntem
    calculateAndPrint(2, 4, ::normalFunctionWillGiveAsParameter)
    calculateAndPrint(2, 4, ::normalFunctionWillGiveAsParameter2)

    // 4. yöntem
    println("4. yontem")
    calculateAndPrint(2, 4) { numberOne, numberTwo -> numberOne / numberTwo }


    // default deger verdigim fonksiyon
    calculateAndPrint4(2, 4)
    calculateAndPrint5(2, 4)

    // tek bir parametre verilirse it yazabiliriz, bir parametre ismi belirtmemize gerek yok
    calculateAndPrint6(2, { it * 2 })
    calculateAndPrint6(2, { number -> number * 2 })

    // parametre olarak verdiğimiz fonksiyon bir extension fonksiyon ise bu sekilde cagiriyoruz
    calculateAndPrint9(2,4,
        { numberOne:Int, numberTwo:Int ->
            println("verdigim veya cagirdigim string "+this  )
            numberOne/numberTwo})
    // bu sekilde cagirirken sinifin bir ozelligini de kullanabiliriz cunku this dedigimiz sey aslında
    // elimizde bu örnek için çağırdıgımız string



    calculateAndPrint(2, fooAAA(), { _, _ -> 250 })
    // NOT: Burada fooAAA() parametre olarak cagirildi. bir HOF olarak değil.
    // HOF kısmı biden bir parametre değil fonksiyon gövdesi bekliyor.

}

fun fooAAA(): Int {
    return 20
}


fun calculateAndPrintNormal(numberOne: Int, numberTwo: Int, operation: Char) {

    val result = when (operation) {
        '+' -> {
            numberOne + numberTwo
        }

        '-' -> {
            numberOne - numberTwo
        }

        'x' -> {
            numberOne * numberTwo
        }

        '/' -> {
            numberOne / numberTwo
        }

        else -> {
            // exception return ettir
            numberOne + numberTwo
        }
    }
    println("Result : $result")
    /**
     *
     * Bu yapı yönetilebilir bir yapı değil, yeni işlemler eklerken öncelikle buraya ekleyeceksin
     * ve bu işlemler kolay da olmayabilirler. Burası büyüyecek, sonra çağıracağın yerde de ona göre
     * çağırman lazım.
     *
     * ama HOF ile yapsaydın direkt fonksiyonunu da gönderirdin.
     */

}

// HOF diye calculateAndPrint fonksiyonuna diyeoruz, içinde beklediği operation functionuna değil
// birden fonksiyon parametresi verebilirsin.
// parametre olarak verdiğin fonksiyonlar'da başka bir fonksiyon return edebilirler. işte bu durumda da parametre fonksiyona da HOF denebilir. calculateAndPrint2'de bunu görebiliriz.
//
fun calculateAndPrint(numberOne: Int, numberTwo: Int, operation: (numberOne: Int, numberTwo: Int) -> Int) {
    val result = operation(numberOne, numberTwo)
    println("Result: $result")
}


fun calculateAndPrint2(
    numberOne: Int,
    numberTwo: Int,
    operation: (numberOne: Int, numberTwo: Int, foo: () -> Unit) -> Int
) {
    val result = operation(numberOne, numberTwo, { println("Parametre fonk. icinde fonksiyon") })
    val result2 = operation.invoke(numberOne, numberTwo, { println("Parametre fonk. icinde fonksiyon") })
    // İkisi aynı şey ister INVOKE ile cagir, ister duz cagir.
    val result3 = operation!!.invoke(numberOne, numberTwo, { println("Parametre fonk. icinde fonksiyon") })
    val result4 = operation?.invoke(numberOne, numberTwo, { println("Parametre fonk. icinde fonksiyon") })
    // invoke kullanırsak !!, ? kullanabiliyoruz. Bu nullable değişkenler için önemli.

    println("Result: $result")
}


private fun normalFunctionWillGiveAsParameter(numberOne: Int, numberTwo: Int): Int {
    return numberOne / numberTwo
}

private fun normalFunctionWillGiveAsParameter2(numberOne: Int, numberTwo: Int): Int = numberOne / numberTwo


// HOF fonksiyonlarda, parametre fonksiyonun parametrelerine bir isim vermene gerek yok
// normalde kullanırken böyle görürsün.
fun calculateAndPrint3(numberOne: Int, numberTwo: Int, operation: (Int, Int) -> Int) {
    val result = operation(numberOne, numberTwo)
    println("Result: $result")
}


// HOF fonksiyonlarda, parametre fonksiyona default bir parametre verebilirsin
fun calculateAndPrint4(
    numberOne: Int = 4, numberTwo: Int = 5,
    operation: (Int, Int) -> Int = { numberOne, numberTwo -> numberOne / numberTwo }
) {
    val result = operation(numberOne, numberTwo)
    println("Result: $result")
}

fun calculateAndPrint5(
    numberOne: Int = 4, numberTwo: Int = 5,
    operation: (Int, Int) -> Int = ::defaultSum
) {
    val result = operation(numberOne, numberTwo)
    println("Result: $result")
}


fun defaultSum(numberOne: Int, numberTwo: Int): Int {
    return numberOne + numberTwo
}


// tek bir parametre verilirse it yazabiliriz, bir parametre ismi belirtmemize gerek yok
fun calculateAndPrint6(
    numberOne: Int = 4,
    operation: (Int) -> Int
) {
    val result = operation(numberOne)
    println("Result: $result")
}

//----------------------------------------------------------------------------------------------------

fun calculateAndPrint9(
    numberOne: Int = 4, numberTwo: Int = 5,
    operation: String.(Int, Int) -> Int
) {
    val result = "musti".operation(numberOne, numberTwo)
    // veya bu sekilde bir string parametre daha istiyor, cunku string function'a extension function verdik
    // extension funciton da biliyorsun byte code'a cevirmistik, kendisini her zaman parametre olarak aliyordu
    val result2 = operation("mustimustimustii",numberOne, numberTwo)
    println("Result: $result")
}







