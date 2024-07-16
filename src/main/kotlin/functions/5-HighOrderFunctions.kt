package org.example.functions


fun main() {

    /**
     *      Fonksiyonlar Kotlin'de "First Class Citizen"dır. Yani degiskenlere deger olarak atanabilir, baska fonksiyonlara
     *      parametre olarak verilebilir ya da bir fonksiyonun geri donus degeri olabilir demektir.
     *
     *      High Order Function'lar bastice bir fonksiyona parametre olarak verilen fonksiyonlardır. Parametre olarak
     *      verilmekten kasit, fonksiyonun cagriminin parametre kisminde yapilmasi degil, fonksiyonun govdesinin (body)
     *      yani suslu parantezler arasinda kalan gorev alaninin baska bir fonksiyona parametre olarak verilmesidir.
     *      ***BODY'Yİ PARAMETRE OLARAK VERİYORUZ.
     *
     *      Yapisal olarak;
     *
     *      fun foo(normalFunction: (message:String) -> Unit){
     *          higherOrderFunction("Codemy")
     *      }
     *
     *      Cagrilirken ;
     *      fun main(){
     *
     *      foo({ message->
     *      println("Message : $message") })
     *
     *      }
     */
}

//---------------------------------------------------------------------------------------------------

/**
 *      High Order Function'lari tanimlamanin 4 yolu vardir.
 *
 *      1- Bir degiskene atayarak Function tanimlayabilirsiniz.
 *      Bu durumda suslu parantezler yanina higher order function'in aldigi parametreler lambda okundan once aralarina
 *      koyularak yazilir. Higher Order Function tek parametre aliyorsa, bu parametreleri yazmak zorunda değilsinizdir.
 *      Bu durumda higher order function size "it" kelimesi ile higher order function'in parametresi tipinde bir değişken alir.
 */

// Degisken gibi gozukse de bu aslinde bir fonksiyon
val higherOrderFunction = { surname: String ->
    "Surname : $surname"
}

/**
 *      High Order Function'lari tanimlamanin 3 yolu vardir.
 *
 *      2- Ismi olmayan "anonymous function" tanimlamalari da HigherOrderFunction olarak normal bir fonksiyona parametre
 *      olarak verilebilir
 *
 *      2.2- Anonymous Function'un expression kullanimini da yine HigherOrderFunction olarak normal fonksiyona
 *  *      parametre olarak verilebilir
 */

val anonymousFunction = fun(surname: String): String {
    return "Surname : $surname"
}

val anonymousFunction2 = fun(surname: String): String = "Surname : $surname"


/**
 *      High Order Function'lari tanimlamanin 3 yolu vardir.
 *
 *      3- Normal bir fonksiyon yazip ::Function ile fonksiyonu çağırma
 *
 *      En test edilebilir ve en güzel yöntem 4. yöntem.
 *      Diğer 3'ünü test edebilmek için main fonksiyona test yazman gerekiyor. Ama bunun testini direkt fonksiyona yazabiliyorsun.
 *      Bu yöntem sayesinde business logic'i ayırabiliyoruz.
 */

private fun normalFunctionWillGiveAsParameter(surname: String): String {
    return "Surname : $surname"
}

private fun normalFunctionWillGiveAsParameter2(surname: String): String = "Surname : $surname"

/**
 *      High Order Function'lari tanimlamanin 3 yolu vardir.
 *
 *      4- Normal bir fonksiyon yazip ::Function ile fonksiyonu çağırma
 *      Eğer HOF tek parametre olarak fonksiyon alıyorsa
 *      Eğer HOF son parametre olarak verilmişse, süslü parantezleri yuvarlak parantezlerin dışına yazabiliyoruz.
 */

//calculateAndPrint(2, 4){ numberOne, numberTwo -> numberOne / numberTwo }

//-----------------------------------------------------------------------------------------------------

/**
 *      Bir Higher Order Function'ina parametre verirken Class ismi() seklinde tanimlama yapilabilir.
 *      Bu sayede ilgili class da paramtere parantezi icerisine yazilabilir.
 */

// mainde
/*
    // parametre olarak verdiğimiz fonksiyon bir extension fonksiyon ise bu sekilde cagiriyoruz
    calculateAndPrint9(2,4,
        { numberOne:Int, numberTwo:Int ->
            println("verdigim veya cagirdigim string "+this  )
            numberOne/numberTwo})
    // bu sekilde cagirirken sinifin bir ozelligini de kullanabiliriz cunku this dedigimiz sey aslında
    // elimizde bu örnek için çağırdıgımız string

 */

/*

fun calculateAndPrint9(
    numberOne: Int = 4, numberTwo: Int = 5,
    operation: String.(Int, Int) -> Int
) {
    val result = "musti".operation(numberOne, numberTwo)
    // veya bu sekilde bir string parametre daha istiyor, cunku string function'a extension function verdik
    // extension funciton da biliyorsun byte code'a cevirmistik, kendisini her zaman parametre olarak aliyordu
    val result2 = operation("mustimustimustii",numberOne, numberTwo)
    println("Result: $result")
}
 */


