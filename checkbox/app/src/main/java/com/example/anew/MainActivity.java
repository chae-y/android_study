package com.example.anew;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    //뷰의 주소값을 담을 참조변수
    TextView text1;
    CheckBox check1, check2, check3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //뷰의 주소값을 가지고 온다
        text1=(TextView)findViewById(R.id.textView);
        check1=(CheckBox)findViewById(R.id.checkBox1);
        check2=(CheckBox)findViewById(R.id.checkBox2);
        check3=(CheckBox)findViewById(R.id.checkBox3);
        //체크박스의 리스너를 설정한다
        CheackBoxListner listner = new CheackBoxListner();
        check1.setOnCheckedChangeListener(listner);
        check2.setOnCheckedChangeListener(listner);
        check3.setOnCheckedChangeListener(listner);
    }

    //첫번째 버튼을 누르면 호출되는 메서드
    //체크 상태 값을 파악한다
    public void btn1Method(View view){
        text1.setText("");

        //체크 상태에 따라 필요한 처리를 해준다.
        boolean a1 = check1.isChecked();
        boolean a2 = check2.isChecked();
        boolean a3 = check3.isChecked();

        if(a1==true){
            text1.append("첫번째 체크박스가 체크되어 있습니다.\n");
        }
        if(a2==true){
            text1.append("두번째 체크박스가 체크되어 있습니다.\n");
        }
        if(a3==true){
            text1.append("세번째 체크박스가 체크되어 있습니다.\n");
        }
    }

    //두번째 버튼과 연결된 메서드
    //모든 체크박스의 상태를 체크상태로 설정한다
    public void btn2Method(View view){
        check1.setChecked(true);
        check2.setChecked(true);
        check3.setChecked(true);
    }
    //세번째 버튼과 연결된 메서드
    //모든 체크박스의 상태를 체크해제로 설정한다
    public void btn3Method(View view){
        check1.setChecked(false);
        check2.setChecked(false);
        check3.setChecked(false);
    }
    //네번째 버튼과 연결된 메서드
    //모든 체크 박스의 체크상태를 반전시킨다.
    public void btn4Method(View view){
        check1.toggle();
        check2.toggle();
        check3.toggle();
    }
    //체크박스의 체크 상태가 변경되면 반응하는 리스너
    class CheackBoxListner implements CompoundButton.OnCheckedChangeListener{
        @Override
        public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
            //체크상태가 변경된 체크박스의 id를 가져온다
            int id = compoundButton.getId();
            //아이디 값으로 분기한다
            switch (id){
                case R.id.checkBox1:
                    if(b==true) {
                        text1.setText("첫번째 체크박스가 체크되었습니다");
                    }else {
                        text1.setText("첫번째 체크박스가 체크 해제되었습니다");
                    }
                    break;
                case R.id.checkBox2:
                    if(b==true) {
                        text1.setText("두번째 체크박스가 체크되었습니다");
                    }else{
                        text1.setText("두번째 체크박스가 체크 해제되었습니다");
                    }
                    break;
                case R.id.checkBox3:
                    if(b==true) {
                        text1.setText("세번째 체크박스가 체크되었습니다");
                    }else{
                        text1.setText("세번째 체크박스가 체크 해제되었습니다");}
                    break;
            }
        }
    }
}