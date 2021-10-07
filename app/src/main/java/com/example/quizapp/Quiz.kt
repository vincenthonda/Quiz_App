package com.example.quizapp

class Quiz (var questions: List<Question>) {
    var aValue = 0
    var bValue = 0
    var cValue = 0
    var dValue = 0

    fun checkAnswer(answer: String) {
        if (answer == "A") {
            aValue++;
        }
        else if (answer == "B") {
            bValue++;
        }
        else if (answer == "C") {
            cValue++;
        }
        else if (answer == "D") {
            dValue++;
        }
    }
}