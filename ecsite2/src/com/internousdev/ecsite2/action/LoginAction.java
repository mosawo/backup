package com.internousdev.ecsite2.action;


import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport implements SessionAware{

	private String loginUserName;
	private String loginPassword;
	private String errorMessage;
	private String result;

	public Map<String , Object> session;





	public String execute(){
		result = ERROR;
		//仮のログイン判定
		if(this.loginUserName.equals("mosa")
			&&this.loginPassword.equals("mosu")){
			//ログイン情報をsessionに格納
			session.put("loginUserName",loginUserName);
				System.out.println("loginUserName = "+ session.get("loginUserName"));
			session.put("loginPassword", loginPassword);
				System.out.println("loginPassword = " + session.get("loginPassword"));
			//ログイン成功
			result = SUCCESS;

		} else {
			//ログイン失敗
			result = ERROR;
			//login.jspに表示するerrorMessage
			errorMessage ="ちがうだろぉ！ちゃんとやれぇ！";
			session.put("errorMessage", errorMessage);
				System.out.println("errorMessage = "+ session.get("errorMessage"));
		}


		return result;

	}



	public String getLoginUserName(){
		return loginUserName;
	}
	public void setLoginUserName(String loginUserName){
		this.loginUserName = loginUserName;
	}


	public String getLoginPassword(){
		return loginPassword;
	}
	public void setLoginPassword(String loginPassword){
		this.loginPassword = loginPassword;
	}

	public String getResult(){
		return result;
	}
	public void setResult(String result){
		this.result = result;
	}

	public String getErrorMessage(){
		return errorMessage;
	}
	public void setError(String errorMessage){
		this.errorMessage = errorMessage;
	}

	@Override
	public void setSession(Map<String, Object> session){
		this.session = session;
	}
}
