package edu.neu.madcourse.numad21f_danpeluso.view

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.webkit.URLUtil
import android.widget.Button
import android.widget.EditText
import androidx.activity.viewModels
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import edu.neu.madcourse.numad21f_danpeluso.R
import edu.neu.madcourse.numad21f_danpeluso.view.recyclerview.LinkCollectorRecyclerViewAdapter
import edu.neu.madcourse.numad21f_danpeluso.viewmodel.LinkCollectorViewModel


class LinkCollectorActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var fab: FloatingActionButton
    private val viewModel: LinkCollectorViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_link_collector)

        initViews()
        observeViewModel()
    }

    private fun observeViewModel() {
        viewModel.linksLiveData.observe(this, Observer { links ->
            // makes a new instance of recyclerview adapter to refresh every time we get new data
            recyclerView.adapter = LinkCollectorRecyclerViewAdapter(links) {
                // click listener to launch based on selected cell
                startActivity(Intent(Intent.ACTION_VIEW).apply { data = Uri.parse(it) })
            }

        })
    }

    private fun initViews() {
        recyclerView = findViewById(R.id.link_collector_recyclerview)
        recyclerView.layoutManager = LinearLayoutManager(this)

        fab = findViewById(R.id.link_collector_fab)
        fab.setOnClickListener { showInputDialog() }
    }

    private fun showInputDialog() {
        val builder = AlertDialog.Builder(this)
                .setTitle("Add to list")
                .setView(LayoutInflater.from(this).inflate(R.layout.link_collector_input_dialog, null))
        val dialog = builder.create()
        dialog.show()
        // declaring the input text validation
        dialog.findViewById<Button>(R.id.link_collector_ok_button)!!.setOnClickListener {
            val parentLayout: View = findViewById(android.R.id.content)
            if (URLUtil.isValidUrl(dialog.findViewById<EditText>(R.id.link_collector_url_input)?.text.toString())) {
                addInputToLinkCollector(
                        dialog.findViewById<EditText>(R.id.link_collector_name_input)?.text.toString(),
                        dialog.findViewById<EditText>(R.id.link_collector_url_input)?.text.toString())
                dialog.dismiss()
                Snackbar.make(parentLayout, "Successfully added url to list", Snackbar.LENGTH_LONG).show()
            } else {
                Snackbar.make(parentLayout, "URL not valid. Please try again", Snackbar.LENGTH_LONG).show()
            }
        }
    }

    private fun addInputToLinkCollector(name: String, url: String) {
        viewModel.addLinkToList(name, url)
    }
}