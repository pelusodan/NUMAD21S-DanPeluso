package edu.neu.madcourse.numad21f_danpeluso.view

import android.annotation.SuppressLint
import android.content.Context
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import edu.neu.madcourse.numad21f_danpeluso.R

class LocationActivity : AppCompatActivity() {

    private lateinit var locationTextView: TextView
    private lateinit var locationGrabButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_location)
        grabLocation()
        setOnClickListeners()
    }

    private fun setOnClickListeners() {
        locationGrabButton = findViewById(R.id.location_grab_button)
        locationGrabButton.setOnClickListener {
            locationTextView.text = "Getting location..."
            grabLocation()
        }
    }

    // we can suppress this as we are only opening the activity if the permission is enabled
    @SuppressLint("MissingPermission")
    private fun grabLocation() {
        locationTextView = findViewById(R.id.location_textview)
        val locationManager = (getSystemService(Context.LOCATION_SERVICE) as LocationManager)
        locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER).also { changeLatLongText(it) }
        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER,
                500L,
                .5f,
                object : LocationListener {
                    override fun onLocationChanged(location: Location?) {
                        location?.let { changeLatLongText(it) }
                    }

                    override fun onStatusChanged(provider: String?, status: Int, extras: Bundle?) {
                        Toast.makeText(parent, "Status Changed", Toast.LENGTH_LONG).show()
                    }

                    override fun onProviderEnabled(provider: String?) {}

                    override fun onProviderDisabled(provider: String?) {}

                })
    }

    private fun changeLatLongText(location: Location?) {
        location?.let {
            locationTextView.text = "Long: ${it.longitude} \nLat ${it.latitude}"
        }
    }
}