package com.example.progressbar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //뷰의 주소값을 담을 참조변수
    ProgressBar bar4;
    SeekBar seek1, seek2;
    TextView text1, text2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bar4=(ProgressBar)findViewById(R.id.progressBar4);

        seek1=(SeekBar)findViewById(R.id.seekBar);
        seek2=(SeekBar)findViewById(R.id.seekBar2);
        text1=(TextView)findViewById(R.id.textView);
        text2=(TextView)findViewById(R.id.textView2);

        SeekbarListener listener = new SeekbarListener();
        seek1.setOnSeekBarChangeListener(listener);
        seek2.setOnSeekBarChangeListener(listener);
    }

    public void btn1Method(View view){
        bar4.incrementProgressBy(5);
    }
    public void btn2Method(View view){
        bar4.incrementProgressBy(-5);
    }
    public void btn3Method(View view){
        bar4.setProgress(80);
    }

    public void btn11Method(View view){
        seek1.incrementProgressBy(1);
        seek2.incrementProgressBy(1);
    }
    public void btn22Method(View view) {
        seek1.incrementProgressBy(-1);
        seek2.incrementProgressBy(-1);
    }
    public void btn33Method(View view){
        seek1.setProgress(8);
        seek2.setProgress(3);
    }
    public void btn44Method(View view){
        int value1= seek1.getProgress();
        int value2= seek2.getProgress();

        text1.setText("seek1:"+value1);
        text2.setText("seek2:"+value2);
    }

    class SeekbarListener implements SeekBar.OnSeekBarChangeListener{
        @Override
        //현재값을 변경 싴켰을때 반응하는 리스너
        public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
            //b true는 사용자 false는 코드
            int id=seekBar.getId();

            switch (id){
                case R.id.seekBar:
                    text1.setText("첫번째 seekbar:"+i);
                    break;
                case R.id.seekBar2:
                    text1.setText("두번째 seekbar:"+i);
                    break;
            }

            if(b==true) {
                text2.setText("사용자에 의해 변경되었습니다");
            }else{
                text2.setText("코드에 의해 변경되었습니다");
            }

        }

        @Override
        //값을 변경하기 위해 터치하면 호출되는 메서드
        public void onStartTrackingTouch(SeekBar seekBar) {
            int id= seekBar.getId();

            switch (id){
                case R.id.seekBar:
                    text2.setText("첫번째 seekbar를 터치하였습니다");
                    break;
                case R.id.seekBar2:
                    text2.setText("두번째 seekbar를 터치하였습니다");
                    break;
            }
        }

        @Override
        //값을 변하고 터치를 떼면 호출되는 메서드
        public void onStopTrackingTouch(SeekBar seekBar) {
            int id= seekBar.getId();

            switch (id){
                case R.id.seekBar:
                    text2.setText("첫번째 seekbar를 떼었습니다");
                    break;
                case R.id.seekBar2:
                    text2.setText("두번째 seekbar를 뗴었습니다");
                    break;
            }
        }
    }
}