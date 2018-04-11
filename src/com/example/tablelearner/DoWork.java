package com.example.tablelearner;

import java.util.HashSet;
import java.util.Random;

import android.util.Log;

public class DoWork {

	int upto;
	DoWork(int size)
	{
		upto = size;
	}

	int size=0;
	HashSet<String> hs = new HashSet <String>();

	public HashSet<String> generateTable()
	
	{  	
		size = upto*10;
		StringBuffer[] stringbuffer = new StringBuffer[size];
		for(int l=0;l<size;l++)
		{
			stringbuffer[l] = new StringBuffer("");
		}
		int  k= -1;
	      
	    for(int i=1;i<upto+1;i++)
	     {
	    	for(int j=1;j<=10;j++)
	    	{
	    	     k++;
	         stringbuffer[k].append(String.valueOf(i));
	    	 stringbuffer[k].append("*");
	    	 stringbuffer[k].append(String.valueOf(j));
	    	 hs.add(stringbuffer[k].toString());
	    	} 
	     }
	return hs;
	    	
	}
	public String getTable()
	{
		java.util.Iterator<String>  it = hs.iterator();
		for(String s:hs)
		{
			Log.d("1",s);
		}
		
		if(it.hasNext())
			
		{
			String s = it.next().toString();
			Log.d("1",s );
			hs.remove(s);
			return(s);
		}
		else
		{
		return "finish";
		}
	}
	
	public HashSet<String> generateSolutionSet(String text)
	{
		
		HashSet<String> hashSet = new HashSet<String>();
		int n = text.indexOf('*');
		String a = text.substring(0, n);
		String b = text.substring(n+1);
		int r = (Integer.parseInt(a))*(Integer.parseInt(b));
		String ans = String.valueOf(r);
		
		Random rn = new Random();
		while(hashSet.size()<8)
		{
		int j = rn.nextInt(200);
		if(j==Integer.parseInt(ans))
		{
			j=j+1;
		}
		hashSet.add(String.valueOf(j));
		}
		Log.d("size",String.valueOf(hashSet.size()));
        hashSet.add(ans);
        Log.d("size again",String.valueOf(hashSet.size()));
        return hashSet;
	}
	public void addTable(String s)
	{
		hs.add(s);
	}
	
	
	
}
