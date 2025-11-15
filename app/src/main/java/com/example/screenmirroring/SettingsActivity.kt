package com.example.screenmirroring

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import android.widget.TextView
import android.widget.Toast
import android.content.Intent
import android.net.Uri
import android.view.View

class SettingsActivity : AppCompatActivity() {

    private val APP_SHARE_LINK = "https://play.google.com/store/apps/details?id=${packageName}"
    private val SHARE_TEXT = "Check out All Mirror for easy screen mirroring: $APP_SHARE_LINK"
    private val SHARE_SUBJECT = "Recommend All Mirror App"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)


        val toolbar: Toolbar = findViewById(R.id.toolbar_settings)
        setSupportActionBar(toolbar)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)


        toolbar.setNavigationOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }
        findViewById<View>(R.id.setting_tutorial)?.setOnClickListener {
            Toast.makeText(this, "Opening Tutorial & FAQ...", Toast.LENGTH_SHORT).show()
            // TODO: Launch your internal Tutorial/FAQ Activity here
        }
        findViewById<View>(R.id.setting_pro)?.setOnClickListener {
            Toast.makeText(this, "Launching 'Go Pro' Purchase Screen...", Toast.LENGTH_SHORT).show()
            // TODO: Launch your In-App Billing/Purchase Activity here
        }
        findViewById<View>(R.id.setting_language_area)?.setOnClickListener {
            Toast.makeText(this, "Opening Language Selector...", Toast.LENGTH_SHORT).show()
            // TODO: Implement language change dialog/activity here
        }
        findViewById<View>(R.id.share_messenger)?.setOnClickListener {
            shareApp()
        }
        // Share via Telegram (ID: share_telegram)
        findViewById<View>(R.id.share_telegram)?.setOnClickListener {
            shareApp()
        }
        findViewById<View>(R.id.share_whatsapp)?.setOnClickListener {
            shareApp()
        }
        findViewById<View>(R.id.share_more)?.setOnClickListener {
            shareApp()
        }
        findViewById<TextView>(R.id.setting_privacy)?.setOnClickListener {
            openUrl("https://www.example.com/privacy", "Opening Privacy Policy...")
        }
        findViewById<TextView>(R.id.setting_terms)?.setOnClickListener {
            openUrl("https://www.example.com/terms", "Opening Terms of Use...")
        }
    }
    private fun shareApp() {
        Toast.makeText(this, "Opening Share Options...", Toast.LENGTH_SHORT).show()

        val shareIntent = Intent(Intent.ACTION_SEND).apply {
            type = "text/plain"
            putExtra(Intent.EXTRA_SUBJECT, SHARE_SUBJECT)
            putExtra(Intent.EXTRA_TEXT, SHARE_TEXT)
        }
        startActivity(Intent.createChooser(shareIntent, "Share All Mirror via:"))
    }

    /**
     * Creates and launches an ACTION_VIEW intent to open a URL in a browser.
     * @param url The URL string to open.
     * @param toastMessage The message to display when the link is opened.
     */
    private fun openUrl(url: String, toastMessage: String) {
        Toast.makeText(this, toastMessage, Toast.LENGTH_SHORT).show()
        try {
            val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
            startActivity(browserIntent)
        } catch (e: Exception) {
            Toast.makeText(this, "Error: Could not open link.", Toast.LENGTH_SHORT).show()
        }
    }
}