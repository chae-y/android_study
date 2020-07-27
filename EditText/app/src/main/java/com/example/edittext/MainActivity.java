package com.example.edittext;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.Html;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    //뷰의 주소값을 담을 참조변수
    EditText edit1;
    TextView text1;

    ImageView img5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edit1=(EditText)findViewById(R.id.editTextTextPersonName2);
        text1=(TextView)findViewById(R.id.textView);

        EnterListener listener= new EnterListener();
        edit1.setOnEditorActionListener(listener);

        WatcherClass watcher = new WatcherClass();
        edit1.addTextChangedListener(watcher);

        //뷰의 주소값을 받아온다
        img5=(ImageView)findViewById(R.id.imageView5);
        //이미지를 세팅한다
        img5.setImageResource(R.drawable.sdf);
    }

    public void btn1Method(View view){
        edit1.setText("새롭게 설정한 문자열");
    }
    public void btn2Method(View view){
        String str = edit1.getText().toString();
        text1.setText("입력한 문자열 : "+str);
    }
    class EnterListener implements TextView.OnEditorActionListener{
        @Override
        public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {

            String str = textView.getText().toString();

            text1.setText("입력한 묹열:"+str);

            return false;
        }
    }
    class WatcherClass implements TextWatcher{
        @Override
        //문자열 값이 변경되었을 때
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            text1.setText("문자열 변경중 : "+charSequence);
        }

        @Override
        //문자열 값이 변경되기 전
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        //문자열 값값이 변경된 이후
        public void afterTextChanged(Editable editable) {

        }
    }
}