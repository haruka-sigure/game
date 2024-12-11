package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import com.example.myapplication.databinding.ActivityMainBinding
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private lateinit var dataBinding: ActivityMainBinding
    private lateinit var viewModel: MainActivityViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dataBinding=DataBindingUtil.setContentView(this,R.layout.activity_main)

        viewModel=ViewModelProvider(this).get(MainActivityViewModel::class.java)
        dataBinding.tvscore.text="${getString(R.string.score)}:${viewModel.score}"
        dataBinding.tvnum.text=viewModel.randNum.toString()

        dataBinding.btlarger.setOnClickListener {
            guess(MainActivityViewModel.GuessNum.LARGER_7)
        }
        dataBinding.btsmaller.setOnClickListener {
            guess(MainActivityViewModel.GuessNum.SMALLER_7)
        }
    }
    private fun guess(guessNum: MainActivityViewModel.GuessNum){
        val isCorrect=viewModel.guess(guessNum)
        dataBinding.tvscore.text="${getString(R.string.score)}:${viewModel.score}"
        dataBinding.tvnum.text=viewModel.randNum.toString()
        if (isCorrect)Toast.makeText(this,R.string.correct,Toast.LENGTH_SHORT).show()
        else Toast.makeText(this,R.string.wrong,Toast.LENGTH_SHORT).show()
    }
}