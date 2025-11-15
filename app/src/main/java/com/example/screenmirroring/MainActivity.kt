package com.example.screenmirroring

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.widget.ImageButton
import android.widget.Toast
import android.view.View
import com.example.screenmirroring.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        val settingsButton = findViewById<ImageButton>(R.id.btn_settings)

        settingsButton.setOnClickListener {
            // Navigate to SettingsActivity
            val intent = Intent(this, SettingsActivity::class.java)
            startActivity(intent)
            Toast.makeText(this, "Launching Settings...", Toast.LENGTH_SHORT).show()
        }

        val connectCard = findViewById<View>(R.id.card_connect)
        connectCard.setOnClickListener {
            // Navigate to CastActivity for device search
            val intent = Intent(this, CastActivity::class.java)
            startActivity(intent)
            Toast.makeText(this, "Starting device search...", Toast.LENGTH_SHORT).show()
        }

        val browserCard = findViewById<View>(R.id.card_browser_mirroring)
        browserCard.setOnClickListener {
            Toast.makeText(this, "Browser Mirroring feature activated!", Toast.LENGTH_SHORT).show()
        }

        val wifiStatus = findViewById<View>(R.id.tv_wifi_status)
        wifiStatus.setOnClickListener {
            Toast.makeText(this, "Wi-Fi status check initiated.", Toast.LENGTH_SHORT).show()

        }
    }
}