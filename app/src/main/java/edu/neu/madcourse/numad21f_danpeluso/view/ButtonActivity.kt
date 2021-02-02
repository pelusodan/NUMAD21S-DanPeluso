package edu.neu.madcourse.numad21f_danpeluso.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import edu.neu.madcourse.numad21f_danpeluso.R
import edu.neu.madcourse.numad21f_danpeluso.viewmodel.ButtonViewModel

class ButtonActivity : AppCompatActivity() {

    private lateinit var aButton: Button
    private lateinit var bButton: Button
    private lateinit var cButton: Button
    private lateinit var dButton: Button
    private lateinit var eButton: Button
    private lateinit var fButton: Button
    private lateinit var labelTextView: TextView
    private val viewModel: ButtonViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_button)

        initViews()
        setOnClickListeners()
        setObservers()
    }

    private fun setObservers() {
        viewModel.getButtonLastPressed().observe(this, Observer {
            labelTextView.text = getString(R.string.last_pressed_label, it ?: "")
        })
    }

    private fun setOnClickListeners() {
        aButton.setOnClickListener { viewModel.setButtonLastPressed("a") }
        bButton.setOnClickListener { viewModel.setButtonLastPressed("b") }
        cButton.setOnClickListener { viewModel.setButtonLastPressed("c") }
        dButton.setOnClickListener { viewModel.setButtonLastPressed("d") }
        eButton.setOnClickListener { viewModel.setButtonLastPressed("e") }
        fButton.setOnClickListener { viewModel.setButtonLastPressed("f") }
    }

    private fun initViews() {
        aButton = findViewById(R.id.a_button)
        bButton = findViewById(R.id.b_button)
        cButton = findViewById(R.id.c_button)
        dButton = findViewById(R.id.d_button)
        eButton = findViewById(R.id.e_button)
        fButton = findViewById(R.id.f_button)
        labelTextView = findViewById(R.id.pressed_textview)
    }
}