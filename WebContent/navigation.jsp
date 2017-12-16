<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">
    <a class="navbar-brand" href="${pageContext.request.contextPath}">JAVA HOUSE</a>
    
    <button class="navbar-toggler collapsed" type="button" data-toggle="collapse" data-target="#mainNav">
        <span class="navbar-toggler-icon"></span>
    </button>
    
    <div class="navbar-collapse collapse" id="mainNav">
        <ul class="navbar-nav ml-auto">
          <li class="nav-item">
            <a class="nav-link" href="${pageContext.request.contextPath}">홈 <span class="sr-only">(current)</span></a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="${pageContext.request.contextPath}/item/search">매물찾기</a>
          </li>
          
          <c:if test="${user.host || user.admin}">
            <li class="nav-item">
                <a class="nav-link" href="${pageContext.request.contextPath}/item/new">매물등록</a>
            </li>
          </c:if>
          
          <c:choose>
	          <c:when test="${empty user}">
	            <li class="nav-item">
                    <a class="nav-link" href="${pageContext.request.contextPath}/user/login">로그인</a>
                </li>
	          </c:when>
	          
	          <c:otherwise>
	            <li class="nav-item">
                    <a class="nav-link" href="${pageContext.request.contextPath}/user/logout">로그아웃</a>
                </li>
	          </c:otherwise>
          </c:choose>
        </ul>
     </div>
</nav>