
public class HelloWorld {
	public static void main(String[] args){

		String menu = "いおいう";
		int sum = 0;
		
		if(menu == "カレー"){
			sum += 250;
		} else if (menu == "ハンバーグ"){
			sum += 350;
		} else if(menu == "昼定職"){
			sum += 450;
		} else {
			System.out.println("なんか食えやぁ");
		}
		System.out.println("料金は" + sum);
		}
	
	}




