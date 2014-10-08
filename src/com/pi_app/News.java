package com.pi_app;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.R;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class News  extends Activity implements AsyncListnerCallBack{

	
	TextView txnew;
Button btn ;
ListView list;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.id.yarab)
		btn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				connection();
			}
		});
	
	}

	

		@Override
		public void OntaskComplete(String str) {
			// TODO Auto-generated method stub
		String news[] =null;
		String n = "";
			JSONArray jsonProduct_jsonarray;
			try { 
		        JSONObject get_string = new JSONObject(str.toString()); 

		        jsonProduct_jsonarray = new JSONArray();

		        jsonProduct_jsonarray = get_string .getJSONArray("users");

		        // Receive the JSON object from server
		        for (int i = 0; i < jsonProduct_jsonarray.length(); i++) {

		            System.out.println("GOT JSON VALUE ");
		            JSONObject c = jsonProduct_jsonarray.getJSONObject(i);

		             news[0]= c.getString("news");
		      
		        }
		        
	             ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
	                     android.R.layout.simple_list_item_1, android.R.id.text1, news);
			}
			
			catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	      
	//		txnew.setText(news);
		
	}
	
		public void connection()
		{
	         AsynNetwork con = new AsynNetwork(this);
		
			con.execute(new String[] { "http://192.168.1.10:8080/newOne.php" });
			
		}
}
