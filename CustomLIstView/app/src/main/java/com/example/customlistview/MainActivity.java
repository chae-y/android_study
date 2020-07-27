package com.example.customlistview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    //리스트 뷰를 구성하기 위한 문자연 배열
    String [] data = {
            "데이터1","데이터2","데이터3","데이터4","데이터5","데이터6"
    };
    //리스트 뷰 항목에 셋팅한 데이터
    int [] imgRes = {
            R.drawable.bae1,R.drawable.bae2,R.drawable.bae3,R.drawable.bae4,R.drawable.bae5,
    };
    String [] data1 = {
            "고","고","고","고","고"
    };
    String [] data2 = {
            "영","영","영","영","영"
    };
    String [] data3 = {
            "배","배","배","배","배"
    };

    //뷰의 주소값을 담을 참조변수
    ListView list1,list2;
    TextView text2,text6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //뷰의 주소값을 받아온다
        list1 = (ListView)findViewById(R.id.list1);
        text2 = (TextView)findViewById(R.id.textView2) ;

        list2 = (ListView)findViewById(R.id.list2);
        text6 = (TextView)findViewById(R.id.textView6);

        //어뎁터를 생성한다
        ArrayAdapter<String> adapter= new ArrayAdapter<String>(this,R.layout.row,R.id.textView,data);
        //어뎁터를 리스트 뷰에 셋팅한다
        list1.setAdapter(adapter);
        //리스너 세팅
        ListListener listener = new ListListener();
        list1.setOnItemClickListener(listener);

        //데이터를 가지고 있는 ArrayList를 생성한다
        ArrayList<HashMap<String,Object>> data_list = new ArrayList<HashMap<String, Object>>();
        //데이터를 담는다
        for(int i=0;i<imgRes.length;i++){
            //항목 하나를 구성하기 위해서 필요한 데이터를 해시 맵에 담는다.
            HashMap<String,Object> map =  new HashMap<String, Object>();
            map.put("사진", imgRes[i]);
            map.put("1",data1[i]);
            map.put("2",data2[i]);
            map.put("3",data3[i]);

            data_list.add(map);
        }
        //해시맵 객체에 데이터를 저장할떄 사용한 이름 배역
        String [] keys = {"사진","1","2","3"};
        //데이터를 세팅할 뷰의 id
        int [] ids = {R.id.imageView, R.id.textView3, R.id.textView4, R.id.textView5};
        //어뎁터를 만들어준다
        SimpleAdapter adapter2 = new SimpleAdapter(this,data_list,R.layout.roow,keys,ids);
        list2.setAdapter(adapter2);

        //리스너를 리스트뷰에 세팅한다
        ListListener2 listener2 = new ListListener2();
        list2.setOnItemClickListener(listener2);
    }
    //리스너뷰의 리스너
    class ListListener implements AdapterView.OnItemClickListener{
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
            text2.setText(data[i]);
        }
    }
    //리스뷰의 항목을 터치하면 반응하는 리스너
    class ListListener2 implements AdapterView.OnItemClickListener{
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
            text6.setText(data1[i]);
        }
    }
}