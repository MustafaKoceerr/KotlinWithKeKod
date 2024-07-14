package org.example.controlflow

data class PairNumber(val numberOne: Int, val numberTwo: Int) {

    operator fun minus(pairNumber: PairNumber): PairNumber {
        val returnPairObject = PairNumber(
            this.numberOne - pairNumber.numberOne,
            this.numberTwo - pairNumber.numberTwo
        )
        println("Sonuc = (${returnPairObject.numberOne}, ${returnPairObject.numberTwo})")
        return pairNumber
    }

}


fun main() {

}