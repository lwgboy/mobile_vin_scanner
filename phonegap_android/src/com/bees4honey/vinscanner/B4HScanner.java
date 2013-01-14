package com.bees4honey.vinscanner;

import android.content.Context;
import android.util.Log;

// Class-wrapper for working with native code
public class B4HScanner 
{
	public float	acuracy;
	
	// load native library when initializing
	static
	{ 
		System.loadLibrary("b4hvinscanner"); 
	};

	// constructor
	public B4HScanner()
	{
		super();
		acuracy = 1.0f;
	}
	
	private void callback(int depth) 
	{
	    if (depth < 5) 
	    {
	    	Log.d("", "In Java, depth = " + depth + ", about to enter C");
	    	
	      	System.out.println("In Java, depth = " + depth + ", back from C");
	    } 
	    else
	    {
	    	System.out.println("In Java, depth = " + depth + ", limit exceeded");
	    }
	}
	
	// parse VIN code from "data" or NULL if VIN code not found
	public native String parse( byte []data, int size, int width, int height, int q, Context context);
	
	// check status of Bees4Honey scanner license
	public native int status(Context context);
}
