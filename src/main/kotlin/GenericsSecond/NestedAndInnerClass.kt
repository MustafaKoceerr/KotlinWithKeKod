package org.example.GenericsSecond

/**
 * Normal class'larda ne yapabiliyorsak, nested ve inner class'larında da onu yapabiliyorsun.
 *
 * bytecode'a çevirdiğimiz zaman;
 * nested class'lar static olarak bulunuyor.
 * inner class'lar final class olarak bulunuyor.
 * ---
 * Gökhan'ın tavsiyesi recyler view'de kodun okunaklığını bozduğu için,
 * ayrı ayrı dosyalarda yazmayı uygun buluyor,
 * Aynı dosyada yapacaksan, inner class kullanman daha mantıklı oluyor.
 *
 * NOT: MVVM kullanıyorsan, business logic'i adapter'da tutma. Adapter'a göndermeden önce veriyi mapper'larla işle.
 * işlenmiş veriyi adapter'a aktar.
 *
 * Fragmenttaki aldığın veriyi manipüle edeceksen, view model'e gönder, orada işle geri döndür.
 *
 *
 * Nested class' ne işe yarar?
 * Dışarıdan kodun görünürlüğünü olabildiğince kapatmak istiyorsunuzdur, reflection'larla bile erişilsin istemiyorsunuzdur.
 * Bu durumda nested Class formunu kullanabilirsiniz.
 * Not: NestedClass'ı, yazdığın class dışında kullanmaya çalışma.
 *
 * Not: Aynı viewHolder'ı birden fazla adapter'da kullanabilirsin.
 * Bunu yapacaksan, view holder'ı ayrı dosyada tutman en iyi seçenek olacaktır.
 *
 */


class RecyclerView() {

    val outerName: String = "RecyclerView"

    class ViewHolder() {
        val nestedName: String = "ViewHolder"

        fun getOuterName():String{
//            return outerName // hata veriyor, erişemiyorsun.
            return ""
        }
    }
}


class RecyclerView2() {
    val outerName: String = "RecyclerView2"

    inner class ViewHolder2() {
        val innerName: String = "ViewHolder2"

        fun getOuterName():String{
            // Bu class'a erişmek için zaten üst class'ın nesnesi gerekliydi.
            // yani aslında with() kullanıyormuş gibi burada outer class'ın bir parametresini kullanabiliyoruz.

            return outerName
        }
    }
}


fun main() {
    val recyclerView = RecyclerView()
    // static oldukları için, böyle erişebiliyoruz.
    val viewHolder = RecyclerView.ViewHolder()

    //############################################

    val recyclerView2 = RecyclerView2()
//    val viewHolder2 = RecyclerView2.ViewHolder2()
    /**
     * böyle erişemiyorum çünkü STATIC değil!
     * öncelikle böyle erişebilmem için nesnesini yaratmam gerekiyor
     */
    val viewHolder21 = RecyclerView2().ViewHolder2()
    val viewHolder22 = recyclerView2.ViewHolder2()

}