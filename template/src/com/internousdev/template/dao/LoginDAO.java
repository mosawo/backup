package com.internousdev.template.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.internousdev.template.dto.LoginDTO;
import com.internousdev.template.util.DBConnector;

public class LoginDAO{
	private DBConnector db = new DBConnector();
	private Connection con = db.getConnection();
	private LoginDTO dto = new LoginDTO();

	/*
	 * ログインユーザ情報取得メソッド
	 *
	 * @param loginUserId
	 * @param loginPassword
	 * @param LoginDTO
	 */

	public LoginDTO getLoginUserInfo(String loginUserId,String loginPassword){
		String sql = "select * from login_user_transaction where login_id=? and login_pass=?";

		try{
			PreparedStatement ps = con.prepareStatement(sql);
			//入力された値を元にSQL完成
			ps.setString(1, loginUserId);
			ps.setString(2, loginPassword);

			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				//dtoにpsで入れた値に該当するものを入れる
				dto.setLoginId(rs.getString("login_id"));
				dto.setLoginPassword(rs.getString("login_pass"));
				dto.setUserName(rs.getString("user_name"));


				if(!(rs.getString("login_id").equals(null))){
					dto.setLoginFlg(true);
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return dto;
	}
	public LoginDTO getLoginDTO(){
		return dto;
	}
}