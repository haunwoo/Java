package application;

import java.io.FileInputStream;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

//������:������
//update:2017.02.16
//���  :FX�� �̿��� �α���
// �̱��� > �ʱ���̵��й�ȣ �����ͷ����� , ����������������


public class Main extends Application {

	String firstid = "admin", firstpassword = "password";
	String initid, initpassword;

	public Admin startadmin = new Admin(firstid, firstpassword);
	// �ʱ� ���̵��й�ȣ

	public void start(Stage stage) {
		try {
			
			Label startname = new Label("ID:");
			Label startpassword = new Label("Password:");
			Label imessage = new Label();

			TextField tfName = new TextField();
			PasswordField tfPassword = new PasswordField();

			Button button = new Button("Login");
			button.prefHeightProperty().bind(tfName.heightProperty().add(tfPassword.heightProperty()));

			Button admininfocange = new Button();
			admininfocange.setText("��������������");
			admininfocange.setStyle("-fx-font-size:15;");
			admininfocange.setOnAction(e -> {

				
				
				

			});

			button.setOnAction(e -> {
				imessage.setStyle("-fx-text-fill: red;");
				String name = tfName.getText();
				String password = tfPassword.getText();

				// login check
				if (name.equals("")) {
					imessage.setText("ID�� �Է��Ͻñ�ٶ��ϴ�");
				} else if (password.equals("")) {
					imessage.setText("PassWrod�� �Է��Ͻñ�ٶ��ϴ�");
				} else
					try {
						if (!name.equals(adminIdInput()) || !password.equals(adminPasswordInput())) {
							imessage.setText("ID�� PassWrod�� ��ġ�����ʽ��ϴ�");
						} else {
							imessage.setStyle("-fx-text-fill: green");
							imessage.setText("�α��� �Ǿ����ϴ�");
						}
					} catch (ClassNotFoundException | IOException e1) {
						e1.printStackTrace();
					}
			});
			// login check end
			
			/*2017.02.13
			 * if(name.equals("")){ imessage.setText("ID�� �Է��Ͻñ�ٶ��ϴ�"); }else
			 * if(password.equals("")){ imessage.setText("PassWrod�� �Է��Ͻñ�ٶ��ϴ�");
			 * }else if(!name.equals(adminFileInput().toString()) ||
			 * !password.equals(startadmin.getPassword())){
			 * imessage.setText("ID�� PassWrod�� ��ġ�����ʽ��ϴ�"); }else{
			 * imessage.setStyle("-fx-text-fill: green");
			 * imessage.setText("�α��� �Ǿ����ϴ�"); } });
			 */

			GridPane grid = new GridPane();
			grid.addRow(0, startname, tfName);
			grid.addRow(1, startpassword, tfPassword);
			grid.add(button, 2, 0, 1, 2);
			grid.add(imessage, 0, 2, 3, 1);
			grid.setAlignment(Pos.CENTER);

			pane.getChildren().addAll(grid, admininfocange);
			StackPane.setAlignment(admininfocange, Pos.BOTTOM_CENTER);

			stage.setTitle("Login");
			stage.setScene(scene);
			stage.show();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	StackPane pane = new StackPane();
	Scene scene = new Scene(pane, 400, 400);

	// ������ ��������
	public void adminFileOutput() throws IOException {

		FileOutputStream fout = new FileOutputStream("admindata.bin");
		ObjectOutputStream oout = new ObjectOutputStream(fout);
		oout.writeObject(startadmin);
		fout.close();

	}

	public String adminIdInput() throws IOException, ClassNotFoundException {
		FileInputStream fin = new FileInputStream("admindata.bin");
		ObjectInputStream oin = new ObjectInputStream(fin);

		Admin admininfomation = (Admin) oin.readObject();
		oin.close();

		return admininfomation.getID();

	}

	public String adminPasswordInput() throws IOException, ClassNotFoundException {
		FileInputStream fin = new FileInputStream("admindata.bin");
		ObjectInputStream oin = new ObjectInputStream(fin);

		Admin admininfomation = (Admin) oin.readObject();
		oin.close();

		return admininfomation.getPassword();

	}

	// main
	public static void main(String[] args) {

		launch(args);
		System.out.println("�α��οϷ�");
	}
}
