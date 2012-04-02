package com.bluebery.event;

import java.io.*;
import java.util.LinkedList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONObject;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;



	  public class BackendService extends IntentService{

			private static final String TAG = "BackendService";
	
		    

		    
			public BackendService(){
				super(TAG);
				Log.d(TAG, "UpdateService constructed");
				
			}
				
			@Override
			protected void onHandleIntent(Intent inIntent) {

				String URL_ADDRESS = "http://10.0.2.2/sites/elgg/services/api/rest/json/?"; //http://localhost/sites/elgg/services/api/rest/json/?method=test.echo&string=testing
					
				JSONArray eventInfoJson = null;
				
				//require the latest topics from web				  
				 String url = URL_ADDRESS; //http://127.0.0.1/sites/elgg/services/api/rest/xml/?method=test.echo&string=testing
				 List<NameValuePair> params = new LinkedList<NameValuePair>();          
				 params.add(new BasicNameValuePair("method", "test.echo"));   
				 params.add(new BasicNameValuePair("string", "testing"));    
				 url += URLEncodedUtils.format(params, "utf-8");      
				 try {
					 HttpClient hc = new DefaultHttpClient();
					 HttpGet getUrl = new HttpGet(url);
					 HttpResponse responseGet = hc.execute(getUrl);
					 InputStream content = responseGet.getEntity().getContent();
					 if (content != null) {
					   String line;     	   
					   BufferedReader rd = new BufferedReader(new InputStreamReader(content));      // Read response until the end     		   
					   line = rd.readLine();
					   JSONObject jo = new JSONObject(line);
					   line = jo.getString("result");
					   eventInfoJson = new JSONArray(line);
					 }	
				}catch(Exception e){
			      e.printStackTrace();
				}

			}


}
