package pcManager;

import java.sql.Connection;
import java.util.HashSet;
import java.util.Scanner;

interface INIT_MENU {
	int ADMIN = 1; //������ 
	int MEMBER = 2; //ȸ������
	int MEMBERBOARD = 3; //�Խ���
}
class BasicInfo{
	int pcroomnumber=40; //�¼��� �� 
	
	
}
class StartPassword{
	String startPassword = new String("������"); // �ʱ��й�ȣ
	
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
		super("�߸��� �����Դϴ�.");
		wrongChoice=choice;
	}
	public void showWrongChoice(){
		System.out.println(wrongChoice + "�� �������� ���� �� �Դϴ�.");
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
		System.out.println("�����Ͻ� �޴��� �������ּ���");
		System.out.println("1.�������հ���");
		System.out.println("2.ȸ������");
		System.out.println("3.ȸ���ǰ� �Խ���");
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
				MenuViewer.keyboard.nextLine(); //������ �Է¹ް� ���͸� ����������
				
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
				System.out.println("ó�����ʹٽ������մϴ�");
			}
		}
		
		
	}
	
}
