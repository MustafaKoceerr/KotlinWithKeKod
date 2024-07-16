package org.example.functions


fun main() {
    qoo(::wooFun, ::rooFun, yoo = ::yooFun, poo = ::pooFun, doo =::dooFun )
    qoo(::wooFun, ::rooFun, ::tooFun, ::yooFun, ::pooFun, ::dooFun)
}

private fun wooFun() {

}

private fun rooFun(number: Int): String {
    return number.toString()
}

private fun tooFun(number: Int): String {
    return number.toString()
}

private fun yooFun(message: String, number: Int): String {
    return "$message : $number"
}

private fun sooFun() {
    println("SooFun cagirildi")
}

private fun pooFun(soo: () -> Unit) {
    soo()
}

private fun fooFun() {
    println("FooFun cagirildi")
}

private fun dooFun(foo: () -> Unit): () -> Unit {
    println("FooFun cagirildi")
    foo()
    return ::returnEdilenFun
}

private fun returnEdilenFun() {
    println("returnEdilenFun'a girdi")
}

fun qoo(
    woo: () -> Unit,
    roo: (Int) -> String,
    too: (Int) -> String = ::defaultToo,
    yoo: String.(Int) -> String,
    poo: (soo: () -> Unit) -> Unit,
    doo: (foo: () -> Unit) -> () -> Unit
) {
    woo()
    val resultRoo: String = roo(5)
    val resultToo: String = too(4)
    val resultYoo: String = yoo("musti", 49)
    val resultYoo2: String = "mesaj".yoo(49)
    println("--------------------------")

    poo.invoke {
        sooFun()
    }
    poo({
        sooFun()
    })

    poo(::sooFun)
    println("\n")

    val returnFun = doo.invoke {
        fooFun()
    }

    val returnFun2 = doo({
        fooFun()
    })

    val returnFun3 = doo(::fooFun)
    println("")

    println("\nReturnFunInvoke")
    returnFun.invoke()
    returnFun2.invoke()
    returnFun3.invoke()
    println("\nReturnFun Normal")
    returnFun()
    returnFun2()
    returnFun3()

}

private fun defaultToo(number: Int): String {
    return number.toString()
}