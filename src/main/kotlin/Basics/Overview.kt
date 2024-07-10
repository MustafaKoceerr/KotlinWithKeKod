package org.example.Basics


fun main() {
    val box : Box = Box()
    println("Bos alan: ${box.availableSpace}")
    box.usedSpace = 20
    println("Yeni bos alan: ${box.availableSpace}")


}


class Box {
    var width = 20
    val height = 40
    var lenght = 50
    var usedSpace = 0

    val availableSpace: Int
        get() {
            return (width * height * lenght) - usedSpace
        }
    // Immutable değil, sadece read only değeri okunabilen ancak set edilemeyen değişkendir,
    // immutable ise değeri hiçbir şekilde değişemeyen değişkendir.
}

fun createName():String{
    val name:String = "Musti"
    return name
}