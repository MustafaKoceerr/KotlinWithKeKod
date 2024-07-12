package org.example.Basics

fun main() {
    /**
     *      Aynı türden ya da belirtilen türün alt türlerinden, **sabit sayıda** veri tutan bir veri yapısıdır.
     *      En sık kullanılan versiyonu Object-Type Array'lerdir. Array sınıfı ile temsil edilirler.
     *
     *      Eğer primitive tipleri Object-Type Array olarak kullanırsanız Boxed kullanım yapmış olursunuz.
     *      Bu da performansa etki eder. Eğer sadece primitive'lerden oluşan arrayler oluşturacaksanoz,
     *      bu durumda Primitive-Type Array'ler kullanın.
     *      ByteArray(byte[]), ShortArray(short[]), IntArray(int[]), LongArray(long[]),
     *      DoubleArray(double[]), FloatArray(float[]),
     *      BooleanArray(boolean[]), CharArray(char[])
     *
     *      arrayOf(ayni tip degerler) seklinde tanimlanabilir.
     *      arrayOf<Any>(farkli tip degerler) seklinde tanimlanabilir.
     *      arrayOfNulls<Type>(size) şeklinde ise verilen boyut kadar null deger iceren dizi tanimlanabilir.
     *      emptyArray() bos array tanimlar.
     *
     */

    val studentNums = arrayOf(13, 45, 54, 54, 25, 10)
    val studentNames = arrayOf("ahmet", "ayse", "veli", "derya")
    val firstCharOfName = arrayOf<Char>('A', 'A', 'V', 'D')
    val mixedArray = arrayOf<Any>(13, "Ahmet,'A", true)

    val arrayOfNulls = arrayOfNulls<String>(4) // null, null, null, null
    println(arrayOfNulls.joinToString())

    val st1 = "ahmet"
    val st2 = "ayse"
    val st3 = "veli"
    val st4 = "derya"
    val studentNames2 = arrayOf(st1, st2, st3, st4)

    val emptyArray = emptyArray<String>()
    // herhangi bir size'ı yok boş bir array. 0 Size'lı bir array, bu array boş bir array.
    val emptyArray2: Array<String> = emptyArray()

    /**
     *      Array'ler sabit büyüklüktedirler. Array'lere ekleme ve çıkartma yapmak aynı String'lerde olduğu gibi
     *      memory'de yeni bir Array oluşturulmasına neden olur.
     */

    var riversArray = arrayOf("Istanbul", "Hatay", "Kars")
    riversArray += "Sivas"
    // Birden fazla eleman eklemek icin
    riversArray += arrayOf("Izmir", "Konya")
    val x = riversArray.joinToString() // Istanbul, Hatay, Kars, Sivas, Izmir, Konya
    println(riversArray.joinToString())
    // joinToString() fonksiyonu array'leri yazdırmamızı sağlar.

    riversArray.forEach {
        println("$it, ")
    }

    riversArray = arrayOf("Afyon", "Canakkale")

    //--------------------------------------------------------------------

    /**
     *      Array<Type>(size){high order function} seklinde tanimlanabilir.
     *      Bu durumda high order function icerisinde son satira denk gelen degerler diziyi olusturur.
     *      High order function, icerisi dizinin boyutu kadar index'i (it) bir arttirarak calisir.
     */

    // 5 elemanli, elemanlari index * 3.14 olan bir dizi olustur.
    val carNamesMini = Array<Double>(5) {
        // pseudo Codes
        // pseudo Codes
        // pseudo Codes

        /**
         * Burada loglama yapabilirsin, error fırlatabilirsin vb vb manipulasyonlar yapabilirsin
         */

        // it bize burada size'ı veriyor
        // return 3.14 * it gibi çalışıyor ama return koyulmuyor
        3.14 * it
        // bu süslü parantezlerin son satırı bize bu array'in içerisindeki elemanı dönüyor olacak.
    }


    var i = 0
    val carNamesMini2 = Array<Double>(5) {
        i = i + 1
        (i * 2).toDouble()
        // bu süslü parantezlerin son satırı bize bu array'in içerisindeki elemanı dönüyor olacak.
    }
    carNamesMini2.forEach {
        //println(it)
    }
    /**
     *      Peki neden bu şekilde high order functions'ları kullanıyoruz da
     *      val studentNums = arrayOf(13, 45, 54, 54, 25, 10) gibi tanımlamıyoruz?
     *
     *      Eğer değerler üzerinde işlemler, manipulasyonlar yapacaksak high order function'ları kullanıyoruz.
     *      Fonksiyonel programlama yaptığınız için kotlin size böyle avantajlar sunuyor.
     *
     */

    // 10 elemanli 0-9 arasindeki index değerlerinin karesini alan bir dizi olusturur.
    val carNames = Array<Int>(size = 10) {
        it * it
    }
    carNames.forEach {
        //println(it)
    }


    /**
     *      ByteArray, ShortArray, IntArray, LongArray, DoubleArray, FloatArray, gibi ya da bunların Unsigned halleri
     *      primitive array tanimlamalari da yapilabilir.
     *
     *      .toCharArray() gibi fonksiyonlarla Object-Type bir array Primitive-Typed bir array'e donusturulur.
     *      .toTypedArray() fonskiyonu ile Primitive-Ryped bir array'i Object-Typed bir array'e dönüştürebilirsiniz.
     *
     *      Bu tarz tanimlamalarda ilgili index degerine atama icin set(index, value) ya da [index] = value kullanılabilir.
     *      Bu tarz tanimlamalarda ilgili index degerindeki degisken degerine get(index) ya da [index] seklinde ulasilabilir.
     *
     *      Not: Set-Get fonksiyonları java syntax'ı gibi. Biz kotlin'de [] kullanıyoruz.
     *
     */

    // Yukarıda da bahsedildiği gibi primitive-typed bir array böyle tanımlanıyor.
    val firstCharOfCountries = CharArray(4)
    // Eger herhangi bir value'ya deger vermemissen, onu null olarak isaretleyecektir.
    firstCharOfCountries[0] = 'T'
    firstCharOfCountries.set(1, 'I')
    firstCharOfCountries.set(3, 'A')

    firstCharOfCountries[2] = 'B'

    println("firstCharOfCountries index 2: ${firstCharOfCountries.get(2)}")
    println("firstCharOfCountries index 2: ${firstCharOfCountries[2]}")

    val charSample: CharArray = arrayOf('T', 'I', 'B', 'I').toCharArray()
    // Sonuna toCharArray() yazarsan daha performanslı olur.

    val charSample2: CharArray = charArrayOf('T', 'I', 'B', 'I')
    // Veya böyle kullanırsan daha performanslı olur
    // arrayOf() object-referance'lıyı verir, charArrayOf primitive referanslıyı verir.
    // object-referance'lıyı toCharArray() ile primitive referanslıya dönüştürebiliriz.
    // böylece performansımız artar.


    //-------------------------------------------------------

    /**
     *      val ile tanimlanmis bir array'in herhangi bir index'indeki deger degistirilebilir.
     *      val indexideki degerlerin degismesine karismaz.
     *      ancak ilgili diziyi baska bir dizi ile esitlemenize izin verilmez.
     *      Bunun icin tanimlamayi var ile degistirmeniz gerekir.
     */


    val awesomeArray = arrayOfNulls<String>(5)
    awesomeArray[2] = "Musti"
    awesomeArray[2] = "qweqw"
    awesomeArray[2] = "dasdas"
    // awesomeArray = arrayOf("foo","boo","goo","doo","loo") // calismaz cunku val tanimlandi

    /**
     *      var ile tanımlarsan + ile size'ını büyütebilirsin.
     *      Aslında bu noktada array'e yer eklenmez, array heap'te tekrardan oluşturulur.
     *
     */
    var variableArray = arrayOfNulls<String>(5)
    variableArray[2] = "Musti"
    variableArray[2] = "qweqw"
    variableArray[2] = "dasdas"
    variableArray += "selam"

    variableArray.forEach {
        println(it)
    }
    println(variableArray.size)

    //------------------------------------

    // 2 boyutlu Array'ler
    val twoDArray = Array(2) { Array(2) { 0 } }
    println(twoDArray.contentDeepToString()) // [[0, 0], [0, 0]]

    // 3 boyutlu Array'ler
    // High Order Functions' ile multidimensional arrays oluşturabiliyoruz
    val threeDArray = Array(3) { Array(3) { Array(3) { 0 } } }
    println(threeDArray.contentDeepToString())
    // contentDeepToString() fonksiyonu multi dimensional array'leri ekrana yazdırmamızı sağlar
    // [[[0, 0, 0], [0, 0, 0], [0, 0, 0]],
    // [[0, 0, 0], [0, 0, 0], [0, 0, 0]],
    // [[0, 0, 0], [0, 0, 0], [0, 0, 0]]]
    // [3x3]
    // Arraylerin içi her zaman değişebilirdir (mutable)


    println(twoDArray[0][0].toString())

    //**
    // Aynı zamanda array'ler üst class'lari yerine atanamazlar (invariant)
    val arrayOfString: Array<String> = arrayOf("V1", "V2")
    //val arrayOfAny : Array<Any> = arrayOfString
    // Any türü bekliyorum bana string veriyorsun diyip type mismatch hatası alıyorum.
    val arrayOfAny2: Array<Any> = arrayOf("V1", "V2")
    // ama aynı eşitlemeyi arrayOf("V1","V2") Any türüne de yapabiliyorum.

    //------------------------------------


    /**
     * vararg kelimesi ile istediğimiz sayıda parametreyi kabul edebiliriz.
     * Eğer vararg'a denk gelecek şekilde bir array kullanmak istiyorsak "spread" "*" operatörünü kullanırız.
     * Spread operatoru verdiğiniz arrayin elemanlarının her birini bir variable olacak şekilde parametre olarak paslar.
     */

    val lettersArray = arrayOf("c", "d")
    printAllStrings("a", "b", *lettersArray, "f", "e")
    println()
    printAllStrings("a", "b", "c", "d")


    //------------------------------------

    /**
     *  Array'leri karşılaştırırken == operatorunu kullanamazsiniz. == operatoru o array'lerin referans object'lerini karşılaştırır.
     *  Ve siz false alırsınız.
     *  contentEquals ya da contentDeepEquals kullanmanız gereklidir.
     *  contentEquals -> tek boyutlu array'in varsa
     *  contentDeepEquals -> çok boyutlu array'in varsa
     */

    val arr1 = intArrayOf(1, 2, 3)
    val arr2 = intArrayOf(1, 2, 3)

    val arr3 = arr1
    val arr4 = arr1


    if (arr1 == arr2) {
        println("\nArr1 == arr2")
    } else {
        println("\nArr1 != arr2")
    }

    if (arr1.contentEquals(arr2)) {
        println("Arr1 contentEquals arr2")
    } else {
        println("Arr1 not contentEquals arr2")
    }

    if (arr3 == arr4) {
        println("Arr3 ve arr4 aynı referanstan üretilmiştir")
    } else {
        println("Arr3 ve arr4 farklı referanstan üretilmiştir")
    }

    if (arr3.contentEquals(arr4)) {
        println("arr3 contentEquals arr4")
    } else {
        println("arr3 not contentEquals arr4")
    }

    //-------------------------------------------------------------------------

    /**
     * https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array
     * fonksiyonlar listesi
     *
     * .sum() -> sadece number typed arrayler ile çalışır.
     * .shuffle -> random karıştırma; elemanları random bir şekilde yer değiştirir
     */


    val sumArray = arrayOf(1,2,3)
    println("Sum of sumArray ${sumArray.sum()}")

    val shuffledArray = arrayOf(1,2,3)

    shuffledArray.shuffle()
    println("shuffledArray.joinToString() : ${shuffledArray.joinToString()}")

    shuffledArray.shuffle()
    println("shuffledArray.joinToString() : ${shuffledArray.joinToString()}")

    //-------------------------------------------------------------------------

    /**
     *  Arrayleri List'e ve Set'e dönüştürebilirsiniz
     */
    val sampleArray = arrayOf("a","b","c","c")
    println("sampleArray to Set : ${sampleArray.toSet()}")

    println("sampleArray to List : ${sampleArray.toList()}")

    //-------------------------------------------------------------------------

    /**
     *  Arrayleri Map'lere de dönüştürebilirsiniz. Ancak bunun için array'in özel olarak Pair<K,V> formunda olması lazım.
     */

    val cities = arrayOf("Istanbul" to 34, "Kars" to 36, "Hatay" to 31)
    println(cities.toMap())
    println(cities.joinToString())

} // end of MAIN

fun printAllStrings(vararg string: String) {
    for (str in string) {
        print("$str, ")
    }
}
