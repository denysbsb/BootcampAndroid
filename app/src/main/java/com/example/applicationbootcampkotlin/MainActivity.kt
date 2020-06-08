package com.example.applicationbootcampkotlin

import android.app.PendingIntent.getActivity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        showGif()
        viewModelStart()

        var title: String? = "My title principal"

        message.setOnClickListener {
            viewModel.showMsg()
        }

        titlebt.setOnClickListener {
            replaceTitle(title)
        }
    }

    fun showGif() {
        val imageView: ImageView = findViewById(R.id.imageView)
        Glide.with(this).load(R.drawable.android).into(imageView)
    }

    fun viewModelStart(){
        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)

        viewModel.item.observe(this, Observer { msg ->
            if (msg != null ) {
                Toast.makeText(this, msg, Toast.LENGTH_LONG).show()
            }
        })
    }

    fun replaceTitle( tx: String? = "nda"){
        title_label.text = title
    }
}
