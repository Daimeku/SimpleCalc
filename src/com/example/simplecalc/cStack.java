package com.example.simplecalc;

public class cStack {

	private cNode top;
	private int count;
	
	public cStack(){
		top=null;
		count=0;
	}
	
	public void push(String dat){			// adding the chars
		cNode link= new cNode(dat);
		link.setLink(top);
		top=link;	
		count++;
	}
	
	public String pop(){			// returning the chars
		
		String dat;
		
		if(top==null){
			dat="";
		}
		else{
		cNode tmp=new cNode();
		dat=top.getInf();
		tmp=top;
		top=top.getLink();
		}
		count--;
		return dat;
	}
	
	public String getTop()		// get the data stored in the top node
	{	String tmp;
		
		if(top==null)
			tmp="";
		else
			tmp=top.getInf();
		
		return tmp;
		
	}
	
	public int getCount(){
		return count;
	}
}
