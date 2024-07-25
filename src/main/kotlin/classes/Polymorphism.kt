package org.example.classes

/**
 *  Ust class'ta bir fonksiyon var, child class'lardaki fonksiyonlar çıktıyı değiştiriyorsa
 *  buna polymorphism denir.
 *
 * Direkt olarak open yaptığımız bir property'yi (değişken veya fonksiyon) override
 * etmesine Polymorphism denir ama->
 * DYNAMIC POLYMORPHISM denir.
 * illaha override yapman gerekli 
 * override ile dinamik olarak fonksiyonu değiştiriyorum bu yüzden dynamic polymorphism
 * makeASound dog için farklı, cat için farklı
 */
open class Animal2(val name: String, open val species: String) {
    open var footCount = 4

    /**
     * Not: Bir parametreyi open yapmayacaksan, basitçe val yaparsın ve set'ini private yapmış olursun
     * var yaparsan, open yapmasan bile tekrar atanabilir olacaktır. Bu da anlamlı olmaz.
     * Open yaptığın bir şeyin alt class'lar tarafından atanabilir olması gerekir.
     * Open yapmadan var değişkene alt sınıflardan değer atama
     */
    val tailShape = "YUVARLAK"

    open fun makeASound(): String {
        return ""
    }
}

class Dog2(name: String, override val species: String, footCount: Int) : Animal2(name, species) {

    override var footCount: Int = footCount
        set(value) {
            field = value
        }

    override fun makeASound(): String {
        return "HavHavHav:"
    }

    fun call(gokhan: Gokhan) {
        gokhan.foo()
    }

    /**
     * Ayni class icinde 2 tane ayni isimli fonksiyon ama baska isler yapiyorlar,
     * buna polymorphism denir ama
     * STATIC POLYMORPHISM denir.
     * Static polymorphism'de override yok.
     * alacakları değerler statik oluyor,fonksiyonun alacağı değerler belli, geri döndürecekleri sonuçlar belli
     * bu sabit bir bilgi olduğu için static polymorphism oluyor.
     */
    fun call(musti: Musti) {
        musti.boo()
    }


    // bunu şöyle de yapabilirdin.
    fun call(male: Male) {
        if (male is Gokhan) {
            (male as Gokhan).foo()
        } else {
            (male as Musti).boo()
        }
    }

    // bunu şöyle de yapabilirdin.
    fun call(gokhan: Gokhan? = null, musti: Musti? = null) {
        if (gokhan==null){
            musti?.boo()
        }else{
            gokhan.foo()
        }
    }
}

class Gokhan : Male() {
    fun foo() {
        println("Gokhan foo")
    }
}

class Musti : Male() {
    fun boo() {
        println("Musti boo")
    }
}

open class Male()


fun main() {
    val dog = Dog2("Karabas", "Dog", 4)

//    dog.tailShape = "HEYHEY"

    println("Dog name: ${dog.name}")
    println("Dog species: ${dog.species}")
    println("Dog footCount: ${dog.footCount}")
    println("Dog tailShape: ${dog.tailShape}")

    println("Dog: ${dog.toString()}")
    println("Dog makeASound: ${dog.makeASound()}")

}