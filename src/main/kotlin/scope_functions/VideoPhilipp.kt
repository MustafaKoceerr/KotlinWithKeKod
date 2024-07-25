package org.example.scope_functions

private var number : Int? = null
private var alsoVar : Int = 0


fun main(){

    /**
     * Number global değişken olduğu için, bu süreçte değişebilir ve if'i geçtikten sonra tekrar null olabilir.
     * another thread sets this number back to null,
     * kotlin is a null safe language
     * Bunu çözmenin bir yolu !! koymak ama eğer number tekrar null olmuşsa program bize crash verir
     *
     * Bunu çözmenin diğer bir yolu let kullanmaktır. Let fonksiyonu ile
     * let?.number yaparsan, eğer scope boyunca number değişkeni değişse bile let içinde bundan etkilenmez.
     * Yani let fonksiyonu just the state of that variable, of that oobject here
     *
     *  Ayrıca bir değişkene atama da yapabilirsin.
     */

//    if (number != null){
//        val number2 = number +1
//    }

    number?.let {
        val number2 = it + 1
    }
    val ifNumberIsNotNullVar = number?.let {
        // pseudo codes
        // pseudo codes
        // pseudo codes
        it*2 + 7
    } ?: 3

    /**
     * Also'yu istediğin objede çağırabilirsin ve objene referans eden bir fonksiyon yaratırsın
     * son satırı let gibi döndürümez
     * bunun yerine çağrılan objeyi return ederiz.
     *
     * (alsoVar * alsoVar).also {it -> }
     * incelikle soldaki değişkeni hesaplayıp, sonucunu it ile obje olarak bize veriyor.
     */

    getSquaredI()
    getSquaredI()

    /**
     * Apply, çok kullanışlı bir fonksiyon, onjeleri modifiye etmekte kullanacaksın.
     * Spesifik bir objede birden fazla değişiklik yapacaksan, bir araya topyalabilirsin.
     *
     * Return olarak uyguladığın objeyi döner
     * Data class'larda kullanışlı olabilir. Örneğin person diye bir dataclass'ın olsun
     * person.apply{
     * name = "musti"
     * age = 22
     * }
     * yapabilirsin. person.name, person.age yapmana gerek kalmaz
     */
//    val intent = Intent().apply{ // this:Intent veriliyor yani her seferinde it veya Intent yazmana gerek yok
//        putExtra("var","")
//        putExtra("var2",0)
//        putExtra("var","") // Intent.putExtra'ya dönüşür
//        action = ""  // Intent.action'a dönüşür
        // //Sonunda yok ama return Intent yapar
//    }

    /**
     * Run'da apply'ın aynısıdır, this ile objeyi alır ve manipüalsyonlarını uygularsın ama bir farkı vardır.
     * return olarak uygulanan objeyi değil sen son satırı döner
     */
    var runReturnsInt: Int = "mustafa".run { // this ile zaten çağırdığımız objeye referans verir.
        this.compareTo("Koc")
        // ikisi arasında fark yoktur.
        compareTo("Koc")
        hashCode()
        get(2)
        length * 3
    }

    /**
     * With ile run arasında fark yoktur. yazımları farklıdır.
     * with içinde yazıldığı objeye referans verir.
     * son satırı return eder
     */
    val withReturnsInt :Int= with("mustafa"){
        this.compareTo("Koc")
        // ikisi arasında fark yoktur.
        compareTo("Koc")
        hashCode()
        get(2)
        length * 3
    }

}

private fun getSquaredI() = (alsoVar * alsoVar).also {
    println("in also funct $it")
    alsoVar++}