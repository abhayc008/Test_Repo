package com.pharmacy.pojo;

public class Login
{
	String userName, newPassword, password;
	
    public Login(String userName, String newPassword, String password) {
		super();
		this.userName = userName;
		this.newPassword = newPassword;
		this.password = password;
	}

	@Override
	public String toString() {
		return "Login [userName=" + userName + ", newPassword=" + newPassword + ", password=" + password + "]";
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
