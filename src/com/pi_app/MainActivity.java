package com.pi_app;



import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {

	  Button btn ;
		@Override
		protected void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
			setContentView(R.layout.activity_main);
			
			btn = (Button) findViewById(R.id.button2);
			btn.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					BtnOnclick();
				}
			});
		}


		
		public void BtnOnclick()
		{
		    Intent i = new Intent(this,ForYou.class);
		    startActivity(i);
		}


}
