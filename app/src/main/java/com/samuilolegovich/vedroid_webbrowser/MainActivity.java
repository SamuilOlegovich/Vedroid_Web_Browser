package com.samuilolegovich.vedroid_webbrowser;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {
    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        webView = (WebView) findViewById(R.id.webView);
        // устанавливаем настройки для броузера
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webView.loadUrl("https://github.com/SamuilOlegovich");
        // для того чтобы не переходило в броузер при нажатии на линки, а оставались в приложении
        webView.setWebViewClient(new WebViewClient());
        // для доступа приложения к интернету надо указать в манифесте -->
        //     <uses-permission android:name="android.permission.INTERNET"></uses-permission>
    }


    // при нажатии на кнопку назад будем возвращаться назад
    @Override
    public void onBackPressed() {
        if (webView.canGoBack()) {
            webView.goBack();
        } else {
            super.onBackPressed();
        }
    }
}