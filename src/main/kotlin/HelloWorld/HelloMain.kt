package org.example.HelloWorld

fun main(args: Array<String>) {
    // bir kotlin dosyasında main, kodların çalıştırılmaya başladığı fonksiyondur.

    args.forEach {
        println("selam $it")
    }
    println("Hello world")

    val name: String = "Musti"
    // explicit type, açık tip gösterimi
    val age = 22
    // implicit type, kapalı tip gösterimi
    // ide default olarak int, string ataması yapabilir.

    val surname: String

    surname = readLine()!!
    println("Surname $surname")
    // type inference ne zaman önemli? -> değişkeni ilk oluştururken atamıyorsan önemli
    // hafızada ona göre yer ayırıyor.

    var isMale: Boolean = true
    var isStudent = true

    // val keyword'u ile atadığım değişkenin değerini bir daha değiştirmeyeceğim diyorum.
    // var'da ise atamamı yaptım, bunu değiştirebilirim demektir.
    isStudent = false

    val a = A()
    //a.isMale = false
    
}

class A() {
    var isMale: Boolean = true
        private set

    // bunu decompile edersek set fonksiyonunun isFemale için oluştuğunu, isMale için oluşmadığını göreceğiz.
    var isFemale: Boolean = true


}