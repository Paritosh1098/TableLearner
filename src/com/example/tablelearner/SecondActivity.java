package com.example.tablelearner;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Timer;
import java.util.TimerTask;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TableRow;
import android.widget.TextView;

public class SecondActivity extends Activity {
	
	Intent intent;
	int upto;
	 HashSet<String> hs;
	 TextView tw;
	 Iterator<Button> it;
	 DoWork dw;
	 String[] solutionSet;
	 HashSet<String> integerHash ;
	 Iterator<String> integerIterator;
	 String score;
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_second);
		final Activity activity = this;
		
		final TextView _tv = (TextView) findViewById( R.id.time);
	    new CountDownTimer(160000, 1000) {

	        public void onTick(long millisUntilFinished) {
	            _tv.setText("Time remaining: " +new SimpleDateFormat("mm:ss:SS").format(new Date( millisUntilFinished)));
	        }

	        public void onFinish() {
	          activity.finish();
	        }
	     }.start();
		
		
		
		
		/*Timer timer = new Timer();
		timer.schedule(new TimerTask() {

			   public void run() {

			 activity.finish();
			   }

			},10000);
		*/
		
	    intent = getIntent();
	 String uptoString =	intent.getStringExtra("key");
	 upto = Integer.parseInt(uptoString);
	 score = getIntent().getStringExtra("score");
	TextView scoreTextView =  (TextView)findViewById(R.id.score);
	scoreTextView.setText(score);
	 Log.d("1",String.valueOf(upto));
	  dw = new DoWork(upto);
	  hs = dw.generateTable();
	  tw  = (TextView)findViewById(R.id.text);
	  tw.setText(dw.getTable());
      integerHash =  dw.generateSolutionSet(tw.getText().toString());
      integerIterator = integerHash.iterator();
	 HashSet<Button> collection = new HashSet<Button>();
	 collection.add((Button)findViewById(R.id.one));
	 collection.add((Button)findViewById(R.id.two));
	 collection.add((Button)findViewById(R.id.three));
	 collection.add((Button)findViewById(R.id.four));
	 collection.add((Button)findViewById(R.id.five));
	 collection.add((Button)findViewById(R.id.six));
	 collection.add((Button)findViewById(R.id.seven));
	 collection.add((Button)findViewById(R.id.eight));
	 collection.add((Button)findViewById(R.id.nine));
	 Button b =null;
	 it = collection.iterator();
	 int k=0;
	 for(int i=0;i<9;i++)
	 {
		b = it.next();
		
		b.setText(integerIterator.next());
		k++;
	 }
	 
	 
	}
	
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	String check;
	public void One(View view)
	{
		check = ((TextView)findViewById(R.id.one)).getText().toString();
		solutionCheck(check);
	}
	public void Two(View view)
	{
		check = ((TextView)findViewById(R.id.two)).getText().toString();
		solutionCheck(check);
	}
	public void Three1(View view)
	{
		check = ((TextView)findViewById(R.id.three)).getText().toString();
		solutionCheck(check);
	}
	public void Four(View view)
	{
		check = ((TextView)findViewById(R.id.four)).getText().toString();
		solutionCheck(check);
	}
	public void Five(View view)
	{
		check = ((TextView)findViewById(R.id.five)).getText().toString();
		solutionCheck(check);
	}
	public void Six(View view)
	{
		check = ((TextView)findViewById(R.id.six)).getText().toString();
		solutionCheck(check);
	}
	public void Seven(View view)
	{
		check = ((TextView)findViewById(R.id.seven)).getText().toString();
		solutionCheck(check);
	}
	public void Eight(View view)
	{
		check = ((TextView)findViewById(R.id.eight)).getText().toString();
		solutionCheck(check);
	}
	public void Nine(View view)
	{
		check = ((TextView)findViewById(R.id.nine)).getText().toString();
		solutionCheck(check);
	}
	
	public void solutionCheck(String check)
	{
	  
		int n = tw.getText().toString().indexOf('*');
		String a = tw.getText().toString().substring(0, n); 
		String b = tw.getText().toString().substring(n+1); 
		int r = (Integer.parseInt(a))*(Integer.parseInt(b));
		String ans = String.valueOf(r);
		if(ans.equals(check))
		{
			
			generateNextSolution();

		}
		else
		{
			dw.addTable(tw.getText().toString());
			tw.setText(dw.getTable());
			TextView attempts = (TextView)findViewById(R.id.attempts);
		int att = 	(Integer.parseInt(attempts.getText().toString()));
			att--;
			attempts.setText(String.valueOf(att));
			if(att<=0)
			{
				Intent intent = new Intent(this,GameOver.class);
				startActivity(intent);
				this.finish();
			}
		}
		
	}
	public void generateNextSolution()
	{
		
		tw.setText(dw.getTable());
		if(tw.getText().toString().equals("finish"))
		{
			Intent intent = new Intent(this,GameWin.class);
			intent.putExtra("upto",String.valueOf(upto));
			String score = ((TextView)findViewById(R.id.score)).getText().toString();
			intent.putExtra("score",score);
			startActivity(intent);
			this.finish();
		}
		else
		{
		fillArea();
		}
	}
	public void fillArea()
	{
		     integerHash =  dw.generateSolutionSet(tw.getText().toString());
		     
		     
			 HashSet<Button> collection1 = new HashSet<Button>();
			 collection1.add((Button)findViewById(R.id.one));
			 collection1.add((Button)findViewById(R.id.two));
			 collection1.add((Button)findViewById(R.id.three));
			 collection1.add((Button)findViewById(R.id.four));
			 collection1.add((Button)findViewById(R.id.five));
			 collection1.add((Button)findViewById(R.id.six));
			 collection1.add((Button)findViewById(R.id.seven));
			 collection1.add((Button)findViewById(R.id.eight));
			 collection1.add((Button)findViewById(R.id.nine));
			 Button b =null;
			 it = collection1.iterator();
			 int k=0;
			

			
			   integerIterator = integerHash.iterator();
			  Log.d("12",tw.getText().toString());
			  for(String s:integerHash)
			  {
				  Log.d("11", s);
			  }
			  for(k=0;k<9;k++) 
			    {
			      b = it.next();
				 
				  b.setText(integerIterator.next());
				
			
				
			 }
	}
}
