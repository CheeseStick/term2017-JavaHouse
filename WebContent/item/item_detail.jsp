<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!doctype html>
<html lang="ko">

<head>
    <title>JAVA HOUSE - 매물 상세 보기</title>
    
    <!-- Required meta tags -->
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
    
    <!-- Bootstrap, Fontawesome, fonts and other libraries -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css" />
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css" />
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/3.5.2/animate.css" />
    <link rel="stylesheet" href="https://cdn.rawgit.com/openhiun/hangul/14c0f6faa2941116bb53001d6a7dcd5e82300c3f/nanumbarungothic.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css?124" />
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
            <div id="item-detail">
                <h2 class="item-title"><c:out value="${item.itemTitle}" /></h2>
                <p class="item-desc"><c:out value="${item.itemDesc}" /></p>
                
                <div class="item-date">
	                계약 시작일: <fmt:formatDate pattern = "yyyy-MM-dd" value = "${item.contractStartDate}" /> <br/>
		            계약 종료일: <fmt:formatDate pattern = "yyyy-MM-dd" value = "${item.contractEndDate}" /> <br/>
	            </div>
	            
	            <div class="item-address">
	                주소: <c:out value="${item.address}" /> <br/>
	                상세주소: <c:out value="${item.addressDetail}" /> <br/>
	                주택타입: <c:out value="${housingTypes[item.housingTypeID].name}" /> - 
	                <c:out value="${residenceTypes[item.residenceTypeID].name}" />
	            </div>
	            
	            <div class="item-price">
	                계약종류: <c:out value="${contractTypes[item.contractTypeID].name}" /> <br/>
                    보증금: <c:out value="${item.deposit}" /> 만원<br/>
                    <c:out value="${paymentTypes[item.paymentTypeID].name}" />: <c:out value="${item.price}" /> 만원<br/>
                </div>
                
                <hr/>
                
                <div class="item-options">
                    옵션
                    <ul>
                      <c:if test="${option.hasTV}"><li>TV</li></c:if>
                      <c:if test="${option.hasAC}"><li>에어컨</li></c:if>
                      <c:if test="${option.hasWashingMachine}"><li>세탁기</li></c:if>
                      
                      <c:if test="${option.hasKitchen}"><li>주방</li></c:if>
                      <c:if test="${option.hasRefrigerator}"><li>냉장고</li></c:if>
                      <c:if test="${option.hasMicrowave}"><li>전자레인지</li></c:if>
                      
                      
                      <c:if test="${option.hasBathroom}"><li>화장실 <c:if test="${option.isPublicBathroom}">(공용)</c:if></li></c:if>
                      <c:if test="${option.hasBed}"><li>침대 (<c:out value="${option.bedCnt}" />개)</li></c:if>
                    </ul>
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