package org.example.functions

import java.util.*

/**
 *      Fonksiyonları neden kullanıyoruz? Neden her şeyi main içinde yazmıyoruz?
 *      Eğer ki kodunuzu anlamlı olabilecek şekilde ayırabiliyorsanız,
 *      Mesela binding olmadan önce, bir fonksiyon yazıp, örneğin createComponents, bunu main'in en başında
 *      çağırırsan component init ile ilgili bir sorun olduğunda sadece o fonksiyona bakabilirsin.
 *
 *      aynı şekilde componenetler için event listesi oluşturup onları da ayrı bir fonksiyon haline getirebilirsin.
 *
 *      1- Gruplanabilir yapılan için kodun OKUNAKLIGINI ARTTIRMAK ADINA fonksiyonları çıkabilirsiniz.
 *      2- Bir fonksiyonun business logic içerebilir,
 *      Business logic (basitçe bir string converter işlemi bile yapıyorsan, class'ın içinde return ettiği değeri değiştiriyorsan) bunlar business logic'tir.
 *      Bir mapping işlemi yapıyorsan business logic'tir.
 *
 *      Bu business logic'ler tek satır olsa bile harici bir fonksiyon olarak yazmak zorundasınız.
 *      Tek satırlık bir alan bile olsa sen ona TEST yazacaksın.
 *      Böylelikle kodun maintenance edilmesi çok daha kolay oluyor.
 *
 *      Örneğin 2 componenti bir fonksiyonda, 3 componenti başka bir fonksiyonda create etmeye çalışma.
 *      Bu hiç anlamlı değil. Bu durumlarda fonksiyonları ayırma, ikisini birleştir.
 *      Çünkü buna özel Test'de yazamazsın.
 *
 *      3- Bir kod parçası belli bir yerde tekrar ediyorsa ve bunu birden fazla yerde kullanıyorsanız.
 *      Bu kodu fonksiyon haline çevirip, gereken yerlerde çağırmalısınız.
 *      Böylece aynı yerde çağırılan fonksiyonlar için bir değişiklik yapmanız gerektiğinde sadece 1 yerde
 *      değişiklik yaparak, tüm çağrılan yerlerde bunu uygulayacaksınız.
 */


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

    getUserInfo3(3, *arrayOf("Mustafa", "Kocer", "Istanbul", "Turkiye", "Turk"))

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

fun getUserInfo4(vararg userInfo: Any) {
    userInfo[3]
    userInfo.get(3)
}


/**
 *      Default degeri olan parametrelere sahip bir fonksiyon JAVA siniflarindan cagrilacaksa eger,
 *      Bu fonksiyona @JvmOverloads annotation'i verilmelidir. Böylece yazilan kod Jvm'e hazir hale getirilirken
 *      ilgili fonksiyonun tum varyasyonlari yazilir (overload edilir)
 */

@JvmOverloads
fun print(message: String = "Message") {
    println(message)
}


/**
 *      Extend edilebilir bir sinif, yavru (child) sinif tarafindan miras (inherit) alinirsa
 *      ve bu sinifin override edilebilir open bir methodu varsa, bu method default argument'e
 *      bu sinifi miras alan sinifta method override edilirse, override edilen methodun parametresine defaulr argument verilirse
 *      Ust sinifin method'undaki default argument gecerli olur.
 */

private open class A {
    open fun foo(i: Int = 10) {

    }
}

private class B : A() {
    override fun foo(i: Int) {
        // no default value allowed
    }
}

/**
 * Bir fonksiyona = koyularak da return edeceği deger yazilabilir. (Single-Expression) kullanimi
 */

val userList = arrayOfNulls<String>(5)

fun getListCount(): Int = userList.size
fun getListCount2() = userList.size

// Ayni isi yapiyorlar.
fun getListCount3(): Int {
    return userList.size
}

/**
 * Nothing kullanımı
 * Unit kullandığında herhangi bir şeyi return ettirmiyorsun, return gibi bir satırın olmuyor.
 * Ve aslında hiçbir şey geri döndürmüyorum demektir.
 *
 * İllahaki bir şey döndürmeniz gerekiyorsa ve return ettirdiğiniz şeyin bir anlamı olmayacaksa,
 * Yani siz onu bir değer olarak kullanmayacaksanız bu durumlar için
 * Nothing'i kullanabilirsiniz.
 *
 * Daha çok exception handling yapilan yerlerde kullanirsin.
 */

