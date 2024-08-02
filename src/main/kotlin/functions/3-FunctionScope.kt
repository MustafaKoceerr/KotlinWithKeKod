package org.example.functions

/**
 *      Bir fonksiyon herhangi bir sinifin icerisinde degil de bir dosyasinin icerisinde boslukta tanimlaniyorsa
 *      top level function adini alir.
 *
 *      Bir fonksiyon olusturulurken top level tanimlama yapilamiyor, sadece bir sinif a ait fonksiyonlar yazilabiliyorsa
 *      bunlara fonksiyon degil, method denir. Bir fonksiyona fonksiyon diyebilmemiz icin top level tanimlanabiliyor olmasi lazimdir.
 */


fun main(){


    fun calculateAtomPhysics2() {
    }

    calculateAtomPhysics2()
}
// calculateAtomPhysics2() // call edemiyoruz, sadece tanimladigimiz fonksiyon icinden cagirabiliyoruz.

//--------------------------------------------------------------------------

/**
 *      Fonksiyon icerisinde fonksiyon tanimi kotlin'de yapilabilir. Bu fonksiyonlara Local Functions denir.
 *      Sebebi ise, yazdiginiz fonksiyonun kendi sinifinizdan dahi cagrilmasini istemeyebilirsiniz.
 *
 *      Bu fonksiyonun herhangi bir baska fonksiyon ya da sinif icin degistirilmesini istemeyebilirsiniz.
 *      ***Reflection ile fonksiyonlariniz erisilirken gizli kalsin isteyebilirsiniz.
 *      Reflection ile dahi ulaşılamıyor.
 *
 *      Bu gibi durumlarda bu cok onemli fonksiyonunuzu baska bir fonksiyon icerisinde yazabilirsiniz.
 */

fun calculateAtomPhysics(){
    val userName = "Codemy"
    println("Init process")
}

class PrivateA(){

    fun commonFunction(){
        fun specialField(){
            // disaridan ulasilmadigini istemedigin islemler
            // kesinlikle başka function tarafından call edilmesini istemediğin islemler
        }
    }

    fun secondFunction(){
        commonFunction()
        // specialField() // calismaz, hata verir
    }
}

private fun foo(){
    val privateA = PrivateA()
    privateA.commonFunction()
    // Maximum common function'a erişebiliyorsun.

//privateA.specialField() // hata veriyor erişemezsin.
}

//--------------------------------------------------------------------------

/**
 *      Bir sinifin icerisindeki fonksiyonlara, uye fonksiyonlar denir.
 */
private class Car(){
    fun setColor(colorCodeId:Int){
    }
}

//--------------------------------------------------------------------------

/**
 *      Bir fonksiyon Generic tip aliyorsa, Generic Function olarak adlandirilir.
 */
fun <T> setColor(colorCodeId: T){

}