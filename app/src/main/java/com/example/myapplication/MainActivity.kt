package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.example.myapplication.databinding.ActivityMainBinding
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private lateinit var dataBinding: ActivityMainBinding
    private var score:Int=0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dataBinding=DataBindingUtil.setContentView(this,R.layout.activity_main)

        dataBinding.btlarger.setOnClickListener {
            val x=randomNum()
            if (x>7)correct()
            else wrong()
        }
        dataBinding.btsmaller.setOnClickListener {
            val x=randomNum()
            if (x<7)correct()
            else wrong()
        }
    }
    private fun randomNum():Int{
        val x= Random.nextInt(1,14)
        dataBinding.tvnum.text=x.toString()
        return x
    }
    private fun correct(){
        score++
        dataBinding.tvscore.text="${getString(R.string.score)}$score"
        Toast.makeText(this,R.string.correct,Toast.LENGTH_SHORT).show()
    }
    private fun wrong(){
        Toast.makeText(this,R.string.wrong,Toast.LENGTH_SHORT).show()
    }
}