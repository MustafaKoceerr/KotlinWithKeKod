package org.example.controlflow

data class PairNumber(val numberOne: Int, val numberTwo: Int) {

    // NOT: Operatörleri ismine uygun kullan. Örneğin minus fonksiyonunda alakasız işlemler veya çarpma işlemleri yapma
    // çıkartma işlemleri yap. Üzerine ekstra yapman gerekn bir şeyler varsa onları yap. Örn: Her çıkartma işleminde Loglama
     operator fun minus(pairNumber: PairNumber): PairNumber {
        val returnPairObject = PairNumber(
            this.numberOne - pairNumber.numberOne,
            this.numberTwo - pairNumber.numberTwo
        )
        println("Sonuc = (${returnPairObject.numberOne}, ${returnPairObject.numberTwo})")
        return pairNumber
    }

    operator fun plus(value: Int): Int{
        return this.numberOne + value
    }

    operator fun invoke(){
        // bir lambdanın çağırılabilmesini sağlayacak.
    }


}

/*
  operator fun String.plus(value: String): Int{
    return this.toInt() + value.toInt()
    }
 */


fun main() {

    val pairNumberOne = PairNumber(2, 4)
    val pairNumberTwo = PairNumber(-8, 11)

    val resultOne = pairNumberOne.numberOne - pairNumberTwo.numberOne
    val resultTwo = pairNumberOne.numberTwo - pairNumberTwo.numberTwo
    // bu sekilde yaparsam tek tek ugrasmak zorunda kalacagim
    // Ama minus'u override ederek bu isten kurtuluyorum

    /**
     * Class'ımızdaki fonksiyonda operator keyword'ünü kullanarak bu işlemin - ile de yapılabilmesini sağladık
     *  pairNumberOne - pairNumberTwo
     */

    val pairNumber = pairNumberOne.minus(pairNumberTwo)
    val pairNumber2 = pairNumberOne - pairNumberTwo
    println("pairNumber === pairNumber2 ? ${pairNumber === pairNumber2}")

    pairNumber + 10 // ctrl ile + işaretine tıklayabilirsin.
    pairNumber2.plus(20)

}