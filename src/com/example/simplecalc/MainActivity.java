package com.example.simplecalc;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {
	
	public  void addit(View view) // add button==================================================
	{
		EditText num1= (EditText) findViewById(R.id.num1);			// making an editText object to match the xml editText
		EditText num2= (EditText) findViewById(R.id.num2);
		
		String snum1= num1.getText().toString();			// getting the text from the editText fields
		String snum2= num2.getText().toString();			// editText stores strings so they have to be parsed to ints
		
		int n1,n2,sum;			// integers to store the values from the edittext
			if(snum1=="")			// if field is empty set n1 to 0
				n1=0;
			else
				n1= Integer.parseInt(snum1); 	// parsing the string to an int
		
		n2= Integer.parseInt(snum2);
		
		sum= n1+n2;
		String ans = Integer.toString(sum);		// setting the number to a string so it can be displayed by the textview
		
		TextView result= (TextView) findViewById(R.id.result);		// textView object to show answer
		result.setTextSize(30);
		result.setText(ans);										// setting the answer to the textview
		
		
		
		
	}
	
	public void subit(View view){  // subtract button============================================
		
		EditText num1 = (EditText) findViewById(R.id.num1);
		EditText num2= (EditText) findViewById(R.id.num2);
		
		String snum1, snum2;
		snum1 = num1.getText().toString();
		snum2 = num2.getText().toString();
		
		int n1, n2, diff;
		
		n1= Integer.parseInt(snum1);
		n2= Integer.parseInt(snum2);
		
		diff= n1-n2;
		
		String ans= Integer.toString(diff);
		
		TextView result = (TextView) findViewById(R.id.result);
		result.setTextSize(30);
		result.setText(ans);
	}
	
	
	
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		final TextView screen = (TextView) findViewById(R.id.screen);		// the textview for the screen
		screen.setTextSize(30);
		screen.setText("0");
		
		//Multiply button=======================================================================
		Button multi = (Button) findViewById(R.id.multiply);
		
		multi.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				EditText num1= (EditText) findViewById(R.id.num1);
				EditText num2= (EditText) findViewById(R.id.num2);
				
				String snum1, snum2;
				snum1= num1.getText().toString();
				snum2= num2.getText().toString();
				
				int n1, n2, prod;
				
				n1= Integer.parseInt(snum1);
				n2= Integer.parseInt(snum2);
				
				prod=n1 * n2;
				
				String ans = Integer.toString(prod);
				
				TextView result = (TextView) findViewById(R.id.result);
				result.setTextSize(30);
				result.setText(ans);
				
				// TODO Auto-generated method stub
				
			}
		});
		
		// divide button=========================================================================
		Button divi = (Button) findViewById(R.id.divide);
		
		divi.setOnClickListener(new View.OnClickListener() {
			@Override 
			public void onClick(View v) {
				// TODO Auto-generated method stub
				EditText num1= (EditText) findViewById(R.id.num1);
				EditText num2= (EditText) findViewById(R.id.num2);
				
				String snum1, snum2;
				snum1= num1.getText().toString();
				snum2= num2.getText().toString();
				
				int n1, n2, quo;
				
				n1= Integer.parseInt(snum1);
				n2= Integer.parseInt(snum2);
				
				quo=n1/n2;
				
				String ans = Integer.toString(quo);
				
				TextView result = (TextView) findViewById(R.id.result);
				result.setTextSize(30);
				result.setText(ans);
				
			}
		});
		
		//===== ONE ===============================================================
		Button one= (Button) findViewById(R.id.one);
		
		one.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String inp,tex; 
				inp="1";
				
				tex= screen.getText().toString();
				tex=tex+inp;
				screen.setText(tex);
				
				//here is  where the number would be added to the stack
				
				
			}
		});
		
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
