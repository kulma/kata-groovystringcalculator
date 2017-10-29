package com.mikaelkulma.kata.stringcalculator


class StringCalculor {

    def add(String input) {
        input.split(",").collect({
            it.isInteger() ? it as Integer : 0
        }).sum()
    }
}
