package com.leviticus.foodd;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.JavascriptInterface;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.Button;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.util.Scanner;

public class ExpiryScanner extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.expiryscanner);
        WebView webview = (WebView) findViewById(R.id.webview);
        webview.getSettings().setJavaScriptEnabled(true);
        webview.setWebChromeClient(new WebChromeClient());
        webview.getSettings().setJavaScriptEnabled(true);
        webview.getSettings().setLoadWithOverviewMode(true);
        webview.getSettings().setUseWideViewPort(true);
        webview.getSettings().setDomStorageEnabled(true);

        JsInterface jsInterface = new JsInterface();

        webview.addJavascriptInterface(jsInterface, "android");

        webview.loadUrl("file:///android_asset/OCR2.html");

    }

    private class JsInterface {

        @JavascriptInterface
        public String passJSON(String str) {
            try {
//                String FILE_NAME = "image.json";
//                FileOutputStream fos = openFileOutput(FILE_NAME, Context.MODE_PRIVATE);
//                fos.write(str.getBytes());
//                fos.close();
                writeJSONFile(str);

            } catch (Exception e) {
                e.printStackTrace();
            }
            return str;
        }

        @JavascriptInterface
        public void writeJSONFile(String str) {
            System.out.println("Java has access to JSON");
            File file = new File(getFilesDir(), "image.json");
            try {
                FileWriter fw = new FileWriter(file);
                fw.write(str);
                fw.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @JavascriptInterface
        public String testIfJSONWritten() {
            String pathToJSON = getFilesDir() + "/image.json";
            File f = new File(pathToJSON);
            String s = "";
            try {
                Scanner in = new Scanner(f);
                while(in.hasNext()) {
                    s+= in.next();
                }
                System.out.println(s);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return pathToJSON;
        }

    }


}