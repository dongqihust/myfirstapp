package com.example.myfirstapp;

import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;



import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import android.support.v4.widget.SwipeRefreshLayout;  

public class Fragment2 extends  Fragment implements SwipeRefreshLayout.OnRefreshListener{
	
	private static final int REFRESH_COMPLETE = 0X110;  
	private SwipeRefreshLayout mSwipeLayout;
	private ListView mListViw;
	private ArrayAdapter<String> mAdapter;
	private List<String> mDatas = new ArrayList<String>(Arrays.asList("Java", "Javascript", "C++", "Ruby", "Json",  
	            "HTML")); 
	
	private Handler mHandler = new Handler(){

		@Override
		public void handleMessage(Message msg) {
			// TODO Auto-generated method stub
			switch (msg.what) {
			case REFRESH_COMPLETE:
				mDatas.add(0, "lucene");
				mDatas.add(0, "Canvas");
				
				mAdapter.notifyDataSetChanged();
				mSwipeLayout.setRefreshing(false);			
				break;

			default:
				break;
			}
		}
		
	};
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		// TODO Auto-generated method stubs
		View contentView =   inflater.inflate(R.layout.fragment_layout2, container, false);
		
		mListViw = (ListView) contentView.findViewById(R.id.id_listview);  
		mSwipeLayout = (SwipeRefreshLayout) contentView.findViewById(R.id.id_swipe_ly); 
		mSwipeLayout.setOnRefreshListener(this);
		mSwipeLayout.setColorScheme(android.R.color.holo_blue_bright, android.R.color.holo_green_light,  
                android.R.color.holo_orange_light, android.R.color.holo_red_light);  
		
		   mAdapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_list_item_1, mDatas);  
		   mListViw.setAdapter(mAdapter);  
		   onRefresh();
		   return contentView;
		
	}
	
	@Override
	public void onRefresh() {
		// TODO Auto-generated method stub
		mHandler.sendEmptyMessageDelayed(REFRESH_COMPLETE, 0);  
	}

}
