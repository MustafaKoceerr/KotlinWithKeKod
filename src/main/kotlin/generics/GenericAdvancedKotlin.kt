package org.example.Generics

import kotlin.reflect.typeOf

/*
*
* CO-VARIANCE KULLANIM
--------------------------
Tipini ne olduğunu söyleyemediğimiz noktada Kendisini ya da alt class'larını beklediğimiz durumda CO-VARIANT bir kullanım yapmış olacağız.
*
* Kotlinde de aynı şekilde ya constructer'da değişkenin lipini almalıyız ya da
* function'da değişkenin tipini almalıyız.
*
 */


class Box<T>(t: T) {
    var value = t

    fun <L> foo(): L {
        println("")
        return "sea" as L
        return 15 as L
    }

}

fun main() {

//val box: Box<Number> = Box<Int>(15)
    // kotlinde de aynı şekilde sol tarafa Number beklerken, sağ tarafta Int veremezsin

//val box: Box<Int> = Box<Number>(15)
    // aynı şekilde sol tarafa Int beklerken, sağ tarafta Number veremezsin

    /*
    *
    *Direkt olarak Sadece T'yi kullandığımızda javada olduğu gibi Int bekliyorsan Int
    * Invariant'tır
    * vermelisin. Child'ını veya SuperType'ını veremezsin.
    *
     */

    val a = A()
    val result = a.addNums(21.toShort(), 10.3f)
    println(result)
    // cevap 31.3 geliyor


    val ints: Array<Int> = arrayOf(1, 2, 3)
    val any = Array<Any>(3) { "" }

    copy2(ints, any)
    ints.forEach {
        println("Ints : $it")
    }
}


// Fonksiyonlarda ne yapabiliyoruz, childclass'lardan birini verebiliyorz.
class A() {
    fun addNums(param1: Number, param2: Number): Number {
        return param1.toDouble() + param2.toDouble()
    }
}


// out co-variant kullanımlar için lazımdır. (Kendisi ve SubType'ları geçerli olsun istiyorsak)
interface Source<out T> {
    fun nextT(): T
}

fun demo(strs: Source<String>) {
    val objects: Source<Any> = strs
    // Any beklediğin yere string atadın. Yani kendisini veya alt class'ını atadın
}


// in contra-variance kullanımlar için lazımdır. (Kendisini ve SuperType'ları geçerli olsun istiyorsak)
interface Comparable<in T> {
    operator fun compareTo(other: T): Int
}

fun demo(x: Comparable<Number>) {
    val y: Comparable<Double> = x // OK!
    // Kendisini ya da kendisinin süper type'ını verebiliyoruz.
    // Double beklediğin yere Number atadın

    val ints: Array<Int> = arrayOf(1, 2, 3)
    val any = Array<Any>(3) { "" }


    // copy2'deki Array<out Any> ifadesi, Javadaki Array<? super Object> karşılaştırılmasıdır
    copy2(ints, any)
    println("ints $ints")

    // fill'deki Array<in String> ifadesi, Javadaki Array<? super String> karşılaştırılmasıdır
    val strings: Array<Any> = arrayOf("a","b","c")

    fill(strings, "d")
}

fun copy2(from: Array<out Any>, to: Array<Any>) {}

fun fill(dest: Array<in String>, value: String) {}





// ----------------------------------------------------------------------------------------
// *** Star-Projection


class Boxs<T>(val item:T)



fun printBox(box: Boxs<*>){
    val item = box.item
    println("Item: $item")
}

fun demo2(){
    val stringBox = Boxs("Hello Kotlin!")
    val intBox = Boxs(42)

    // * hepsinin yerine geçebilmiş oluyor
    // böylelikle stringle kurulmuş bir box'da verebilirim
    // int'la kurulmuş bir box'da verebilirim.
    // Aşağıdaki açıklamalar gereği, T ile tür belirtiyorsak, * yerine her şeyi verebiliyoruz
    printBox(stringBox)
    println(intBox)

    val nullBox = Boxs(null)
    printBox(nullBox)
}


// NOT: Bir fonksiyona parametre olarak bir değer gönderdiysek, return'da onun üstünü döndürmememiz gerekli.
// Örneğin, parametre olarak Int aldıysak, Number döndüremeyiz
/*
* Function<*, String> ifadesi Function<in Nothing, String> olur.
 */
/*
* Bu ifade, Function'ın parametrelerinin türlerini belirtmediğimiz ancak dönüş değeri türünün String
* olduğu bir fonksiyonu temsil eder. Bu durumda, herhangi bir türden parametre kabul edebiliriz.
* ancak dönüş değeri her zaman String olmalıdır. Bu, kotlin'de Funtion<in Nothing,String> ile
* aynı şeyi ifade eder. Nothing, diğer tüm türlerin alt türüdür, bu yüzden Function herhangi bir türden
* parametre kabul edilebilir.
 */

/*
* Function<Int, *> ifadesi Function<Int, out Any?> olur.
 */
/*
* Bu ifade, Function'ın Int türünden bir parametre aldığı ancak dönüş değeri türünün belirli bir
* türle sınırlı olmadığı bir Function'ı temsil eder. Yani, herhangi bir dönüş değeri türüne sahip olabilir.
* Bu durumda, dönüş değeri Any? olarak kabul edilir, çünkü Any? türü herhangi bir türün alt türüdür ve
* nullable olabilir (? işareti).
 */

/*
* Function<*, *> ifadesi Function<in Nothing, out Any?> olur.
 */
/*
* Bu ifade, hem parametrelerin hem de dönüş değerlerinin türlerinin belirli bir türle sınırlı olmadığı bir
* Function'ı temsil eder. Yani, Function herhangi bir türden parametre kabul edebilir ve herhangi bir türde
* dönüş değeri verebilir. Bu durumda, yine Function<in Nothing, out Any?> ile aynıdır; Çünkü parametre türü
* Nothing (yani herhangi bir tür) ve dönüş değeri türü Any? (yani herhangi bir tür veya null olabilir)
 */



