package org.example.classes

class Encapsulation constructor(){

    /**
     * Eğer bir property'yi
     * Val yaparsan arka planda set'i oluşmaz. Sadece get'i oluşur.
     * Var yaparsan set ve get'i oluşur.
     */
    private val name:String = "Musti"
    private var surName:String = "Koc"

    fun getFUllName():String="$name $surName"

    companion object{

    }

}


fun main(){
    val obj1 = Encapsulation()

}