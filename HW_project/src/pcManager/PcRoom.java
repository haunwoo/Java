package pcManager;

import java.sql.Connection;
import java.util.HashSet;
import java.util.Scanner;

interface INIT_MENU {
	int ADMIN = 1; //관리자 
	int MEMBER = 2; //회원관리
	int MEMBERBOARD = 3; //게시판
}
class BasicInfo{
	int pcroomnumber=40; //좌석의 수 
	
	
}
class StartPassword{
	String startPassword = new String("장현우"); // 초기비밀번호
	
	private boolean StartPassword(String password){
		if(password==this.startPassword)
			return true;
		else
			return false;
	}
}
class MenuChoiceException extends Exception{
	int wrongChoice;
	
	public MenuChoiceException(int choice){
		super("잘못된 선택입니다.");
		wrongChoice=choice;
	}
	public void showWrongChoice(){
		System.out.println(wrongChoice + "은 범위내에 없는 수 입니다.");
	}
}

class PcManager{
	HashSet<PcManager> infoStorage = new HashSet<PcManager>();
	static PcManager inst =null;
	public static PcManager CreateManager(){
		if(inst==null)
			inst= new PcManager();
		
		return inst;
	}
			private PcManager(){}
			
			
	}


class MenuViewer {
	public static Scanner keyboard = new Scanner(System.in);

	public static void menuViewer() {
		System.out.println("관리하실 메뉴를 선택해주세요");
		System.out.println("1.매장통합관리");
		System.out.println("2.회원관리");
		System.out.println("3.회원의견 게시판");
	}
}

class PcRoom {

	public static void main(String[] args) {
		PcManager manager = PcManager.CreateManager();
		int choice;
		while (true) {
			try{
				
			
				MenuViewer.menuViewer();
				choice = MenuViewer.keyboard.nextInt();
				MenuViewer.keyboard.nextLine(); //정수를 입력받고 엔터를 버리기위함
				
				if(choice<INIT_MENU.ADMIN || choice>INIT_MENU.MEMBERBOARD)
					throw new MenuChoiceException(choice);
				
				switch(choice){
				case INIT_MENU.ADMIN : 
					manager.
				case INIT_MENU.MEMBER :
					
				case INIT_MENU.MEMBERBOARD : 
				}
			}
			catch(MenuChoiceException e){
				e.showWrongChoice();
				System.out.println("처음부터다시진행합니다");
			}
		}
		
		
	}
	
}
