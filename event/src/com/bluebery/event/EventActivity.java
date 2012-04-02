package com.bluebery.event;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.widget.ImageView;

public class EventActivity extends Activity {
	
	ImageView current1Event10DigNumberPic;
	ImageView current1EventDigNumberPic;
	ImageView current1Heat10DigNumberPic;
	ImageView current1HeatDigNumberPic;
	ImageView current2Event10DigNumberPic;
	ImageView current2EventDigNumberPic;
	ImageView current2Heat10DigNumberPic;
	ImageView current2HeatDigNumberPic;
	ImageView regCurrentEvent10DigNumberPic;
	ImageView regCurrentEventNumberPic;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initial();
    }
    
    public void onResume() {
    	super.onResume();
    	initial();
    }
    
    private void initial() {
    	int QUERY_INTERVAL = 20000;
    	
    	setContentView(R.layout.main);
        current1Event10DigNumberPic = (ImageView) findViewById(R.id.event1Event10DigPic);
        current1Event10DigNumberPic.setImageResource(R.drawable.num_0);
        
        current1EventDigNumberPic = (ImageView) findViewById(R.id.event1EventDigPic);
        current1EventDigNumberPic.setImageResource(R.drawable.num_0);
        
        current1Heat10DigNumberPic = (ImageView) findViewById(R.id.event1Heat10DigPic);
        current1Heat10DigNumberPic.setImageResource(R.drawable.num_0);
        
        current1HeatDigNumberPic = (ImageView) findViewById(R.id.event1HeatDigPic);
        current1HeatDigNumberPic.setImageResource(R.drawable.num_0);
        
        current2Event10DigNumberPic = (ImageView) findViewById(R.id.event2Event10DigPic);
        current2Event10DigNumberPic.setImageResource(R.drawable.num_0);
        
        current2EventDigNumberPic = (ImageView) findViewById(R.id.event2EventDigPic);
        current2EventDigNumberPic.setImageResource(R.drawable.num_0);
        
        current2Heat10DigNumberPic = (ImageView) findViewById(R.id.event2Heat10DigPic);
        current2Heat10DigNumberPic.setImageResource(R.drawable.num_0);
        
        current2HeatDigNumberPic = (ImageView) findViewById(R.id.event2HeatDigPic);
        current2HeatDigNumberPic.setImageResource(R.drawable.num_0);
        
        regCurrentEvent10DigNumberPic = (ImageView) findViewById(R.id.regEvent10DigPic);
        regCurrentEvent10DigNumberPic.setImageResource(R.drawable.num_0);
        
        regCurrentEventNumberPic = (ImageView) findViewById(R.id.regEventDigPic);
        regCurrentEventNumberPic.setImageResource(R.drawable.num_0);
        
        // start the service to fresh the data
		Intent intent = new Intent(this, BackendService.class);
		PendingIntent pendingIntent = PendingIntent.getService(this, -1,intent, PendingIntent.FLAG_UPDATE_CURRENT);
		AlarmManager alarmManager = (AlarmManager)getSystemService(ALARM_SERVICE);
		alarmManager.setInexactRepeating(AlarmManager.RTC, SystemClock.elapsedRealtime(), QUERY_INTERVAL, pendingIntent); //System.currentTimeMillis()  AlarmManager.ELAPSED_REALTIME
	   	  
    }
}