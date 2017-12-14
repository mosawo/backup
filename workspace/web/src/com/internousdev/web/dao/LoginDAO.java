package com.internousdev.web.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.internousdev.web.dto.LoginDTO;
import com.internousdev.web.util.DBConnector;

public class LoginDAO{
	//使う値を用意
	public String username;
	public String password;
	//ArrayListクラスからインスタンス化するけどListの機能で十分なのでこの書き方
	public List<LoginDTO> loginDTOList = new ArrayList<LoginDTO>();

	//Actionで呼ばれるselectメソッド。DTOに色々入れてく。
	public List<LoginDTO> select(String username, String password){
		//DBConnectorをインスタンス化
		DBConnector db = new DBConnector();
		//Connection型の変数conにDBConnectorのgetConnectionメソッドを入れる
		Connection con = db.getConnection();

		//user_nameとpasswordを後入れできるSQL文
		String sql = "select * from users where user_name=? and password = ?";

		//通信のため、try-catchで囲う
		try{
			//SQL文をpsに格納、接続用のconも入れる
			PreparedStatement ps = con.prepareStatement(sql);
			//psにの1個目の？にusername,2個目の？にpasswordを入れる
			ps.setString(1, username);
			ps.setString(2, password);

			//psのSQL文を持って検索してもらうのをrsに入れる
			ResultSet rs = ps.executeQuery();

			//DBを全部検索してもらう
			while(rs.next()){
				//dtoの箱用意
				LoginDTO dto = new LoginDTO();
				//LoginDTOのセッタにDBの値を入れる
				dto.setUsername(rs.getString("user_name"));
				dto.setPassword(rs.getString("password"));
				//DTOListに上の文で入れたdtoを入れる
				loginDTOList.add(dto);
			}

			//DTOListになにも入ってなければ
			if(loginDTOList.size()<=0){
				//dtoの箱用意
				LoginDTO dto = new LoginDTO();

				dto.setUsername("該当なし");
				dto.setPassword("該当なし");
				loginDTOList.add(dto);
			}
		}catch (SQLException e){
			e.printStackTrace();
		}
		try{
			//ずっとあけっぱはよくないらしいので閉じる
			con.close();
		} catch(SQLException e){
			e.printStackTrace();
		}
		return loginDTOList;

	}






}