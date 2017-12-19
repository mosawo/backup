package com.internousdev.web.dto;

public class LoginDTO {
//使う値の箱作り
	private String username;
	private String password;


//usernameのゲッ他セッタ
	public String getUsername(){
		return username;
	}
	public void setUsername(String username){
		this.username = username;
	}


//passwordのゲッ他セッタ
	public String getPassword(){
		return password;
	}
	public void setPassword(String password){
		this.password = password;
	}


}
