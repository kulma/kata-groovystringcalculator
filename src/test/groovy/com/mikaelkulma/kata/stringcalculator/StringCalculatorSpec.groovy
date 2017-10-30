package com.mikaelkulma.kata.stringcalculator

import spock.lang.IgnoreRest;
import spock.lang.Specification
import spock.lang.Unroll

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

    def "Two numbers return their sum"() {
        expect:
        calculator.add("1,2") == 3
    }

    @Unroll
    def "The string #numbers returns #sum"() {
        expect:
        calculator.add(numbers) == sum

        where:
        numbers             | sum
        "1,2,3,4,5,6,7,8"   | 36
        "10,34,200"         | 244
        "87,23,3,1,3,3,3"   | 123
        "1,1,1,1,1,1,1,1,1" | 9
    }

    def "Newlines can be used as delimiters"() {
        expect:
        calculator.add("1\n2,3") == 6
    }

    def "An extra delimiter can be added to the input as follows //delimiter\n[numbers…]"() {
        expect:
        calculator.add("//-\n1-2-3") == 6
    }

    def "Multiple delimiters can be added as follows //[delimiter1][delimiter2]\n[numbers…]"() {
        expect:
        calculator.add("//[-][#]\n1-2#3") == 6
    }

    def "Delimiters can be of any length"() {
        expect:
        calculator.add("//[----][#####]\n1----2#####3") == 6
    }

    def "Nunbers larger than 1000 are ignored"() {
        expect:
        calculator.add("1,1001") == 1
    }
}