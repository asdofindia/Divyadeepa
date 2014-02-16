package com.moodilabs.aforandroid;
import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;

public class WebViewActivity extends Activity {

	private WebView webView;
	protected static final String TAG = "WEB VIEW ACTIVITY";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String key=getIntent().getExtras().getString("urlKey");
        webView = new WebView(this);
        webView.loadUrl("https://www.google.co.in/search?q="+key);
        //Here we see a change from the usual.
        //We can call setContentView on any view. Here I'm choosing just a simple webview.
        //I can still create a separate layout file, add a webview to it and load a web page to it.
        setContentView(webView);
    }

    @Override
    protected void onResume() {
    	super.onResume();
    }
}
