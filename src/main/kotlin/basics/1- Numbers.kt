package org.example.Basics/*
*Değişkene değer ataması yapılırken maksimum performans almak için doğru değişken tipini kullanmak önemlidir.
* Bunu için değişkenlerin değer aralıklarını kontrol edip buna göre atama yapabilirsin.
*
* Sayısal bir değere bir değer atanırken, eğer sayi Int ifadeden büyük değilse ve tip belirtmezsek INT
*
* eğer sayı Int ifadeden büyükse default olarak tipi long set edilir.
*
* Byte  8 bit -> 128
* Short  16 bit -> 32,767
* Int  32 bit -> 2,147,483,647 (2^31 -1)
* Long  64 bit -> (2^63 -1)
*
* Min value = 0 yaparak
* UByte  8 bit -> 255
* UShort  16 bit -> 65,535
* UInt  32 bit -> 4,294,967,295 (2^32 -1)
* ULong  64 bit -> (2^64 -1)
*
* Type inferance -> Değişkenin tipini belirtmeden, idenin otomatik bir tip atamasıdır.
*/

/*
* Long değişkenler için sayının sonuna "L" konularak değer atamasi yapilabilir.
* Float değişkenler için sayinin sonuna "F" veya "f" konularak değer atamasi yapilabilir
* Double değişkenler için geleneksel gosterim desteklenir
* Decimal tanimi yapilabilir   [0-9]
* Octal tanimi yapilabilir     [0-8]
* Hexadecimal tanimi yapilabilir
* Binary tanimi yapilabilir
 */

class MyNums {
    val longNumber = 1554L
    val floatNumber1 = 19.03F
    val floatNumber2 = 22f
    val doubleNumber = 3.14
    val doubleNumber2 = 3.14e10
    val decimalNumber = 1907

    //val ocatalNUmber = 0183 // calismaz
    val hexadecimalNumber = 0x759
    val binaryNumber = 0b01000011

/*
* Number değişken tanımı yapilirken underscore "_" kullanilabilir.
* Ide bunu görmezden gelir
*/

    val oneMillion = 1_000_000
    val creditCartNumber = 1234_5678_1234_5678L
    val bytes = 0b01000011_01101111_01100101_01101101_01111001

}

fun main() {
    val binaryNumber = 0b11111111
    println(binaryNumber)

    val bitValue = 0b11111111
    val bitValue2 = 0b10101001

    val resultBit = bitValue.and(bitValue2) // bitValue && bitValue2
    // bit düzeyinde işlemler yapılır
    println("resultBit : $resultBit")

}

