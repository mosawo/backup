package com.human;

public class HumanName {
	public String sei;
	private String mei;

public HumanName(){
	sei = "私は";
	mei = "ほんま";
}
public HumanName(String sei,String mei){
	this.sei = sei;
	this.mei = mei;
}



public String getName(){
	return sei + mei;
}
public String getMei(){
	return mei;
}





public void setName(String sei,String mei){
	this.mei = mei;
	this.sei = sei;
}









}