package com.feima.settingdemo;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.feima.settingdemo.fragment.FragmentOne;

public class MainActivity extends FragmentActivity {

    int[] icons = {R.mipmap.general_settings, R.mipmap.version};
    String[] titles = {"基本设置","版本信息"};
    private ListView mLv;
    private FragmentManager mManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mLv = (ListView) findViewById(R.id.lv_left);
        mManager = getSupportFragmentManager();



        mLv.setAdapter(new BaseAdapter() {
            @Override
            public int getCount() {
                return 2;
            }

            @Override
            public Object getItem(int position) {
                return null;
            }

            @Override
            public long getItemId(int position) {
                return 0;
            }

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                View view;
                if (convertView == null) {
                    view = View.inflate(MainActivity.this, R.layout.item_left, null);
                } else {
                    view = convertView;
                }

                ImageView iv = (ImageView) view.findViewById(R.id.iv_icon);
                TextView tv = (TextView) view.findViewById(R.id.tv_title);
                iv.setImageResource(icons[position]);
                tv.setText(titles[position]);

                return view;
            }
        });

        mLv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.i("测试", "点击了" + position);
                FragmentTransaction transaction = mManager.beginTransaction();
                transaction.replace(R.id.fl_right, new FragmentOne());
                transaction.commit();


            }
        });

        mLv.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Log.i("测试", "选中了" + position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Log.i("测试", "没有选中任何东西");
            }
        });

    }


}
