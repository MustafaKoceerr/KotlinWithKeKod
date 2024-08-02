package org.example.functions

private fun musti(name: String): Unit {
    println("JUST NAME")

}

private fun musti(age: Int): Unit {

}

private fun musti(name: String = "Mustafa", surname: String = "Koc"): Unit {
    println("SURNAME ILE")
}
//private fun musti(name: String) : Int{
//
//    return 22
//}
// Calismaz Cunku dil hangi fonksiyonu dondurecegini bilemez

fun main() {

    musti("Mustafa", surname = "Koc")
    musti(surname = "Koc")

}