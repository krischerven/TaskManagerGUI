package co.gc.taskmanager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TaskController {
	
	@Autowired
	TaskRepository tasks;
	@Autowired
	UserRepository users;
	
	@RequestMapping("/")
	public ModelAndView welcome() {
		return new ModelAndView("index", "", "");
	}
	
	@RequestMapping("/create-account")
	public ModelAndView createAccount() {
		return new ModelAndView("create-account", "", "");
	}
	
	@RequestMapping("/created-account")
	public ModelAndView createdAccount(@RequestParam("email") String email, @RequestParam("password") String password) {
		User user = new User(email, password);
		users.addUser(user);
		return new ModelAndView("created-account", "account", user);
	}
	
	@RequestMapping("/view-tasks")
	public ModelAndView viewTasks() {
		ModelAndView m = new ModelAndView("view-tasks", "tasks", tasks.toString());
		m.addObject("blurb", "<h4><em><a href=\"remove-tasks\" style=\"margin-left: 1%\">Remove all tasks</a></em></h4>");
		return m;
	}
	
	@RequestMapping("/view-tasks-error")
	public ModelAndView viewTasks(String error) {
		return new ModelAndView("view-tasks", "tasks", error);
	}
	
	@RequestMapping("/adding-task")
	public ModelAndView addingTask() {
		return new ModelAndView("add-task", "", "");
	}
	
	@RequestMapping("/add-task")
	public ModelAndView add(@RequestParam("email") String email, @RequestParam("desc") String desc, @RequestParam("dueDate") String dueDate) {
		if (users.hasUser(email)) {
			tasks.addTask(new Task(email, desc, dueDate, false));
			return viewTasks();
		} else {
			return viewTasks("<center><h2 class = \"text-danger\"><strong>Error: no email \"" + email + "\" was found in our account registry.</strong></h2></center>");
		}
	}
	
	@RequestMapping("/remove-tasks")
	public ModelAndView remTasks() {
		tasks.remAllTasks();
		return viewTasks();
	}
	
	@RequestMapping("/mark-as-complete")
	public ModelAndView markAsComplete(@RequestParam("id") String _id, @RequestParam("yes") boolean yes) {
		Long id = Long.parseLong(_id);
		tasks.markTask(id, yes);
		return viewTasks();
	}
	
}