<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!doctype html>
<html lang="ko">

<head>
    <title>JAVA HOUSE - 홈</title>
    
    <!-- Required meta tags -->
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
    
    <!-- Bootstrap, Fontawesome, fonts and other libraries -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css" />
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css" />
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/3.5.2/animate.css" />
    <link rel="stylesheet" href="https://cdn.rawgit.com/openhiun/hangul/14c0f6faa2941116bb53001d6a7dcd5e82300c3f/nanumbarungothic.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css?129" />
</head>

<body>
    <!-- 네비게이션 부분 -->
    <jsp:include page="navigation.jsp" />
    <!-- 네비게이션 부분 끝 -->
    
    <!-- 컨텐츠 시작 -->
    <main role="main">
      
      <header class="masthead">
	      <div class="overlay">
	        <div class="container">
	          <h1 class="display-1 text-white">JAVA HOUSE</h1>
	          <h2 class="display-4 text-white">원하시는 장소를 검색하세요</h2>
	          <div class="search-form">
		          <form class="form-inline" method="get" action="${pageContext.request.contextPath}/item/search">
	                <input type="text" class="search-query form-control" id="keyword" name="keyword" placeholder="검색..." />
	                <button type="submit" class="btn btn-primary"><i class="fa fa-search" aria-hidden="true"></i></button>
	              </form>
	          </div>
	        </div>
	      </div>
      </header>

      <section>
	      <div class="container">
	        <div class="row align-items-center">
	          <div class="col-md-6 order-2">
	            <div class="p-5">
	              <img class="img-fluid rounded-circle" src="http://cleanbnb.co.kr/wp-content/uploads/2017/02/724be5f5-887a-4cad-bb5a-93df117334dc.jpg" alt="">
	            </div>
	          </div>
	          <div class="col-md-6 order-1">
	            <div class="p-5">
	              <h2 class="display-4">전국에 많은 방들이 있습니다..</h2>
	              <p> 전대 ,하숙 등등을 제공합니다. 또한 이러이러한 서비스를 제공합니다. 전대 ,하숙 등등을 제공합니다. 또한 이러이러한 서비스를 제공합니다. 전대 ,하숙 등등을 제공합니다. 또한 이러이러한 서비스를 제공합니다. </p>
	            </div>
	          </div>
	        </div>
	      </div>
      </section>
      
    
    
    </main>
    <!-- 컨텐츠 끝 -->
    
    <!-- 푸터 부분 -->
    <jsp:include page="footer.jsp" />
    <!-- 푸터 부분 끝 -->

    <!-- 스크립트 로드 -->
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.3/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/js/bootstrap.min.js"></script>
</body>
</html>