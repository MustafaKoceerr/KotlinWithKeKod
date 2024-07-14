package org.example.Basics

fun main() {

    /**
     *      Sonlu sayili liste olusturmaya yarar.
     */

    /**
     *      Kucukten buyuge liste olusturmak icin;
     *      ".." operatorunu, ya da "rangeTo()"
     *      "..<" operatorunu ya da rangeUntil()"
     *      fonksiyonunu kullanabilirsiniz.
     */

    val numbers = 1..100 // [1,100]
    val numbers2 = 1.rangeTo(100)

    val numbersUntil = 1..<100 // [1,100)
    val numbersUntil2 = 1.rangeUntil(100)

    //-----------------------------------------------------------------

    /**
     *      Char'lardan olusan bir liste de tanimlanabilir. Turkce karakterleri icermez.
     */
    val alphabet = ('A'..'Z')
    println("English alphabet: ${alphabet.joinToString()}}")

    //-----------------------------------------------------------------

    /**
     *      Buyukten kucuge .. operatorunu kullanarak liste olusturamayız. Ide hata verir.
     *      Buyukten kucuge liste olusturmak icin downTo() fonksiyonunu kullanabilirsiniz. Infix kullanimi da vardir.
     */

    //val reversedNumvers = 100..1 // Calismaz
    val reversedNumbers = 100.downTo(1)
    val reversedNumbers2 = 100 downTo 1
    println("reversedNumbers ${reversedNumbers.joinToString()}")

    //-----------------------------------------------------------------

    /**
     *      until fonksiyonunu kullanarak da range tanımlanabilir. Anacak bu durumda bitis degeri listeye dahil edilmez.
     */
    val gradeNumbers = 10.until(100) // [10,100)
    val gradeNumbers2 = 10.rangeTo(99) // [10,100)
    val gradeNumbers3 = 10..99 // [10,100)
    val gradeNumbers4 = 10 until 100 // [10,100)
    //val gradeNumbers5 = 100 until  10 // Calismaz

    //-----------------------------------------------------------------

    /**
     *      step fonksiyonunu kullanarak liste olustururken belli sayida atamalar yapabilirsiniz
     */

    val steppedNumbers = 1..100 step 2
    val steppedNumbers2 = 1..100 step 3
    println("steppedNumbers: ${steppedNumbers.joinToString()}")

    val reversedSteppedNumbers = 100 downTo 1 step 3
    val reversedSteppedNumbers2 = 100.downTo(0) step 2
    println("reversedSteppedNumbers2: ${reversedSteppedNumbers2.joinToString()}")

    //-----------------------------------------------------------------

    /**
     *      Kotlin'de özel olarak CharRange, IntRange ve LongRange isimlerinde özel range'ler vardır. Progression olarak adlandırılır.
     *      Diğer tipler bulunmaz.
     *      Bu durumda, first, last, step, count gibi ek bilgiler de alinabilir.
     *      Iterable<N> interface'ini implement etmişlerdir. O sebeple map, filter gibi fonksiyonları kullanabilirler.
     */

    // NOT: Eğer double, float gibi şeyler verirsen step gibi özellikleri kullanamazsın
    val doubleNumbers = 1.0..100.0 //step 3.2  // Calismaz
    val doubleNumbers2 = 1.0.rangeTo(100.2)  //step 3.2  // Calismaz
    val floatNumbers = 1.0F.rangeTo(100.2F)  //step 3.2  // Calismaz
    // doubleNumbers2'de dongu donduremiyorsun veya joinToString gibi dongu gerektiren şeyleri kullanamıyorsun.
    // bunun nedeni iki sayının aralığının sonsuza gitmesi ve step koyamadığımız için dilin bunu bilememesi
    // 0-1 arasında sonsuz tane sayı vardır.


    val intNumberList: IntProgression = 10 until 90 step 7
    intNumberList.first
    intNumberList.last // last bilgisini dönülürken step'e göre dönüş bilgisi sağlanır
    println("Last : ${intNumberList.last}")
    intNumberList.step

    intNumberList.count()
    // Bu gibi bir çok fonksiyon var. Bu fonksiyonlara göz atabilirsin.
    println("intNumberList.average : ${intNumberList.average()}")
    val reversedIntNumberList: IntProgression = intNumberList.reversed()
    println("intNumberList.reversed : ${reversedIntNumberList.joinToString()}")

    println("intNumberList.filter : ${intNumberList.filter { it % 2 == 0 }}")

    return

}