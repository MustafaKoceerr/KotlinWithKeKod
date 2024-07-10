package org.example.Enum

fun main() {
    val fenerbahce = "Fenerbahce"
    val galatasaray = "Galatasaray"
    val besiktas = "Besiktas"
    val trabzonspor = "Trabzonspor"
    val afyonspor = "Afyonspor"


    //val userType = student, teacher, manager, parent
    val isStudent = false
    val isTeacher = false
    val isManager = false
    val isParent = true


    val isStudentType = 0
    val isTeacherType  = 1
    val isManagerType  = 2
    val isParentType  = 3

    val userType = isTeacherType
    when(userType){
        0-> println("student")
        1-> println("teacher")
        2-> println("manager")
        3-> println("parent")
    }

// Enum: Gruplayabildiğiniz, benzer tiplere sahip veri yapılarıdır. Veri gruplarıdır.
    // elinde 2 seçenekten fazla bir durum varsa boolean kullanmaman lazım.
    // bunları yönetmek için enum class'lar var



}