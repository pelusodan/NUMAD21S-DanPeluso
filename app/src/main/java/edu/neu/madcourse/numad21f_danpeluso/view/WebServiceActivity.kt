package edu.neu.madcourse.numad21f_danpeluso.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View.GONE
import android.view.View.VISIBLE
import android.widget.*
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import edu.neu.madcourse.numad21f_danpeluso.R
import edu.neu.madcourse.numad21f_danpeluso.viewmodel.WebServiceViewModel
import edu.neu.madcourse.numad21f_danpeluso.viewstate.WebServiceViewState

class WebServiceActivity : AppCompatActivity() {

    private lateinit var progressView: ProgressBar
    private lateinit var factList: TextView
    private lateinit var submitButton: Button
    private lateinit var editText: EditText
    private val viewModel: WebServiceViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web_service)
        initViews()
        observeViewModel()
    }

    private fun initViews() {
        progressView = findViewById(R.id.progress_bar)
        progressView.visibility = GONE
        factList = findViewById(R.id.cat_facts_textview)
        editText = findViewById(R.id.cat_fact_number_edit_text)
        submitButton = findViewById(R.id.cat_fact_send_button)
        submitButton.setOnClickListener {
            when {
                // check if the user has inputted any text before calling our function
                editText.text.isBlank() -> {
                    Toast.makeText(this, "Must enter number to receive cat facts", Toast.LENGTH_LONG).show()
                }
                // check if the value is less than 500 (should only allow number input)
                Integer.valueOf(editText.text.toString()) > 500 -> {
                    Toast.makeText(this, "Cannot request more than 500 cat facts!", Toast.LENGTH_LONG).show()
                }
                else -> {
                    viewModel.getCatFacts(Integer.valueOf(editText.text.toString()))
                }
            }
        }
    }

    private fun observeViewModel() {
        viewModel.viewStateLiveData.observe(this, Observer { state ->
            state?.let { handleViewState(it) }
        })
    }

    private fun handleViewState(state: WebServiceViewState) {
        if (state.isLoading) {
            progressView.apply {
                visibility = VISIBLE
                animate()
            }
        } else if (!state.isLoading && state.catFacts.isNotEmpty()) {
            progressView.visibility = GONE
            factList.text = state.catFacts
                    .filter { !it.deleted }
                    .map { it.text }
                    .reduce { acc, s -> acc + "\n\n\n" + s }
        }
        state.errorMessage?.let { Toast.makeText(this, it, Toast.LENGTH_LONG).show() }
    }
}