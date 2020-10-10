package com.artifact.screendisplay

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.webkit.CookieManager
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // This allows sites using google auth sign in to work
        sd_webView.settings.userAgentString = sd_webView.settings.userAgentString.replace("wv", "")

        // Enable features we need to run a majority of sites
        CookieManager.getInstance().setAcceptThirdPartyCookies(sd_webView, true)
        sd_webView.settings.domStorageEnabled = true
        sd_webView.settings.javaScriptEnabled = true
        sd_webView.settings.setSupportMultipleWindows(true)
        sd_webView.settings.setGeolocationEnabled(true)
        sd_webView.settings.javaScriptCanOpenWindowsAutomatically = true
        sd_webView.clearCache(true)

        sd_webView.loadUrl("https://google.com")

        sd_webView.webViewClient = object : WebViewClient() {
            override fun shouldOverrideUrlLoading(
                view: WebView?,
                request: WebResourceRequest?
            ): Boolean {
                return false
            }
        }
    }

    override fun onResume() {
        super.onResume()

        // Apparently this fixes issues with keeping fullscreen onResume
        val decorView: View = window.decorView

        decorView.systemUiVisibility =
            (View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                    or View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                    or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                    or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                    or View.SYSTEM_UI_FLAG_FULLSCREEN)
    }
}
