package com.example.simplecalc;

public class cNode {
			
	private String inf;
	private cNode link;
	
	public cNode(){
		inf="";
		link=null;
	}
	
	public cNode(String i){
		inf=i;
		link=null;
	}
	
	public cNode(String i, cNode l){
		inf=i;
		link=l;
	}

	public String getInf() {
		return inf;
	}

	public void setInf(String inf) {
		this.inf = inf;
	}

	public cNode getLink() {
		return link;
	}

	public void setLink(cNode link) {
		this.link = link;
	}
	
	
	
}
