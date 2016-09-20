package com.superyu.bottomtab;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.superyu.bottomtab.normal.Normal;
import com.superyu.bottomtab.radiobtnstyle.RadioBtnStyle;
import com.superyu.bottomtab.wechatstyle.WeChatStyle;

import java.util.Arrays;
import java.util.List;
/**
 * Created by superyu on 2016/9/18.
 */
public class MainActivity extends AppCompatActivity {

    private List<String> mData = Arrays
            .asList("FragmentTabHost+Fragment","CustomView+ViewPager+Fragment","RadioButton+ViewPager+Fragment");
    private ListView listView;
    private ListAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView)findViewById(R.id.listView);
        mAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, mData);
        listView.setAdapter(mAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i){
                    case 0:
                        Intent intent = new Intent(MainActivity.this,Normal.class);
                        startActivity(intent);
                        break;
                    case 1:
                        Intent intent2 = new Intent(MainActivity.this,WeChatStyle.class);
                        startActivity(intent2);
                        break;
                    case 2:
                        Intent intent3 = new Intent(MainActivity.this,RadioBtnStyle.class);
                        startActivity(intent3);
                        break;
                }

            }
        });
    }
}
