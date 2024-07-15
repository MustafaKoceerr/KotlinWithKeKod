package org.example.functions

import java.util.*

/**
 *      fun keyword'u ile fonksiyonlar baslar.
 *      fonksiyon ismi verilir
 *      parametre parantezleri acilir ve parantezler girilir.
 *      : operatoru ve geri donus degeri yazilir.
 *      fonksiyon body'si acilir ve kapatilir.
 *      Geri donus degeri verilmeyen fonksiyonlar Unit tipini geri dondurur.
 */
// val name :String "Musti"

//fun name: String = "Musti"
//
//fun name(val surname: String "Koc"): String = "Musti"
//
//fun name(surname: String = "Koc"): String = "Musti"
fun name(): String = "Musti"

fun main(): Unit {
    //Fonksiyon cagirilirken ismi ve parametreleri kullanilir
    // Eger bir geri donusu varsa bir degiskene atanabilir.
    takeSquare(2)
    val squareValue = takeSquare(2)

    //-------------------------------------------------------------------------

    // Bir class'in fonksiyonu statikse cagirirken ise nokta (.) isareti kullanilir.
    Math.pow(2.1, 3.2)
    // Bir class'in fonksiyon statik degilse nesnesini oluşturup çağırmalıyız.
    //    Math().anotherFun()

    //-------------------------------------------------------------------------

    /**
     * Default degeri olan parametreler sahip bir fonksiyon cagrilirken, default degeri olan parametrelere deger atamak
     * sart degildir. Default degeri olan bu parametreler opsiyonel parametrelerdir.
     * Default degeri olan parametrelere deger atanmadan fonksiyon cagrilacaksa bu durumda parametre sirasi degisir.
     * Ide'ye hangi parametreye deger atadiginizi soylemek icin Named Arguments'leri kullanmaniz gerekir.
     */
    takeSquare(number2 = 7)
    takeSquare(number = 2)
    takeSquare(2)
    takeSquare(2, 7)

    /**
     * Neden default value kullanırız?
     * Eğer bazı parametrelerim opsiyonel olacaksa bu durumda kullanırız.
     */

    reformatMessage("Hello", size = 7, isUpperCase = false, lang = "tr")
    // size,isUpperCase gibi şeylere name argument'ler deriz

    //----------------------------------------------------------------------------

    //vararg kullanimina ornek, key = 3'den onceki parametreler vararg parametresine denk gelir
    // bu durumda name argument yapman gerekiyor. Eğer son durumda key ile belirtmezsen hata alirsin.
    getUserInfo("Mustafa", "Kocer", "Istanbul", "Turkiye", "", "", "", key = 3)

    //vararg parametresi olarak arrayOf kullanimal istenirse * operatoru eklenmelidir. (Spread operatoru)
    // bu operator diger dillerdeki pointer kullanimi anlamina gelmez. Kotlinde pointerlar yoktur.
    getUserInfo(*arrayOf("Mustafa", "Kocer", "Istanbul", "Turkiye", "", "", ""), key = 4)

    getUserInfo2("Mustafa", "Kocer", "Istanbul", "Turkiye", "", "", "")

    getUserInfo3(3, *arrayOf("Mustafa", "Kocer", "Istanbul", "Turkiye",  "Turk"))

    // Any parametre aldigi icin her turlu parametreyi gonderdik ama bu guzel bir kullanim degil
    getUserInfo4(3, "Mustafa", "Kocer", "Istanbul", "Turkiye", true, 3.14, "")


}

/**
 *      @param number degisken tanimlanir gibi tanimlanir.
 *      Fonksiyon parametresi tanimlanirken, val var gibi betimleyiciler kullanilmaz.
 */
fun takeSquare(number: Int = 5, number2: Int = 10): Int {
    //...
    return number * 2
}

fun reformatMessage(message: String, isUpperCase: Boolean = false, size: Int, lang: String = "tr") {
    if (isUpperCase) {
        if (lang.equals("tr")) {
            println("Message : " + message.uppercase(Locale("TR", "tr")))
        } else {
            println("Message : " + message.uppercase(Locale.ROOT))
        }
    } else {
        if (lang.equals("tr")) {
            println("Message : " + message.lowercase(Locale("TR", "tr")))
        } else {
            println("Message : " + message.lowercase(Locale.ROOT))

        }
    }
    // Burada baktın ki belli şeyleri tekrar ediyorsun. Code smell yapman lazım
    // ne yapabilirsin diye düşünüyorsun ve aklına locae'i bir değişkene tanımlamak geldi

    val locale = if (lang.equals("tr")) {
        Locale("TR", "tr")
    } else {
        Locale.ROOT
    }

    val localMessage = if (isUpperCase) {
        message.uppercase(locale)
    } else {
        message.lowercase(locale)
    }

    println("Message : $localMessage")
}


/**
 *      Cok uzun sayida parametreniz olacaksa "variable number of arguments" - vararg tanimlanabilir.
 *      Bu sayede fonksişyon tek bir parametre aliyor gibi gozukurken kendisine cok miktarda degisken atanabilir.
 *      Bu degiskenlere array'e erisir gibi erisebilirsiniz. [index] ya da .get(index) seklinde
 *
 *      varargtek ya da son parametre olarak yazilirsa, JVM'e hazirlanirlen, Javadaki "String..." gibi ayni kod derlenir.
 *      Ancak vararg param birden fazla tanimlanirken ortada ya da basta yer alirsa, JVM'e hazirlanirken, Array'e donusturulur.
 *      Bu da performans fa7rki olusturur demektir.
 *      Yani kullanabiliyorsan en sonda kullan veya yalniz kullan.
 *
 *      ONEMLI NOT: VARARG parametre sayisinin belirsiz oldugu durumlarda kullanman gereken bir degisken,
 *      parametre sayisi cok fazla diye vararg kullanilmaz
 *
 *      NOT: Birden fazla vararg'ı aynı fonksiyonda parametre olarak bekleyemezsin.
 */

fun getUserInfo(vararg userInfo: String, key: Int) {
    userInfo[3]
    userInfo.get(3)
}

// vararg tek basina yazilmis
fun getUserInfo2(vararg userInfo: String) {
    userInfo[3]
    userInfo.get(3)
}

// vararg sonda yazilmis
fun getUserInfo3(key: Int, vararg userInfo: String) {
    userInfo[3]
    userInfo.get(3)
}

fun getUserInfo4( vararg userInfo: Any) {
    userInfo[3]
    userInfo.get(3)
}

