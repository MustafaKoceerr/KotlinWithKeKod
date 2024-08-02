package org.example.classes

/**
 * Eğer bir property'ye custom getter setter yazacaksan,mutlaka değişken ile anlamlı işlemler yapmalısın.
 *
 *
 */
class Rectangle2(val width : Int, val height : Int){
//    var <propertyName>[: <PropertyType>] [= <property_initializer>]
//    [<getter>]
//    [<setter>]

    /**
     * Getter ve setter optional,
     * PropertyType optional

     *     val area : Int = width * height
     *     val area2 : Int
     *         get() = width * height
     *     val area3 : Int get() = width * height

     */


//        get() = this.width * this.height
    // Ustteki ve allttaki bire bir aynı şey.

    fun getArea():Int{
        return this.width * this.height
    }




    var stringRepresentation: String=""
        get() = field
        set(value) {
            field = setDataFromString(value) // parses the string and assigns values to other properties
        }

    fun setDataFromString(value :String):String{
        return  "$value + lenght ${value.length*2}"
    }
    fun getDataFromString(value :String):String{
        return  "$value + lenght ${value.length*2}"
    }

    /**
     * Field'lar dananın kuyruğunun koptuğu yerdir.
     * field'a bakarsan kalın yazıldığını görürsün. field, değişkenin memory'de saklanan gerçek ismidir.
     * yani field'a ulaşınca memory'den değişkene ulaşıyorsun.
     *
     * sen set-get fonksiyonu yazarak sadece setAge, getAge fonksiyonları yazmış oldun.
     *
     * NOT: Local bir function içinde get-set yazamazsın.
     * Get-Set yazabildiğin yer class'ın üye fonksiyonlarıdır.
     *
     * Peki neden local bir fonksiyon içinde yazamazsın?
     * Cevap: Zaten fonksiyonun içindeki bir değişkene erişmeye ihtiyaç duymazsın. Fonksiyon işini yapar,
     * bitirir ve garbage collector tarafından temizlenir. Fonksiyonun içindeki bir değişkene dışarıdan erişme ihtiyacı duymazsın.
     *
     * Ama class'larda obje oluşturuyorsun ve property'lere erişme ihtiyacın oluyor.
     *
     * Yani Local fonksiyonlarda değişkenin kendisine, field'ına doğrudan erişiyoruz.
     * Ama Class'larda setter-getter fonksiyonlarına erişiyoruz.
     *
     */
    val name = "musti"
    val surname = "Kocer"
    var fullName: String = ""
        get() {return field}
        set(value) {
            println("SET'E GIRDI")
            println("value: $value")
            field = value
        }

//    / ERROR StackOverflow: Using actual name 'counter' would make setter recursive
    var counter = 0 // the initializer assigns the backing field directly
        set(value) {
            if (value >= 0)
                field = value
//             counter = value // ERROR StackOverflow: Using actual name 'counter' would make setter recursive
            /**
             * counter = value yapsaydın stackoverflow hatası alacaktın.
             * Çünkü zaten sen counter = 0 diyerek bir kere setter'a gönderdin.
             * counter yazdığın şey aslında setCounter oluyor. bu tekrar seni set'e gönderiyor.
             * o tekrar set'i çağırıyor ve stackoverflow hatası alıyorsun
             * Sonra set ile bir daha atamaya çalışıyorsun.
             *
             */
        }
    val size = 35
    val isEmpty : Boolean
        get() = (size==0)
    /**
     * Burada bir backing field yok. val yaparak set atamayı engelledin, get ile de
     * set fonksiyonu olmadığı için bir backing field'ı olmayacak yani sadece set,get fonksiyonuyla çalışır.
     * Get fonksiyonu (size==0) kontrolü için bir alan kaplar. ama fonksiyon çağrılması bitince alanı geri verir.
     * bu alanın kendisi, isEmpty ile ifade edilen bir değişken olarak bulunmaz.
     * Bu yapı çok önemli, çünkü siz bu yapıyı kullanarak bir extension olarak property yazabiliyorsun.
     *
     * isEmpty2'de atama yaptığın için bir backing field'ı geri alabiliyorsun. Backing field var.
     *
     */
    val isEmpty2 : Boolean = true
        get() = field
}

val Rectangle2.extensionProperty:String
    get() = "bu bir extension property'dir ve backing field'ı yoktur"

// üsttekiyle bu aynı şey.
fun Rectangle2.extensionPropertyFun(): String  {
    val musti = "fonksiyondur bu "
    return "bu bir extension property'dir ve backing field'ı yoktur"
}


interface X{
    /**
     * Interface'ler ile abstract'ların en belirgin özelliği, interface'ler state tutmazlar yani backing field tutmazlar.
     * interfaceler sadece fonksiyon tanımlarlar, geçici olarak değişken oluşturular. fonksiyonlar kapanınca değişkenler silinir.
     * Yani interface'nin içinde veri saklayamıyorsun. Bu zaten istediğimiz bir şey değil.
     *
     * abstract class'larla en önemli farkı backing field tutmaz.
     *
     */
    val Rectangle2.isEmptyy:Boolean
        get() = size==0
//    val Rectangle2.isEmptyy2:Boolean = true
//        get() = size==0
}


/**
 * Const val, top level olarak veya companion object içinde tanımlanırlar,
 *
 * siz play tuşuna bastığınızda const var'ın değeri de tipi de ide tarafından biliniyor.
 * compile zamanında biliniyor.
 * bazı durumlarda genericlerler çalışıyorsanız, class'ların tipini compile aşamasında bilmeniz gerekiyor zorunlu olarak.
 *
 * daha çok companion object içinde kullanılır.
 *
 * val runtime'da belirlenir. yani çalışma zamanında sıra ne zaman o satıra gelirse o zaman değişkenin değeri ve tipi belli olur.
 * const val değişkeni kullanmamış olsan bile compile zamanında belirlenir.
 */

fun main(){
    val obj = Rectangle2(10,10)
    obj.stringRepresentation = "242 ati "
    println(obj.stringRepresentation)

    obj.fullName = "selamlar"
    println(obj.fullName)

    println(obj.counter)
    obj.counter = 22
    println(obj.counter)


}

