package org.example.Generics

/**
 * Kotlin'de class'lar type parameters'lara sahip olabilirler.
 *
 * Kotlin wildCard'ları desteklemiyor. Bunun yerine Declaration-site variance ve type projections kavramlarını
 * Wildcards kısmı için Java'ya bakalım.
 *
 * NOT: Kotlin'de de Java'da olduğu gibi generic tipler, invariant(Değişmez) türler.
 * Yani Ne verdiysen Onu alırsın.
 *
 * Co-variant -> kendisi ve SubType'ları için: out parametresini kullanıyoruz.
 * interface Sourcee<out T>{
 *
 * Contra-variance -> kendisi ve SuperType'ları için: in parametresini kullanıyoruz.
 * interface Comparable<in T> {
 *
 */

class MyBox<T>(t: T) {
    val value = t

    fun <L> foo(l: L): L {
        return l
    }
}


fun main() {
    val myBox = MyBox<String>("selam")
//    val myBox2 : MyBox<Number> = MyBox<Int>(2)
// invariant'lar, birbirlerinin yerine kullanılamıyorlar. Bu yüzden hata verir.
    // invariant'lar yani ne verirsen onu kullanırsın.

    val box2: MyBox<String> = MyBox("naber")
    val box3: MyBox<Int> = MyBox(20)

}

// out co-variant kullanımlar için lazımdır. (Kendisi ve SubType'ları geçerli olsun istiyorsak)
interface Sourcee<out T> {
    fun nextT(): T
}

fun demo(strs: Sourcee<String>) {
    val objects: Sourcee<Any> = strs
    // burada Any beklediğin yere, String class'ını almış
}

// in contra-variance kullanımlar için yazılır. (Kendisi ve Super type'ları için.)
interface Comparable<in T> {
    operator fun compareTo(other: T): Int
}

fun demo(x: Comparable<Number>) {
    x.compareTo(1.0) // 1.0 double değişken demektir. Double'da Number'ın alt türüdür.
    // Daha açık görmek için, Number arayüzündeki Comparable interface'i double olan alt türe verilebiliyor
    val y: Comparable<Double> = x // OK!
    // Burada double beklediğin yere , Number class'ını almış.
}

/**
 * Star projection
 *
 * Bazen type argument hakkında hiçbir şey bilmeyiz. Yine de bunu güvenli şekilde kullanabilmemiz lazımdır.
 *
 * Foo<out T: TUpper> T bu durumda co-variant oluyor ve kendisi ve  sub typle'larını alıyor.
 * Foo<*> Foo<out TUpper>'nin eş değeri oluyor. read için -> Foo<out TUpper>
 *
 * Foo<in T> T bu durumda contra-variant oluyor ve kendisi ile  super type'larını alıyor.
 * Foo<*> ise Foo<in Nothing>'in eş değeri oluyor. write için Foo<in Nothing> oluyor.
 *
 * Foo<T: TUpper> T bu durumda in-variant oluyor super'i TUpper için.
 * Foo<*> ise read için -> Foo<out TUpper> write için Foo<in Nothing> oluyor.
 */

/**
 * Function <*, String> ifadesi Function<in Nothing, String> olur.
 */
/*
    Bu ifade, Function'ın parametrelerinin türlerini belirtmediğimiz ancak dönüş değeri türünün String
    olduğu bir fonksiyonu temsil eder. Bu durumda, herhangi bir türden parametre kabul edebiliriz,
    ancak dönüş değeri her zaman String olmalıdır. Bu, Kotlin'de Function<in Nothing, String> ile
    aynı şeyi ifade eder. Nothing, diğer tüm türlerin alt türüdür, bu yüzden Function herhangi bir
    türden parametre kabul edebilir.
 */

/**
 * Function<Int,*> ifadesi, Function<Int, out Any?>.
 */
/*
    Bu ifade, Function'ın Int türünden bir parametre aldığı ancak dönüş değeri türünün belirli bir
    türle sınırlı olmadığı bir Function'ı temsil eder. Yani, herhangi bir dönüş değeri türüne sahip olabilir.
    Bu durumda, dönüş değeri Any? olarak kabul edilir, çünkü Any? türü herhangi bir türün alt türüdür ve
    nullable olabilir (? ilareti).
 */

/**
 * Function<*, *> ifadesi Function<in Nothing, out Any?>
 */
/*
    Bu ifade, hem parametrelerinin hem de dönüş değerinin türlerinin belirli bir türle sınırlı olmadığı bir
    Function'ı temsil eder. Yani, Function herhangi bir türden parametre kabul edebilir ve herhangi bir türde
    dönüş değeri verebilir. Bu durumda, yine Function Function<in Nothing, out Any?> ile aynıdır; çünkü parametre
    türü Nothing (yani herhangi bir tür) ve dönüş değeri türü Any? (Yani herhangi bir tür veya nullable olabilir)
 */

class Boxs<T>(val item: T)

fun printBox(boxs: Boxs<*>){
    // Yıldız ile veriyorum, yani herhangi bir türden veri kabul edebiliriz,
    val item = boxs.item
    println("item: $item")
}

fun demo2(){
    val stringBox = Boxs("Hello, Kotlin!")
    val intBox = Boxs(42)

    printBox(stringBox)
    printBox(intBox)
}
// todo star projection'a tekrar bak