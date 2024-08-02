package org.example.classes

/**
 * Düz class'lardan farkı
 *  * Primary constructer'a sahip olmak zorunda değil.
 * * Mutlaka en azından 1 tane parametresi olmak zorunda değil.
 * * Mutlaka bu parametre val/var olmak zorunda değil.
 *
 *  * init bloğu var
 *  *
 *  * Secondary constructer içerebilir,
 *  * Member property tanımlanabilir.
 *
 *   * Visibility modifier'ları kullanabiliyorum.
 * Default'u final'dır, open yapılabilir, dolayısıyla miras alınabilir.
 * Body'si olmasa da kullanılabilirz
 *
 *  * abstract, open, interface'den miras alabiliyor.
 *
 * sealed yapılabilir, inner ve nested yapılabilir.
 */

class Pokemon(name:String, type:String, age:Int, origin:String)


/**
 * Data class ne? Düz class'tan farkı ne? Neden DB'den gelen,
 * uzak sunucudan gelen dataları, düz class'la değil de data class'la karşılıyoruz, tercih etme eğilimindeyiz?
 *
 * Primary constructer'ı mutlaka olmalı, mutlaka en az 1 tane parametre içermelidir.
 *
 * Mutlaka en azından 1 tane parametresi olacak.
 * Mutlaka bu parametre val/var ile yazılmış olacak.
 * parametreleri default değer alabilir.
 *
 * init bloğu var
 *
 * Secondary constructer içerebilir,
 * Member property ve function tanımlanabilir.
 * Member property ve function'ların componentN function'ları üretilmez.
 * Member propery'ler copy, hashcode, equals ve toString fonksiyonları generate edilirken kullanılmazlar.
 *
 * Visibility modifier'ları kullanabiliyorum.
 *
 * Open yapamıyorum, bir miras hiyerarşisinde kullanamıyorum demek, miras alamazsınız.
 * final default olarak geliyor
 * Body'si olmasa da kullanılabiliriz, genel kullanımı body'siz dir.
 *
 * abstract, open, interface'den miras alabiliyor.
 *
 * sealed yapılamıyor, inner yapılamıyor ama nested yapılabilir.
 * miras alınmaya kapalı olduğu için başka bir data class'dan da miras alamaz
 *
 * toString metodunu otomatik olarak override ediyor,
 * ayrıca diğer class'lara ek olarak copy function'u tanımlar.
 *
 * Data class'ların içine fonksiyon yazılabiliyor ama yazmamamız lazım.
 * normal class'ları data class şeklinde kullanırken de fonksiyon yazmamamız lazım.
 *
 * DATA CLASS'LARIN VERI TAŞIMAK ICIN KULLAN
 *
 * Not: Özel data class'ta özel bilgiler geliyorsa bunu data class'ta tutma.
 * Örneğin gizliliği ihlal edecek bir veri var, bunu normal class'da tutarsın, mesela son 4 hanesini alman gerekiyordur,
 * data'yı override edip son 4 hanesini alırsın, BU şekilde normal class'ları kullanabilirsin.
 *
 */

/**
 * kotlin bytecode'a çevirdiğimizde
 * ComponentN diye fonksiyonlar gördük, bu primary constructer'da yazılan parametreleri sırayla alıyor.
 * ama üye değişkenleri almıyor.
 * Bu sayede biz destructing declarations'da kullanabiliyoruz.
 *
 * Default değerler verebiliyoruz, default değerler verirsek boş constructer oluşturabiliriz.
 * Bu konu mapping kütüphanelerinin(jackson, gson), boş constructor'a sahip olması gerekliliğinden ötürü önemlidir.
 *
 * *  copy, hashcode, equals ve toString fonksiyonları arka planda generate edilirler,
 * generate edilirken primary constructer'daki parametreleri otomatik olarak kullanırlar.
 *
 * Eğer sen bu fonksiyonlardan herhangi birini override edersen, o class'ın generate edilmesini engellemiş oluyorsun.
 */

data class PokemonData(val name: String="", val type: String="", val toothCount: Int=0):ASDA{
    constructor(name: String, type: String, toothCount:Int, age: Int):this(name,type,toothCount){
    }

    var age:Int = 0
    override fun foo() {
        // todo
    }

    fun memberFun(){

    }
}

class MyClass(name:String, type: String){
    /**
     * Neden val ya da var olmak zorunda!!!!
     * Çünkü val ya da var olmazsa, tostring metodunu override edemez,
     * yani generate edilen fonksiyonları bu variable'lara erişmesi gerekiyor.
     */
    override fun toString(): String {
       // return "name: " + name + "type: " + type
        return ""
    }
}


private interface ASDA{
    fun foo()
}

fun main(){
    val pokemonData :PokemonData = PokemonData()
    val pokemonData2 :PokemonData = PokemonData("Bakugan","dragon",300)

    val pair : Pair<String,String> = Pair(pokemonData2.name, pokemonData2.type)
    val triple : Triple<String,String,Int> = Triple("first","second",3)
    /**
     * Data classlarda Destructuring yapabiliyorsun.
     */

    pair.first
    pair.second

    triple.first
    triple.second
    triple.third

    val (name1, type1) = pair


    val pokemonName= pokemonData2.component1()
    val pokemonType = pokemonData2.component2()
    val pokemonToothCount =  pokemonData2.component3()

    // burada arka planda component1, component2, component3 atıyor, yani primary constructor'da olmak zorunda
    val (name2, type2, toothCount2) = pokemonData2
    // hepsini almak istemiyorsan ve componenle de kafanın karışmasını istemiyorsan, 2 ve 3 lü değerler için
    // pair ve triple'ı kullanabilirsin. Örneğin pokemonun 5 tane parametresi var ama sana 2 tanesi lazım
    val (name3,type3) = Pair(pokemonData2.name, pokemonData2.type)
    val (name4,type4,toothCoun4) = Triple(pokemonData2.name, pokemonData2.type, pokemonData.toothCount)




    println(name2+type2+toothCount2.toString())
}