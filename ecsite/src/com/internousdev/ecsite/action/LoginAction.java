package com.internousdev.ecsite.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.BuyItemDAO;
import com.internousdev.ecsite.dao.LoginDAO;
import com.internousdev.ecsite.dto.BuyItemDTO;
import com.internousdev.ecsite.dto.LoginDTO;
import com.opensymphony.xwork2.ActionSupport;


/*
 * ログイン認証処理
 * Login.jspからid  pass を受け取り
 * DBへ問い合わせをします
 */
public class LoginAction extends ActionSupport implements SessionAware{
	private String loginUserId;
	private String loginPassword;

	public  Map<String, Object> session;

	private LoginDAO loginDAO = new LoginDAO();
	private LoginDTO loginDTO = new LoginDTO();

	private BuyItemDAO buyItemDAO = new BuyItemDAO();

	public String execute(){
		String result = ERROR;

		//ログインじっぉう
		loginDTO = loginDAO.getLoginUserInfo(loginUserId, loginPassword);

		session.put("loginUser", loginDTO);

		if(((LoginDTO) session.get("loginUser")).getLoginFlg()){
			result = SUCCESS;

			//ログイン成功時、buyItem.jspに表示するため
			BuyItemDTO buyItemDTO = buyItemDAO.getBuyItemInfo();
			 //buyItemDTOにそのまま、buyItemDAOで取得した値を入れる

			//ユーザーの情報もいれるでぇ
			session.put("login_user_id",loginDTO.getLoginId());

			//sessionに商品のidを格納。buyItem.jspで呼ばれるよぉ！
			session.put("id",buyItemDTO.getId());
			session.put("buyItem_name", buyItemDTO.getItemName());
			session.put("buyItem_price", buyItemDTO.getItemPrice());

			//if文に入ったときにSUCCESS!!!!!!
			return result;
		}
		//ERRORのまんまです
		return result;
	}

	public String getLoginUserId(){
		return loginUserId;
	}
	public void setLoginUserId(String loginUserId){
		this.loginUserId = loginUserId;
	}


	public String getLoginPassword(){
		return loginPassword;
	}
	public void setLoginPassword(String loginPassword){
		this.loginPassword = loginPassword;
	}

	@Override
	/*
	 * SessionAwareのインターフェースに(非 Javad
	 * オーーーーーーバーーーらいっ
	 * @see org.apache.struts2.interceptor.SessionAware#setSession(java.util.Map)
	 */

	public void setSession(Map<String, Object> session){
		this.session = session;
	}

















}
