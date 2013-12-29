package com.example.simplecalc;

public class inData {

	private char data;
	private inData link;
	
	public inData(){
		data=' ';
		link=null;		
	}
	
	public inData(char d){
		data=d;
		link=null;
	}
	
	public inData(char d, inData l){
		data=d;
		link=l;
	}
	
	public void setData(char d){
		data=d;
	}
	
	public char getData(){
		return data;
	}
	public void setLink(inData l){
		link=l;
	}
	
	public inData getLink(){
		return link;
	}
	
	
	
}
