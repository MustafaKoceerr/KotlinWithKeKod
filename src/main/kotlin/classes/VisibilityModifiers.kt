package org.example.classes

/**
 * Kotlin'de 4 farklı visibility modifiers vardır.
 * Public, Private, Protected, Internal
 *
 * Kotlin'de herhangi bir visibilty modifier vermiyorsanız, default'u publictir.
 * Java'da ise private'dır.
 * Peki bu fark neden kaynaklanıyor.
 * Genel davranış olarak da değişkeni private yapmak değil, değişkene erişecek olan get-set'i private yapmak
 *
// decompile et, private olanın get fonksiyonunun yazılmadığını gör, kotlinde zaten değiştiremeyeceğin şekilde arka planda private
 * sen modifier yapınca, ona erişen fonksiyonları belirliyorsun.
 *
 * Internal ->
 * package'lar caddelerse, modüller de mahalleler gibi düşün.
 * modül seviyesinde erişim sağlar.
 * Modül oluştururken yapıları olabildiğince dışarıya açmamamız lazım.
 *
 */

class VisibilityModifiers constructor(val name: String, private val age: Int, mSex: Boolean) {
    // decompile et, private olanın get fonksiyonunun yazılmadığını gör
    val sex: Boolean

    init {
        this.sex = mSex
    }

    var feetColor: String = "Brown"
        set(value) {
            field = value
        }
        get():String = field

    /**
     * Field dediğimiz şey değişkenin kendisine karşılık geliyor.
     * feetColor ve feetCount aslında bir property
     *
     * gerçek anlamda field, variable olan şey get-set fonksiyonları
     */
    var feetCount: Int = 4
        set(value) {
            field = value
        }
        get():Int {
            return field
        }

}

fun main() {

    val obj1 = Turtle()
    obj1.feetCount = 3
    // obj1.setFeetCount(3) // aslında buna erişmiş oluyorsun.
    // Extesion fonksiyonlarda, variable'da extend edebiliyoruz demiştik.
    // Aslında sen değişkenlerin get, set fonksiyonları extend ediyorsun

    // Fonksiyonlar memory'de bir yer kaplamaz, çalıştıkları süre boyunca içindeki değişkenler yer kaplar.
    // çalışması bitince garbage collector onları toplar ve memory serbest bırakılır.
}