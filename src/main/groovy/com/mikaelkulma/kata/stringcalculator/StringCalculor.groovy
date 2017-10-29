package com.mikaelkulma.kata.stringcalculator


class StringCalculor {

    def add(String input) {
        return input.isInteger() ? input as Integer : 0
    }
}
