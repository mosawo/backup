package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.SQLException;

import com.internousdev.ecsite.util.DBConnector;
import com.internousdev.ecsite.util.DateUtil;

public class BuyItemCompleteDAO {

	private DBConnector db = new DBConnector();
	private Connection con = db.getConnection();
	
	private DateUtil dateUtil = new DateUtil();
	
	private String sql = "INSERT INTO user_buy_item_transaction (item_transaction_id, total_price,total_count, user_master_id, pay, insert_date)"
			+ "VALUES(?,?,?,?,?,?)";
	
	/*
	 * 買った商品の情報を登録
	 * ユーザがかった商品のテーブルに登録
	 * 
	 */
	public void buyItemInfo(String item_transaction_id, String user_master_id, String total_price, String total_count,String pay) throws SQLException{
		
	}
}
