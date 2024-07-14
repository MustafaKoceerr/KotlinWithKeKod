package org.example.controlflow

fun main() {

    /**
     *      switch case'lerin yerine gelmiştir.
     *      when(karsilastirilacak_ifade)
     *          value ->{}
     *          value ->{}
     *          else  ->{}
     *      formatiyla kullanilir.
     *
     *      Yine {} arasina tek satir kod yazilacaksa bu durumda {}'leri kullanamayabilirsiniz.
     *      "tr", "az" gibi ayni kodu calistiracak case'ler varsa araya virgul koyarak kullanabiliriz.
     *      Bu "veya" kullanimi yapmayi saglar. "tr veya az" gibi.
     */

    //val countryCode = readLine()!!
    val countryCode = "tr"
    when (countryCode.lowercase()) {
        "tr", "az" -> println("Turk")
        "ar" -> println("Arab")
        "fr" -> println("French")
        "ru" -> println("Russ")
        "uk" -> println("British")
    }
    val countryCodeInt = 2
    // ONEMLI NOT: When case'lerinde eğer yapacagimiz islem tek satirsa bunu parantez açmadan
    // yazmamız daha doğru olacaktır {} tek satırsa kullanma

    //---------------------------------------------------------------------

    /**
     *      When'in yanina karsilastirma ifadesi eklemeden, bunu case'lerin yanina da ekleyebilirsiniz.
     *      Bunun artisi && || and or xor gibi ifadeleri de kullanabilmenizi saglar.
     *
     *      Ama bu kullanim if' kullanimi gibi oldugundan bunu önermiyoruz, when özelligini kaybediyor
     */

    when {
        (countryCode.lowercase() == "tr").or(countryCode.lowercase() == "az") -> println("Turk")
        countryCode.lowercase() == "ar" -> println("Arab")
        countryCode.lowercase() == "fr" -> println("French")
        countryCode.lowercase() == "ru" -> println("Russ")
        countryCode.lowercase() == "uk" -> println("British")
    }

    //---------------------------------------------------------------------

    /**
     *      When'i de expression olarak kullanabilirsin
     */

    val countryCode2 = when (countryCode) {
        "tr", "az" -> {
            println("Turk")
            "Turk Vatandasi"
        }

        "ar" -> {
            println("Arab")
            "Arab Vatandasi"
        }

        "fr" -> {
            println("French")
            "France Vatandasi"
        }

        else -> {
            println("Atlantisten gelmis")
            "Atlantis Vatandasi"
        }
    }

    //---------------------------------------------------------------------

    /**
     *      is !is ile bir class'in referansi olunup olunmadigi kontrolu yapilabilir
     */
    val phoneNumber: Long = 531626692231
    when (phoneNumber) {
        is Long -> {
            println("Long value")
        }

        !is Long -> {
            println("Non Long Value")
        }
        // Miras almalı bir kod yazarsak bu şekilde is ile kontrol etmemiz gerekiyor.
    }

    //---------------------------------------------------------------------

    /**
     *      Range'lerin in !in şeklinde kontrulu yapilabilir
     */

    val number = 333
    when (number) {
        in 0..10 -> {
            println("in 0 .. 10")
        }

        in 11..20 -> {
            println("in 11 .. 20")
        }

        !in 0..100 -> {
            println("not in 0 .. 100")
        }
    }


}