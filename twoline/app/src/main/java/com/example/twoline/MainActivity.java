package com.example.twoline;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    //리스트뷰의 항목을 구성하기 위함 문자열 배열
    String [] data1 = {
            "1","2","3","4","5","6"
    };
    String [] data2 = {
            "one","two","three","four","five","six"
    };

    String [] data = {
            "데이터1","데이터2","데이터3","데이터4","데이터5"
    };
    ListView list1,list2;
    TextView text1,text3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list1 = (ListView)findViewById(R.id.list1);
        text1 = (TextView)findViewById(R.id.textView);
        list2 = (ListView)findViewById(R.id.list2);
        text3 = (TextView)findViewById(R.id.textView3);
        //데이터를 담을 arraylist
        ArrayList<HashMap<String,String>> data_list = new ArrayList<HashMap<String, String>>();
        //Arraylist에 데이터 담기
        for(int i=0; i<data1.length;i++){
            HashMap<String,String> map = new HashMap<String,String>();
            map.put("str1",data1[i]);
            map.put("str2",data2[i]);

            data_list.add(map);
        }
        String [] keys =  {"str1","str2"};
        int [] ids={android.R.id.text1, android.R.id.text2};
        //어뎁터를 리스트뷰에 셋팅한다.
        SimpleAdapter adapter = new SimpleAdapter(this,data_list,android.R.layout.simple_list_item_2,keys,ids);
        list1.setAdapter(adapter);

        //리스너를 세팅한다
        ListListener listener = new ListListener();
        list1.setOnItemClickListener(listener);

        //어뎁터를 세팅해 준다
        ListAdapter adapter1 = new LisAdapter();
        list2.setAdapter(adapter1);
    }
    class ListListener implements AdapterView.OnItemClickListener{
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
            text1.setText(data1[i]);
        }
    }

    class LisAdapter extends BaseAdapter{

        BtnListener listener = new BtnListener();
        @Override
        //리스트 뷰의 항목 개수를 반환하는 매서드
        public int getCount() {
            return data.length;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        //i 현재 몇번째
        public View getView(int i, View view, ViewGroup viewGroup) {
            //재사용 가능ㅎㄴ 뷰가 없다면 뷰를 만들어 준다
            if(view==null){
                LayoutInflater inflater = getLayoutInflater();
                view = inflater.inflate(R.layout.row,null);
            }
            //뷰를 구성한다.
            TextView sub_text = (TextView)view.findViewById(R.id.textView2);
            Button sub_btn1 = (Button)view.findViewById(R.id.button);
            Button sub_btn2 = (Button)view.findViewById(R.id.button2);

            sub_btn1.setOnClickListener(listener);
            sub_btn2.setOnClickListener(listener);

            //버튼에 인덱스 값을 저장한다.
            sub_btn1.setTag(i);
            sub_btn2.setTag(i);

            sub_text.setText(data[i]);
            //뷰를 반환한다.
            return view;
        }
    }
    //항목에 배치된 버튼에 셋팅할 리스너
    class BtnListener implements View.OnClickListener{
        @Override
        public void onClick(View view) {
            //버튼의 아이디 추출
            int id = view.getId();

            //리스트의 인덱스 값을 추출한다.
            int position = (Integer) view.getTag();
            switch (id){
                case R.id.button:
                    text3.setText("첫번째 버튼을 눌렀습니다."+position);
                    break;
                case R.id.button2:
                    text3.setText("두번쨰 버튼을 눌렀습니다."+position);
                    break;
            }
        }
    }
}