package com.pi_app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class ForYou  extends Activity{
	
	
    Button btn ;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.foryou);
		btn = (Button) findViewById(R.id.button_new);
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
	    Intent i = new Intent(this,News.class);
	    startActivity(i);
	}

}
