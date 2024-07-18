package org.example.functions

fun main() {
    // inline yapmazsan, main'de nesne oluşturuyor, nesne main'de oluşturuluyor, çağırdığın yerde oluşturuluyor
    calculate(2, 54) { num1, num2 ->
//        if (num2==0) return
        num1 + num2
    }
}

//      BURASI BİZDEN BİR FONKSİYON BODY'Sİ BEKLİYOR. BİZ DE BODY'DE NUMBERONE,NUMBERTWO, OILARAK (INT,INT) VERİYORUZ VE
//      İÇERİDE FONKSİYONUMUZU CALL EDİYORUZ.
//    operation.invoke(num1, num2) VEYA
//    operation(num1, num2) İLE. BU DA BİZE GERİYE BİR INT DEĞER DÖNDÜRÜYOR. YANİ LOG FONKSİYONUNDA PARAMETRE OLARAK İSTEDİĞİ GİBİ
//      (INT,INT) -> INT VERDİĞİMİZ BİR FONKSİYON OLMUŞ OLUYOR


//logger(numberOne, numberTwo) {
//    num1, num2 ->
//    operation.invoke(num1, num2)
////        operation(num1,num2) // bu da calisir, ayni seydir.
//}

inline fun calculate(
    numberOne: Int, numberTwo: Int, crossinline operation: (Int, Int) -> Int
) {
//logger(numberOne, numberTwo, operation) // calismaz cunku nesne bekliyor, noinline yap diye öneri veriyor.
    println("Calculate fun cagrildi")
    logger(numberOne, numberTwo) { num1, num2 ->
        val result = operation.invoke(num1, num2)
        result
    
//        operation(num1,num2) // bu da calisir, ayni seydir.
        /*
        logger fonksiyonunda bu satıra gelince, operation'u almak için buraya dönüyor.
        val result = operation(numberOne, numberTwo)
        Buraya döndükten sonra da bu kısıma operation'u mainden verdiğimiz için main'e gidecek.
        Aslında biz operation'u burada parametre olarak logger fonksiyonuna göndermiş oluyoruz.
        Main'de öğreniyor, fonksiyonu çağırıyor ve bunu nerede çağırmıştı?
        Logger fonksiyonundaki şu satırda:
        val result = operation(numberOne, numberTwo)
        Bu satırın altından devam ediyor. Result'ı yazdırıp çıkıyor.
         */
    }

// FARKLI GOSTERIM 2
// üstteki ile aynı is
//    logger(numberOne,numberTwo,{ num1, num2 ->
//        operation.invoke(num1, num2)
// ikisi de doğru, ikisinden birini tercih edebilirsin.
//        operation(num1, num2)
//    })

// FARKLI GOSTERIM 3
// üstteki ile aynı is
//    logger(numberOne,numberTwo,{ num1, num2 ->
// Aslında invoke ile yazdığımız ifadeler, inline fonksiyon içinde olduğumuz için fonksiyonun gövdesini alabiliriz.
// fonksiyonun gövdesini main'den aldığımızda
    /*
    { num1, num2 ->
    //        if (num2==0) return
    num1 + num2
    }
    */
// bu şekilde bir kod oluşuyor. Bunda return olmadığını garantilemek için crossinline koyuyorum

//    })
}


// inline değil dolayısıyla nesne bekliyor.
fun logger(
    numberOne: Int, numberTwo: Int, operation: (Int, Int) -> Int
) {
    println("logger fun cagrildi")
    val result = operation(numberOne, numberTwo)
    println("Result: $result")
}

/**
 * Eğer bir inline olmayan HighOrderFonksiyonu, inline olan bir HighOrderFonksiyon'un içerisinde call etmek istersek,
 *
 */


inline fun calculate10(
    numberOne: Int, numberTwo: Int, operation: (Int, Int) -> Int
) {
    val result = operation(numberOne, numberTwo)
// inline olunca şöyle düşünebilirsin, body'yi olduğu gibi kopyalıyor.
    /*
    val result = { num1, num2 ->
    num1 + num2
    }
    */
    println("Result: $result")
}