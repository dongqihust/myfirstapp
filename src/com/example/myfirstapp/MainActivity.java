package com.example.myfirstapp;


import android.support.v4.app.FragmentTabHost;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TabHost.TabSpec;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {
	
    private Toolbar toolbar;
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mDrawerToggle;
    private FragmentTabHost fragmentTabHost;
    private String texts[] = {"首页","消息","时间","博客"};
    private int imageButtons[] = {R.drawable.ic_social_mood,R.drawable.ic_social_people_outline,R.drawable.ic_notification_phone_forwarded,R.drawable.ic_maps_local_restaurant};
    private Class fragmentClass[] = {Fragment1.class,Fragment2.class,Fragment3.class,Fragment4.class};
    
  
   
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();
        
      
        fragmentTabHost.setup(this,getSupportFragmentManager(),R.id.maincontent);
        
        for(int i =0;i <texts.length;i++){
        	TabSpec spec = fragmentTabHost.newTabSpec(texts[i]).setIndicator(getView(i));
        	fragmentTabHost.addTab(spec, fragmentClass[i], null);
        	
        	fragmentTabHost.getTabWidget().getChildAt(i).setBackgroundResource(R.drawable.bt_selector);;
        }
        
       
        toolbar.setTitle("测试项目");//
        toolbar.setTitleTextColor(Color.parseColor("#ffffff")); 
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true); //
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        
        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, toolbar, R.string.open, R.string.close) {
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
              
            }
            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
               
            }
        };
        mDrawerToggle.syncState();
        mDrawerLayout.setDrawerListener(mDrawerToggle);
      
      
    }
    private void findViews() {
       fragmentTabHost = (FragmentTabHost) findViewById(R.id.tabhost);
        toolbar = (Toolbar) findViewById(R.id.tl_custom);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.dl_left);
      
    }
    
    private View getView(int i) {
    	         //取得布局实例
    	        View view=View.inflate(MainActivity.this, R.layout.tabcontent, null);
    	         
    	         //取得布局对象
    	         ImageView imageView=(ImageView) view.findViewById(R.id.image);
    	        TextView textView=(TextView) view.findViewById(R.id.text);
    	        
    	        //设置图标
    	        imageView.setImageResource(imageButtons[i]);
    	        //设置标题
             textView.setText(texts[i]);
    	         return view;
    	     }
}
