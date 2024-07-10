package org.example.inner_and_nested


class RecyclerView {
    val outerName: String = "RecyclerView"

    class ViewHolder { // static oluyor direkt üstündeki class'tan erişebiliyoruz
        // nested kullanım
        val nestedName: String = "ViewHolder"

      /*
        fun getOuterName():String{
            return outerName
        }
       */
        // outer name'ye erişemiyor, hata veriyor
    }
}


class RecyclerView2 {
    val outerName: String = "RecyclerView2"
    inner class ViewHolder { // statik olmuyor, buna erişebilmek için üstteki class'ın nesnesini yaratmamız gerekiyor
        // inner kullanım
        val innerName: String = "ViewHolder2"

        fun getOuterName():String{
            return outerName
            //return RecyclerView2().outerName
            // inner class'ın nested class'a göre esprisi içinde üst sınıfın bir nesnesi varmış gibi,
            // üst sınıfın değişkenlerine erişebiliyoruz.
        }
        // outer name'ye erişebiliyor
    }
}


fun main(){
    val recyclerView = RecyclerView()
    val viewHolder = RecyclerView.ViewHolder()

    val recyclerView2 = RecyclerView2()
    val viewHolder2 = RecyclerView2().ViewHolder()
    // statik olmuyor, buna erişebilmek için üstteki class'ın nesnesini yaratmamız gerekiyor



}