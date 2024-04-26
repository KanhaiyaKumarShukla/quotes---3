package com.example.retrofitexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlin.math.log

class MainActivity : AppCompatActivity() {
    private lateinit var quoteViewModel: QuoteViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val repository=(application as QuoteApplication).quoteRepository
        quoteViewModel = ViewModelProvider(this, QuoteViewModelFactory(repository))[QuoteViewModel::class.java]

        quoteViewModel.quote.observe(this) {
            //Log.d("QuoteData : ", it.results.toString())
            Toast.makeText(this, it.results.size.toString(), Toast.LENGTH_SHORT).show()
        }
    }
}