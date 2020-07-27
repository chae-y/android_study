package com.example.androidview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //뷰의 주소값을 담을 참조 변수를 선언
    TextView text1;
    Button button1, button2, button3, button4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //id 속성이 text2인 뷰의 주소값을 얻어온다
        text1 = (TextView) findViewById(R.id.text2);
        button1 = (Button) findViewById(R.id.button);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);
        button4 = (Button) findViewById(R.id.button4);

        //리스너 객체를 생성
        BtnListener1 listener1 = new BtnListener1();
        BtnListener2 listener2 = new BtnListener2();
        BtnListener34 listener34 = new BtnListener34();
        //리스너를 버튼 객체에 설정한다
        button1.setOnClickListener(listener1);
        button2.setOnClickListener(listener2);
        button3.setOnClickListener(listener34);
        button4.setOnClickListener(listener34);

    }

    //첫번째 버튼과 연결된 리스너
    class BtnListener1 implements View.OnClickListener{
        @Override
        public void onClick(View view) {
            text1.setText("첫번째 버튼을 눌렀습니다");
        }
    }
    //두번째 버튼과 연결된 리스너
    class BtnListener2 implements View.OnClickListener{
        @Override
        public void onClick(View view) {
            text1.setText("두번째 버튼을 눌렀습니다");
        }
    }
    //세번째와 네번째 버튼과 연결된 리스너
    class BtnListener34 implements View.OnClickListener{
        @Override
        public void onClick(View view) {
            //이벤트가 발생된 뷰의 ID값을 추출한다.
            int id= view.getId();
            //id로 분기한다
            switch (id){
                case R.id.button3:
                    text1.setText("세번째 버튼을 눌렀습니다");
                    break;
                case R.id.button4:
                    text1.setText("네번째 버튼을 눌렀습니다");
                    break;
            }
        }
    }
    //메소드로 하는거 클릭이벤트
    //다섯번쨰 버튼을 누르면 호출되는 메서드
    public void btn5Method(View view){
        text1.setText("다섯번째 버튼을 눌렀습니다");
    }
    public void btn6Method(View view){
        text1.setText("여섯번째 버튼을 눌렀습니다");
    }
    //일곱번째, 여덟번째 버튼을 누르면 호출되는 메서드
    public void btn78Method(View view){
        int id=view.getId();
        switch (id){
            case R.id.button7:
                text1.setText("일곱번쨰 버튼을 눌렀습니다");
                break;
            case R.id.button9:
                text1.setText("여덟번쨰 버튼을 눌렀습니다");
                break;
        }
    }
}