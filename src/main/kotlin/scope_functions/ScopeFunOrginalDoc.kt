package org.example.scope_functions

import kotlin.random.Random

/**
 * Kotlin standart kütüphanesi, bir kod bloğunu bir nesne bağlamında çalıştırma amacına sahip birkaç fonksiyon içerir.
 * When you call such a function on an object with a lambda expression provided, it forms a temporary scope.
 * In this scope, you can access the object without its name.
 * Such functions are called scope functions.
 * There are five of them: let, run, with, apply, and also.
 *
 * Basically, these functions all perform the same action: execute a block of code on an object.
 * What's different is how this object becomes available inside the block and what the result of the whole expression is.
 *
 * Scope functions don't introduce any new technical capabilities, but they can make your code more concise and readable.
 * concise -> özlü, kısa
 *
 * Due to the many similarities between scope functions, choosing the right one for your use case can be tricky.
 * The choice mainly depends on your intent and the consistency of use in your project
 * consistency -> tutarlılık
 *
 * Below, we provide detailed descriptions of the differences between scope functions and their conventions.
 */


/**
 * Function selection
 * Function - Object refreance - Return Value - Is Extension Function
 *
 *  Let         it          Lambda Result           Yes                                          object.let{ }
 *  run         this        Lambda Result           Yes                                          object.run{ }
 *  run         -           Lambda Result           No: called without the context object        run(object){  }
 *  with        this        Lambda Result           No: takes the context object as an argument  with(object){  }
 *  apply       this        Context Object          Yes                                          object.apply{ }
 *  also        it          Context Object          yes                                          object.also{ }
 *
 *  Detailed information about these functions is provided in the dedicated sections below.
 *
 *  NEYE GORE NE KULLANAYIM ?
 *
 *  -Executing a lambda on non-nullable objects: let
 *  -Introducing an expression as a variable in local scope: let
 *  -Object configuration: apply
 *  -Object configuration and computing the result: run
 *  -Running statements where an expression is required: non-extension run
 *  -Additional effects: also
 *  -Grouping function calls on an object: with
 *
 *  Bunların kullanımları birbirleriyle örtüşebilir, Bu yüzden projede veya takımının nasıl kullandığına göre birini tercih edebilirsin.
 *
 *  Scope functions kodunu daha anlaşılır yapsa da, aşırı kullanmamaya çalış. Çünkü aşırı kullanım
 *  kodunu okunması zor hale getirebilir ve hatalara yol açabilir.
 *  Ayrıca biz iç içe scope functions'ları kullanmamanı ve onları zıncirleme kullanırken dikkatli olmanı tavsiye ediyoruz.
 *  Çünkü şu anki durumun ne olduğu hakkında kafanın karışması çok kolay
 */

/**
 * Farklılıklar:
 *
 * Scope functions'lar doğası gereği birbirine benzerler fakat önemli olan farklılıkları anlamaktır.
 * Her bir scope function'da 2 temel fark vardır.
 * 1- Kullandığın objeji nasıl refer ettiği,
 * 2- Döndürdükleri değeri.
 */

/**
 * Context object: this or it:
 *
 * Her bir lambda ifadesinde context obje (scope function uygulanan obje) this veya it adında bir lamda temsiline sahip oluyor.
 * İkisi de aynı kapasiteye sahip,
 * Bu nedenle, her birinin farklı kullanım senaryoları için avantaj ve dezavantajlarını açıklıyor ve kullanımları için önerilerde bulunuyoruz.
 */

private class Person(val name: String, var age: Int = 22, var city: String = "Paris") {
    fun moveTo(newCity: String) {
        this.city = newCity
    }

    fun incrementAge() {
        this.age++
    }

    override fun toString(): String {
        return "Name: $name, age: $age, city: $city"
    }
}

fun main() {
    Person("Alice", 21, "Amsterdam").let {
        println(it)
        it.moveTo("Berlin")
        it.incrementAge()
        println(it)
    }
// If you write the same without let, you'll have to introduce a new variable and repeat its name whenever you use it.
    val alice = Person("Alice", 20, "Amsterdam")
    println(alice)
    alice.moveTo("London")
    alice.incrementAge()
    println(alice)

    println("--------------------------------------------------------->")
    val str = "Hello"
    // this
    str.run {
        println("The string's lenght : $length")
//        println("The string's lenght : ${this.length}")  // does the same
    }

    // it
    str.let {
        println("The string's lenght : ${it.length}")
    }
    /**
     * THIS:
     *
     * run, with v apply objeyi default olarak this ile referans eder.
     * Nesne, sıradan sınıf fonksiyonlarında olduğu gibi kullanılabilir durumdadır.
     *
     * Kodu daha kısa yapmak için this keyword'ünü çıkartabilirsin, kullanmayabilirsin.
     * Diğer bir yandan this kullanmamak, çağırdığımız objenin mi yoksa,
     * dışarıdan gelen bir değişkenin veya fonksiyonun çağrımımı bunu ayırt etmemizi zorlaştırır
     *
     * This kullanan bir fonksiyon seçilmesi;
     * genellikle nesnenin işlevlerini çağırarak veya özelliklerine değer atayarak nesnenin üyeleri üzerinde çalışan lambda ifadeleri için önerilir.
     */
    var externalVariable = 10
    val adam = Person("Adam").apply {
        externalVariable = 20
        externalFunction()

        age = 20
        city = "London"
        incrementAge()
    }
    println(adam)

    /**
     * IT:
     * let ve also, lambda fonksiyonun içinde referans default değer olarak it'i sağlar.
     * It, this gibi örtük olarak obje'ye ulaşım sağlamaz, açıkça it.property olarak belirtmek zorundasın.
     *
     * Bu nedenle, nesnenin genellikle işlev çağrılarında bir argüman olarak kullanıldığı durumlarda, bağlam nesnesine it ile erişmek daha iyidir.
     *
     * Ayrıca birden çok değişkenin kullanıldığı durumda it'in kullanımı daha iyidir.
     */


    /**
     * RETURN VALUE:
     * Scope functions'lar döndürdükleri sonuçlar ile de ayrılırlar.
     * apply ve also, context objenin kendisini döndürür
     * let, run, with lambda sonucunu yani son satırı döndürür.
     *
     * Birini kullanmadan önce neyi döndürmek istediğini dikkatlice düşünmelisin, bu hangi scope function'u kullanacağını seçmekte sana yardımcı olacaktır.
     */

    /**
     * Context Object:
     * Apply ve also'nun döndürdüğü şey, context objenin kendisidir.
     * Bu nedenle zincir çağrımlarda rahatlıkla kullanabilirsin.
     *
     * Aynı obje üzerinde zincirleme fonksiyonları sürdürebilirsin.
     * Ayrıca fonksiyonlar return object olarak da kullanılabilirler
     *
     */
    val numberList = mutableListOf<Double>()
    numberList.also { println("Populating the list") }
        .apply {
            add(2.71)
            add(3.14)
            add(22.0)
        }
        .also { println("Sorting The List") }
        .sort()
    // Ayrıca fonksiyonlar return object olarak da kullanılabilirler
    val randomNumber = getRandomInt()
    println(randomNumber)

    /**
     * Lambda Result:
     * let, run ve with lambda result döndürürler. Böylece değişkenlere döndürdükleri sonuçları atayabilirsin.
     *
     * Objenin kendisi değil de Result döndürüp onunla zincirleme işlem yapacağında kullanabilirsin.
     *
     * Ayrıca return value'yu ignorelayıp, fonksiyon içinde local değişken tanımlayabilirsin.
     */

    val numbers = mutableListOf("one", "two", "three")
    val countEndsWithE = numbers.run {
        add("four")
        add("five")
        count {
            it.endsWith("e")
        }
    }
    println("There are $countEndsWithE elements that end with e.")
//     Ayrıca return value'yu ignorelayıp, fonksiyon içinde local değişken tanımlayabilirsin.
    with(numbers) {
        val firstItem = first()
        val lastItem = last()
        println("First item $firstItem, last item $lastItem")
    }

    /**
     * FUNCTIONS:
     * Doğru scope fonksiyonunu seçmen için detayını tarif edeceğiz ve önerdiğimiz kullanımları örneklerle sağlayacağız.
     * Teknik olarak scope fonksiyonlar değişken olarak kullanılabilirler.
     * Örneklerde alışıla gelmiş kullanımlarını göreceksiniz.
     */

    /**
     * LET:
     * The context object is available as an argument (it).
     * The return value is the lambda result.
     *
     * "let", çağrı zincirlerinin sonuçları üzerinde bir veya daha fazla fonksiyon çağırmak için kullanılabilir.
     * Eğer kullanacağımız fonksiyon bir taneyse HOF özelliği olarak ::funname ile fonksiyonu passlayabiliriz.
     *
     * Genelde nullable bir objemiz varsa (?.) safe call operatörü ile birlikle
     * obje üzerinde işlemler yaparken kullanılır
     */
//    val numbers = mutableListOf("one", "two", "three")
    val resultList = numbers.map { it.length }.filter { it > 3 }
    println(resultList)
    // Burada buna gerek yok let kullanarak yeni bir değişkene atamamız gerekmeyebilirdi
    numbers.map { it.length }.filter { it > 3 }.let {
        println(it)
        // and more function calls if needed
    }
    // Eğer kullanacağımız fonksiyon bir taneyse HOF özelliği olarak ::funname ile fonksiyonu passlayabiliriz.
    numbers.map { it.length }.filter { it > 3 }.let(::println)

    val str2: String? = "Hello"
    val lenght: Int? = str2?.let {
        println("let() called on $it")
        // processNonNullString(it) // some functions need non null parameter
        it.length
    }
//    başka bir örnek
    val modifiedFirstItem = numbers.first().let { firstItem ->
        println("The first item of the list is $firstItem")
        if (firstItem.length >= 5) firstItem else ("!$firstItem!")
    }.uppercase()
    println("First item after modifications: $modifiedFirstItem")


    /**
     * WITH
     * The context object is available as a receiver (this).
     * The return value is the lambda result.
     *
     * with bir extension function değildir, parametre olarak context object'i verirsin.
     * fakat lambda'nın içinde default receiver olarak this'i kullanırsın.
     *
     * Biz with'i döndürülen sonuç gerekmiyorsa ve fonksiyon kullanacaksan with'i kullanmanı öneririz.
     *
     * with'i bir yardımcıyı tanıtırken, object'in properties'ini veya function'u hesaplama yapmak için kullanacaksan öneririz.
     */
    with(numbers) {
        println("With is called with argument $this")
        println("it contains $size elements")
    }
    // with'i bir yardımcıyı tanıtırken, object'in properties'ini veya function'unu hesaplama yapmak için kullanacaksan öneririz.
    val firstAndLast = with(numbers) {
        "The first element is ${first()}," +
                "The last element is ${last()},"
    }
    println(firstAndLast)


    /**
     * RUN:
     * The context object is available as a receiver (this).
     * The return value is the lambda result.
     *
     * run with ile aynı çalışır fakat extension function'dur. Yani with gibi parametre olarak vermezsin de
     * nokta (.) ile objenin sonunda çalıştırırsın.
     *
     * run lambda returnu yapar, objeyle işlem yapıp, value return'lemek için kullanışlıdır.
     *
     * Ayrıca run'ı non-extension function olarak da kullanabilirsin.
     * Non-extension varyantı context objesine ihtiyaç duymaz fakat lambda result dönmeye devam eder.
     * Non-extesinon run bir açıklamanın, ifadenin gerekli olduğu durumlarda birden fazla ifadeyi içeren
     * bir blok çalıştırmanıza olanak tanır.
     * Kod bloğunda "run the code block and compute the result." olarak düşünülebilir.
     */

    val service = MultiportService("https://example.kotlinlang.org", 80)
    val runResult = service.run {
        port = 8080
        query(prepareRequest() + " for port $port")
    }
    println("run Service result $runResult")

    // the same code written with let() function:
    val letResult = service.let {
        it.port
        it.query(it.prepareRequest() + " for port ${it.port}")
    }
    println("let Service result $runResult")

    // Non-extension varyantı
    val hexNumberRegex = run {
        val digits = "0-9"
        val hexDigits = "A-Fa-f"
        val sign = "+-"

        Regex("[$sign]?[$digits$hexDigits]+")
    }

    for (match in hexNumberRegex.findAll("123 -FFF !%*& 99 XYZ")) {
        println(match.value)
    }


    /**
     * APPLY:
     * The context object is available as a receiver (this).
     * The return value is the object itself.
     *
     * Apply objenin kendisini döndürdüğü için, objen üstünde işlemler yaptığın,
     * objenin property'lerini ve fonksiyonlarını kullandığın, fakat return yapmadığın durumlarda kullanmanı tavsiye ederiz.
     *
     * Apply'ın en çok kullanıldığı yer object configration'dur.
     * Böyle çağrılar şöyle okunabilir: Bu atamaları objeye uygula. ("apply the following assignments to the object.")
     *
     * Başka bir apply kullanımı da zincirleme çağırımlarda daha karmaşık işlemler yapmak için kullanılmasıdır.
     */
    val applyPerson = Person("Adam").apply {
        age = 32
        city = "Dusseldorf"
    }
    println(applyPerson) // Name: Adam, age: 32, city: Dusseldorf


    /**
     * ALSO:
     * The context object is available as an argument (it).
     * The return value is the object itself.
     *
     * Yan İşlemler: also, bir nesne üzerinde işlemler yaparken aynı zamanda bazı yan işlemler (loglama, doğrulama) yapmak için kullanılır.
     * Also, context objeyi parametre olarak alıp, bir kaç actions uygulamak için kullanışlıdır.
     * Objenin properties'lerine ve fonksiyonlarına çok ihtiyaç duymadığında ama obje üzerinde işlem yapacağında also kullanabilirsin.
     * Also, it kullandığı için üst scope'da this varsa also kullanabilirsin. Böylelikle this ile kafa karışıklığı yaşanmamış olur.
     *
     * Also'yu kodunda gördüğünde şöyle okuyabilirsin: Ve ayrıca objeyle şunları da yap. "and also do the following with the object."
     */
    numbers
        .also { println("The list elements before adding new one $it") }
        .add("six")
    println("The list elements after adding new one $numbers")


    /**
     * TAKELF AND TAKEUNLESS:
     * Scope fonksiyonlara ek olarak, standart Kotlin kütüphanesi takeIf ve takeUnless fonksiyonlarını içerir.
     * Bu fonksiyonlar, bir nesnenin durumunu çağrı zincirlerinde kontrol etmenize olanak tanır.
     *
     * takeIf eğer verilen koşulu sağlıyorsa objeyi döner, sağlamıyorsa null döner.
     * Yani aslında tek bir obje için filtreleme fonksiyonudur.
     *
     * takeUnless tam tersi bir logic'e sahiptir. Verilen koşul sağlanıyorsa null döner, sağlanmıyorsa objeyi döner.
     *
     * takeIf veya takeUnless kullanırken, obje lambda'da it argumanı olarak verilir.
     *
     * takeIf veya takeUnless fonksiyonlarını zincilemede kullanıyorsan, safe call (?.) işaretini kullanmayı unutma.
     * Çünkü bu fonksiyonlar null değer döndürebilirler.
     */

    val randNumber = Random.nextInt(100)

    val evenOrNull = randNumber.takeIf { it % 2 == 0 }
    val oddOrNull = randNumber.takeUnless { it % 2 == 0 }

    println("number: $randNumber, even: $evenOrNull, odd: $oddOrNull")

    val helloMessage = "Hello"
    val caps = helloMessage.takeIf { it.isNotEmpty() }?.uppercase()
//    val caps2 = helloMessage.takeIf { it.isNotEmpty() }.uppercase() // compile error alırsın
    println(caps)


    /**
     * takeIf ve takeUnless, scope funcitons'larla beraber oldukça kullanışlıdırlar.
     * Örneğin, takeIf veya takeUnless ile let fonksiyonunu kullanarak, verilen koşula göre bir blok yazabilirsin.
     * Bunu yapmak için let'i safe call (?.) ile çağırman gerekli.
     * Eğer obje koşulu sağlamazsa takeIf sağlarsa takeUnless null döndürecektir ve let bloğundaki işlemler yapılmayacaktır.
     */
    displaySubstringPosition("010000011", "11")
    displaySubstringPosition("010000011", "12")

    displaySubstringPositionSecond("010000011", "11")
    displaySubstringPositionSecond("010000011", "12")

}

class MultiportService(var URL: String, var port: Int) {
    fun query(queryString: String) {
        println("Querry sended. Query: $queryString ")
    }

    fun prepareRequest(): String {
        // pseudo code
        // pseudo code
        return "Prepared"
    }
}

private fun externalFunction() {
    println("Hello I am an external function!")
}

private fun getRandomInt(): Int {
    return Random.nextInt(100).also {
        println("getRandomInt generated : $it")
    }
}

private fun getRandomInt2(): Int {
    return Random.nextInt(100).also { value ->
        println("getRandomInt generated : $value")
    }
}


fun displaySubstringPosition(input:String, sub:String){
    input.indexOf(sub).takeIf { it>0 }?.let {
        println("The substring $sub is found in $input.")
        println("Its start position is $it.")
    }
}

fun displaySubstringPositionSecond(input:String, sub: String){
    input.indexOf(sub).takeIf { it>0 }?.let {
        println("The substring $sub is found in $input.")
        println("Its start position is $it.")
    }
}