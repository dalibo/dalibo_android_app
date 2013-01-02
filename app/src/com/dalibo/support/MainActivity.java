package com.dalibo.support;

import android.os.Bundle;

import android.app.Activity;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.net.http.SslError;
import android.webkit.SslErrorHandler;	
import android.widget.Toast;

public class MainActivity extends Activity {
 
	private WebView webView;
	
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
						
		setContentView(R.layout.activity_main);
		
		webView = (WebView) findViewById(R.id.webkit);
		webView.setWebViewClient(new myWebViewClient());
		webView.getSettings().setJavaScriptEnabled(true);
		webView.loadUrl("https://support.dalibo.mobi");  
    }
	
private class myWebViewClient extends WebViewClient {	
    @Override
    public boolean shouldOverrideUrlLoading(WebView view, String url) {
        view.loadUrl(url);
        return true;
    }	  
    
    public void onReceivedError(WebView view, int errorCod,String description, String failingUrl) {
        Toast.makeText(getApplicationContext(), "Your Internet connection may not be active Or " + description , Toast.LENGTH_LONG).show();
    }    
    
    @Override
    public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
       handler.proceed(); // Ignore SSL certificate errors
    }    
}

}