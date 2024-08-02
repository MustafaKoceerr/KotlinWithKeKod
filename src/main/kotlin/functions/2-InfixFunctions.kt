package org.example.functions

fun main() {

    /**
     *      Daha okunakli kodlar yazmak icin kullanilir.
     *      . (nokta) kullanimi kaldirir.
     *      Bir fonksiyonu infix hale getirebilmek icin 5 sart vardir.
     *      1. infix keyword'u ile baslar.
     *      2. fonksiyon bir UYE fonksiyon olmalidir. (bir sinifa ait olmalidir)
     *      3. ya da bir EXTENSION fonksiyon olmalidir.
     *      4. sadece bir parametre almalidir. Bu parametre vararg olamaz. Bir cakal sizsiniz :)
     *      5. infix method'un parametresi default deger alamaz.
     *
     *      Yapisal olarak;
     *
     *      infix fun infixMethod(justOneParam : AwesomeParam) : Whatever{
     *      ...
     *      }
     */

    val isStudent = false
    val isMale = true

    /**
     *      and, or, xor gibi onlarca infix method vardir.
     */
    if (!isStudent and isMale) {
        println("Ogrenci olan erkek")
    }

    // infix kullanim
    isStudent.and(isMale)
    isStudent and isMale

    val awesomeInstance = AwesomeClass()
    // infix kullanimi
    awesomeInstance downloadImage "www.google.com.tr"
    awesomeInstance.downloadImage("www.google.com.tr")
    /**
     *      Infix'i daha çok operatorumsu bir hava katabileceginiz bir fonksiyonunuz varsa elinizde o zaman kullanın.
     *      Her gordugunuz tek parametre alan fonksiyonu infix yapmayin.
     *      Yapsaniz teknik olarak yanlis mi olur? Hayir olmaz.
     *      Bu tarz konular challenge'larınızda kıymetli, ufacık şeylerden öne geçiyorsanız challenge'larda
     */

    //---------------------------------------------------------------------------------------------------

    val number = 5
    // Matematiksel operatorlerin, tip donusumlerinin (type conversion), range kullaniminin, infix methodlara gore islem onceligi vardir.
    if (number + number - 2 * (awesomeInstance specialPlus 4) == 5) {

    }
    println(number + number - 2 * (awesomeInstance specialPlus 4)) // 2

    //---------------------------------------------------------------------------------------------------

    // infix methodlarin da mantik operatorlerine gore onceligi vardir.
    if (number == 3 && number < 5 || awesomeInstance specialPlus 4 == 5) {

    }

}

class AwesomeClass(val number: Int = 0) {
    infix fun downloadImage(url: String) {

    }
//    infix fun downloadImage2(vararg url: String) {
//
//    } // Calismaz, vararg alamaz


    infix fun specialPlus(number: Int): Int {
        return this.number + number
    }

    //------------------------------------------------------------------------------------------

    // bir sinifin ICINDEYKEN this kullanimi size bulundugu sinifi isaret eder.
    // asagidaki kullanimda AwesomeClass().downloadImage(imageUrl) kullanimi olusur aslinda. (implicit)
    fun logWhenImageDownloaded(imageUrl: String) {
        downloadImage(imageUrl)
        // veya infix kullanim
        this downloadImage imageUrl
        // ama boyle yazmak daha karisik durdugundan boyle yazmana pek de gerek yok
    }
}

// bir sinifin DISINDAYKEN this kullanamazsin.
//fun logWhenImageDownloaded(imageUrl:String){
//    this downloadImage imageUrl
//}