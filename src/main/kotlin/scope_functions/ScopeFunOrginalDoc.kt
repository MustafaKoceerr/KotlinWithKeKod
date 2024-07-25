package org.example.scope_functions

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
 *
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
     * run, with v apply objeyi this ile referans eder.
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

}

private fun externalFunction(){
    println("Hello I am an external function!")
}