<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="/css/user/home.css">
<title>Insert title here</title>
</head>
<body>
	<header> 
	<div class="menu" id="menu1">메뉴1</div>
	<div class="menu" id="menu2">메뉴 2</div>
	<div class="menu" id="userImg">
		<img src="userImg/${user.fileName}" width="30px" height="30px"/>
	</div>
	<div class="menu" id="userInfo">${user.name} 님 </div>
	<div class="menu" id="logout"><a href="/user/logout"><button>logout</button></a></div>
	</header>