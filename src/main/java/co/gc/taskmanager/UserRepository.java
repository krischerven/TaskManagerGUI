package co.gc.taskmanager;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {
	@Autowired
	JdbcTemplate database;
	ArrayList<User> users = new ArrayList<User>();
	public int addUser(User user) {
		users.add(user);
		return database.update("INSERT INTO users (email, password) VALUES(?,?)", user.getEmail(), user.getPassword());
	}
	public boolean hasUser(String email) {
		return database.query("SELECT * FROM users WHERE email = '"+email+"'", new BeanPropertyRowMapper<User>(User.class)).size() > 0;
	}
	public boolean hasUser(String email, String password) {
		return database.query("SELECT * FROM users WHERE email = '"+email+"' OR password = '"+password+"'", new BeanPropertyRowMapper<User>(User.class)).size() > 0;
	}
}
