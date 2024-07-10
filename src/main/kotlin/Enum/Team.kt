package org.example.Enum

/*
 *
 * Default olarak final durumundalar.
 * Visibility modifierlarla ilgili özel bir kısıtı yok
 * Primary constructer tanımlanabiliyor
 * init bloğu kullanılabiliyor
 * Secondary constructer tanımlanabiliyor
 * Enum class cannot inherit from classes, Classlardan miras alamıyorlar, başka enum class'lardan da miras alamıyorlar.
 * Interface implement edilebiliyor
 * Enum types cannot be instantiated, nesnesi oluşturulamıyor
 * Constructer'ı private, Bir class'ın nesnesini oluşturamıyorsan, constructer'ıyle ilgili bir durum olması lazım.
 * Nesnesi üretilemez, primary constructer'ı mecburi olarak private olmak zorunda, diğerlerini kabul etmiyor
 * companion object tanımlanabiliyor.
 * sealed, open, abstract, inner enum class'lar yapılamıyorlar.
 * içerisinde functionlar tanımlayabiliyorsun
 *
 * içerisinde abstract fun tanımına izin veriyor. Ancak bunu yaptığımızda
 * tüm enum sabitleri bu fonksiyonu override etmek zorunda olacaktır çünkü enum değişkenleri aslında birer class'lar
 *
 * open bir fun da yine tanımlayaniliyoruz, enum sabitleri bu durumda override etmek zorunda kalmıyor. (opsiyonel)
 *
 * interface implement edebiliyorum, interface'nin içinde fonksiyonlar olabilir, bunu enum class'ıma implement ettiğimde şöyle oluyor
 * interface'nin özelliği gereği eğer ana sınıfa implement ettiysek alt sınıflarına implement etmek zorunda kalmıyorduk
 * yani Team sınıfında implement edersek, alt sınıf olarak varsaydığımız
    Fenerbahce, Galatasaray, Besiktas, Trabzonspor, Afyonspor;'a bu interfacemizdeki fonksiyonu implement etmek zorunda kalmıyoruz.
 * Fakat Team sınıfına implement etmezsek bu alt sınıflara da implement etmek zorunda kalıyoruz.
 *
 * Sabitler de birer class olduğu için constructer verebiliyor ama içlerine ayrıca bir parametre tanımlanamaz
 * Enum class'ının parent class'ına bir parametre verdiysen, child class'ların constructerlarına da vermek zorundasın
 * alt parametreler Üst sınıfı miras aldığı için, üst sınıf constructer'ında bir değişken alırsa, alt sınıflar onu implement ettikleri için onlar da almak zorunda
 * Fenerbahce(5) : Team(5) aslında arka tarafta bu dönüyor
 *
 * Sabitler tek başlarına bir class'ı veya interface'i implement edemezler.
 * Sabitlerin içerisinde class, function tanımlamaya izin verilirmez, companion object bile tanımlayamıyorsun.
 * Eğer içine atadığımız property val ya da var ile tanımlanıyorsa, bu enum sabitleri üzerinden bu property'e dışarıdan erişilebilir
    Team.BESIKTAS.starCount
 *
 * EnumClass'lar ve sabitleri özünde class oldukları için toString, hashcode, equals gibi fonksiyonları override edebilirler
 *
 * Enum class'ların entries ve values() fonksiyonları bize o Enum Class'ın sabitlerinin listesini verir.
 * Kotlin 1.9'dan sonra entries, values() fonksiyonunun yerini almıştır.
 * valuesOf() fonksiyonu ise, o enumdaki belli bir enum sabitini bize döndürür. Eğer yanlis bir isimlendirme yapılırsa
 * bu durumda IllegalArgumentException alınır.
 *
 *
 * Enum sabitleri ordinal ve name diye 2 ayrı property'e de sahiptirler
 *  println(Team.BESIKTAS.name)
    println(Team.BESIKTAS.ordinal)
 * name bize direkt olarak enum sabitinin adının stringe dönmüş halini verir,
 * ordinal ise enum sabitinin enum içerisindeki sırasını bize belirtir.
 *
 * enum sabitleri static formda bulundukları için, nesneleri üretilmeden içerisindeki  fonksiyonlara ve değişkenlere erişebilirsiniz.
 *
 * enum sabitinin ismine direkt olarak erişeceksek, bir format kaygımız yoksa zaten enum class'ların bir property'si olan name'i kullanmalıyız.
 * Eğer bu sabit isminde bir değişiklik ya da format farklılığına gideceksek, sabit içinde toString() metodunu override edebiliriz.
 *
 * enum class'ının içerisinde yazılabilen düz fonksiyonlara, static olmadıkları için, dışarıdan erişim yoktur.
 * bu fonksiyonların amacı, enum sabitleri içindeki kodların okunaklığını arttırmak için kullanılırlar.
 * */







enum class Team private constructor(val starCount: Int) : SomeInterface{
    FENERBAHCE(5){
        override fun submarina(){
            println("akdo ver muzigi")
        }

        override fun toString(): String {
            return "Fenerbahce"
        }
    } , GALATASARAY(4) {
        override fun submarina() {
            TODO("Not yet implemented")
        }
    }, BESIKTAS(starCount = 3) {
        override fun submarina() {
            TODO("Not yet implemented")
        }
    }, TRABZONSPOR(2) {
        override fun submarina() {
            TODO("Not yet implemented")
        }
    }, AFYONSPOR(0) {
        override fun submarina() {
            TODO("Not yet implemented")
        }
    };

    // Burada oluşturduğumuz her bir değişken aslında bir class, Team'ı extend eden bir class

    init{

    }
    companion object{

    }
    // abstract fun absFun()

    abstract fun submarina()
}

enum class SomeOtherEnum

open class AnotherClass

interface SomeInterface{
    //fun submarina()
    //fun interfaceFun()
}

fun main(){
    Team.BESIKTAS.starCount
    Team.values()
    Team.entries // values() ve entries aynıdır

    println(Team.valueOf("BESIKTAS"))

    println(Team.BESIKTAS.name)
    println(Team.BESIKTAS.ordinal)

    Team.FENERBAHCE.submarina()
    println(Team.FENERBAHCE.toString())

    printTeam(Team.AFYONSPOR)

}

fun printTeam(team: Team){
    println(team.name)
}