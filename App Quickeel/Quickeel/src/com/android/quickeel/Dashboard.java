package com.android.quickeel;




import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.LinearLayout.LayoutParams;

public class Dashboard extends Activity {

	   @Override
	    public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.activity_menu);
	        SetTabs();
	    }
	   


	    @Override
	    public boolean onCreateOptionsMenu(Menu menu) {
	        getMenuInflater().inflate(R.menu.activity_home, menu);
	        return true;
	    }
	    
	    
		//Tabs Opciones
		private void SetTabs(){
			
			Resources res = getResources();
			 
			
			TabHost tabs=(TabHost)findViewById(android.R.id.tabhost);
			//tabs.setBackgroundDrawable(getResources().getDrawable(R.drawable.tab_indicator));
			tabs.setup();
		
						
			TabHost.TabSpec spec=tabs.newTabSpec("mitab1");
			spec.setContent(R.id.tab1);
			spec.setIndicator(makeTabIndicator("Quick"));
			tabs.addTab(spec);
			 
			spec=tabs.newTabSpec("mitab2");
			spec.setContent(R.id.tab2);
			spec.setIndicator(makeTabIndicator("Hot Quick"));
			tabs.addTab(spec);
			
			spec=tabs.newTabSpec("mitab3");
			spec.setContent(R.id.tab3);
			spec.setIndicator(makeTabIndicator("Global Quick"));
			tabs.addTab(spec);
			
			
			
			
			tabs.setCurrentTab(0);
		}
		
		private TextView makeTabIndicator(String text){
			TextView tabView = new TextView(this);
			LayoutParams lp3 = new LayoutParams(70, 80, 1);
			lp3.setMargins(0, 0, 0, 0);
			tabView.setLayoutParams(lp3);
			tabView.setText(text);
			tabView.setTextSize(9);
			tabView.setTextColor(Color.BLACK);
			tabView.setGravity(Gravity.CENTER_HORIZONTAL|Gravity.CENTER_VERTICAL);
			tabView.setBackgroundDrawable(getResources().getDrawable(R.drawable.tab_indicator));
			tabView.setPadding(10, 0, 13, 0);
			return tabView;
			}
}
