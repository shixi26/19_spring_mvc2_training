<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath"  value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인</title>
</head>
<body>
	<c:choose>
		<c:when test="${sessionScope.loginUser eq null}">
			<p><a href="${contextPath }/member/memberList">회원 리스트 조회</a></p>
			<p><a href="${contextPath }/member/join">회원가입</a></p>
			<p><a href="${contextPath }/member/login">로그인</a></p>	
		</c:when>
		<c:otherwise>
			<h2>${sessionScope.loginUser }님 반갑습니다.</h2>
			<p><a href="${contextPath }/member/myPage">마이페이지로 이동</a></p>	
			<p><a href="${contextPath }/member/logout">로그아웃</a></p>
			<p><a href="${contextPath }/member/delete">회원탈퇴</a></p>	
		</c:otherwise>
	</c:choose>
</body>
</html>