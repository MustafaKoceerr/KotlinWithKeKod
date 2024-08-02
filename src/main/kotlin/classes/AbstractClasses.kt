package org.example.classes

/**
 * abstract class'ın başına open yazarsak redundant uyarısı alıyoruz.
 * final yazarsak yani miras almaya kapatırsak ide compile hatası veriyor, yani abstract class miras alınabilir olmak zorunda.
 * public-private-internal kullanılabiliyor
 * constructer'lara sahip olabiliyor
 *
 * constructer'ı varsa nesnesini oluşturabilmem gerekiyor, deniyorum hata veriyor
 * constructer'ına bakıyorum, public constructer, private olamıyor.
 * Peki Neden costructer'ı var.
 * DI yapabilmemiz için var, constructer'a parametre olarak parametre verip DI sağlayabiliyoruz
 * Ikinci nedeni de child class'larda oluşturacağın ortak değişkenler varsa onları da abstract class'a yazabilirsin.
 *
 * Abstract property tanımlayabiliyoruz ama default değer atayamıyoruz.
 * fakat bir Open değişken oluşturursam buna default değer atayabiliyorum.
 * bu çok normal abstract class default değer içermemeli dedik,
 *
 * fakat düz değişken default value ile tanımlanabiliyor
 *
 * Abstract fun tanımlayabiliyorsun ama abstract tanımlamak istiyorsan bu mutlaka gövdesiz olmalı
 * abstract fun'lar miras alan class'lar için mutlaka override edilmeliler.
 * open'da bu zorunluluk yok
 *
 * Normal değişken oluşturabiliyorum, yani state tutabiliyorum.
 * abstract property override edilmesi zorunludur. ister constructer'da ister class'da override edebilirsin.
 * abstract property'nin backing field'i o abstract class için yok, ama eğer o class'ı miras alan bir başka class varsa
 * o class'ta override etmemiz zorunlu, yani o class'da backing field var.
 * byteCode'a bakarak anlayabilirsin. veya default değer atayabiliyoruz.
 *
 * override etmek istemiyorsan, miras aldığın class'ı da abstract yapmalısın
 *
 * Property in primary constructor cannot be declared abstract
 * abstract değişkeni primary constructer'da tanımlayamıyorsun.
 *
 * Open class'lar abstract property' veya fun içeremez,
 * abstract sadece abstract classlarda ve interface'lerde kullanılabilir.
 *
 * Abstract class'lar şablon niteliğindedir ve özel detay içermezler, tek başlarına bir anlam ifade etmezler, nesnesi üretilemez.
 * Open class'lar detay bilgi içermek zorundadır. (open function mutlaka body'ye sahip olmalı, open property mutlaka default değere sahip olmalı)
 * dolayısıyla şablon niteliğinde olmaktan çıktık, gruplama niteliğine geçtik.
 *
 * Abstract class'larda open fun ya da property oluşturabiliyoruz.
 *
 */


abstract class Human(val name: String, val eventManager: EventManager, //abstract val sayHi : String
) {
    //    val eventManager = EventManager() // bu kötü bağımlılık arttırdın DI yapabilirsin
    constructor(name: String, age: Int, eventManager: EventManager) : this(name, eventManager) {
    }

    //    abstract val surname :String = "default value"
//    abstract var surName :String = "default value"
    open var surName: String = "default value"
    abstract var middleName: String
    abstract var abstractSurname: String
    abstract var abstractSurname2: String
    val eyeColor: String = "brown"

    //    abstract fun display(){}
    abstract fun display()

    open fun display2() {}
}

class EventManager {
}

class Turk(
    name: String, eventManager: EventManager, override var abstractSurname: String,
    surName2: String
) : Human(name, eventManager) {
    override fun display() {
    }

    override var middleName: String = "asdfasdas"
    override var abstractSurname2: String = surName2

    //    override var surName: String
//        get() = "Override etmek zorunlu değil"
//        set(value) {}
    override var surName: String = "Open override etmek zorunlu değil"
}

abstract class AbsClass(name: String, eventManager: EventManager) : Human(name, eventManager) {
    /**
     * Abstract class olduğu için miras alsa dahi override etme zorunluluğu yok
     */
}

open class OpenClass(
    name: String, eventManager: EventManager,
    override var middleName: String,
    override var abstractSurname: String,
    override var abstractSurname2: String
) : Human(name, eventManager) {
    /**
     * Open class, bir abstract class'tan gelen şeyleri override etmek zorunda
     */
    override fun display() {
    }
}

abstract class Laz( name: String, eventManager: EventManager):Human(name, eventManager){
    abstract val skinColor:String

    final override var abstractSurname2: String = "Abstract'tan abstract'a"
    /**
     * Istersem override ederim, istersem etmem. Burada karar vana kalmış,
     * alt sınıflardan override etmemek istiyorsam final ekini koyup, override edilmesini kapatabilirim.
     */
}
class Trabzonlu(
    name: String, eventManager: EventManager,
    skinColor:String = "Kar beyazı",
    override var abstractSurname: String
) :Laz (name, eventManager) {
    override var middleName: String = "middle"
    override val skinColor: String = skinColor
//    override var abstractSurname2: String= "surname2"
    // yukarıda override ettiğim için burada override etmesem bana kızmıyor.
    override fun display() {
    }

}

fun main() {
//    val human = Human("selam")
}