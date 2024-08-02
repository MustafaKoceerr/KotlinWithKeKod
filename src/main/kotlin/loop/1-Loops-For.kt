package org.example.loop

fun main() {

    /**
     *      Kotlin'de elvis operatoru
     *      val musti2 :Int = musti1 ?: 0
     *      Diyoruz ki eğer musti1 null değilse onu al, null ise sağdakini al
     *      Once soluna bak null değilse onu al, null ise sağdakini al
     */

//    val musti1 : Int? = readlnOrNull()?.toInt()
//
//    val musti2 :Int = musti1 ?: 0


    /**
     *      3 farkli sekilde for tanimlayabilirsiniz.
     *      value in list                       seklinde value degerlerini alabilirsiniz.
     *      index in list.indices               seklinde index degerlerini alabilirsiniz.
     *      (index,value) in list.withIndex()   seklinde index,value degerlerini alabilirsiniz.
     *       for (value: String in countryCodeArray) gibi donecegimiz degiskenin adini ve tipini belirtebiliyoruz.
     */

    for (value: Int in 1..10) {
        print("$value, ")
    }
    println()
    for (value: Int in 10 downTo 1) {
        print("$value, ")
    }
    println()
    val countryCodeArray = arrayOf<String>("tr", "az", "en", "fr")

    for (value: String in countryCodeArray) {
        print("$value, ")
    }
    println()
    for (index: Int in countryCodeArray.indices) {
        println("index $index, degeri: ${countryCodeArray[index]}")
    }
    println("------------------------------------------------------")
    for ((index, value) in countryCodeArray.withIndex()) {
        println("index : $index, degeri: $value")
    }

    //-------------------------------------------------------

    /**
     *      repeat(size) seklinde herhangi bir listeye ihtiyac duymadan tekrarlayan isler yapabilirsiniz.
     *      it : Int gibi bir şey görüyorsan o highOrder funciton'dur.
     *      Icine ctrl ile girersen bir fonksiyon bekledigini goreceksin.
     */
    repeat(10) {
        print("\nMedium'a yazi yamma lazim!")
    }

    //-------------------------------------------------------

    /**
     *  return kullanarak ilgili sart saglanirsa, donguden cikabilirsiniz.
     *  continue kullanarak ilgili sart saglanirsa, donguye o degeri atlayarak devam edebilirsiniz.
     *  break kullanarak ilgili sart saglanirsa, donguyu kirip bitirebilirsiniz.
     */
    println()
    for (value in 1..50) {
        if (value % 2 == 1) {
            continue
        }
        print("$value, ")
    }

    println()
    for (value in 1..50) {
        if (value == 22) {
            println("Your age:  $value")
            break
        }
        print("$value, ")
    }

    //-------------------------------------------------------

    /**
     *      Ic ice for donguleri kullaniyorsak bir ustteki for'a degil de iki ustteki uc ustteki fır'a donmek istiyorsak
     *      label kullanabiliriz. Bunun icin labelname@ ifadersini ilgili for'un onune yazip, return ya da continue
     *      yazdigimiz yere ise @labelname seklinde yazmamiz yeterlidir.
     */
    println()
    returnlabel@ for (value in 1..10) {
        println("------------CONTINUE------------")
        for (value2 in 0..10){
            if(value2 == 5){
                continue@returnlabel
            }
            println("val1 : $value, val2 :$value2 ")
        }
    }
    println()

    returnlabel@ for (value in 1..10) {
        println("------------BREAK------------")
        for (value2 in 0..10){
            if(value2 == 5){
                break@returnlabel
            }
            println("val1 : $value, val2 :$value2 ")
        }
    }

}