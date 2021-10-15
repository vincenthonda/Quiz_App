package com.example.quizapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.core.view.isVisible
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
    lateinit var karen: ImageView
    lateinit var hypebeast: ImageView
    lateinit var bitcoin: ImageView
    lateinit var chad: ImageView

    lateinit var questions : List<Question>

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
        val jsonText = inputStream.bufferedReader().use { it.readText() }
        val gson = Gson()
        var type = object: TypeToken<List<Question>>(){}.type
        questions = gson.fromJson<List<Question>>(jsonText, type)

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
            checkD()
            buttonNext.setOnClickListener {
                nextQuestion()
            }
        }

    }

    fun nextQuestion() {

        buttonA.isClickable = true
        buttonB.isClickable = true
        buttonC.isClickable = true
        buttonD.isClickable = true
        buttonNext.isVisible = false

        if (x < 10) {
            questionText.text = questions[x].question
            buttonA.text = questions[x].A
            buttonB.text = questions[x].B
            buttonC.text = questions[x].C
            buttonD.text = questions[x].D

            buttonA.setOnClickListener {
                checkA()
                buttonNext.isVisible = true
                buttonNext.setOnClickListener {
                    nextQuestion()
                }
            }
            buttonB.setOnClickListener {
                checkB()
                buttonNext.isVisible = true
                buttonNext.setOnClickListener {
                    nextQuestion()
                }
            }
            buttonC.setOnClickListener {
                checkC()
                buttonNext.isVisible = true
                buttonNext.setOnClickListener {
                    nextQuestion()
                }
            }
            buttonD.setOnClickListener {
                checkC()
                buttonNext.isVisible = true
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
        buttonD.visibility = View.GONE
        buttonNext.visibility = View.GONE


        if (max(max(aValue, bValue), max(cValue, dValue)) == aValue) {
            questionText.setText("You are 16 year old Bitcoin Millionaire")
                bitcoin.isVisible = true
        }
        if (max(max(aValue, bValue), max(cValue, dValue)) == bValue) {
            questionText.setText("You are a 12 year old \"hypebeast\"")
            hypebeast.isVisible = true
        }
        if (max(max(aValue, bValue), max(cValue, dValue)) == cValue) {
            questionText.setText("You are gigachad")
            chad.isVisible = true
        }
        if (max(max(aValue, bValue), max(cValue, dValue)) == dValue) {
            questionText.setText("You are Karen")
            karen.isVisible = true
        }
    }

    fun checkA() {
        aValue++
        x++
        buttonA.isClickable = false
        buttonB.isClickable = false
        buttonC.isClickable = false
        buttonD.isClickable = false
    }
    fun checkB() {
        bValue++
        x++
        buttonA.isClickable = false
        buttonB.isClickable = false
        buttonC.isClickable = false
        buttonD.isClickable = false
    }
    fun checkC() {
        cValue++
        x++
        buttonA.isClickable = false
        buttonB.isClickable = false
        buttonC.isClickable = false
        buttonD.isClickable = false
    }
    fun checkD() {
        dValue++
        x++
        buttonA.isClickable = false
        buttonB.isClickable = false
        buttonC.isClickable = false
        buttonD.isClickable = false
    }

    fun wireWidgets () {
        buttonA = findViewById(R.id.button_main_a)
        buttonB = findViewById(R.id.button_main_b)
        buttonC = findViewById(R.id.button_main_c)
        buttonD = findViewById(R.id.button_main_d)
        buttonNext = findViewById(R.id.button_main_e)
        questionText = findViewById(R.id.question_text)
        karen = findViewById(R.id.image_karen)
        chad = findViewById(R.id.image_chad)
        bitcoin = findViewById(R.id.image_bitcoin)
        hypebeast = findViewById(R.id.image_hypebeast)
        karen.isVisible = false
        chad.isVisible = false
        bitcoin.isVisible = false
        hypebeast.isVisible = false
    }

}