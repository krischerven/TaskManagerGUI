package co.gc.taskmanager;

public class TemporaryTask {
	private Long id;
	private String email;
	private String description;
	private String dueDate;
	private Boolean completed;
	// constructors
	public TemporaryTask() {}
	public TemporaryTask(Long _id, String _email, String _description, String _dueDate, Boolean _completed) {
		id = _id;
		email = _email;
		description = _description;
		dueDate = _dueDate;
		completed = _completed;
	} 
	public TemporaryTask(String _email, String _description, String _dueDate, Boolean _completed) {
		email = _email;
		description = _description;
		dueDate = _dueDate;
		completed = _completed;
	}
	// misc
	public Task toRealTask() {
		return new Task(id, email, description, dueDate, completed);
	}
	// getters
	public Long getid() {
		return id;
	}
	public String getEmail() {
		return email;
	}
	public String getDescription() {
		return description;
	}
	public String getDueDate() {
		return dueDate;
	}
	public Boolean getCompleted() {
		return completed;
	}
	// setters 
	public void setid(Long _id) {
		id = _id;
	}
	public void setEmail(String _email) {
		email = _email;
	}
	public void setDescription(String _description) {
		description = _description;
	}
	public void setDueDate(String _dueDate) {
		dueDate = _dueDate;
	}
	public void setCompleted(Boolean _completed) {
		completed = _completed;
	}
}
 