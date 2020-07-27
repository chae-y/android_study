package com.example.asynctaskclass;

import androidx.appcompat.app.AppCompatActivity;
import androidx.loader.content.AsyncTaskLoader;

import android.os.AsyncTask;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    //뷰의 주소값을 받을 참조 변수
    TextView text1, text2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text1=(TextView)findViewById(R.id.textView);
        text2=(TextView)findViewById(R.id.textView2);

        AsynTaskClass async = new AsynTaskClass();
        //AsynTask를 가동한다. 매개 변수의 같은 doInBackground 메서드로 전달된다
        async.execute(10,20);

    }

    public void btnMethod(View view){
        long now = System.currentTimeMillis();
        text1.setText("버튼클릭 : "+now);
    }
    //첫번째 제네닉 : execute 메서드의 매개 변수 doInBackground 메서드의 매개 변수 타입
    //두번째 제네닉 : publishProgress의 매개 변수, onProgressUpdate 매서드의 매개 변수 타입
    //세번째 제네닉 : doInBackgroung 메서드의 반환ㅌ입, onPostExecute 메서드의 매개 변수 타입
    class AsynTaskClass extends AsyncTask<Integer,Long,String>{
        @Override
        //doInBackground 매서득 호출되기 전에 호출되는 메서드
        //일반 쓰레드로 처리할 작업이 동작하기 전에 필요한 사전 작업을 해준다
        //메인 스레드
        protected void onPreExecute() {
            super.onPreExecute();
            text2.setText("AsyncTask 가동");
        }

        @Override
        //
        protected String doInBackground(Integer... integers) {
            int a1 = integers[0];
            int a2 = integers[1];

            for (int i=0; i<10; i++){
                SystemClock.sleep(1000);
                a1++;
                a2++;
                Log.d("test",i+":"+a1+". "+a2);
                //화면처리
                long now= System.currentTimeMillis();
                publishProgress(now);
            }
            return "작업 종료";
        }
        // doInBackground 메서드에서 화면처리를 요청하면 메인 쓰레드에 호출하는 메서드
        @Override
        protected void onProgressUpdate(Long... values) {
            super.onProgressUpdate(values);
            text2.setText("async : " + values[0]);
        }
        //doInBackground 메서드의 수행이 완료되면 메인 쓰레드가 호출하는 메서드
        //doInBackground 메서드가 반환하는 값을 매개 변수로 받는다
        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            text2.setText(s);
        }
    }
}