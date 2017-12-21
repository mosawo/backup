package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.internousdev.ecsite.dto.LoginDTO;
import com.internousdev.ecsite.util.DBConnector;

public class LoginDAO {
//DBコネクタインスタンスか
	private DBConnector dbConnector = new DBConnector();
//コネクションを作成
	private Connection connection = dbConnector.getConnection();
/*
 * DTO(箱)を用意
 * DAOで入力された値にあったDBの値を格納
 * で、Actionにあげる？
 */
	private LoginDTO loginDTO = new LoginDTO();

	/**
	 * ログインユーザ情報取得メソッド
	 *
	 * @param loginUserId
	 * @param loginPassword
	 * @return LoginDTO
	 */
									//ID,Passをもらって実行
	public LoginDTO getLoginUserInfo(String loginUserId, String loginPassword) {


		String sql = "SELECT * FROM login_user_transaction where login_id = ? AND login_pass = ?";

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			//入力されたID、PassをSQL分に入れる
			preparedStatement.setString(1, loginUserId);
			preparedStatement.setString(2, loginPassword);

			//完成したSQL文で検索できるようにする
			ResultSet resultSet = preparedStatement.executeQuery();

			//読み込めればtrue
			if(resultSet.next()) {
				//DTOにSQL文にあったDBの値を格納(行？)
				loginDTO.setLoginId(resultSet.getString("login_id"));
				loginDTO.setLoginPassword(resultSet.getString("login_pass"));
				loginDTO.setUserName(resultSet.getString("user_name"));

				//id一致？でFlgがtrue
				if(!(resultSet.getString("login_id").equals(null))) {
					loginDTO.setLoginFlg(true);
				}
			}

		} catch(Exception e) {
			e.printStackTrace();
		}

		return loginDTO;
	}

	//上のDTOとはちがう？
	public LoginDTO getLoginDTO() {
		return loginDTO;
	}
}
