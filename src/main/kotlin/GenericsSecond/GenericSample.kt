package org.example.GenericsSecond

/**
 * Hatayı runtime yerine compile time'da almamız çok önemli.
 * Any ile bunu yapamıyoruz, any compile time'da hata vermese bile runtime'da hata alırsın.
 * Generic kullanarak hata yaparsan, bunu compile time'da görüyorsun.
 *
 * Generic'i tek bir fonksiyonda veya yerde kullanıcaksan, fonksiyon üzerinde vermen lazım.
 * Birden fazla yerde kullanıcaksan, class yanında vermen lazım.
 *
 */

fun main() {

}

abstract class BaseFragment<VB : Number> {
    fun printNumberVB(number: VB): VB {
        println("Card Name:$number")
        return number
    }
}
// YA BÖYLE TANIMLAYACAKSIN

abstract class BaseFragmentSecond {
    fun <VB : Number> printNumberVB(number: VB): VB {
        println("NumberName: $number")

        return number
    }
}


class HomeFragment : BaseFragment<Int>()
class DashboardFragment : BaseFragment<Double>()


