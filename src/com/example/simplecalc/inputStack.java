package com.example.simplecalc;

public class inputStack {

	private inData top;
	private int count;
	
	public inputStack(){
		top=null;
		count=0;
	}
	
	public inputStack(inData t){
		top=t;
		
		if(top==null)		// checking if null node
			count=0;
		else
			count=1;
	}
	
	public void push(char dat){			// adding the chars
		inData link= new inData(dat);
		link.setLink(top);
		top=link;		
	}
	
	public char pop(){			// returning the chars
		
		char dat;
		
		if(top==null){
			dat=' ';
		}
		else{
		inData tmp=new inData();
		dat=top.getData();
		tmp=top;
		top=top.getLink();
		}
		return dat;
	}
	
	public char getTop()		// get the data stored in the top node
	{	char tmp;
		
		if(top==null)
			tmp=' ';
		else
			tmp=top.getData();
		
		return tmp;
		
	}
}
