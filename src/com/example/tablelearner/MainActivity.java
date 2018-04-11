package com.example.tablelearner;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends Activity {

	Intent intent;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		intent = new Intent(this,SecondActivity.class);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	public void Second(View view)
	{
		intent.putExtra("key",((EditText)findViewById(R.id.upto)).getText().toString());
		intent.putExtra("score",String.valueOf(0));
		startActivity(intent);
	}
	public void Inc(View view)
	{
		EditText et = (EditText)findViewById(R.id.upto);
		int a = Integer.parseInt(et.getText().toString());
		a++;
		et.setText(String.valueOf(a));
		
		
	}
	public void Dec(View view)
	{
		EditText et = (EditText)findViewById(R.id.upto);
		int a = Integer.parseInt(et.getText().toString());
		a--;
		et.setText(String.valueOf(a));
		
		
	}
}
