package com.mikaelkulma.kata.stringcalculator


class StringCalculor {

    def add(String input) {
        input.split("[,\n]").collect({
            it.isInteger() ? it as Integer : 0
        }).sum()
    }
}
