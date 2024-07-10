package org.example.Generics

fun main() {

    val homeFragment = HomeFragment()
    homeFragment.call()
    homeFragment.callAny()
}

/*
*   Eğer T kullanacaksan ya fonksiyonda vereceksin, ya constructer'da vereceksin.
* Constructer'da verdiysen, o sınıfı extend ederken de constructer'da vermen gerekiyor.
* Eğer fonksiyonda verdiysen, fonksiyon çağrısı yaparken gönderdiğin T'nin türünü vermen gerekiyor.
*
* Birden fazla fonksiyonda kullanacaksan, constructer'da verebilirsin.
* Tek bir fonksiyonda kullanacaksan, fonksiyonun yanında T'yi istemen lazım.
*
* Bazen diyeceğiz ki biz bu parametrenin ne olduğunu bilmiyoruz ama SüperClass'ını biliyoruz.
* SüperType'ı şu olan parametreleri bekle diyeceğiz.
 */
abstract class BaseFragment<T : Number> {
    fun printNumber(number: T): T {
        return number
    }
}

abstract class BaseFragment2 {
    // EĞER CONSTRUCTER'A T VERMEZSEN, FUNCTİON'A T VERMEN GEREKİYOR
    fun <T : Number> printNumber(number: T): T {
        return number
    }

    fun <T> printAny(param: T): T {
        return param
    }


}


class HomeFragment : BaseFragment2() {
    fun call() {
        println(printNumber<Short>(5))
    }

    fun callAny() {
        println(printAny<String>("Mustafa"))
    }
}

class DashboardFragment : BaseFragment<Double>() {

}