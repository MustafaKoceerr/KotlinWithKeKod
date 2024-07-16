package org.example.functions


fun main() {
    /**
     *
     *      Bu dunyayi cekilebilir kılan seylerin basinda gelir Extension Funcitons :)
     *
     *      **Uzerinde DEGİSİKLİK YAPAMADİGİMİZ (readOnly) siniflara, ya da yapmak istemedigimiz siniflara, bu siniflarin
     *      icerisinde yazmadan fonksiyon tanimlayabilmemizi saglar. Boylece o sinifa uye bir fonksiyon kazandirabiliriz.
     *      Bunu yaparken unutmamaniz gereken; yazdiginiz extension fonksiyonlar aslinda o sinifin gercek bir fonksiyonu olmayacaktir.
     *      Dolayısıyla extension funciton o sinifin PRIVATE FONKSİYONLARINA "ERISEMEZ".
     *
     *      Ama olsun, bir sinifa ait olmalari gerekmez :)
     *
     *      Bazen çok büyük, çok uzun satirli dosyalara extension function yazmak isteyebilirsiniz.
     *
     *      Bazen bilerek konu bütünlüğünü korumak adına extension function yazmak isteyebilirsiniz.
     *
     *
     *      Arka planda bir şey değişmiyor, yani siz bir extension fonksiyon yazdiginizda o class'ın üye fonksiyonu oluyor.
     *      Sadece görünürde farklı görünüyor. Bu şekilde çok daha yönetilebilir kodlar yazabiliyorsunuz.
     *      Performansa bir etkisi yok. Arka planda hala üye fonksiyon.
     *
     *      Bazi dosyaların satır sayıları kısa bile olsa anlam olarak o class'lara direkt olarak üye fonksiyon yazmamanız gerekiyor.
     *      Örneğin data class, o veriyle ilgili çok gerekli bir manipülasyon yapman lazım ve bunu her yerde kullanacaksın.
     *
     *      Data class içinde yazmıyorsun, EXTENSION function olarak yazıyorsun.
     *      Data class'a test yazmıyorsun, EXTENSION functiona TEST yaziyorsun. Ve o kadar güzel işin içinden çıkıyorsun.
     *
     *      Reciver diye adlandiracagimiz bir sinifa ihtiyac duyar. Extension yazacagimiz sinifi ifade eder Reciever tanimi.
     *
     *      Yapisal olarak;
     *
     *      fun String.extPritnt( handsomeValue: HandsomeOne) : Unit{
     *      }
     *      Burada verdigimiz class yani String bizim Reciver'imiz oluyor.
     *
     * ******
     * YENİ BİR KONU ÖĞRENİYORSUN.
     * ARKA PLANDA NASIL ÇALIŞIYOR? İYİ BİR DEVELOPER OLMAK İCİN BUNU SORMALISIN.
     *
     * Dosyayı hemen decompile et.
     *
     *      Bytecode'dan çevirdiğimizde görüyoruz ki static bir fonksiyon ve her zaman kendisini parametre alıyor,
     *      extra parametre veriyorsak onu da parametre alıyor.
     */

    // normalde degiskenlere deger atayip, print islemini asagidakiler gibi yapariz.
    val pi: Double = 3 + 0.14
    println("Double Number : $pi")

    val schoolNumber: Int = 1453
    println("Int Number : $schoolNumber")

    val tcIdentityNumber: Long = 111111111111
    println("Long Number $tcIdentityNumber")

    // println'i çok kullandik, code smells var. Ne yapacağım bütün bu class'lara bakıyorum. Hepsinin üst sınıfı number
    // Yukaridaki kullanimlarin yerine normal bir log2 fonksiyonu yazilabilir
    log2(pi, "Double Number")
    log2(schoolNumber, "Int Number ")
    log2(tcIdentityNumber, "Long Number ")
    // ***BU NESNE YÖNELİMLİ PROGRAMLAMA YAKLAŞIMIDIR
    // Bir nesne gönderirsin ve işlemler yaparsın


    // extension functionlar sari renkte gozukurler
    val result: Int = "3".extPlus("5")

    // infix fonksiyonlar extension fonksiyonlarla kullanilabilir demistik.
    // extPLus infix extension oldugu icin . (nokta) kullanimina ihtiyac duymaz.
    // log ise sadece exten sion fonksiyon oldugu icin . (nokta ) ile cagirilir.
    ("3" extPlus "5").log("Int Number")

    pi.log("Double Number")
    schoolNumber.log("Int Number")
    tcIdentityNumber.log("Long Number")
    // ***BU FONKSİYONEL PROGRAMLAMA YAKLAŞIMIDIR
    // o class'ın fonksiyonu gibi çağırabilirsin.


//    val shape = Shape()
//    shape.type = "triangle"
//    println(shape.type)

}


infix fun String.extPlus(otherString: String): Int = this.toInt() + otherString.toInt()


// Normal fonksiyon, aslında top level tanimlandigi icin static bir fonksiyon
fun log2(number: Number, message: String) {
    /*
     when(number){
         is Long-> println("Long Number $number")
         is Double-> println("Double Number $number")
         is Int-> println("Ing Number $number")
     }
     */
    println("$message: $number")
}

infix fun Number.log(emptyParam: String): Unit = println("$emptyParam : $this")
/**
 * Bunu extension fonksiyon yaparak bunu tüm dosyalarda çağırabilir oluyorum.
 * DİKKAT bu özelliği eğer extension function top level function'sa sağlayabiliyorum.
 * Eğer bir class'ın içindeyse sadece o class içinde kullanabiliyorum.
 *
 * Bunu normal fonksiyonda yapamaz mıydık? Evet yapardık. Başına static koyarsak bunu sağlayabilirdik.
 * Zaten extension function da static kullanarak bunu yapıyor.
 * Kotlinde static yok, fonksiyonu top level tanımladıysan ve public verdiysen zaten static oluyor.
 *
 * Bunu extension olarak yazman, fonksiyonel programlama pratiği ile bakmanızı sağlatıyor.
 * Her şey nesnelere bağlı değil, fonksiyonlar daha öncelikli, kıymetli.
 */

private class FOO(){

    /**
     *  * Bunu extension fonksiyon yaparak bunu tüm dosyalarda çağırabilir oluyorum.
     *  * DİKKAT bu özelliği eğer extension function top level function'sa sağlayabiliyorum.
     *  * Eğer bir class'ın içindeyse sadece o class içinde kullanabiliyorum.
     */

    infix fun Number.logInside(emptyParam: String): Unit = println("$emptyParam : $this")
//  logInside fonksiyonunu class dışında çağıramam. Global kullanımı yapmamızı sağlatan şey,
//  Extension function'u top level olarak tanımlaman.
    fun fooPrint(){
        32.logInside("Int Number")
    }

}

open class Shape(){
    // - DETAY KONULAR, EZBERLEMENE GEREK YOK

    /**
     *      Bir sinifin icinde, farkli bir sinifa ait edxtension fonksiyon yazilirsa, bu sinifin icinde ayni isimde baska
     *      bir fonksiyon olsa bile, extension function önceliklidir ve o çağrım extension function'a işaret eder.
     *
     *      Eğer uye fonksiyonu kullanmak istiyorsan,
     *      this@sinifismi.uyefonksiyon() seklinde cagirim yapılmalidir.
     */

    open fun Int.extToString(){
        println("")

        //Int.extToString() methoduna isaret eder.
        extToString()

        //Shape'e ait asagidayi uye methodu isaret eder
        this@Shape.extToString()

        println("ShapeClass printi")
    }

    fun extToString(){
        println("Shape'deki siradan üye function")
    }



    fun setNumber(intNum:Int){
        println("Hello ${intNum*intNum*intNum}")
    }
}

//---------------------------------------------------------------------------------------------------

/**
 *      Bir sinifin, yazilmis extension fonksiyonun aynisi (isim ayni, parametre sayisi ve tipleri ayni, ayrica geri donus tipi de ayni olmali),
 *      kendi icinde barindiriyorsa, bu durumda yazilan extension function gecersizdir. Sinifin uye fonksiyonu cagirilir.
 */

fun Shape.setNumber(intNumber: Int){
    val result = intNumber * intNumber
    println(result)
}

//---------------------------------------------------------------------------------------------------

/**
 *  Extension function ile overriding yapabiliriz.
 */

//---------------------------------------------------------------------------------------------------

/**
 * Bir sinifa extension function yazilabildigi gibi extensin property de yazilabilir.
 * Bunun sebebi aslinda property'lerin get() ve set() methodlarından olusmasindan dolayidir.
 *
 * Bu extension property'lerin icerisinde field tanimlanamaz.
 * Dolayisiyla aslinda gercek anlamda bir degisken extension yapilamaz.
 * Bu konu property vs filed konusu ile beraber sinif'lar islenirken detayli anlatilacaktir.
 */

//var Shape.type
//    get()="Rectangle"
//    set(value){
//        type = value
//    }

//fun Shape.getType():String{
//    return "Rectangle"
//}
//fun Shape.setType(value: String){
//    type = value
//}
/**
 * KOTLİNDE BİZ GERÇEK ANLAMDA DEĞİŞKEN TANIMLAMIYORUZ.
 * BİZ ASLINDA HEP FONKSİYONLAR TANIMLIYORUZ, GERÇEK ANLAMDAKİ DEĞİŞKENE HİÇ ULAŞMIYORUZ. GET FONKSİYONUNA ULAŞIYORUZ.
 * Yani extension property aslında bir extension function.
 */

//---------------------------------------------------------------------------------------------------

/**
 * Aşağıdaki gibi bir çağrım sonsuz recursive döngüsüne sokar.
 * get, set'i çağırıcak. Set de bir değer bekleyecek. Recursive bir çağrım olacak.
 */

var Shape.anotherVar : String
    get() = anotherVar
    set(value){
        anotherVar = value
    }
// zaten get ve set fonksiyonlarından oluşuyor.
//---------------------------------------------------------------------------------------------------

/**
 * ***Open (Extend edilebilir) bir sinifta, sinifin icinde bir open (override edilebilir) extension function yazilirsa,
 * bu sinifi miras (inherit) alan siniflar, ilgili extension fonksiyonu override edebilirler.
 */

class Rectangle : Shape(){
    override fun Int.extToString(){
        println("Override edilmis Int.extToString fonksiyonu ")
    }
}

//---------------------------------------------------------------------------------------------------

/**
 *      Notes:
 *      Nullable extension function da yazilabilir.
 *      Companion object'lere de extension yazilabilir. Siniflar'da ornegini yapacagiz.
 */