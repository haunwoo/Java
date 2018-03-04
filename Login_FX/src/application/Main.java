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

//개발자:장현우
//update:2017.02.16
//기능  :FX를 이용한 로그인
// 미구현 > 초기아이디비밀번호 데이터로저장 , 관리자정보변경기능


public class Main extends Application {

	String firstid = "admin", firstpassword = "password";
	String initid, initpassword;

	public Admin startadmin = new Admin(firstid, firstpassword);
	// 초기 아이디비밀번호

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
			admininfocange.setText("관리자정보변경");
			admininfocange.setStyle("-fx-font-size:15;");
			admininfocange.setOnAction(e -> {

				
				
				

			});

			button.setOnAction(e -> {
				imessage.setStyle("-fx-text-fill: red;");
				String name = tfName.getText();
				String password = tfPassword.getText();

				// login check
				if (name.equals("")) {
					imessage.setText("ID를 입력하시기바랍니다");
				} else if (password.equals("")) {
					imessage.setText("PassWrod를 입력하시기바랍니다");
				} else
					try {
						if (!name.equals(adminIdInput()) || !password.equals(adminPasswordInput())) {
							imessage.setText("ID나 PassWrod가 일치하지않습니다");
						} else {
							imessage.setStyle("-fx-text-fill: green");
							imessage.setText("로그인 되었습니다");
						}
					} catch (ClassNotFoundException | IOException e1) {
						e1.printStackTrace();
					}
			});
			// login check end
			
			/*2017.02.13
			 * if(name.equals("")){ imessage.setText("ID를 입력하시기바랍니다"); }else
			 * if(password.equals("")){ imessage.setText("PassWrod를 입력하시기바랍니다");
			 * }else if(!name.equals(adminFileInput().toString()) ||
			 * !password.equals(startadmin.getPassword())){
			 * imessage.setText("ID나 PassWrod가 일치하지않습니다"); }else{
			 * imessage.setStyle("-fx-text-fill: green");
			 * imessage.setText("로그인 되었습니다"); } });
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

	// 관리자 저장정보
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
		System.out.println("로그인완료");
	}
}
