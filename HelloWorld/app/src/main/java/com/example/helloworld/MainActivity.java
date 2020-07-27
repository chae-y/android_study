package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import static android.util.Log.*;

public class MainActivity extends AppCompatActivity {

    @Override
    // Activity가 생성될 떄 자동으로 호출된다.
    // 화면 회전이 발생했을 때 자동으로 호출된다.
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //System.out.println("onCreate 매서드 호출");
        Log.d("test","onCreate 호출");
    }

    @Override
    //onCreat 메서드 호출 이후에 자동으로 호출
    //Activity가 정지 상태가 되었다가 활동상태로 돌아올 때 호출
    protected void onStart() {
        super.onStart();

        Log.d("test", "onStart 호출");
    }

    @Override
    //onStart 매서드가 호출된 이후에 자동으로 호출
    //Activity가 일시정지 되었다가 다시 돌아올때 호출
    protected void onResume() {
        super.onResume();
        Log.d("test", "onResume 호출");
    }

    @Override
    //Activity가 정지 상태가 되었다가 활동 사아태로 돌아갈 떄 onStart 메서드 전에 호출된다
    protected void onRestart() {
        super.onRestart();
        Log.d("test","onRestart 호출");
    }

    @Override
    //Activity가 일시정지 상태가 될 때 호출
    //화면상에서 완전히 사라지거나 현재 화면 위에 작은 팝업창 같은 것이 나타날 때 호출
    protected void onPause() {
        super.onPause();
        Log.d("test","onPause 호출");
    }

    @Override
    //Activity가 화면에서 사라질 때 호출
    protected void onStop() {
        super.onStop();
        Log.d("test","onStop 호출");
    }

    @Override
    //현재 액티비티의 수행이 완전히 종료되어 메로리 상에서 제거 될 떄 호출
    protected void onDestroy() {
        super.onDestroy();
        Log.d("test","onDestroy 호출");
    }


}