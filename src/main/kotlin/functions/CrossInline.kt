package org.example.functions

class CrossInline {
}

fun main() {
    val list = listOf(1, 2, 3, 4, 5, 6, 7)
//    list.forEach {
//        return
//    }

    HOFMusti {
        println("Selam musti")

    }
    println("end")
}

// LocalReturn yapabilmek için fonksiyon inline olmali
inline fun <T> Iterable<T>.forEach2(action: (T) -> Unit): Unit {
    for (element in this) action(element)
}

inline fun HOFMusti(crossinline myFun: () -> Unit) {

    anotherMustiFun {
        myFun.invoke()
        // myfun benim HOFMusti çağırırken kullandığım parametre oluyor,
        // yani selam musti

        // bu fonksiyon aynı zamanda AnotherMustiParam :()->Unit buraya parametre olarak verdigimiz fonksiyon oluyor
    }

}

fun anotherMustiFun(AnotherMustiParam: () -> Unit) {
    println("start anotherMustiFun")

    AnotherMustiParam()
    println("end anotherMustiFun")

    return
}


// CROSS INLINE
/**
 *      Eğer high order fucntion'nunuz
 *      call edileceği yerde yazdığınız algoritma gereği return edilmesi gerekiyorsa
 *      bu durumda bu HOF'ınızın INLINE olması gerekiyor. INLINE olmazsa NONLOCAL RETURN'ü kullanamıyorsunuz.
 *
 *      Yazdığın HighOrderFunction Başka bir HighOrderFunction'ın içinde call ediliyorsa bu durumda inline özelliğinden dolayı izin verilmiyor.
 *      bunun için fonksiyonunu cross inline yapmalısın.
 *
 *      Peki iç içe HOF'larda neden nonLocal return'e izin vermiyor?
 *      NonLocalReturn olsa ve run etsem bana nasıl bir problem çıkartır?
 *
 *      NonLocalReturn ne yapıyor? HighOrderFunction'ın dışına değil de onun kullanıldığı fonksiyonun dışına çıkartıyor sizi
 *
 *
 *      Inline olması demek nonlocal return yapma ihtimalin var demek.
 *      Inline olması demek kodun olduğu gibi nesnesi olmadan kopyalanması demek.
 *
 *      Bizim nonlocal return'ümüz buraya kopyalanmış olur demek.
 *
 *      Bir A HighOrderFunction ve başka bir B HighOrderFunction'ımız olsun. A HighOrderFunction'ı inline, B HighOrderFunction normal fonksiyon olsun.
 *      Eğer A HighOrderFunction'un parametre olarak aldığı fonksiyon,
 *      B HighOrderFunction'a parametre olarak gönderilecekse buna izin verilmiyor.
 *      Çünkü B HighOrderFunction nesne beklerken, biz A HighOrderFunction'ı inline olduğu için nesne üretme diyoruz.
 *      Bunu aşmak için A HighOrderFunction'ın parametre olarak aldığı fonksiyona noninline koymalıyız ve nesnesinin
 *      üretilmesini sağlamalıyız.
 *
 *      Başka bir yolu da bunu B HighOrderFunction'a parametre olarak vermek yerine,
 *      A HighOrderFunction'ın içinde şunları yapmaktır.
 *      B HighOrderFunction tetiklenirse, A HighOrderFunction'ın parametre olarak aldığı fonksiyonu call et.
 *
 *      CROSSINLINE basitçe sana NONLOCAL RETURN yapmayı yasaklıyor.
 *
 *      Developerlar zaten çok büyük ihtimalle onClick'in içerisinde nonlocal return'ü kullanmıyor developerlar.
 *      CROSSINLINE ile bunu ide'ye garanti ediyoruz. CROSSINLINE Koyunca artık nonlocal return yapamıyoruz.
 *
 *
 */
