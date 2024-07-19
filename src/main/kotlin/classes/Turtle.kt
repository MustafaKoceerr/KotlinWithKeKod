package org.example.classes

// normalde constructer, böyle özel olarak belirtilmez.
// modifier veya anotation veriyorsan böyle belirtirsin.
class Turtle constructor(
    var feetCount: Int = 4, var name: String = "Brown"
) {
    // Eğer primary constructer yazmazsan, sen yazmasan bile default bir boş primary constructer tanımlı.
    /**
     * init primary constructer çağırıldığı zaman çalışan kod bloğudur.
     * Nesne oluşturulurken ilk çalışan şeydir.
     *
     * ***Farkettiysen primary constructer'ın bir body'si yok.
     * Bu body nerede? init bloğunda.
     *
     *  ONEMLI NOT: Primary const ile de Secondary const ile de nesneyi üretirsen,
     *  init bloğu her nesne oluşturduğumuzda ilk çalışacak bloktur.
     */
    init {
        println("Primary constructer created")
    }


    /**
     * Kotlinde 2 farklı türde consturcter vardır.
     * 1- Primary constructer
     * 2- Secondary constructer
     *
     * Primary Constructer ->
     *      Class'ın yanına () açarsın,  ve istediğin değerleri yazarsın
     *
     * Secondary Constructer ->
     *      Secondray constructer'ın sonuna :this() ile primary constructer'ı işaret etmelisin
     *      Secondary constructer, primary'nin default değer içermeyen tüm değişkenlerini içermek zorundadır.
     *      el ile de atayabiliriz ama bu çirkin bir kod yazımı olur. Bu yüzden secondary'de parametre olarak alıp
     *      primary constructer'a aktarmamız gereklidir.
     *
     *      Kotlin'de Java'daki gibi birbirinden bağımsız secondary constructer'lar yazamıyoruz.
     *      Her bir constructer primary constructer'a this() ile referans vermek zorunda.
     *
     * Kotlinde genelde fazla secondary constructer kullanılmıyor.
     * Default değer verip, init bloğunda halletmek şeklinde çözülüyor. 
     *
     *
     * */
    constructor(name: String = "Tosbik", feetCount: Int = 4, isMarried: Boolean) : this(
        feetCount = feetCount, name = name
    ) {
        this.feetCount = feetCount
        this.isMarried = isMarried
        println("Secondary constructer created")

    }

    val feetColor: String = "Brown"
    val headCount: Int = 1
    val headColor: String = "Brown"
    val shelterColor: String = "Green"
    val tailCount: Int = 1
    val tailColor: String = "Brown"
    val age: Int = 1
    val sex: String = "Male"
    var isMarried: Boolean = false

    fun makeASount(): String {
        return "ghhsdıgsd"
    }

    fun eatMeal() {}
    fun walk() {}
    fun swim() {}
}

fun main() {
    val turtleOne: Turtle = Turtle() // constructer parantezleri
    /**
     * Nesnemizi constructer'lar aracılığıyla oluşturuyoruz.
     * Constructer'lar sayesinde bir instance variable'a değer atayabiliyoruz.
     *
     * Nesne aracılığıyla class'ın içindeki tüm public fonksiyonlara ve variable'lara erişebiliyoruz.
     *
     */
    turtleOne.name = "Murtle"
    turtleOne.walk()
    anotherWalk()

    val turtleTwo: Turtle = Turtle(feetCount = 4) // constructer parantezleri
    val turtleThree: Turtle = Turtle(feetCount = 4, name = "Gray") // constructer parantezleri
    val turtleFour: Turtle = Turtle(name = "Gray") // constructer parantezleri

    /**
     * Eğer primary constructer'a default değer verirsen, üstteki gibi istediğin tanımlamaları yapabiliyorsun
     * Java'dan farkı, java'da default değer olmadığı için hepsini ayrı ayrı tanımlaman lazımdı.
     *
     */
    val turtleFive: Turtle = Turtle(name = "SuperKaplus", feetCount = 3, isMarried = true) // constructer parantezleri


}

fun anotherWalk() {
}