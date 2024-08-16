package GenericsSecond;

import java.util.ArrayList;
import java.util.List;

/**
 * ***Öncelikli olarak Java'da Generic'ler invariant(değişmez) olarak bulunurlar. ***
 *
 * Bunun anlamı List<String>, List<Object>'nin bir alt tipi değildir.
 * String, objectin bir alt türüdür ama List<Object>, List<String>'in bir alt türü değildir.
 * Eğer List'ler invariant olmasaydı, Java'daki array'lerden bir farkı kalmazdı.
 *
 *  Yani String, aslında Object'in bir alt class'ı olsa da,
 *  Object diy
 */



public class GenericsInJava {

    public static void main(String[] args) {
        List<String> strs = new ArrayList<String>();

        List<Object> objs = strs;
        // Compile time'da error vermese ve bu işlemi yapabilseydik, aşağıda int ekleyebilecektik.
        objs.add(1);

        // Java runtime safety sağlamak için bunu sağlıyor.
        String s = objs.get(0);
    }

    void copyAll(MyCollection<Object> to, MyCollection<String> from){
        // Collection<String>, Collection<Object>'nin bir alt tipi olmadığından bunu yapamıyoruz
        to.addAll(from);
    }

    void copyAll2(MyCollection2<Object> to, MyCollection2<String> from){
        // void addAll(MyCollection2<? extends E> items); ile, o türde ya da onun alt türünde
        // bir tür bekliyorum diyorsunuz.
        to.addAll2(from);
        from.addAll2(to);
    }

    void copyAll3(MyCollection3<Object> to, MyCollection3<String> from){
        //void addAll3(MyCollection3<? super E> items); ile, o türde ya da onun üst türünde
        // bir tür bekliyorum diyorsunuz.
        to.addAll3(from);
        from.addAll3(to);

    }

    interface MyCollection<E>{
        void addAll(MyCollection<E> items);
    }
    interface MyCollection2<E>{
        void addAll2(MyCollection2<? extends E> items);
    }
    interface MyCollection3<E>{
        void addAll3(MyCollection3<? super E> items);
    }
}
/**
 * Invariant : Beklediğini alırsın, sadece o türde veri arasında işlem yapabilirsin -> void addAll(MyCollection<E> items);
 * Covariant : Beklediğini alırsın, o ve onun alt class'larının türünde veri arasında işlem yapabilirsin -> void addAll2(MyCollection2<? extends E> items);
 * Contravariance : Beklediğini alırsın, o ve onun üst class'larının türünde veri arasında işlem yapabilirsin -> void addAll3(MyCollection3<? super E> items);
 *
 * ? ->  WildCart deniyor. extends, super'e göre Covariant, Contravariant olarak veririz.
 *
 * Buradaki ? extends E ifadesi E tipinbdeki bir değişkeni ya da E'nin alt tiplerini de(subtype) kabul ettiğimiz,
 * Bu sebeple String normalde Object'in bir alt sınıfı olduğundan yukarıdaki copyAll2 methodunda
 * Object tipi veya onun alt tipleri kabul edilmiş oluyor.
 * Bu sebeple wildcard'ların extends-bound (upper bound) kullanımı burada tipi "Covariant" yapıyor.
 * Özetle üst tipe sahip bir listeye alt türü de atayabilmek şeklinde söyleyebiliriz.
 *
 * Java'da ayrıca ? super String gibi wildcard kullanımı da vardır.
 * Bu da String ve super type'larını kabul ediyorum demektir. Buna da "Contravariance" denmektedir.
 */