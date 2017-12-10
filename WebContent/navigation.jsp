<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">
    <a class="navbar-brand" href="${pageContext.request.contextPath}">JAVA HOUSE</a>
    
    <button class="navbar-toggler collapsed" type="button" data-toggle="collapse" data-target="#mainNav">
        <span class="navbar-toggler-icon"></span>
    </button>
    
    <div class="navbar-collapse collapse" id="mainNav">
        <ul class="navbar-nav ml-auto">
          <li class="nav-item active">
            <a class="nav-link" href="${pageContext.request.contextPath}">홈 <span class="sr-only">(current)</span></a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="${pageContext.request.contextPath}/item/search">매물찾기</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="${pageContext.request.contextPath}/user/login">로그인</a>
          </li>
        </ul>
      </div>
</nav>