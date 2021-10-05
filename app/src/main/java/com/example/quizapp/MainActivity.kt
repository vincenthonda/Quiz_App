package com.example.quizapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    val TAG = "MainActivity"
    lateinit var quiz = quiz()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val inputStream = resources.openRawResource(R.raw.questions)
        val jsonText = inputStream.bufferedReader().use { it.readText() }
        data class Question(val question: String, val answer: Boolean)
    }

    fun Question() {
        
    }

}