package com.rupeevest.httpswww.rupeevest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.view.Menu;
import android.view.Display;
import android.content.res.Configuration;
import android.view.WindowManager;
import android.widget.Toast;

public class Home extends AppCompatActivity {

    private WebView mWebView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        mWebView = (WebView) findViewById(R.id.activity_main_webview);
        WebSettings webSettings = mWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);


        // open a clicked link webpage in the app only
        mWebView.setWebViewClient(new WebViewClient(){
            @Override
            public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
//              String customHtml = "<html><body><h1>No Internet Connection</h1></body></html>";

                // Load the Web page when there is no Internet Connection
                mWebView.loadUrl("file:///android_asset/error.html");
            }
        });

        // To load the specified url in the web view
        mWebView.loadUrl("https://www.rupeevest.com/");




        // To Hide the Action Bar
        getSupportActionBar().hide();
    }



    // To prevent automatic back when orientation chnage
    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

        // Checks the orientation of the screen for landscape and portrait
//        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
//
//        } else if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT){
//
//        }
    }



    // For Press of Back button in android app
    @Override
    public void onBackPressed() {
        if(mWebView.canGoBack()) {
            mWebView.goBack();
        } else {
            super.onBackPressed();
        }
    }


}
