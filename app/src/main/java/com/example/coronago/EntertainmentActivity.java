package com.example.coronago;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Locale;

import android.speech.RecognizerIntent;
import android.widget.Toast;

public class EntertainmentActivity extends AppCompatActivity {

    TextToSpeech textToSpeech;

    //webview for ibm Smart reply
    WebView smartReplyView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entertainment);



        smartReplyView = (WebView) findViewById(R.id.ibmSmartReply);
        Intent smartReplyIntent = getIntent();
        //        getting the details from first activity
        final String message = smartReplyIntent.getStringExtra("DETAIL");
        openView();

    }

    private void openView() {

        smartReplyView = (WebView) findViewById(R.id.ibmSmartReply);

        WebSettings webSettings = smartReplyView.getSettings();

        webSettings.setJavaScriptEnabled(true);
        smartReplyView.loadUrl("https://integrations.eu-gb.assistant.watson.cloud.ibm.com/web/public/ed3126c8-47f1-4247-a3ec-99b56545be69");

        smartReplyView.setWebViewClient(new WebViewClient());
    }

    @Override
    public void onBackPressed() {
        if(smartReplyView.canGoBack()){
            smartReplyView.goBack();
        }
        else {
            super.onBackPressed();
        }
    }

}
