package automation.pojo;

public class UserCredentials {
	private String email = "";
	private String password = "";
	
	//to get and set the user credentials from testdata.properties
	public String getFreeUser() {
		return email;
	}

	public void setFreeUser(String email) {
		this.email = email;
	}

	public String getFreePass() {
		return password;
	}

	public void setFreePass(String password) {
		this.password = password;
	}
}