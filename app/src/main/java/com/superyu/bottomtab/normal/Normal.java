package com.superyu.bottomtab.normal;

import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.FragmentTabHost;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TabHost;
import android.widget.TextView;

import com.superyu.bottomtab.R;

/**
 * Created by superyu on 2016/9/18.
 */
public class Normal extends AppCompatActivity implements TabHost.OnTabChangeListener{

    private FragmentTabHost mTabHost;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.normal);

        mTabHost = (FragmentTabHost) findViewById(android.R.id.tabhost);
        mTabHost.setup(this, getSupportFragmentManager(), R.id.realtabcontent);
        if (Build.VERSION.SDK_INT > 10) {
            mTabHost.getTabWidget().setShowDividers(0);
            initTabs();
            mTabHost.setCurrentTab(0);
            mTabHost.setOnTabChangedListener(this);
        }
    }

    @Override
    public void onTabChanged(String tabId) {
        int size = mTabHost.getTabWidget().getTabCount();
        for (int i = 0; i < size; i++) {
            View view = mTabHost.getTabWidget().getChildAt(i);

            if (i == mTabHost.getCurrentTab()) {
                view.setSelected(true);
            } else {
                view.setSelected(false);
            }
        }
    }

    private void initTabs() {
        MainTab[] tabs = MainTab.values();
        int size = tabs.length;
        for (int i = 0; i < size; i++) {

            MainTab mainTab = tabs[i];
            TabHost.TabSpec tab = mTabHost.newTabSpec(getString(mainTab
                    .getResName()));
            View view = LayoutInflater.from(getApplicationContext()).inflate(
                    R.layout.main_tab_indicator, null);
            TextView title = (TextView) view.findViewById(R.id.tab_title);
            Drawable drawable = this.getResources().getDrawable(
                    mainTab.getResIcon());
            title.setCompoundDrawablesWithIntrinsicBounds(null, drawable, null,
                    null);

            title.setText(getString(mainTab.getResName()));
            tab.setIndicator(view);
            tab.setContent(new TabHost.TabContentFactory() {
                @Override
                public View createTabContent(String tag) {

                    return new View(Normal.this);
                }
            });

            mTabHost.addTab(tab, mainTab.getClz(), null);
        }
    }
}
