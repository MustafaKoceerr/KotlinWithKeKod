package org.example.Basics

fun main() {

    /*
    *   16 bit yer kaplar
    *
    *   Tek tirnaklarin arasina, harf, sayi, escape char, ya da uniicode yazarak kullanilirlar.
    *   Cift tirnak icerisine yazilirsa String olur. Char olmaz.
    *
    *
     */

    val firstCharOfName: Char = 'M'
    //val firstCharOfName2: Char = "M"  // calismaz
    //val firstCharOfName3: Char = 'Mu'  // calismaz
    val charNumber: Char = '6'
    println(charNumber)
    val convertedCharNumber = charNumber.toInt()
    val convertedCharNumber2 = charNumber.code
    val digitToInt = charNumber.digitToInt()
    val nullableChar : Char? = null
    // bu durumda javbadaki CHARACTER sınıfına denk gelir nullable olduğu için
    // primitive olmaz

    println("CharNumber = $charNumber")
    println("convertedCharNumber = $convertedCharNumber")
    // 6'ya denk gelen ascii decimal değerini verir. 54'ü verir.
    println("convertedCharNumber2 = $convertedCharNumber2")
    println("digitToInt = $digitToInt")

    val temp = 'x'
    val digitToInt2 = temp.code
    println("digitToInt2 = $digitToInt2")

    //-----------------------------------------------------------

    /*
    *   Kacis(Escape) karakterleri
     */

    val exampleString = "Kotlin'de escape karakter örnekleri\n" +
            "\t \\t ile bir tab boşluğu ekleyebilirsiniz\n" +
            "\t \\n ile yeni bir satıra geçebilirsiniz\n" +
            "\t \\b ile bir backspace (geri al) işlemi yapabilirsiniz\n" +
            "\t \\r ile satir basina donebilirsiniz\n" +
            "\t \\' ile tek tirnak (') karakterini kullanabilirsiniz\n" +
            "\t \\\" ile cift tirnak (\") karakterini kullanabilirsiniz\n" +
            "\t \\\\ ile slash (\\) karakterini kullanabilirsiniz\n" +
            "\t \\\$ ile dolar işareti ($) karakterini kullanabilirsiniz"

    println(exampleString)

    // '\b' kullanarak son karakteri geri al
    val modifiedStr = "ABCD\bE"
    println("Modified String: $modifiedStr")


    /*
    *   Unicode karakterlerini de tanımlamak için kullanılabilir.
    *
     */
    val heavyBlackHeart = '\u2665'
    val blackHeart = '\u2764'

    println("first commit with $blackHeart")
    println("first commit with $heavyBlackHeart")

    val ANSI_RED = "\u001B[31m"
    // ANSI renk sıfırlama kodu (metni varsayılan rengine döndürür)
    val ANSI_RESET = "\u001b[0m"

    println("First commit with $ANSI_RED$blackHeart$ANSI_RESET")


}