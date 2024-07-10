package Generics;

/*
* Öncelikli olarak java da Generic'ler invariant(değişmez) olarak bulunurlar.
* Bunun anlamı List<String>, List<Object>'nin bir alt tipi değildir.
* Eğer List'ler invariant olmasaydı, Java'daki array' lerden bir farkı kalmazdı.
*
*  Object, String'in bir üst türüdür. Sadece <Object> bekliyorsanız, <String> verebilirsiniz.
* Bunda bir problem yok. List<Object> beklediğiniz durumda List<String> veremezsiniz.
*
*
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class GenericsInJava {
    public static void main(String[] args) {
        List<String> strs = new ArrayList<String>();
        strs.add("1");

        // compile time hatası alırız. Type mismatch
        //List<Object> objs = strs ;

        // eğer hata almasaydık, int bir değeri string bir lise atayabilirdik, çünkü arayüzü object olacaktı
        // her tipi kabul edebilecekti.
        //objs.add(1);

        // sonrasında string list'ten eleman alırken aslında int alacaktık ve bunu string değişkene vermeye
        // çalışırken ClassCastException alırdık. Integer can not cast to String gibi
        // Java runtime safety'i sağlamak için bunu engelliyor.
        String s = strs.get(0);


    }
}
