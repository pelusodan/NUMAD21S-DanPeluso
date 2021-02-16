package edu.neu.madcourse.numad21f_danpeluso.view

import android.annotation.SuppressLint
import android.content.Context
import android.location.Location
import android.location.LocationManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import edu.neu.madcourse.numad21f_danpeluso.R

class LocationActivity : AppCompatActivity() {

    private lateinit var locationTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_location)
        grabLocation()
    }

    // we can suppress this as we are only opening the activity if the permission is enabled
    @SuppressLint("MissingPermission")
    private fun grabLocation() {
        locationTextView = findViewById(R.id.location_textview)
        val locationManager = (getSystemService(Context.LOCATION_SERVICE) as LocationManager)
        locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER).also { changeLatLongText(it) }

    }

    private fun changeLatLongText(location: Location?) {
        location?.let {
            locationTextView.text = "Long: ${it.longitude} \nLat ${it.latitude}"
        }
    }
}