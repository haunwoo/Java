package application;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Admin implements Serializable{
	private String id;        				// admin ID
	private String password;  				// admin password
	
	public Admin(String id, String password){
		this.id=id;
		this.password=password;
	}

	public String getID() {
		return id;
	}

	public void setID(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}

