package com.example.myapplication

import androidx.lifecycle.ViewModel
import java.util.Random

class MainActivityViewModel :ViewModel() {
    var score=0
        private set
    var randNum=7
        private set
    enum class GuessNum{
        LARGER_7,SMALLER_7
    }
    fun guess(guessNum: GuessNum) :Boolean{
        randNum=kotlin.random.Random.nextInt(1,14)
        var isCorrect=false
        when(guessNum){
            GuessNum.LARGER_7->{
                if (randNum>7){
                    score++
                    isCorrect=true
                }
            }
            GuessNum.SMALLER_7->{
                if (randNum<7){
                    score++
                    isCorrect=true
                }
            }
        }
        return isCorrect
    }
}