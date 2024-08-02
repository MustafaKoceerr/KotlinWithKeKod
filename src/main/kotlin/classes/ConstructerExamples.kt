package org.example.classes

class ConstructerExamples {

    init {
        println("Init code block")
    }

    var name: String = ""
    var age: Int = 0
    var sex: Boolean = true

    constructor(name: String, age: Int) {
        println("Const1 code block")
        this.name = name
        this.age = age
    }

    constructor(name: String, age: Int, sex: Boolean) {
        println("Const2 code block")
        this.name = name
        this.age = age
        this.sex = true
    }
}

fun main() {
    val obj1 = ConstructerExamples("Musti", 22)
//    val obj2 = ConstructerExamples("Musti",22,true)

    val obj3 = ConstructerExamples4(isMarried = false)
    val obj4 = ConstructerExamples4("Musti",22)



}

class ConstructerExamples2(name: String, age: Int) {
    val age: Int
    val name: String

    init {
        this.age = age
        this.name = name
    }
}
// Üstteki class ile, aşağıdaki class aynı

class ConstructerExamples3(val name: String, val age: Int) {
}


class ConstructerExamples4(name: String = "Musti", age: Int = 22) {
    val name: String
    val age: Int

    init {
        this.name = name
        this.age = age
    }

    var isMarried = false

    constructor(isMarried: Boolean) : this() {
        println("ConstructerExamples4 const cagrildi")
        this.isMarried = isMarried
    }
}