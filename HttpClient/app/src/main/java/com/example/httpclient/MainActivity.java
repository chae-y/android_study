package com.example.httpclient;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class MainActivity extends AppCompatActivity {

    TextView text1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text1=(TextView)findViewById(R.id.textView);
    }

    public void btnMethod(View view){
        NetworkThread thread = new NetworkThread();
        thread.start();
    }

    class NetworkThread extends Thread{
        @Override
        public void run() {
            try{
                String site="http://172.30.1.32:8080/BasicServer/basic.jsp";
                URL url = new URL(site);
                //접속
                URLConnection conn = url.openConnection();
                //서버와 연결되어 있는 스트림을 추출한다
                InputStream is = conn.getInputStream();
                InputStreamReader isr = new InputStreamReader(is,"UTF-8");
                BufferedReader br = new BufferedReader(isr);

                String str = null;
                StringBuffer buf = new StringBuffer();

                //읽어온다
                do{
                    str= br.readLine();
                    if(str!=null){
                        buf.append(str);
                    }
                }while (str!=null);

                final String str2 = buf.toString();
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        text1.setText(str2);
                    }
                });
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }
}