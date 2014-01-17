package com.example.simplecalc;

//import inputStack;
//import cStack;
//import inputStack;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {
	
	
	 protected int priority(char c){
		int p=0;
		
		switch(c){
		case '^': p=3;
					break;
		case '*': p=2;
					break;
		case '/': p=2;
					break;
		case '+': p=1;
					break;
		case '-': p=1;
					break;
		default: p=0;
					break;
		}
		
		return p;
	}
	
	 protected String postFix(String inf){		// converting from infix string to postfix string and returning it
		String postF="";
		inputStack stak = new inputStack();
		
		for(int i=0;i<inf.length();i++){	// iterating through the infix string and comparing each character
			char c=inf.charAt(i);
			int p;
			
			if( (c=='*') || (c=='/') || (c=='+') || (c=='-') || (c=='^') ){		// if the current character is an operator==============================
				postF+=" ";
				if(stak.getTop()==' '){  					// if the stack is empty
					stak.push(c);
					
				}
				else{										// if the stack isn't empty 
					
					while(priority(stak.getTop()) >= priority(c) && stak.getTop() != ' '){	// if the top of the stack is a higher priority than c
						postF+= stak.pop();
						}
					stak.push(c);
					
				}
			}
			else{	// if the current character is an operand===============================================================================
				postF+=c;
				}
		} // end for
		
		while( stak.getTop() !=' '){		// after loop has exited add operations to end of postF string
			postF+=stak.pop();
		}
	
		return postF;
	}
	
	protected  boolean isOp(String c){		// test if the string is an operation -- single strings
		boolean an=false;
		
		if( (c.equals("*")) || (c.equals("/")) || (c.equals("+")) || (c.equals("-")) || (c.equals("^")) ){
			an=true;
		}
		
		if( an==false)
			System.out.println(" False");
		else
			System.out.println("TRUE");

		
		return an;
	}
	
	protected boolean checkString(String inp){					// checking the format of the string before calculation
		boolean check=false;
		int oc=0;
		if(inp.equals("")){
			check=false;
			return check;
		}
		
		for(int i=0;i<inp.length();i++){
			
			if(isOp(inp.charAt(i))){
				oc++;
			}
			
		}
		
		if( (!isOp(inp.charAt(inp.length()-1))) && (oc>0) ){
			check=true;
		}
		
		
			
		
		return check;
	}
	
	protected boolean isSpec(char c){			// test if the character is a special character
		boolean an=false;
		
		if( (c=='*') || (c=='/') || (c=='+') || (c=='-') || (c=='^') || (c=='.') ){
			an=true;
		}
		/*
		if( an==false)
			System.out.println(" False2");
		else
			System.out.println("TRUE2");
		*/
		return an;
	}
	
	protected boolean isOp(char c){			// test if the character is an operation 
		boolean an=false;	
		
		if( (c=='*') || (c=='/') || (c=='+') || (c=='-') || (c=='^') ){
			an=true;
		}
		
		if( an==false)
			System.out.println(" False2");
		else
			System.out.println("TRUE2");
		return an;
	}

protected  double calculate(String ss2, String ss1, String sop){		// accepts strings, does calculations and returns double
	/*
	String s1= new StringBuilder(ss2).reverse().toString();
	String s2= new StringBuilder(ss1).reverse().toString();
	*/
	
	String s1=ss2;
	String s2=ss1;
	double n2= Double.parseDouble(s2);
	double n1= Double.parseDouble(s1);
	char op= sop.charAt(0);
	double ans=0;
	
	switch(op){
	case'*': ans= n1 *n2;
			break;
	case '/': ans= n1/n2;
			break;
	case '-': ans= n1-n2;
			break;
	case'+': ans=n1+n2;
			break;
	case '^': ans= Math.pow(n1,n2);
			break;
	}
	
	System.out.println(" Ans: "+ans);
	return ans;
	
}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		final TextView screen = (TextView) findViewById(R.id.screen);		// the textView for the screen
		screen.setTextSize(30);
		screen.setText("0");
		
		final inputStack ops= new inputStack();								// stack to store numbers and operations
		
		
		
		
		
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
				
				ops.push('1');
				
			}
		});
		
		//========= TWO====================================================
		Button two= (Button) findViewById(R.id.two);
		
		two.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				String inp,tex;
				inp="2";
				 tex= screen.getText().toString();
				 tex= tex+inp;
				 screen.setText(tex);
				 
				 // add to stack here
				
			}
		});
					//========= THREE====================================================
		Button three= (Button) findViewById(R.id.three);
		
		
		three.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				String inp, tex;
				inp="3";
				tex= screen.getText().toString();
				tex= tex+inp;
				screen.setText(tex);
			}
		});
						//========= four====================================================
		Button four= (Button) findViewById(R.id.four);
		
		four.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
				String inp, tex;
				inp="4";
				tex= screen.getText().toString();
				tex= tex+inp;
				screen.setText(tex);
				
			}
		});
		//==============================================FIVE================
		Button five= (Button) findViewById(R.id.five);
		
		five.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String inp, tex;
				inp="5";
				tex= screen.getText().toString();
				tex= tex+inp;
				screen.setText(tex);
			}
		});
		//=============================================SIX=========================
		Button six= (Button) findViewById(R.id.six);
		
		six.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String inp, tex;
				inp="6";
				tex= screen.getText().toString();
				tex= tex+inp;
				screen.setText(tex);
				
			}
		});
		
		//=========================================SEVEN==================
		Button seven = (Button) findViewById(R.id.seven);
		
		seven.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String inp, tex;
				inp="7";
				tex= screen.getText().toString();
				tex= tex+inp;
				screen.setText(tex);
			}
		});
		
		//========================================================EIGHT=======
		Button eight =(Button) findViewById(R.id.eight);
		
		eight.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String inp, tex;
				inp="8";
				tex= screen.getText().toString();
				tex= tex+inp;
				screen.setText(tex);
			}
		});
		//=======================================NINE======================
		Button nine = (Button) findViewById(R.id.nine);
		
		nine.setOnClickListener(new View.OnClickListener(){
			@Override
			public void onClick(View v){
				
				String inp, tex;
				inp="9";
				tex= screen.getText().toString();
				tex= tex+inp;
				screen.setText(tex);
			}
		});
		//==================================================ZERO========================
		Button zero = (Button) findViewById(R.id.zero);
		
		zero.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String inp, tex;
				inp="0";
				tex= screen.getText().toString();
				tex= tex+inp;
				screen.setText(tex);
			}
		});
		
		//==========================DECIMAL=======================
		
		Button deci= (Button) findViewById(R.id.decimal);
		
		deci.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				String inp, tex;
				inp=".";
				tex= screen.getText().toString();
				if(isSpec(tex.charAt(tex.length()-1))){
					tex=tex.subSequence(0, tex.length()-1).toString();
					tex=tex+inp;
					}
					else{
					tex= tex+inp;
					}
				screen.setText(tex);
				
				
			}
		});
		
		//========================DELETE========================
		Button del= (Button) findViewById(R.id.delete);
		
		del.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				String tex=screen.getText().toString();
				String ntex="";
				for(int i=0;i<tex.length()-1;i++){
					ntex+= tex.charAt(i);
				}
				screen.setText(ntex);
				
			}
		});
		
		//NEW ADD BUTTON=======================================================================
				Button add = (Button) findViewById(R.id.add);
				
				add.setOnClickListener(new View.OnClickListener() {
					@Override 
					public void onClick(View v) {
						// TODO Auto-generated method stub
						String inp, tex;
						inp="+";
						tex= screen.getText().toString();
						
						if(isSpec(tex.charAt(tex.length()-1))){
							tex=tex.subSequence(0, tex.length()-1).toString();
							tex=tex+inp;
						}
						else{
							tex= tex+inp;
						}
						screen.setText(tex);
						
					}
				});
				//======================CLEAR BUTTON
				Button clear= (Button) findViewById(R.id.clear);
				
				clear.setOnClickListener(new View.OnClickListener() {
					
					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						String inp, tex;
						inp="+";
						tex="";
						
						screen.setText(tex);
					}
				});
				//====================================EXPONENENT========================
				Button expo= (Button) findViewById(R.id.exp);
				
				expo.setOnClickListener(new View.OnClickListener() {
					
					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						String inp, tex;
						inp="^";
						tex= screen.getText().toString();
						if(isSpec(tex.charAt(tex.length()-1))){
							tex=tex.subSequence(0, tex.length()-1).toString();
							tex=tex+inp;
							}
							else{
								tex= tex+inp;
							}
						screen.setText(tex);
					}
				});
				
				//=================DIVIDE==============================================
				Button divide= (Button) findViewById(R.id.divide);
				
				divide.setOnClickListener(new View.OnClickListener(
						) {
					
					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						String inp, tex;
						inp="/";
						tex= screen.getText().toString();
						if(isSpec(tex.charAt(tex.length()-1))){
							tex=tex.subSequence(0, tex.length()-1).toString();
							tex=tex+inp;
							}
							else{
							tex= tex+inp;
							}
						screen.setText(tex);
					}
				});
				
				//==================================MULTIPLY=========================
				Button multiply = (Button) findViewById(R.id.multiply);
				
				multiply.setOnClickListener(new View.OnClickListener() {
					
					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						String inp, tex;
						inp="*";
						tex= screen.getText().toString();
						if(isSpec(tex.charAt(tex.length()-1))){
							tex=tex.subSequence(0, tex.length()-1).toString();
							tex=tex+inp;
							}
							else{
							tex= tex+inp;
							}
						screen.setText(tex);
					}
				});
		//===================================================SUBTRACT BUTTON===============================
		Button subtract= (Button) findViewById(R.id.subtract);
		
		subtract.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String inp, tex;
				inp="-";
				tex= screen.getText().toString();
				if(isSpec(tex.charAt(tex.length()-1))){
					tex=tex.subSequence(0, tex.length()-1).toString();
					tex=tex+inp;
					}
					else{
					tex= tex+inp;
					}
				screen.setText(tex);
			}
		});
		//=================================================EQUALS============
		Button eq= (Button) findViewById(R.id.equal);
		
		eq.setOnClickListener(new View.OnClickListener() { 			// to calculate------ work out logic
			
			@Override
			public void onClick(View v) {
				
				
				// TODO Auto-generated method stub
				cStack stakk= new cStack(); 		// stack to track operations 
				double ans=0;
				String n="";
			
				//	String inf="1+211-24/6";
				
				String inf=screen.getText().toString();
			if(checkString(inf)){	 // IF THE STRING HAS NO SYNTAX ERRORS
				
				String postF= postFix(inf);						// getting postFix string
				
				for(int i=postF.length()-1;i>=0;i--){
					char c=postF.charAt(i);
				//	System.out.println("n: "+n+"    c: "+c+"    top: "+stakk.getTop());
					
					if( (c!=' ') && (c!='*') && (c!='/') && (c!='^') && (c!='-') && (c!='+') /*|| (i==0)*/ ){		//if current char isnt a special character keep scanning to make number
						n+=c;
					}
					else{
						
						
						if(n.equals("") || n.equals(" ")){			// if there's nothing in n
							
							if(isOp(c)){	// check if c is an operator and add it to stack
								
								String d="";
								d+=c;
								stakk.push(d);
							
							}
						}
						
						else{			// if n has a value
												
							if(isOp(stakk.getTop())){		// if stack top isnt a number
									
								stakk.push(n);		
							}
							else if(!isOp(stakk.getTop())){		// if stack top is a number
								
								String n2=stakk.pop();				// pop twice from stack and calculate using the 2 numbers and the operation
								String op=stakk.pop();
							
								
								String s1= new StringBuilder(n).reverse().toString();
								String s2= new StringBuilder(n2).reverse().toString();
								
								double tem= calculate(s1,s2,op);
								String p= String.valueOf(tem);
								stakk.push(p);
								
							
							}
							
							if(c!=' '){
							String cc="";		// add operation to the stack after processing
							cc+=c;
							stakk.push(cc);
							}
							n="";
						}						
						
					}
				}
				String s1= new StringBuilder(n).reverse().toString();
				n=s1;
			// outer loop
				
				while( stakk.getCount() >1){
					
					if(n.equals("") || n.equals(" ")){
						String n1=stakk.pop();
						String n2=stakk.pop();				// pop twice from stack and calculate using the 2 numbers and the operation
						String op=stakk.pop();
					//	 n1= new StringBuilder(n).reverse().toString();
					//	 n2= new StringBuilder(n2).reverse().toString();
						
						n2= new StringBuilder(n2).reverse().toString();
						double tem= calculate(n1,n2,op);
						String p= String.valueOf(tem);
						stakk.push(p);
						
					}
					else{
						String n2=stakk.pop();				// pop twice from stack and calculate using the 2 numbers and the operation
						String op=stakk.pop();
						;
						
						 n2= new StringBuilder(n2).reverse().toString();
						double tem= calculate(n,n2,op);
						String p= String.valueOf(tem);
						stakk.push(p);
						n="";
					}
					
				}
				String an=stakk.pop();
				
				ans=Double.parseDouble(an);
				
				screen.setText(an);
				//return ans;
			
			}
			else{
				screen.setText(inf);
			}
			
			}});
		
			
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
