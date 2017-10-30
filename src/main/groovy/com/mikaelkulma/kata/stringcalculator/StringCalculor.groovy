package com.mikaelkulma.kata.stringcalculator

class StringCalculor {

    def add(String input) {

        def delimiters = [",", "\n"]

        if (input.startsWith("//")) {
            delimiters.addAll input
                    .getAt([2..input.indexOf("\n") - 1])
                    .replaceAll(~/^\[|\]$/, "")
                    .split("\\]\\[")
                    .toList()

            input = input.drop(input.indexOf("\n") + 1)
        }

        input.split(delimiters.join("|")).collect({
            it.isInteger() && (it as Integer) < 1001 ? it as Integer : 0
        }).sum()
    }

}
