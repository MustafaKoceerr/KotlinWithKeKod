package org.example.test

import org.example.Basics.createName
import org.jetbrains.annotations.TestOnly

class BasicsTest{

    @TestOnly
    fun testCreateNameReturnsString(){
        val result = createName()
        assert(result is String)
    }


}