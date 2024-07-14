package org.example.Sealed


/*
* visibility modifierlarla ilgili özel bir durumu yok
* primary constructer tanımlanabiliyor
* init bloğu kullanılabiliyor
* secondary constructer kullanılabiliyor
* Enumdan farkı, Normal bir class veya abstract veya sealed bir class'ı miras alabilir
* Enumlarda sabitlerle uğraşıyorsun, sealed class'larda class'lara uğraşıyorsun
* interface tanımında bir problem yoktur.
* interface'deki ve abstract class'lardaki  abstract functionları implement etmek zorundayız. Bunu 2 şekilde sağlayabiliriz.
* Ya ana class override edecek ve oradan yavrulara geçecek, ya da tüm yavrular tek tek override edecek.
*
* NOT: Child class dediğim, sealed class içerisinde sealed class'ı extend etmiş class'lardır.
*
* Primary Constructer'ı default olarak protected'dır. private değil protected'dır
* init'i ve constructer'ı olsa bile direkt olarak nesnesi üretilemiyor.
* Primary constructer içerisinde tanımlanan property, sub class'larda ister constructer içerisinde ister birer sabit
* olarak miras alındığı yerde değeri atanabilir.

* companion object tanımlanabiliyor.
*
* open ya da final yapılabilen bir yapı değil,
* başka sınıfa miras verilemez.
*
* final ya da open yapılamıyorlar
* abstract yapılabiliyorlar ama abstract yapmak anlamsız, çünkü arka planda zaten abstract class'lardan oluşuyorlar
*
* içerisinde hali hazırda subclass'ları olan bir sealed class'ı dışarıda bir yerde başka bir class'a miras olarak veremiyoruz
* işte burada developer'ın kontrolünden çıkartıp, idenin kontrolüne veriyorsunuz.
* Ama boş bir sealed class oluşturduysanız, bu durumda herhangi bir class'a miras olarak verebilirsiniz.
*
*
* Eğer primary consturacter'ını private yaparsak şu durumlar oluşur:
* subclass'ların, bu class scope'u dışında miras alınmasını engellemiş olursunuz. Bu da özellikle daha da kısıtlı bir hiyerarşi
* kurmak istediğiniz kütüphane kullanımlarında (closed api) önemlidir.
*
* içerisinde abstract, open, normal method yazmana izin var
* abstract method yapmaya izin verirsen, bu class'ı extend eden class'larında da o abstract metodu uygulamalısın.
* BUnlar class olmanın getirileri. Çünkü Sealed class'ı miras olarak alıyorlar. Ana'ya bir abstract metod yazarsan, onunla
* extend edilen class'lara da bu metodu uygulamalısın.
*
* subclass'ların constructer'larında, ana class'tan farklı şeyler olabilir
* bu enum class'larla farklarından birisidir.
* sealed class'ın childları class olmak için varlar, onlar da birer class
* enum'da onla birer sabit, ama sabit olması için static class'lar kullanılmış. ama biz ondan bir class görevi beklemiyoruz
* bir sabit görevi bekliyoruz
    class NoInternet (message : String): Errors(404) {
*
* Ana class bir interface'yi implement etmeden, subclass'lar doğrudan o interface'yi implement edebilir.
    class NoInternet (message : String): Errors(404), SomeOtherInterface {
* Enum ile farklarından birisidir.
* Kısaca: HER BİR CLASS BAĞIMSIZ BİR DÜNYA GİBİ HAREKET ETSİN AMA KATEGORİLENDİREYİM DERSEN SEALED CLASS
* sabitler kendi başlarına hareket edemesinler diyorsan ENUM CLASS kullanmalısın.
*
* child class'ların içinde de companion object tanımlayabiliyorum.
* child class'ların içinde open, normal function tanımlayabiliyorum.
*
* child class'lar enum class dışında diğer class türleri olabilirler. Sealed, inner, abstract, data olabilir.
* enum class olamamasının sebebi, enum class'lar bir başka class'ı miras alamazlar.
*
* toString, hashCode, equals fonsiyonları override edebilirler.
*
* Sealed class'ların child class'larını, birden fazla kez oluşturabilirsiniz.
Multiple object desteği var.
*  Enumlarda sabitler, tek bir nesne olarak memory'de tutulurlar.
*
* Subclass'lar, enumlarda olduğu gibi static değillerdir. (sealed class scope'u içinde kullanılıyorlarsa static olurlar)
* ama özünde static olmadıkları için kullanılırken nesneleri üretilmesi gerekmektedir.
*
* subclass'lar final oldukları için başka class'a extend edilemezler, kalıtım veremezler
*
* SEALED INTERFACE
* -------------------
* Interface'ler için de interfacelerin özellikleri geçerli olacak şekilde, sealed class'lardaki aynı davranışları gösteriyorlar.
* -------------------
*
* Sealed class'lar aynı module veya package içerisinde geçerlidir. Farklı modüller tarafından görünezmezler.
*
* Sealed class'ların subclass'ları compile time'da biliniyorlar.
 */

public sealed class Errorss protected constructor(val errorCode: Int): A(), B {

    class NoInternet (message : String): Errorss(404), SomeOtherInterface {
        override fun someAbsFun() {
            TODO("Not yet implemented")
        }

        override fun someMethod2() {
            TODO("Not yet implemented")
        }

        override fun someOtherInterface() {
            TODO("Not yet implemented")
        }

        open fun someOpenFun(): String {
            println("hello")
            return "musti"
        }
    }

    abstract class ServerError(errorCode: Int): Errorss(errorCode) {
        override fun someAbsFun() {
            TODO("Not yet implemented")
        }

        override fun someMethod2() {
            TODO("Not yet implemented")
        }
    }

    class FileIOError: Errorss(500) {
        override fun someAbsFun() {
            TODO("Not yet implemented")
        }

        override fun someMethod2() {
            TODO("Not yet implemented")
        }
    }

    override fun someMethod(){
        println("hello")
    }

    abstract fun someAbsFun()

    fun normalMethod() : String{
        return "Merhaba mustafa saat gece 12"
    }

}

interface SomeOtherInterface {
    abstract fun someOtherInterface()
}

abstract open class A

interface B{
    fun someMethod()
    fun someMethod2()
}

class normalClass(errorCode: Int) : Errorss.ServerError(errorCode)
// error verdi

fun main(){
    // val error = Errorss(120) // yapamazsın

    val error = Errorss.NoInternet("No Internet")
    val noInternetErrorss : Errorss.NoInternet
    when(error){
        is Errorss.NoInternet ->{
            println("Internet yoook")
        }
    }
}


interface Doo : ASDAS
interface FFF : Doo

sealed interface ASDAS{
    interface IInner: ASDAS
}
