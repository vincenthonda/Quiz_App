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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        wireWidgets()

        val inputStream = resources.openRawResource(R.raw.questions)
        val jsonText = inputStream.bufferedReader().use { it.readText() }

        Log.d(TAG, "onCreate: $jsonText")

        val gson = Gson()
        val type = object: TypeToken<List<Question>>(){}.type
        val questions = gson.fromJson<List<Question>>(jsonText, type)
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