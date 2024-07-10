package org.example.Basics

fun main() {
    /*
    * Implicit Type Conversion : Ortulu - belirgin olmayan sekilde tip donusumu
    * Explicit Type Conversion : Acik - belirgin tip donusumu
     */
// Kotlin'de Implicit typ conversion yoktur

// val number : Int = (Int) 3L // calismaz

    /*
    *   Tip donusumu için kullanabileceğiniz fonksiyonlar;
    *   toByte(), toShort(), toInt(), toString() ...
    *
     */

    val intValue = 3
    getValue(intValue.toDouble())
// java'da to double demeden de buraya short, byte, int değerler verebiliyoruz. Java dönüşümü
// Explicit olarak kendisi yapıyordu. Kotlin bunu yapmıyor, açık açık dönüştürüp göndermeni istiyor.

    /*
    *   1- Numbers.kt dosyasındaki değer aralıklarını inceleyiniz,
    *   Değer araliği kucuk olan tipler buyuk olan tiplere, sorunsuz, acik olarak(explicit) donusturulebilir.
    *   Ancak daha buyuk tipler, daha kucuk tiplere donusturulurken kontrol yapmak gerekir.
    *
    *  Long + byte = long
    *   Long + Int = Long
    *   Long - Int = Long
    *   NOT: 2 sayı ile işlem yapıyorsan cevap da büyük tipli olanın tipinde dönecektir.
    */

    val longNumber = 1_000_000_000_000L
    val longNumber2 = 1_000_000_000_00L
    val resultNumber = longNumber / longNumber2

    val intNumber = 2_000_000_000
    val intNumber2 = 2_000_000_000
    //val resultNumber2 =  (intNumber * intNumber2).toLong() // bu kod işe yaramaz çünkü yanlış sonucu bulduktan sonra long'a çeviriyor
    // eğer doğru sonucu istiyorsan, sayılardan birini long'a çevirmelisin.
    val resultNumber2 =  intNumber * intNumber2.toLong()


    val byteNum1 :Byte = Byte.MAX_VALUE
    val byteNum2 :Byte = Byte.MAX_VALUE
    val result3 = byteNum1+byteNum2
    val shortNum :Short = Short.MAX_VALUE
    val result4 = byteNum1+shortNum









    return
}


fun getValue(doubleNum: Double) {}


