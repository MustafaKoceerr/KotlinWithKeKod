package org.example.Basics

fun main() {
    /*
    *   8 bit alan kaplar
    *   true ya da false değer atamasi icin kullanilir. Nullable ise null değer de alir.
    *   0 ya da 1 boolean olarak kullanilmaz.
     */
    val isStudent: Boolean = true
    val isTeacher: Boolean = false
    val isFirstStudentMale: Boolean? = null

    //--------------
    /*
    *   //(or) &&(and) !(not) gibi operatorlerle beraber kullanilir
    *
    *
     */

    if (isStudent and isTeacher) {
    }
    if (isStudent or isTeacher) {
    }

    if (isStudent && isTeacher) {
    }
    if (isStudent || isTeacher) {
    }

    if (isStudent.and(isTeacher)) {
    }
    if (isStudent.or(isTeacher)) {
    }

    if (isStudent.not()) {
    }
    if (!isStudent) {
    }
    // not kullanımı daha doğru çünkü kodu okurken ! bazen görülmeyebiliyor.

    /*
    *  Eğer bir değişken nullable değilse == true diye kontrol ettirmene gerek yoktur. Direkt değişkeni koyarsan da aynı işi yapar.
    *  Nullable is değişkeni mutlaka kontrol ettirmelisin
     */
    if (isStudent) {
    } else {

    }
    val isNullableStudent : Boolean? = true
    if (isNullableStudent == true){

    }

    /*
    *   Kotlinde || ve && operatörleri lazily çalışma mekanizmasına sahiptir.
    *   Eğer || operatörünün solu true ise sağdaki değere bakmaya gerek duymaz ve true kabul eder.
    *   Eğer && operatörünün solu false ise sağdaki değere bakmayag erek duymaz ve false kabul eder.
    *
     */

}