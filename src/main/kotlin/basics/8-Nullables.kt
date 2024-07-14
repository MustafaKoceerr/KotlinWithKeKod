package org.example.Basics
/**
 * Kotlinde bir değişkene javadaki gibi dfirekt null atayamıyorsun. Onu nullable yapman lazım.
 *
 * Eğer bir değişkene tip vermeyip direkt null atarsanız, kotlin bunu Nothing? olarak işaretler.
 * Çünkü hangi tipe karşılık geldiğini bilemez.
 *
 * Nothing değişkneler, bir fonksiyonun herhangi bir değer döndürmek zorunda olmadığı durumlarda örneğin exception fırlatacaksınız
 * bu durumlarda çok görürüz. Unit'ten farklıdır, unit boş da olsa bir değer dönüyor demektir. Nothing hiçbir şey demektir.
 *
 * val result = Int? = 0
 * result!!.plus(22) -> değişken her durumda çalışsın.
 * result?.plus(22) -> eğer değişken null değilse çalışsın
 *
 * best practice
 * -----------------
 * Eğer result'ın değerinin null olması, plus işlemini yapamaması bizim uygulamamızın crash olmasına neden olmasın,
 * ama ekranda hatalı bir şey belirebilir buna okeyin böyle durumda ?. kullan
 *
 * ama exception fırlatması, yanlış sonuç göstermesinden daha az sıkıntı çıkartacaksa !! kullan.
 * !! kritik sonuçlar için daha doğrudur. Gerekirse hata versin ama yanlış şey basmasın.
 * Örneğin: Banka uygulamasında kredi hesabı yapacaksın, backend'den kredi oranı null geldi. Bu durumda crash olması, yanlış veri göstermekten çok daha iyidir.
 *
 * Kod1
 *    if(number1 !=null && number2 != null){
 *         result = number1+ number2
 *     }
 *
 * Kod2
 *     result = number1?.plus(number2)
 *
 * Kod1 ve Kod2 aynı çıktıları üretirler, kod2 yerine halen kod1 gibi yazıyorsan, bu kotlini içselleştirmemişsindir demektir.
 *
 */

fun main(){

    val number : Int = 100
    val boxedNumber : Int? = number
    val anotherBoxedNum: Int? = number
    println(boxedNumber === anotherBoxedNum)


    val number2 : Int = 10000
    val boxedNumber2 : Int? = number2
    val anotherBoxedNum2: Int? = number2
    println(boxedNumber2 === anotherBoxedNum2)


    val n1 : Int = 100
    val a = number
    val b = number
    println(a === b)


    val n2 : Int = 10000
    val aa = number2
    val bb = number2
    println(aa === bb)
}
