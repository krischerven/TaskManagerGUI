package co.gc.taskmanager;

public class User {
	private String email;
	private String password;
	// constructors
	public User() {}
	public User(String _email, String _password) {
		email = _email;
		password = _password;
	}
	// getters
	public String getEmail() {
		return email;
	}
	public String getPassword() {
		return password;
	}
	// setters
	public void setEmail(String _email) {
		email = _email;
	}
	public void setPassword(String _password) {
		password = _password;
	}
}