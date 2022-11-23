package com.example.hiltexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.hiltexample.viewmodels.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    lateinit var mainViewModel: MainViewModel
    private val productsId :TextView
    get() = findViewById(R.id.productsId)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mainViewModel =ViewModelProvider(this).get(MainViewModel::class.java)
        mainViewModel.productsLiveData.observe(this,Observer{
            productsId.text = it.joinToString {
                x -> x.title +"\n\n"
            }
        })
    }
}