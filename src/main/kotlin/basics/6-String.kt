package org.example.Basics

import java.util.*

fun main() {
    /*
    *   Yaklasik olarak her karakter basina 2 byte yer kaplar, UTF-16 encoding kullanir.
    *
    *   Cift tirnak icerisine yazilan karakterler butunudur
    *   Bir string ifadenin tüm karakterlerini tek tek alip char bir listeye atayabilirsiniz.
    *   Ya da ekrana yazdirabilirsiniz
     */
    val ch1 = 'M'
    val ch2 = 'u'
    val ch3 = 's'
    val ch4 = 't'
    val ch5 = 'i'
    val nameArray = charArrayOf(ch1, ch2, ch3, ch4, ch5)
    val name = "Musti"
    for (char in name) {
        println(char)
    }

    val awesomeKeKod = "KeKod is awesome"
    val firstCharOfAwesomeKekod = awesomeKeKod[awesomeKeKod.indices.first]
    val firstCharOfAwesomeKekod2 = awesomeKeKod[0]
    val lastCharOfAwesomeKekod = awesomeKeKod[awesomeKeKod.indices.last]
    val lastCharOfAwesomeKekod2 = awesomeKeKod[15]

    /**
     * Stringler immutable'dir. Bir string ilk değer ataması yapıldıktan sonra değerini değiştiremez ya da
     * yeni bir değer set edilemez. String üzerinde yapacağınız tüm işlemler sizlere yeni bir string object dönecektir.
     * String'in ilk hali değişemeyecektir.
     *
     * Böyle yapmasaydı, mesela Kocer atadık 10bytelık yer ayırdık, Kocerooo için 16 bytelık yer lazım
     * Nasıl olacaktı?? Bu yüzden yeniden atanıyor.
     * Int öyle değil. 10 için de 1000 için de 1000000 için de 4 byte'lık yer kaplar.
     *
     * Stringlerde değişken ismi Stack'te, değişken değeri Heap'te tutulur.
     * String özel optimizasyonlarla primitive hızında çalışır.
     *
     */
    var surname = "Kocer"
    surname = "Kocerooo"
    // burada aslında yeni bir string üretip bana döndü, artık "Kocer"'i işaret etmiyoruz da
    // Kocerooo'yu işaret ediyoruz. Bu sadece string'e özeldir.
    // Garbage collector Kocer'i silecektir.


    /*
    *   Farkli tipteki bir degiskenin onune String bir degisken ya da ifade koyarak toplarsaniz, sonuc String olacaktir.
    *   Ancak String bir degisken ya da ifadenin sonuna, + operatoru ile farkli tipte bir degisken eklerseniz, kod calismaz
     */

    val numbersValue: String = "value" + (4 + 2 + 8) // value14 dondurur
    val numbersValue3: String = "value".plus(4 + 2 + 8) // value14 dondurur
    // val numbersValue2: String = (4 + 2 + 8) + "value" // bu kod calismaz

    /*
    *   Herhangi bir degisken + operatorune ihtiyac duyulmadan direkt olarak "" arasina yazilarak kullanilabilir.
    *   Bunun icin sadece $ isaretine ihtiyaciniz vardir. Bu yapiya String template denir.
    *   Eger degiskenin bir ozelligine ihtiyac duyacaksaniz ${} seklinde kullanilir.
     */
    println("Price : $${3.42}")


    /*
    *   3 tane cigt tirnak kullanarak Raw String (Multiline String) olusturulabilir.
    *   Raw String'ler ide'ye nasıl yaziliyorsa oyle kullanilir. Hizalamada bozulma olmaz.
    *   trimIndent() fonksiyonu ile bu Raw String'in kenar bosluklarini silebilirsiniz.
    *   Bu silme islemini yaparken tum satirlardaki en soldaki karakteri baz alarak silme islemini saglar.
    *   Alttaki ornek icin 3 satirden da $ isaretinin solundaki bosluga kadarini siler.
    *   Raw Stringlerin icinde escape karakterler calismaz.
     */

    val rawPineTree = """
                *
    $          ***
              *****
    """.trimIndent()

    println("RawString : \n$rawPineTree")

    /**
     * Kotlin'de String.Format() metodu, Java'nın String.Format() metoduna çok benzer şekilde çalışır.
     * Bu metod, belirli bir string içinde yer tutucuları belirtilen değerlerle değiştirerek yeni bir string
     * oluşturmanıza olanak tanır. Yer tutucular, formatlama belirtimleriyle tanımlanır ve bu belirtimler,
     * değiştirilecek değerlerin nasıl biçimlendirileceğini kontrol eder.
     *
     * %s: String için
     * %d: Tam sayi (Integer) için
     * %f: Kayan noktali sayi (Float/Double) için
     * %n: Yeni bir satira gecmek için (platform bağımsız)
     */

    val yas = 22
    val mesaj = String.format("Yasim: %d", yas)
    println(mesaj)

    val boy = 1.75
    val mesaj2 = String.format("Boyum: %.2f metre", boy)
    println(mesaj2)

    val ad = "Musti"
    val kisiBilgisi = String.format("Adim: %s, yasim: %d, Boyum: %.2f", ad, yas, boy)
    println(kisiBilgisi)

    val sayi = 1234567.8921
    val usFormat = String.format(Locale.US, "US formatinda : %,.2f", sayi)
    // US formatinda : 1,234,567.89
    // %,.2f ile , belirteci ile sayiya formata göre nokta ve virgül koy diyoruz
    // .2f ile de ondalık kısımdan sonra 2 basamak al diyoruz
    println(usFormat)

    val localeTR = Locale("tr", "TR") // Turkce icin Locale nesnesi olusturuluyor
    val trFormat = String.format(localeTR, "TR formatinda : %,.2f", sayi)
    // TR formatinda : 1.234.567,89
    println(trFormat)


    return
}