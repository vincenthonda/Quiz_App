package com.example.quizapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.InputStream
import kotlin.math.max

class MainActivity : AppCompatActivity() {

    val TAG = "MainActivity"
    lateinit var buttonA: Button
    lateinit var buttonB: Button
    lateinit var buttonC: Button
    lateinit var buttonD: Button
    lateinit var buttonNext: Button
    lateinit var questionText: TextView

    lateinit var inputStream : InputStream
    lateinit val jsonText : String
    lateinit val gson :
    lateinit val type
    lateinit val questions

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

        var inputStream = resources.openRawResource(R.raw.questions)
        var jsonText = inputStream.bufferedReader().use { it.readText() }
        var gson = Gson()
        var type = object: TypeToken<List<Question>>(){}.type
        var questions = gson.fromJson<List<Question>>(jsonText, type)

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
            x++
        }
        else {
            showResults()
        }
    }

    fun showResults() {
        buttonA.visibility = View.GONE
        buttonB.visibility = View.GONE
        buttonC.visibility = View.GONE
        buttonC.visibility = View.GONE


        if (max(max(aValue, bValue), max(cValue, dValue)) == aValue) {
            questionText.setText("You are " + aValue / 11 + "% 16 year old Bitcoin Millionaire")
        }
        if (max(max(aValue, bValue), max(cValue, dValue)) == bValue) {
            questionText.setText("You are " + bValue / 11 + "% 12 year old \"hypebeast\"")
        }
        if (max(max(aValue, bValue), max(cValue, dValue)) == cValue) {
            questionText.setText("You are " + cValue / 11 + "% gigachad")
        }
        if (max(max(aValue, bValue), max(cValue, dValue)) == dValue) {
            questionText.setText("You are " + dValue / 11 + "% Karen")
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