package co.gc.taskmanager;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class TaskRepository {
	@Autowired
	JdbcTemplate database;
	public List<Task> getTasks() {
		List<TemporaryTask> _tasks = database.query("SELECT * FROM tasks;", new BeanPropertyRowMapper<TemporaryTask>(TemporaryTask.class));
		List<Task> tasks = new ArrayList<Task>();
		for (TemporaryTask task : _tasks) {
			tasks.add(task.toRealTask());
		}
		return tasks;
	}
	public int addTask(Task task) {
		return database.update("INSERT INTO tasks (id, email, description, dueDate, completed) VALUES(?, ?, ?, ?, ?);", 
				task.getid(), task.getEmail(), task.getDesc(), task.getDueDate(), task.getCompleted());
	}
	public int remTask(Long id) {
		return database.update("DELETE FROM tasks WHERE id = ?", id);
	}
	public int remAllTasks() {
		return database.update("DELETE FROM tasks");
	}
	public int markTask(Long id, Boolean yes) {
		return database.update("UPDATE tasks SET completed = $REPLACE WHERE id = ?".replace("$REPLACE", yes.toString()), id);
	}
	@Override
	public String toString() {
		String ret = "<br><center><h2>Task List</h2></center><br>";
		ret += "<ol>";
		for (Task task : getTasks()) {
			ret += ("<h3 style=\"margin-left: 1%\"><li>"+task+"</li></h3>");
			if (task != getTasks().get(getTasks().size()-1)) {
				ret += "\n";
			}
		}
		ret += "</ol>";
		return ret;
	}
	public String toString(String email) {
		String ret = "<br><center><h2>Task List</h2></center><br>";
		ret += "<ol>";
		for (Task task : getTasks()) {
			if (task.getEmail().equals(email)) {
				ret += ("<h3 style=\"margin-left: 1%\"><li>"+task+"</li></h3>");
				if (task != getTasks().get(getTasks().size()-1)) {
					ret += "\n";
				}
			}
		}
		ret += "</ol>";
		return ret;
	}
}