package com.superyu.bottomtab.normal;


import com.superyu.bottomtab.R;
import com.superyu.bottomtab.wechatstyle.TabFragment;

public enum MainTab {


    TAB1("TAB1", R.string.tab1_title, R.drawable.tab1_btn, TabFragment1.class),
    TAB2("TAB2", R.string.tab2_title, R.drawable.tab2_btn, TabFragment2.class),
    TAB3("TAB3", R.string.tab3_title, R.drawable.tab3_btn, TabFragment3.class),
    TAB4("TAB4", R.string.tab4_title, R.drawable.tab4_btn, TabFragment4.class);


    private String id;

    private int resName;

    private int resIcon;

    private Class<?> clz;


    private MainTab(String id, int resName, int resIcon, Class<?> clz) {

        this.id = id;
        this.resName = resName;
        this.resIcon = resIcon;
        this.clz = clz;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getResName() {
        return resName;
    }

    public void setResName(int resName) {
        this.resName = resName;
    }

    public int getResIcon() {
        return resIcon;
    }

    public void setResIcon(int resIcon) {
        this.resIcon = resIcon;
    }

    public Class<?> getClz() {
        return clz;
    }

    public void setClz(Class<?> clz) {
        this.clz = clz;
    }
}
