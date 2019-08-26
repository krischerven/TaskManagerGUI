<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<link href="https://stackpath.bootstrapcdn.com/bootswatch/4.3.1/cosmo/bootstrap.min.css" rel="stylesheet" integrity="sha384-uhut8PejFZO8994oEgm/ZfAv0mW1/b83nczZzSwElbeILxwkN491YQXsCFTE6+nx" crossorigin="anonymous"><meta charset="UTF-8">
<title>Task Manager | Add Task</title>
</head>
<body>
<div style="margin-left: 1%; margin-top: 1%">
<form action="add-task">
Email Address: <input type="email" name="email" placeholder="Email Address"/><br><br>
Description: <input type="text" name="desc" placeholder="Description" required/><br><br>
Due Date: <input type="date" name="dueDate" placeholder="Due Date" required/><br><br>
<input type="submit" class="btn btn-primary" value="Create Task"/>
</form>
</div>
</body>
</html>