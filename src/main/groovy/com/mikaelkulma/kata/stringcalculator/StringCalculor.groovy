package com.mikaelkulma.kata.stringcalculator

class StringCalculor {

    def add(String input) {

        def delimiters = [",", "\n"]

        if (input.startsWith("//")) {
            delimiters << input.find(~/\/\/(.+)\n/, { match, d ->
                d
            })
        }

        input.split("[" + delimiters.join("") + "]").collect({
            it.isInteger() ? it as Integer : 0
        }).sum()
    }

}
