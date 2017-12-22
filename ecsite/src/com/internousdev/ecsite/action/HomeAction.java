package com.internousdev.ecsite.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.BuyItemDAO;
import com.internousdev.ecsite.dto.BuyItemDTO;
import com.opensymphony.xwork2.ActionSupport;

public class HomeAction extends ActionSupport implements SessionAware {

	public Map<String,Object> session;

	/*
	 * ログインボタン押下時に実行
	 * ログイン画面に繊維します
	 *
	 */
	public String execute(){
		//ログインしてなかったらログインさせる
		String result = "login";

		//ログイン済みの場合の処理
		if(session.containsKey("id")){
			//アイテム情報を取得
			//id name priceをDTOから取得してsessionに入れる
			BuyItemDAO buyItemDAO = new BuyItemDAO();
			BuyItemDTO buyItemDTO = buyItemDAO.getBuyItemInfo();
			session.put("id",buyItemDTO.getId());
			session.put("buyItem_name",buyItemDTO.getItemName());
			session.put("buyItem_price",buyItemDTO.getItemPrice());
			//ログインしてる、商品情報も取得した
			result = SUCCESS;
		}
		//ログインしてなかったらログインさせる
		return result;
	}
	@Override
	public void setSession(Map<String ,Object> session){
		this.session = session;
	}
	public void setsession(Map<String,Object> session){
		this.session = session;
	}

	public Map<String,Object> getsession(){
		return this.session;
	}
}
