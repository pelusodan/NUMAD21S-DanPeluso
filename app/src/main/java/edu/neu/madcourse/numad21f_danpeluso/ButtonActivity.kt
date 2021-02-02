package edu.neu.madcourse.numad21f_danpeluso

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class ButtonActivity : AppCompatActivity() {

    private lateinit var aButton: Button
    private lateinit var bButton: Button
    private lateinit var cButton: Button
    private lateinit var dButton: Button
    private lateinit var eButton: Button
    private lateinit var fButton: Button
    private lateinit var labelTextView: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_button)

        initViews()
        setOnClickListeners()
    }

    private fun setOnClickListeners() {
        labelTextView.apply {
            aButton.setOnClickListener { this.text = getString(R.string.last_pressed_label, "a") }
            bButton.setOnClickListener { this.text = getString(R.string.last_pressed_label, "b") }
            cButton.setOnClickListener { this.text = getString(R.string.last_pressed_label, "c") }
            dButton.setOnClickListener { this.text = getString(R.string.last_pressed_label, "d") }
            eButton.setOnClickListener { this.text = getString(R.string.last_pressed_label, "e") }
            fButton.setOnClickListener { this.text = getString(R.string.last_pressed_label, "f") }

        }
    }

    private fun initViews() {
        aButton = findViewById(R.id.a_button)
        bButton = findViewById(R.id.b_button)
        cButton = findViewById(R.id.c_button)
        dButton = findViewById(R.id.d_button)
        eButton = findViewById(R.id.e_button)
        fButton = findViewById(R.id.f_button)
        labelTextView = findViewById(R.id.pressed_textview)
        labelTextView.text = getString(R.string.last_pressed_label, "")
    }
}