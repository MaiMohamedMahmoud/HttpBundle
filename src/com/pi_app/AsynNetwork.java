package com.pi_app;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;


import android.app.Activity;
import android.os.AsyncTask;

public class AsynNetwork extends AsyncTask<String, Void, String>{

	
	private Activity activity;
	private AsyncListnerCallBack CallBack ;
	
	public AsynNetwork(Activity Asyn)
	{
		this.activity = Asyn;
		this.CallBack = (AsyncListnerCallBack) Asyn ;
	}
	
	@Override
	protected String doInBackground(String... arr) {
		// TODO Auto-generated method stub
		android.os.Debug.waitForDebugger();
		String input= "";
	/*	try {
			URL url = new URL(arr[0]);
			URLConnection conn= url.openConnection();
			
			InputStream inStream = conn.getInputStream();
			InputStreamReader reader = new InputStreamReader(inStream);
			BufferedReader buffer = new BufferedReader(reader);
		*/
		for(String url : arr)
		{
			
	    DefaultHttpClient client = new DefaultHttpClient();
        HttpGet httpGet = new HttpGet(url);
        try {
          HttpResponse execute = client.execute(httpGet);
          InputStream content = execute.getEntity().getContent();

          BufferedReader buffer = new BufferedReader(new InputStreamReader(content));
        
			String s ="";
			
			
			
			while((s= buffer.readLine())!=null)
			{
				input+=s;
			}
			
			
			
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		
		}
        return input;
		
		
		
	}

	/* (non-Javadoc)
	 * @see android.os.AsyncTask#onPostExecute(java.lang.Object)
	 */
	@Override
	protected void onPostExecute(String result) {
		// TODO Auto-generated method stub
		super.onPostExecute(result);
		
/*
		JSONArray jsonOb;
		String name ="";
		String pass ="";
		try {
			jsonOb = new JSONArray(result);
		
		
		for (int i = 0; i < jsonOb.length(); i++) {
		try {
		

			
	             JSONObject menuObject;
	             menuObject = jsonOb.getJSONObject(i);
	             name  = menuObject.getString("username");
				 pass = menuObject.getString("password");
		      
		}catch (JSONException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		}} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		};
		*/
		
		
		/*	try {
		JSONArray jObject = new JSONArray(result);
		  for (int i = 0; i < jObject.length(); i++) {
	             JSONObject menuObject = jObject.getJSONObject(i);

	              name += menuObject.getString("username");
	              pass += menuObject.getString("password");
	         
	        }
	} catch (JSONException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
  
*/
		
		
		//this is the working one :) 
		/*
		String name = "";
		String pass = "";
	

		JSONArray jsonProduct_jsonarray;
		try { 
	        JSONObject get_string = new JSONObject(result.toString()); 

	        jsonProduct_jsonarray = new JSONArray();

	        jsonProduct_jsonarray = get_string .getJSONArray("users");

	        // Receive the JSON object from server
	        for (int i = 0; i < jsonProduct_jsonarray.length(); i++) {

	            System.out.println("GOT JSON VALUE ");
	            JSONObject c = jsonProduct_jsonarray.getJSONObject(i);

	             name += c.getString("username");
	             pass += c.getString("password"); 
	        }
		}
		catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
      
		
		parent.tvName.setText(name);
		parent.tvPass.setText(pass);
		*/
		CallBack.OntaskComplete(result);
		}
}
