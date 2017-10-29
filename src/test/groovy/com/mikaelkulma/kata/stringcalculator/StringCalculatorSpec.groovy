package com.mikaelkulma.kata.stringcalculator;

import spock.lang.Specification


class StringCalculatorSpec extends Specification {

    def calculator = new StringCalculor();

    def "an empy string returns zero"() {
        expect:
        calculator.add("") == 0
    }

    def "A single number returns the number"() {
        expect:
        calculator.add("1") == 1
    }

}