package com.superyu.bottomtab.radiobtnstyle;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.superyu.bottomtab.R;
import com.superyu.bottomtab.wechatstyle.TabFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by superyu on 2016/9/18.
 */
public class RadioBtnStyle extends AppCompatActivity{

    private ViewPager viewPager;
    private RadioGroup radioGroup;
    private RadioButton rb1,rb2,rb3,rb4;
    private List<Fragment> fragmentList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.radiobtn);
        initView();
        initViewPager();
    }

    private void initView(){
        viewPager = (ViewPager)findViewById(R.id.viewpager);
        radioGroup = (RadioGroup)findViewById(R.id.radiogroup);
        rb1 = (RadioButton)findViewById(R.id.rb1);
        rb2 = (RadioButton)findViewById(R.id.rb2);
        rb3 = (RadioButton)findViewById(R.id.rb3);
        rb4 = (RadioButton)findViewById(R.id.rb4);

        radioGroup.setOnCheckedChangeListener(new myCheckChangeListener());

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {



            }

            @Override
            public void onPageSelected(int i) {

                switch (i){
                    case 0:
                        radioGroup.check(R.id.rb1);
                        break;
                    case 1:
                        radioGroup.check(R.id.rb2);
                        break;
                    case 2:
                        radioGroup.check(R.id.rb3);
                        break;
                    case 3:
                        radioGroup.check(R.id.rb4);
                        break;
                }

            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });
    }

    private void initViewPager(){
       for(int i=0;i<4;i++){
           TabFragment fragment = new TabFragment();
           Bundle args = new Bundle();
           args.putString("title", "fragment"+i);
           fragment.setArguments(args);
           fragmentList.add(fragment);
       }
       viewPager.setAdapter(new MyFragmentPagerAdapter(getSupportFragmentManager()));
    }

    /**
     *RadioButton切换Fragment
     */
    private class myCheckChangeListener implements RadioGroup.OnCheckedChangeListener{

        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            switch (checkedId){
                case R.id.rb1:
                    //ViewPager显示第一个Fragment且关闭页面切换动画效果
                    viewPager.setCurrentItem(0,false);
                    break;
                case R.id.rb2:
                    viewPager.setCurrentItem(1,false);
                    break;
                case R.id.rb3:
                    viewPager.setCurrentItem(2,false);
                    break;
                case R.id.rb4:
                    viewPager.setCurrentItem(3,false);
                    break;
            }
        }
    }

    private class MyFragmentPagerAdapter extends FragmentPagerAdapter {

        public MyFragmentPagerAdapter(android.support.v4.app.FragmentManager fm){
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return fragmentList.get(position);
        }

        @Override
        public int getCount() {
            return fragmentList.size();
        }

    }


}
