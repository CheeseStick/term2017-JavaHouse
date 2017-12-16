<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:if test="${not empty user}">
    <c:redirect url="/" />
</c:if>

<!doctype html>
<html lang="ko">

<head>
    <title>JAVA HOUSE - 로그인</title>
    
    <!-- Required meta tags -->
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
    
    <!-- Bootstrap, Fontawesome, fonts and other libraries -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css" />
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css" />
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/3.5.2/animate.css" />
    <link rel="stylesheet" href="https://cdn.rawgit.com/openhiun/hangul/14c0f6faa2941116bb53001d6a7dcd5e82300c3f/nanumbarungothic.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css?123" />
</head>

<body>
    <!-- 네비게이션 부분 -->
    <jsp:include page="../navigation.jsp" />
    <!-- 네비게이션 부분 끝 -->
    
    <!-- 컨텐츠 시작 -->
    <main role="main">
    
        <!-- 오류 메시지 출력 -->
        <c:forEach var="msg" items="${errors}">
            <div class="alert alert-warning alert-dismissible fade show" role="alert">
                <i class="fa fa-exclamation-triangle" aria-hidden="true"></i> &nbsp;
                ${msg}
                <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
        </c:forEach>
        
        <!-- 로그인 폼 시작 -->
        <div class="container">
          <div class="form-wrapper animated bounceIn">
            <form id="form-signin" method="post" action="${pageContext.request.contextPath}/user/login">       
                <h2 class="form-signin-heading">로그인</h2>
                <div class="input-group">
                    <div class="input-group-addon"><i class="fa fa-envelope" aria-hidden="true"></i></div>
                    <input type="email" class="form-control" id="email" name="email" placeholder="이메일" required/>
                </div>
                <div class="input-group">
                    <div class="input-group-addon"><i class="fa fa-key" aria-hidden="true"></i></div>
                    <input type="password" class="form-control" id="password" name="password" placeholder="비밀번호" required/>
                </div>    
                <button class="btn btn-lg btn-primary btn-block" type="submit">로그인</button>
                <a class="btn btn-lg btn-info btn-block" href="${pageContext.request.contextPath}/user/join" role="button">회원가입</a>   
            </form>
          </div>
        </div>
        <!-- 로그인 폼 끝 -->
        
    </main>
    <!-- 컨텐츠 끝 -->
    
    <!-- 푸터 부분 -->
    <jsp:include page="../footer.jsp" />
    <!-- 푸터 부분 끝 -->

    <!-- 스크립트 로드 -->
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.3/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/js/bootstrap.min.js"></script>
</body>
</html>