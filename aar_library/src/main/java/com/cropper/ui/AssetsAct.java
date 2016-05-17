package com.cropper.ui;

import android.os.Bundle;
import android.app.Activity;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.eposp.aar_library.R;

/**
 * 测试aar中assets文件访问
 */
public class AssetsAct extends Activity {
WebView mWebView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.aar_library_activity_test);
        mWebView = (WebView)findViewById(R.id.webView);
        testWebView();
    }
    private void testWebView(){

        WebSettings webSettings = mWebView.getSettings();

        webSettings.setJavaScriptEnabled(true);
        webSettings.setJavaScriptCanOpenWindowsAutomatically(true);
        webSettings.setDatabaseEnabled(true);
        // 加上这句话，支持html5的某些alert提示框的弹出
        webSettings.setDomStorageEnabled(true);

            mWebView.getSettings().setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);//自适应手机屏幕
//		mWebView.getSettings().setLayoutAlgorithm(LayoutAlgorithm.SINGLE_COLUMN);//自适应手机屏幕
//

        mWebView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });
        mWebView.setWebChromeClient(new WebChromeClient() {
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                if (newProgress >= 80) {
                }
            }

        });

        mWebView.loadUrl("file:///android_asset/readme.html");

    }

}
