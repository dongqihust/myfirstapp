package com.example.myfirstapp;


import com.viewpagerindicator.TabPageIndicator;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

public class Fragment1 extends  Fragment{

	private static final String[] TITLE = new String[] { "头条", "房产", "另一面", "女人",  
            "财经", "数码", "情感", "科技" };  
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		
		//ViewPager的adapter 
	   
        return inflater.inflate(R.layout.fragment_layout1, container, false);
		
	}
	
//	 @Override
//     public void onActivityCreated(Bundle savedInstanceState) {
//		  
//	        FragmentPagerAdapter adapter = new TabPageIndicatorAdapter(getChildFragmentManager());  
//	        ViewPager pager = (ViewPager)getView().findViewById(R.id.pager);  
//	        pager.setAdapter(adapter);  
//	  
//	        //实例化TabPageIndicator然后设置ViewPager与之关联  
//	        TabPageIndicator indicator = (TabPageIndicator)getView().findViewById(R.id.indicator);  
//	        indicator.setViewPager(pager);  
//	          
//	        //如果我们要对ViewPager设置监听，用indicator设置就行了  
//	        indicator.setOnPageChangeListener(new OnPageChangeListener() {  
//	              
//	            @Override  
//	            public void onPageSelected(int arg0) {  
//	                Toast.makeText(getContext(), TITLE[arg0], Toast.LENGTH_SHORT).show();  
//	            }  
//	              
//	            @Override  
//	            public void onPageScrolled(int arg0, float arg1, int arg2) {  
//	                  
//	            }  
//	              
//	            @Override  
//	            public void onPageScrollStateChanged(int arg0) {  
//	                  
//	            }  
//	        });  
//	    
//	 }
//	

	/** 
     * ViewPager适配器 
     * @author len 
     * 
     */  
    class TabPageIndicatorAdapter extends FragmentPagerAdapter {  
        public TabPageIndicatorAdapter(FragmentManager fm) {  
            super(fm);  
        }  
  
        @Override  
        public Fragment getItem(int position) {  
            //新建一个Fragment来展示ViewPager item的内容，并传递参数  
            Fragment fragment = new ItemFragment();    
            Bundle args = new Bundle();    
            args.putString("arg", TITLE[position]);    
            fragment.setArguments(args);    
              
            return fragment;  
        }  
  
        @Override  
        public CharSequence getPageTitle(int position) {  
            return TITLE[position % TITLE.length];  
        }  
  
        @Override  
        public int getCount() {  
            return TITLE.length;  
        }  
    }  
}
