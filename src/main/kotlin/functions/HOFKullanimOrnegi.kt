package org.example.functions


fun main() {

    val homeFragment = HomeFragment()

}

/**
 * Burada bahsettiğimiz geriye dönme işlemini Recyler View için görüyoruz.
 *
 * Tıklanan bir buton, view holder'dan fragment'a nasıl geri dönecek burada çok güzel bir örneğini görüyoruz.
 *
 * Eğer Button class'ındaki setOnClickListener fonksiyonu inline olsaydı benim view holder'daki
 * bind fonksiyonum da inline olabilirdi. Ama olmadığı için ve SDK hazır olarak normal nesne bekleyen şekilde
 * verdiği için ben fonkisyonumu ya inline, noinline onclick yapacaktım.
 *
 * Ya da yaptığım gibi crossinline yapacaktım.
 */


class HomeFragment(){
    init {
        val homeListAdapter = HomeListAdapter({
        println("OnClick runs")
        })
    }

}

class HomeListAdapter(onClick: (View) -> Unit){
    init{
        val homeListViewHolder = HomeListViewHolder()
        homeListViewHolder.bind(onClick)
    }
}


class HomeListViewHolder() {

    /**
     * CROSSINLINE kullanımı nonlocal return kullanılmayacağını garanti ediyor.
     *
     * inline fonksiyonda nonlocal return yapılabilir hale geliyor.
     * inline vermesek nonlocal return yapılamıyor
     *
     * Android projelerin %90'ında onClick işleminde nonlocal return kullanılmıyor.
     * Kullanılmıyorsa fonksiyonu inline yapıp Crossinline vererek, nonlocal return yapılmayacağını garanti edip,
     * inline kullandığın için performans artışı sağlayabilirsin.
     *
     * Inline
     * -----------
     * Inline keyword'ü fonksiyonun nesnesinin üretilmesini engelliyor. Body'yi alıp fonksiyonun içine yapıştırıyor gibi düşün.
     * Bu sayede performans artışı sağlamış oluyorsun, çünkü nesne üretim işinden kaçınıyorsun. Ama developer olarak build süren artıyor,
     * çünkü inline yapınca generate edilen file'lar artıyor.
     *
     * NoInline
     * ------------
     * Eğer ki inline HighOrderFunction'ın aldığı parametredeki fonksiyon, başka bir inline olmayan HighOrderFunction'a parametre olarak verilecekse
     * başka HighOrderFunction sizden bir nesne beklemiş oluyor, çünkü onda inline kullanmamışsın.
     *
     * Sen de parametre olarak bunu vermek istiyorsan, fonksiyonun nesnesinin üretilmesini sağlamak zorundasın. Bunu da noinline ile sağlıyorsun.
     *
     * CrossInline (nesne oluşturma işlemi yine yok, sadece nonlocal return'e izin vermiyor)
     * --------------
     * İllaha parametre olarak göndermene gerek yok. Başka inline olmayan fonksiyonun tetiklediğini algılayabiliyorsan (setOnClickListener) gibi
     * o tetiklendiğinde normalde parametre olarak göndereceğin fonksiyonu, call-invoke etmek de aynı işi görüyor.
     *
     * Böylece nesne üretimine gerek kalmadığı, tetiklendiğinde içinde çağırdığı için inline kullanabilir durumda oluyorsun.
     * Fakat böyle yapınca da nonlocal return'e izin vermiyor çünkü inline fonksiyonun body'sini kopyaladığı için
     *
     * // Inline olmayan fonksiyonlar nonLocalReturn'ü desteklemiyorlar. Bu kuraldır.
     * // Inline olmayan fonksiyonlar nonLocalReturn'ü desteklemiyorlar. Sen inline olmayan bir fonksiyonda, inline olmuş bir fonksiyonun inline uygulanmış parametresini çağırırsan,
     * // ide diyor ki ben Inline olmayan fonksiyonlar için NonLocalReturn'ü desteklemiyorum ama sen bana inline olmuş bir fonksiyonun inline uygulanmış bir parametresini verdin,
     * // ve bu da NonLocalReturn'ü destekliyor. Bunu yapamazsın, sen bu inline uygulanan parametreyi crossinline yap ki NonLocalReturn desteğini kaldır.
     *
     */
    //Burada problem button.setOnClickListener'ın bir nesne beklemesi yüzünden olusuyor
    inline fun bind(crossinline onClick: (View) -> Unit) {
        val button = Button()
        /**
         * Invoke ile burada fonksiyonu çağırıyoruz, call ediyoruz, çalıştırıyoruz.
         * Parametre olarak VERMİYORUZ.
         * invoke ile çağırınca, setonclick tetiklendiği anda kendi fonksiyonunuzu da tetikliyorsunuz.
         *
         *Can't inline 'onClick' here: it may contain non-local returns. Add 'crossinline' modifier to parameter declaration 'onClick'
         *
         * nonlocal return içerebilir, bunu ben bilemem. bu yüzden bunu yapmana izin vermiyorum diyor.
         * eğer inline kullanmak istiyorsan, crossinline keyword'ünü kod diyor.
         *
         * //button.setOnClickListener(onClick) burada ise fonksiyonu çağırmadan parametre olarak veriyoruz.
         *
         */
        //button.setOnClickListener(onClick)
        button.setOnClickListener{
            onClick.invoke(it)
            // pesudo code
            // pesudo code
            // pesudo code
            // return
            // Inline oldugu icin fonksiyon body'sini buraya taşımış gibi düşün. Bu durumda crossinline ile return kullanılmamasını garantilemiş oluyorsun.
            // Çünkü burada return kullanılsaydı setOnClickListener fonksiyonu yerine bind fonksiyonunu sonlandıracaktı.
            //
            // Inline olmayan fonksiyonlar nonLocalReturn'ü desteklemiyorlar. Sen inline olmayan bir fonksiyonda, inline olmuş bir fonksiyonun inline uygulanmış parametresini çağırırsan,
            // ide diyor ki ben Inline olmayan fonksiyonlar için NonLocalReturn'ü desteklemiyorum ama sen bana inline olmuş bir fonksiyonun inline uygulanmış bir parametresini verdin,
            // ve bu da NonLocalReturn'ü destekliyor. Bunu yapamazsın, sen bu inline uygulanan parametreyi crossinline yap ki NonLocalReturn desteğini kaldır.

            // Bind fonksiyonu da senin bağlama yaptığın yer oluyor ve bunu yapmak istemezsin.
            // Sadece setOnClickListener'ı return etmek isteyebilirsin.
            // %90 durumda bunu da yapmıyorsun, nonLocal return kullanmana gerek olmuyor.
        }

    }

    // Bu durumda inline kullanmanin anlami kalmaz, cunku tek bir fonksiyon var ona da noinline koymuşsun
//    inline fun bind2(noinline onClick: (View) -> Unit) {
//        val button = Button()
//        button.setOnClickListener(onClick)
//        button.setOnClickListener{
//            onClick.invoke(it)
//        }
//    }

}

class Button() {
    fun setOnClickListener(onClick: (org.example.functions.View) -> Unit) {
    println("setOnClickListener fun called")
        val view = org.example.functions.View()
        onClick.invoke(view)
    }

//    init {
//        setOnClickListener {
//            println("init : setOnClickListener fun called")
//        }
//    }
}

class View

