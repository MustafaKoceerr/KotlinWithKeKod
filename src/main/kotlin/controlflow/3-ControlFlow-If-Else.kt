package org.example.controlflow

import java.io.IOException

fun main() {

    /**
     *  if else case'lerinden sonra suslu parantez acilir ve kapanir
     *  Ancak bu suslu parantezler arasina tek satir kod yazacaksak, suslu parantez kullanmak zorunda degiliz.
     *  If - else case'lerinin state ve expression olmak uzere 2 kullanimi vardir. Basitce;
     *  State kullanimi sadece if else kullanarak sartli durumlarimizi kodlamaktir.
     *  Expression kullanimi ise bir value'ya deger olarak esitligin karsi tarafina if else kodlarini yazmaktır.
     *  Expression olarak yapilan kullanimda, if else case'leri icin yazilmis pazantezlerin son satiri value olarak alinir.
     */

    print("Ogrenci misin? Y/N  ")
    //val answer = readLine()!!
    val answer = "y"

    if (answer.contains("y", ignoreCase = true)) {
        println("Ogrencisin")
    } else {
        println("Ogrenci degilsin")
    }

    if (answer.contains("y", ignoreCase = true))
        println("Ogrencisin")
    else
        println("Ogrenci degilsin")
    // NOT: Bu syntax tavsiye edilen bir syntax değil.


    /*
        if (1. durum){

        }else{

        }
    */


    /*
    if (1. durum){

    }else if (2. durum){

    }else if (3. durum){

    }else{

    }
 */

    // Aslında else if şöyle

    /*
    if (1. durum){

    }else{
        if (2. durum){

        }else{
            if (3. durum){

            }else{

            }
        }
    }
    */


    val result: String = if (answer == "y") {
        val str = "Burada ne yaptigin onemli degil" +
                "Bunu bir lambda fonksiyon olarak dusun" +
                "Sadece en sonra ne dondurdugun onemli, istersen buraya bir if satiri daha koy"
        // return "Ogrenci" degil de sadece "Ogrenci" yazıyorsun
        "Ogrenci"
    } else {
        "Ogrenci degil"
    }

    println("Result : $result")


    //---------------------------------------------------------------------

    /**
     *      Kotlin'de if else'lerin Expression kullanimindan oturu ternary operatoru yoktur.
     *      Ternary yerine asagidaki gibi kullanim yapabilirsiniz.
     */
    val isStudent = false
    val isStudent2 = if (isStudent) {
        "true"
    } else {
        "false"
    }

    // String name2 = isStudent ? "ture" : "false" // ternary operator
    // Kotlin'de ?: böyle bir operatörü kullanacağız, ama bu nulalble'lığı check ediyor olacak.

    //---------------------------------------------------------------------

    /**
     *      ***
     *      2 farkli tipteki number degiskenler karsilastirilirken equals fonksiyonu once tiplerini karsilastirdigi icin
     *      eger tipler uyusmuyorsa, ide hata verecektir
     */
// if( 10 == 10L) { // Calismaz.
//}

    /**
     *      Birden fazla sartli durumunuz varsa bunlarin her birini, asagidaki gibi, ayri ayri if seklinde yazmak
     *      if else seklinde yazmaktan daha kotu performans almaniza yol acar. Zira if else durumlarinde dogru case
     *      bulunursa, diger case'ler kontrol edilmez. Ancak asagidaki durumda dogru case bulunsa bile tum case'ler
     *      kontrol edilir.
     */
    val grade = 65
    if (grade <= 100) {

    }
    if (grade >= 85) {

    }
    if (grade <= 84) {

    }

    //---------------------------------------------------------------------

    /**
     *  Bazi durumlarda if else yazmaktansa, if case'ni yazip return ya da throw gibi kodun devam etmesini bozacak
     *  ifadelerle kodu sonlandirabilirsiniz. Kod calisirken bu if case'sine girmezse devam eden kod blogu calisir ki
     *  bu da pratikte else case'si demek olur. Bu sekilde yazim kodu biraz daha temiz gosterecektir.
     */

    if (isStudent) {
        println("Evet Student")
    } else {
        otherMethod()
    }

    if (isStudent) {
        println("Evet Student")
        throw IOException()
        // return
    }

    // else case burasıdır, zaten üstte if'e girdiyse kodu bitirecektir.
    // çünkü throw atıyor veya return ediyor.

    //---------------------------------------------------------------------

    /**
     *  Cok sık yapilan bir hata:
     *      If bloğunda karşılaştırdığın parametreyi sonradan arttirma
     *      Sen If case'inde 2 tane degiskeni kontrol ediyorsan,
     *      Else If case'sinde 5 tane degiskeni kontrol etmemelisin
     *      Else If case'nde yine o 2 tane degiskenin farkli durumlarini kontrol etmeli
     */

    val m1 = 100
    val age = 22
    if (m1 <= 100 && m1 >= 85) {
        println("AA")
    } else if (m1 < 85 && m1 >= 70 || age < 25) {
        // Eger burada age'i kontrol ettirmek istiyorsan, yukarıda da age'nin olması lazim
        println("BB")
    } else if (m1 < 70 && m1 >= 55) {
        println("BB")
    }

    //---------------------------------------------------------------------

    if (isStudent == true) {

    }
    // NOT: Bu 2 ifade aynı şeyler.
    if (isStudent) {
        // NOT: Eğer ifade nullable ise bu şekilde yazamazsın
    }
    
}

private fun otherMethod() {
}
