package com.example.bosch

import junit.framework.TestCase

class CalculatorTest : TestCase() {
lateinit var calculator:Calculator

    //oncreate
    public override fun setUp() {
        super.setUp()
        calculator = Calculator()
    }

    //ondestroy
    public override fun tearDown() {}

    fun testAdd() {
        var expectation = 40
        var actual = calculator.add(10,20)
        assertEquals(expectation,actual)
       // assertTrue()
    }
}