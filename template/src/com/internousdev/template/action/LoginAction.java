package com.internousdev.template.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.template.dao.BuyItemDAO;
import com.internousdev.template.dao.LoginDAO;
import com.internousdev.template.dto.BuyItemDTO;
import com.internousdev.template.dto.LoginDTO;
import com.opensymphony.xwork2.ActionSupport;
/*
 * ログイン認証処理
 * Login.jspからログインID、ログインパスワードを受け取り
 * DBへ問い合わせをおこないます
 */

public class LoginAction extends ActionSupport implements SessionAware{

	private String loginUserId;
	private String loginPassword;
	private String result;

	//ログイン情報を格納
	public Map<String,Object> session;

	//ログイン情報取得DAO
	private LoginDAO dao = new LoginDAO();

	//ログイン情報格納DTO
	private LoginDTO dto = new LoginDTO();


	//アイテム情報を取得
	private BuyItemDAO buyItemDAO = new BuyItemDAO();

	public String execute(){
		result = ERROR;
		//ログイン実行
		dto = dao.getLoginUserInfo(loginUserId,loginPassword);

		session.put("loginUser", dto);

		//ログイン情報を比較
		//LoginFlgがtrueのとき実行?
		if(((LoginDTO) session.get("loginUser")).getLoginFlg()){
			result = SUCCESS;

			//アイテム情報を取得
			BuyItemDTO buyItemDTO = buyItemDAO.getBuyItemInfo();
			session.put("login_user_id", dto.getLoginId());
			session.put("id" ,buyItemDTO.getId());
			session.put("buyItem_name", buyItemDTO.getItemName());
			session.put("buyItem_price",buyItemDTO.getItemPrice());

			return result;
		}
		return result;
	}
	public String getLoginUserId() {
		return loginUserId;
	}

	public void setLoginUserId(String loginUserId) {
		this.loginUserId = loginUserId;
	}

	public String getLoginPassword() {
		return loginPassword;
	}

	public void setLoginPassword(String loginPassword) {
		this.loginPassword = loginPassword;
	}

	@Override
	//親クラスで消されてもいいように
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}


}