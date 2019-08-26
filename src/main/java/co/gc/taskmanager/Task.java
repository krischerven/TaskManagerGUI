package co.gc.taskmanager;
import javax.persistence.Column;
import javax.persistence.Table;

public class Task {
	private Long id; // for nullability
	private String email;
	private @Column(name="description") String desc;
	private String dueDate;
	private boolean completed;
	// constructors
	public Task() {}
	public Task(Long _id, String _email, String _desc, String _dueDate, boolean _completed) {
		id = _id;
		email = _email;
		desc = _desc;
		dueDate = _dueDate;
		completed = _completed;
	} 
	public Task(String _email, String _desc, String _dueDate, boolean _completed) {
		email = _email;
		desc = _desc;
		dueDate = _dueDate;
		completed = _completed;
	}
	// statics
	public static String strong(String input) {
		return "<strong>"+input+"</strong>";
	}
	public static String good(String input) {
		return "<span style=\"color: green\">"+strong(input.toUpperCase())+"</span>";
	}
	public static String bad(String input) {
		return "<span style=\"color: red\">"+strong(input.toUpperCase())+"</span>";
	}
	// misc
	public String mark(String input, boolean bool) {
		return "<a href=\"mark-as-complete?id="+id+"&yes="+bool+"\">"+input+"</a>";
	}
	@Override
	public String toString() {
		return "\"" + desc + "\": " + " (" + "Due on " + strong(dueDate) + ") " + " (" + "Completed: " + 
				(completed ? mark(good("yes"), false) : mark(bad("no"), true)) + "): Assigned to " + email;
	}
	// getters
	public Long getid() {
		return id;
	}
	public String getEmail() {
		return email;
	}
	@Column(name="description")
	public String getDesc() {
		return desc;
	}
	public String getDueDate() {
		return dueDate;
	}
	public boolean getCompleted() {
		return completed;
	}
	// setters 
	public void setid(Long _id) {
		id = _id;
	}
	public void setEmail(String _email) {
		email = _email;
	}
	@Column(name="description")
	public void setDesc(String _desc) {
		desc = _desc;
	}
	public void setDueDate(String _dueDate) {
		dueDate = _dueDate;
	}
	public void setCompleted(boolean _completed) {
		completed = _completed;
	}
}
 