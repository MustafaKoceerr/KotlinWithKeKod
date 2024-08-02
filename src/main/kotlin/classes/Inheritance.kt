package org.example.classes

import javax.swing.Box.Filler

/**
 * Kotlinde bir class'ın önünde otomatik olarak final modifier'ı var.
 *
 * open, final gibi modifier'lara accessibility modifiers deniyor.
 *
 * Eğer bir class'ın önüne open koyarsak, bu class diğer class'lardan miras alınabilir anlamına geliyor.
 * Eğer bir değişkenin önüne koyarsak o değişken child class'lardan override edilebilir anlamına geliyor.
 * Bu override işlemine polymorphism deniyor.
 * Static-dynamic polymorphism
 *
 * Final ->
 * Override etme işlemini kapatıyor.
 * Bir class içindeki fonksiyonlar, class'lar, değişkenler default olarak final geliyorlar.
 *
 * Open ->
 * Override ve miras alma işlemini açıyor
 */
open class Animal(var name: String = "") {

    final var feetCount: Int = 4
    open var origin: String = "Sivas"
    open var tailShape: String = "oval"

    final fun makeASound(): String {
        return ""
    }

    open fun attackToTheWolf() {

    }

    fun eat() {}
    fun walk() {}
    fun dance() {}


}

class Dog(name: String) : Animal("LilyDog") {
    // initte verdiğimiz için parametre olarak gönderdiğimiz iptal oldu
    init {
        super.name = name
    }

    override var origin: String
        get() = super.origin
        set(value) {}

    override fun attackToTheWolf() {
        println("HIRR HAV HAV HAV")
    }
}

// başına keyword vermediğimde ne oluyordu, primary constructer'ın bodys'si olan
// sadewce init bloğunda erişilebiliyordu. Bu basitçie initte super'de eşlemesine eşit oluyor
class Cat(override var origin: String, name: String) : Animal(name) {

    override var tailShape: String = "Yuvarlak"
        set(value) {
            field = value
        }

    override fun attackToTheWolf() {
        println("Meowww miavvv meovvv")
    }
}

fun main() {
    val animal = Animal()
    val dog = Dog("EtYiyenKopek")
    val cat = Cat("TURUNCU KEDI", "Tofu")

    println("Cat : ${cat.origin}")
    println("Dog : ${dog.origin}")
    println("Cat tail : ${cat.tailShape}")

    println("Dog name: ${dog.name}")
    println("Cat name: ${cat.name}")

    dog.attackToTheWolf()
    cat.attackToTheWolf()
    println("----------------")
    val fillerRectangle = FilledRectangle()
    val filler = fillerRectangle.Filler()
    filler.drawAndFill()

    return
}

open class Frag() {
    open fun onViewCreated() {
//        return inflate.inflater(layoutId)
    }
}

open class BaseFragment(val layoutId: Int) : Frag() {

    // Sadece Zaten var olan bir şeyi override edebiliriz
    override fun onViewCreated() {
//        return inflate.inflater(layoutId)
    }
}

class DashBoardFragment() : BaseFragment(1) {
    /*
       fun onViewCreated() {
   //        return inflate.inflater(R.layout.fragment_dashboard,)
       }
     */
}

class ProfileFragment() : BaseFragment(2) {
    /*
        fun onViewCreated() {
    //        return inflate.inflater(R.layout.fragment_profile)
        }
     */
}


open class Rectangle() {
    open fun draw() {
        println("Drawing a rectangle")
    }
}

class FilledRectangle() : Rectangle() {
    override fun draw() {
        val filler = Filler()
        filler.drawAndFill()
    }

    inner class Filler {
        fun fill() {
            println("Filling")
        }

        fun drawAndFill() {
            super@FilledRectangle.draw() // Call Rectangle draw fun
            fill()
            println("Drawn a filled rectangle with black borders")
        }

    }
}


interface Polygon{
    fun draw(){  }
}

class Square() : Rectangle(), Polygon{
    override fun draw() {
        super<Rectangle>.draw()
        super<Polygon>.draw()
    }
    /**
     * Eğer iki tane miras aldığın class ve interface'ler aynı parametre, isim, geri dönüş değerli metodda çakışıyorsa
     * <ClassName> ile bundan kaçınabilirsin.
     * Araya artık arayüz giriyor.
     */

}