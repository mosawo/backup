package com.internousdev.ecsite.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;


public class BuyItemAction extends ActionSupport implements SessionAware{
	//アイテム購入個数
	private int count;

	//支払い方法
	private String pay;

	//アイテム情報を格納
	public Map<String,Object> session;

	//商品情報取得メソッド
	//
	public String execute(){
		String result = SUCCESS;
		session.put("count", count);
		//count、priceをint型に変換
		int intCount = Integer.parseInt(session.get("count").toString());
		int intPrice = Integer.parseInt(session.get("buyItem_price").toString());



		//total_priceに個数、値段をかけたものを入れる
		session.put("total_price", intCount * intPrice);

		//payment =支払い
		String  payment;

		//jspのラジオボタンで現金が選択された
		if(pay.equals("1")){
			payment = "元気はらい";
			session.put("pay",payment);
		} else {
		//jspのラジオボタンでカードが選択された
			payment = "カードで（ピッ）";
			session.put("pay",payment);
		}
		return result;
	}
	public int getCount(){
		return count;
	}
	public void setCount(int count){
		this.count = count;
	}

	public String getPay(){
		return pay;
	}
	public void setPay(String pay){
		this.pay = pay;
	}

	@Override
	public void setSession(Map<String, Object> session){
		this.session = session;
	}
}


