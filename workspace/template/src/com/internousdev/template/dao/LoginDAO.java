package com.internousdev.template.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.internousdev.template.dto.LoginDTO;
import com.internousdev.template.util.DBConnector;

public class LoginDAO{
	private DBConnector dbConnector = new DBConnector();
	private Connection connection = dbConnector.getConnection();
	private LoginDTO loginDTO = new LoginDTO();


	/*
	 * ログインユーザ情報取得メソッド
	 *
	 * @param loginUserId
	 * @param loginPassword
	 * @return LoginDTO
	 */
	//実行メソッドgetLoginUserInfo、idとpassで入る
	public LoginDTO getLoginUserInfo(String loginUserId,String loginPassword){
		//login_idとlogin_passを入れれるSQL文
		String sql ="select * from login_user_transaction where login_id=? and login_pass=?";

		try{
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			//入力されたid、passをSQL文に入れる
			preparedStatement.setString(1, loginUserId);
			preparedStatement.setString(2, loginPassword);

			ResultSet resultSet = preparedStatement.executeQuery();

			//読み込めたらtrue
			if(resultSet.next()){
				loginDTO.setLoginId(resultSet.getString("login_id"));
				loginDTO.setLoginPassword(resultSet.getString("login_pass"));
				loginDTO.setUserName(resultSet.getString("user_name"));

				if(!(resultSet.getString("login_id").equals(null))){
					loginDTO.setLoginFlg(true);
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}

		return loginDTO;
	}
	public LoginDTO getLoginDTO(){
		return loginDTO;
	}
}

