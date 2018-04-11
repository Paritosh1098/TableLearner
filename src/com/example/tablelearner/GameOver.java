package com.example.tablelearner;

import java.util.Timer;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import java.util.TimerTask;

public class GameOver extends Activity {
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_gameover);
		Timer timer = new Timer();
		final Activity activity = this;
		timer.schedule(new TimerTask() {

			   public void run() {

			 activity.finish();
			   }

			},5000);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
