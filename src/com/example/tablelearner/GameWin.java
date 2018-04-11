package com.example.tablelearner;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;

public class GameWin extends Activity {
	
	int upto;
	int score;
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_win);
		upto = Integer.parseInt(getIntent().getStringExtra("upto"));
		 score = Integer.parseInt(getIntent().getStringExtra("score"));
		score++;
		final GameWin gm = this;
		Timer timer = new Timer();
		timer.schedule(new TimerTask() {

			   public void run() {

			     Intent intent = new Intent(gm,SecondActivity.class);
			     intent.putExtra("key",String.valueOf(++upto));
			     intent.putExtra("score",String.valueOf(score));
			     startActivity(intent);
			     gm.finish();

			   }

			},3000);

		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
