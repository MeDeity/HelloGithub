package com.deity.github;

import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.tl_custom)
    protected Toolbar toolbar;
    private ActionBarDrawerToggle mDrawerToggle;
    @BindView(R.id.dl_left)
    protected DrawerLayout mDrawerLayout;
    @BindView(R.id.lv_left_menu)
    protected ListView lvLeftMenu;
    private ArrayAdapter arrayAdapter;
    private String[] lvs = {"List Item 01", "List Item 02", "List Item 03", "List Item 04"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initToolbar();
    }

    private void initToolbar(){
        toolbar.setTitle("Github");
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true); //设置返回键可用
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mDrawerToggle = new ActionBarDrawerToggle(MainActivity.this,mDrawerLayout,toolbar,R.string.draw_open,R.string.draw_close);
        mDrawerToggle.setDrawerIndicatorEnabled(true);//状态标志
        mDrawerToggle.syncState();
        mDrawerLayout.addDrawerListener(mDrawerToggle);
        //设置菜单列表
        arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, lvs);
        lvLeftMenu.setAdapter(arrayAdapter);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home://toolbar返回键处理
                mDrawerLayout.openDrawer(Gravity.START);
                mDrawerLayout.closeDrawer(Gravity.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
