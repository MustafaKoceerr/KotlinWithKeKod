package org.example.classes

/**
 *  Interface'ler 2'ye ayrılır, birisi arayüz olan <> işareti,
 *  diğeri bildiğimiz interface'ler.
 *
 * Interface dediğimiz şey, bir ismi olan ve içerisinde mutlaka bir ismi olan yapı
 *
 * public, private, internal olabiliyor.
 *
 * open bir fonksiyon yazabiliyoruz ama bir anlamı yok, zaten override edilebiliyor.
 * final yaparsan override edemezsin, sen zaten override etmek için bu yapıyı kullanıyorsun.
 * bu yüzden final yapmak yasaklı
 *
 * body'li bir fonksiyon da yazabilirsin, bunu yaparsan override etme zorunluluğunu da kaldırırsın.
 * *** body'li fonksiyon open oluyor, yani zorunluluk kalkıyor. ***
 * kotlin bytecode'a bakıyoruz, bunu yaparak static bir class içinde static bir fonksiyon olduğunu görüyoruz,
 * buradan her open fonksiyon statictir gibi bir anlam çıkartma
 *
 * abstract class'larda body'si olan fonksiyonlar open olabiliyordu.
 * abstract class'larda open functionlar'lar statik değiller, normal fonksiyonlar
 *
 * interface'nin önüne abstract yazabiliyorsun ama redunant,
 * final yazamıyorsun, çünkü kalıtım için zaten oluşturuyorsun.
 *
 * body'si olamayan function'lara abstract yazabiliyorsun. ama redunant
 * body'si olan'a yazamazsın.
 *
 * bir interface başka bir interface'i implement edebilir.
 * bir interface başka bir interface'i implement ediyorsa, override etme zorunluluğu o interface'de kalkıyor.
 * eğer ki child interface'de override ediyorsak, sonrasında child interface'yi bir class'a implement ediyorsak,
 * parent interface'deki functionları, child interface'de zaten override ettiğimiz için class içinde override etme
 * zorunluluğumuz kalkıyor.
 *
 * Bu davranış önemli neden?
 * third-part SDK'lerde bir interface implement edince 20 tane fonksiyon gelebiliyor, sen bir childInterface oluşturup,
 * gereksiz fonksiyonları override edersen veya tüm fonksiyonları override edip, bu child class'ı interface'yi kullanacağın yerde
 * kullanırsan çok daha temiz bir implementasyon yapmış olursun.
 *
 * Bunun tek bir dezavantajı var, başka bir yazılımcı arkadaş istediği bir fonksiyonu bulamayabilir.
 *
 * Interface bir abstract class'ı veya open class'ı implement edemez. Sadece interface'leri implement edebilir.
 * bir interface başka bir interface'i implement edebilir, ama class'ı edemez.
 */

interface TextWatcher {
    fun onTextChanced()
    fun beforeTextChanced()
    fun afterTextChanced()
    open fun foo()

    //    final fun boo()
    open fun functionWithBody() {
    }

    var abstractVariable: String
}

abstract class MustiAbstract() {
    fun foo() {}
    open fun boo() {}
    abstract fun poo()
}

class InterfaceSample(override var abstractVariable: String) : TextWatcher {
    // Gördüğün gibi body'si olan fonksiyonu implement ettirmedi.
    // istersen kendin override edebilirsin.
    override fun onTextChanced() {
    }

    override fun beforeTextChanced() {
    }

    override fun afterTextChanced() {
    }

    override fun foo() {
    }

}

abstract class Base() {}
interface ChildInterface : TextWatcher// Base() // yapamam class implement edemem.
{
    /**
     * Property in an interface cannot have a backing field hatası alıyorum, yani interface'ler backing field, state tutmazlar.
     *
     */
    override var abstractVariable: String
        get() { //return field
            return "ChildInterface tarafından override edildi"
        }
        set(value) {//field = value
        }
//    final override fun afterTextChanced() {}
    /**
     * Burası bir yapı kurarken interface'mi, abstract class mı kullanacağımızı belirleyen önemli yerlerden.
     * Eğer siz bir abstract class'ta bir fonksiyon override ediyorsanız, final verebilirsiniz ve kalıtımı orada bitirebilirsiniz.
     * yani sizi child'larınız gidip o function'u override edemezler
     *
     * Ama interface'ler bir fonksiyonu override ederlerse, final veremiyorlar, yani alt class'lar bunu isterse tekrar
     * override edebiliyor, istemezse etmiyor. kesin bir kısıtlama yapamıyorsun.
     *
     * Aynı şekilde bu tek fonksiyonlar için geçerli değil de, property için de geçerli.
     */

}

abstract class AnotherAbstractClass() : TextWatcher {
    final override fun afterTextChanced() {
        // Final verip kalıtımı burada bitirtebiliyoruz
        // yine aynı şekilde abstract class interface'nin fonksiyonlarını override etmek zorunda değil.
        // ama eğer override etmezsen, o abstract class'ı implement eden tüm child class'ları implement etmen zorunlu.
    }
}

class ChildClass() : ChildInterface, AnotherAbstractClass() {
    override fun onTextChanced() {

    }

    override fun beforeTextChanced() {
    }

//    override fun  afterTextChanced() {
//    }
    // Burada abstract class final olduğu için bana izin vermedi, bunu delegation ile aşacağım galiba

    override fun foo() {
    }

    override var abstractVariable: String = "Class icinde abstract property şu an backing field'ı var."
        get() {
            return field
        }
        set(value) {
            field = value
        }

}

fun main() {
    val array = arrayOf<String>()
    // bu da bir interface
    val textWatcher = object : TextWatcher {
        override fun onTextChanced() {
        }

        override fun beforeTextChanced() {
        }

        override fun afterTextChanced() {
        }

        override fun foo() {
//            super.foo()
            // buna izin vermiyor çünkü gövdeli bir function değil.
        }

        override fun functionWithBody() {
            super.functionWithBody()
            /**
             * üstte static class içinde static bir fonksiyon çağırdığından bahsetmiştik.
             * bunu super() çağırmasından da anlayabilirsin. Bytecode'a bakabilirsin.
             */
        }

        override var abstractVariable: String
            get() = "absVariable"
            set(value) {}
    }

    /**
     * Object expression yöntemi
     * Object kullanımı vardır.
     * bytecode'a baktığımızda nesnesi oluşturulduğunu gördük.
     * arka planda bir class gibi davranıyor.
     *
     * Object ile hem interface'nin hem de abstract class'ın nesnesi oluşturulabilir.
     */

    val abstractObject = object : MustiAbstract() {
        override fun poo() {
        }

    }
}