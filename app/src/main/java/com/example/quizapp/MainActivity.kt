package com.example.quizapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class MainActivity : AppCompatActivity() {

    val TAG = "MainActivity"
    lateinit var buttonA: Button
    lateinit var buttonB: Button
    lateinit var buttonC: Button
    lateinit var buttonD: Button
    lateinit var buttonNext: Button
    lateinit var questionText: TextView

    val inputStream = resources.openRawResource(R.raw.questions)
    val jsonText = inputStream.bufferedReader().use { it.readText() }
    val gson = Gson()
    val type = object: TypeToken<List<Question>>(){}.type
    val questions = gson.fromJson<List<Question>>(jsonText, type)

    var aValue = 0
    var bValue = 0
    var cValue = 0
    var dValue = 0
    var x = 0

    companion object Values {

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        wireWidgets()

        questionText.text = questions[x].question
        buttonA.text = questions[x].A
        buttonB.text = questions[x].B
        buttonC.text = questions[x].C
        buttonD.text = questions[x].D

        buttonA.setOnClickListener {
            checkA()
            buttonNext.setOnClickListener {
                nextQuestion()
            }
        }
        buttonB.setOnClickListener { checkB() }
        buttonC.setOnClickListener { checkC() }
        buttonD.setOnClickListener { checkC() }

    }

    fun nextQuestion() {
        if (x < 10) {
            buttonA.text = questions[x].A
            buttonB.text = questions[x].B
            buttonC.text = questions[x].C
            buttonD.text = questions[x].D

            buttonA.setOnClickListener {
                checkA()
                buttonNext.setOnClickListener {
                    nextQuestion()
                }
            }
            buttonB.setOnClickListener {
                checkB()
                buttonNext.setOnClickListener {
                    nextQuestion()
                }
            }
            buttonC.setOnClickListener {
                checkC()
                buttonNext.setOnClickListener {
                    nextQuestion()
                }
            }
            buttonD.setOnClickListener {
                checkC()
                buttonNext.setOnClickListener {
                    nextQuestion()
                }
            }
        }
        else {

        }
    }

    fun checkA() {
        aValue++
        x++
    }
    fun checkB() {
        bValue++
        x++
    }
    fun checkC() {
        cValue++
        x++
    }
    fun checkD() {
        dValue++
        x++
    }

    fun wireWidgets () {
        buttonA = findViewById(R.id.button_main_a)
        buttonB = findViewById(R.id.button_main_b)
        buttonC = findViewById(R.id.button_main_c)
        buttonD = findViewById(R.id.button_main_d)
        buttonNext = findViewById(R.id.button_main_e)
        questionText = findViewById(R.id.question_text)

    }

}