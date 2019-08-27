<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<link href="https://stackpath.bootstrapcdn.com/bootswatch/4.3.1/cosmo/bootstrap.min.css" rel="stylesheet" integrity="sha384-uhut8PejFZO8994oEgm/ZfAv0mW1/b83nczZzSwElbeILxwkN491YQXsCFTE6+nx" crossorigin="anonymous">
<meta charset="UTF-8">
<title>Task Manager</title>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
    <div class="navbar-nav">
      <a class="nav-item nav-link active" href="/">Home <span class="sr-only">(current)</span></a>
      <a class="nav-item nav-link" href="view-tasks">Tasks</a>
    </div>
  </div>
</nav>
<br>
<div class="container">
<h2>Welcome to the <span class="text-primary"><strong><a href="#">Task Manager™ GUI</a></strong></span><br>Please click one of the hyperlinks below to get started:</h2>
<br>
<h3>
<ol>
	<li><a href="create-account">Create a new Task Manager account</a></li><br>
	<li><a href="adding-task">Add a new task</a></li><br>
	<li><a href="#" onclick="view_tasks_js();">View existing tasks</a> (Email: <input type="email" id="email" style="font-style: italic" name="email" placeholder="johndoe@gmail.com">)</li>
</ol>
</h3>
</div>
<script>
function view_tasks_js() {
	window.location.href="view-tasks-email?email="+document.getElementById("email").value;
}
</script>
</body>
</html>