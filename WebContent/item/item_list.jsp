<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!doctype html>
<html lang="ko">

<head>
    <title>JAVA HOUSE - 모든 매물 보기</title>
    
    <!-- Required meta tags -->
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
    
    <!-- Bootstrap, Fontawesome, fonts and other libraries -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css" />
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css" />
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/3.5.2/animate.css" />
    <link rel="stylesheet" href="https://cdn.rawgit.com/openhiun/hangul/14c0f6faa2941116bb53001d6a7dcd5e82300c3f/nanumbarungothic.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css?1629" />
</head>

<body>
    <!-- 네비게이션 부분 -->
    <jsp:include page="../navigation.jsp" />
    <!-- 네비게이션 부분 끝 -->
    
    <!-- 컨텐츠 시작 -->
    <main role="main">
        <!-- 내부 컨텐츠 시작 -->
        <div class="container">
          <div class="form-wrapper animated bounceIn">
            <div id="item-list">
                <h2>전체 매물 보기</h2>
	            <div class="table-responsive">
	                <table class="table table-striped">
		              <thead>
		                <tr>
		                    <th>상태</th>
		                    <th>이름</th>
		                    <th>기간</th>
		                    <th>위치</th>
		                </tr>
		              </thead>
		              
		              <tbody>
			              <c:forEach var="item" items="${items}">
			                <tr style="cursor:pointer;" onClick="location.href='${pageContext.request.contextPath}/item/detail?id=${item.itemID}'">
			                  <td>
				                  <c:choose>
				                      <c:when test="${item.available}">
				                          <div class="item-status available">가능</div>
				                      </c:when>
				                      <c:otherwise>
				                          <div class="item-status not-available">완료</div>
				                      </c:otherwise>
				                  </c:choose>
			                  </td>
			                  
			                  <td>${item.itemTitle}</td>
			                  
			                  <td>
			                     <fmt:formatDate pattern = "yy/MM/dd" value = "${item.contractStartDate}" />
			                     ~
			                     <fmt:formatDate pattern = "yy/MM/dd" value = "${item.contractEndDate}" />
			                  </td>
			                  <td>${item.address}</td>
			                </tr>
			              </c:forEach>
		              </tbody>
		            </table>
	            </div>
	        </div>
          </div>
        </div>
        <!-- 내부 컨텐츠 끝 -->
        
    </main>
    <!-- 컨텐츠 끝 -->
    
    <!-- 푸터 부분 -->
    <jsp:include page="../footer.jsp" />
    <!-- 푸터 부분 끝 -->

    <!-- 스크립트 로드 -->
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.3/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/js/bootstrap.min.js"></script>
    <script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
    
</body>
</html>