package org.example.functions

/**
 *      High order funciton yapınca, fonksiyonun nesnesi oluşturuluyordu,
 *      Fonksiyonun nesnesini oluşturmak demek, hafızada bir yer işgal etmek demekti.

 *      NOT: Sadece HOF'lar inline edildiğinde anlamlı olur
 *      Eğer ki biz bu fonksiyonu yapabiliyorsak inline yaparsak
 *
 */

fun main() {
//  repeat(10){
//      runAndPrint {message->
//          println("$it- $message: Geceler uzar gider.")
//      }
//  }
    runAndPrint2({ message ->
        println("$message: Geceler uzar gider.")
    }, { log ->
        println("Log: $log")
    }, {
        println("Yasim 22")
        22
    })

    outerFunction()

}


/**
 *  Inline yapinca ide, main'ce verdiğimiz kod bloğunu geliyor fonksiyonun içine koyuyor.
println("$it- $message: Geceler uzar gider.")
bunu fonksiyonun içinde gibi düşün. Böylelikle nesne üretmeden çağırılabiliyor.
 *
 * Main'de dongude çağırdık, nesnesi defalarca yaratılabiliyor.
 * Inline'ın yaptığı şey :
 *   runAndPrint {message->
 *           println("$it- $message: Geceler uzar gider.")
 *       }
 *  Kod bloğunda ne kadar kod varsa alıyor,
 *  inline fun runAndPrint(run:(String)->Unit)'in içine veriliyor.
 *
 *  Böylelikle runANdPrint'i çağırırken nesnesinin oluşturulmasına gerek kalmıyor.
 *
 *  Bunun şöyle bir dez avantajı var. HOF içeriği çok büyükse, bu size build time problemi olarak süre problemi yaratacak.
 *
 *  NOT: Zaten 1 kere çağırdığın bir HOF'u inline yapayım gibi bir düşünceye girme.
 *  Zaten inline kullanmamızın amacı, bellekte fonksiyonun tekrar tekrar nesnesinin oluşturulmamasını istememiz.
 *
 *  Küçük ama 1 kere çağırılıyor, inline yapabilirsin
 *  Büyük 1 kere çağırılıyor, inline yapma
 *
 *  Küçük çok kere çağırılıyor, Kesinlikle inline yap.
 *
 * Büyük ama çok kere çağırılıyor -> Kodunu daha güzel yazmaya çalış.
 * Build süren kullanıcı deneyiminden önemli değil. Inline yapabilirsin.
 *
 * Trade off'u doğru yapman lazım.
 */
inline fun runAndPrint(run: (String) -> Unit) {
    run.invoke("Stabil")
//    run("Stabil")

//    println("$it- $message: Geceler uzar gider.")

}

// CROSSINLINE, NOINLINE
/**
 *      Inline yazdigin HOF'ın parametre olarak aldığı fonksiyona CROSSINLINE ve NOINLINE yazabilirsin.
 *
 *      Parametre olarak geçireceğin sayısı birden fazlaysa bu durumda NOINLINE kullanmak isteyebilirsiniz.
 *
 *      2 durumda NOINLINE'a ihtiyaç duyarsınız
 *      1. durum:
 *      Eğer parametre olarak veriler bir fonksiyonu, başka bir fonksiyona parametre olarak vermek istiyorsanız
logg(logger) gibi
 *      Bu gibi durumlarda eğer HOF'ununuz inline ise, parametre fonksiyona noinline vermeden bu işlemi gerçekleştiremezsiniz.
 *
 *      2. durum:
 *      Eğer fonksiyonun nesnesini bir parametreye atamak istiyorsan, nesneye ihtiyacın olacak. Bu gibi durumlarda da,
 *      NOINLINE kullanmalısın.
 *      val yas = returnInt
 *
 *  Yani nesnesini üretmen gereken yerde NOINLINE kullanmalisin.
 */

inline fun runAndPrint2(run: (String) -> Unit, noinline logger: (String) -> Unit, noinline returnInt: () -> Int) {
    logg(logger)
    run.invoke("Stabil")
//    run("Stabil")
    logger("End")
    val yas = returnInt
}

fun logg(logger: (String) -> Unit) {
    logger("Start")
}

fun outerFunction(){
    println("Start")
    val list = listOf(1,2,3,4,5,6,7)
    /**
     * NON-LOCAL RETURN NEDİR
     * Ctrl ile forEach'e bakarsan senden bir şey return etmeni beklemiyor, yani unit.
     *
     * Fakat bir return ile neyi return ediyoruz??
     * Burada return etmemiz demek NON-LOCAL RETURN demek.
     * ForEach'i değil de forEach'in bulunduğu fonksiyonun dışına çıkarmış oluyoruz.
     *
     * Eğer dış fonksiyonun değil de HOF'un dışına çıkmak istiyorsak burada basitçe LABELİNG
     * yapıyoruz.
     */
    list.forEach label@{
        if(it==5){
            println("End")
            return@label
        }
        println(it)
    }
    println("End of fun")

}