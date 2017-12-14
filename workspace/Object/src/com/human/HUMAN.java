package com.human;



public class HUMAN {

	public static String sei;
	public static String mei;

	public static void main(String[] args) {
		
		HumanName human = new HumanName();

		System.out.println(human.getName());








		human.setName("海パン王子","小島ヨシオ");
		System.out.println(human.getName());

		String sei1 = human.sei;
		String mei1 = human.getMei();
		
		

		HumanName human2 = new HumanName("世紀末覇者","拳王！！！！");

		System.out.println(human2.getName());
		




		}







}

