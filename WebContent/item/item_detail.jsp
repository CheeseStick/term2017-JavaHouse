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
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css?1625" />
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
                <div class="item-heading">
                    <div class="title-bar">
                        <div class="item-title"><c:out value="${item.itemTitle}" /></div>
                        <c:choose>
                          <c:when test="${item.available}">
                              <div class="item-status available">계약가능</div>
                          </c:when>
                          <c:otherwise>
                              <div class="item-status not-available">계약완료</div>
                          </c:otherwise>
                        </c:choose>
                    </div>
                </div>

                <div class="item-element">
                    <div class="item-group">
                        <div class="title">호스트 이름</div>
                        <div class="data"><c:out value="${host.firstName} ${host.lastName}" /></div>
                    </div>
                    
                    <div class="item-group">
                        <div class="title">매물 설명</div>
                        <div class="data"><c:out value="${item.itemDesc}" /></div>
                    </div>
                </div>
                
                <div class="item-element">
                    <div class="item-group">
		                <div class="title">계약 시작일</div>
		                <div class="data"><fmt:formatDate pattern = "yyyy년 MM월 dd일" value = "${item.contractStartDate}" /> 부터</div>
	                </div>
	                
	                <div class="item-group">
			            <div class="title">계약 종료일</div>
			            <div class="data"><fmt:formatDate pattern = "yyyy년 MM월 dd일" value = "${item.contractEndDate}" /> 까지</div>
		            </div>
	            </div>
	            
	            <div class="item-element">
	                <div class="item-group">
	                   <div class="title">주소</div>
                        <div class="data"><c:out value="${item.address}" /></div>
                    </div>
                    
                    <div class="item-group">
                        <div class="title">상세주소</div>
                        <div class="data"><c:out value="${item.addressDetail}" /></div>
                    </div>
                    
                    <div class="item-group">
                        <div class="title">주택타입</div>
                        <div class="data">
                            <c:out value="${housingTypes[item.housingTypeID].name}" /> - 
                            <c:out value="${residenceTypes[item.residenceTypeID].name}" />    
                        </div>
                    </div>
	            </div>
	            
	            <div class="item-element">
	                <div class="item-group">
	                   <div class="title">계약종류</div>
                        <div class="data"><c:out value="${contractTypes[item.contractTypeID].name}" /></div>
                    </div>
                    
                    <div class="item-group">
                        <div class="title">보증금</div>
                        <div class="data"><c:out value="${item.deposit}" /> 만원</div>
                    </div>
                    
                    <div class="item-group">
                        <div class="title"><c:out value="${paymentTypes[item.paymentTypeID].name}" /></div>
                        <div class="data"><c:out value="${item.price}" /> 만원</div>
                    </div>
                </div>
                
                <div id="option-element">
                    <div class="heading"><span>옵션</span></div>
                    <div class="option-list">
	                    <ul>
	                       <c:choose>
                               <c:when test="${option.hasBed}">
                                   <li id="option-item" class="option-available">
                               </c:when>
                               
                               <c:otherwise>
                                   <li id="option-item" class="option-not-available">
                               </c:otherwise>
                           </c:choose>
                           <div class="icon"><i class="fa fa-bed fa-fw fa-2x" aria-hidden="true"></i></div>
                           <div class="status">침대(<c:out value="${option.bedCnt}" />개)</div>
                           </li>
                          
                          <c:choose>
                               <c:when test="${option.hasBathroom}">
                                   <li id="option-item" class="option-available">
                               </c:when>
                               
                               <c:otherwise>
                                   <li id="option-item" class="option-not-available">
                               </c:otherwise>
                           </c:choose>
                           <div class="icon"><i class="fa fa-bath fa-fw fa-2x" aria-hidden="true"></i></div>
                           <div class="status">화장실<c:if test="${option.publicBathroom}">(공용)</c:if></div>
                           </li>

	                       <c:choose>
	                           <c:when test="${option.hasTV}">
		                           <li id="option-item" class="option-available">
	                           </c:when>
	                           
	                           <c:otherwise>
	                               <li id="option-item" class="option-not-available">
	                           </c:otherwise>
	                       </c:choose>
	                       <div class="icon"><i class="fa fa-television fa-fw fa-2x" aria-hidden="true"></i></div>
	                       <div class="status">케이블 TV</div>
                           </li>
	                       
	                       <c:choose>
                               <c:when test="${option.hasAC}">
                                   <li id="option-item" class="option-available">
                               </c:when>
                               
                               <c:otherwise>
                                   <li id="option-item" class="option-not-available">
                               </c:otherwise>
                           </c:choose>
                           <div class="icon"><i class="fa fa-thermometer-three-quarters fa-fw fa-2x" aria-hidden="true"></i></div>
                           <div class="status">에어컨</div>
                           </li>
                           
                           <c:choose>
                               <c:when test="${option.hasWashingMachine}">
                                   <li id="option-item" class="option-available">
                               </c:when>
                               
                               <c:otherwise>
                                   <li id="option-item" class="option-not-available">
                               </c:otherwise>
                           </c:choose>
                           <div class="icon"><i class="fa fa-archive fa-fw fa-2x" aria-hidden="true"></i></div>
                           <div class="status">세탁기</div>
                           </li>
                           
                           <c:choose>
                               <c:when test="${option.hasKitchen}">
                                   <li id="option-item" class="option-available">
                               </c:when>
                               
                               <c:otherwise>
                                   <li id="option-item" class="option-not-available">
                               </c:otherwise>
                           </c:choose>
                           <div class="icon"><i class="fa fa-cutlery fa-fw fa-2x" aria-hidden="true"></i></div>
                           <div class="status">주방</div>
                           </li>
                           
                           <c:choose>
                               <c:when test="${option.hasRefrigerator}">
                                   <li id="option-item" class="option-available">
                               </c:when>
                               
                               <c:otherwise>
                                   <li id="option-item" class="option-not-available">
                               </c:otherwise>
                           </c:choose>
                           <div class="icon"><i class="fa fa-snowflake-o fa-fw fa-2x" aria-hidden="true"></i></div>
                           <div class="status">냉장고</div>
                           </li>
                           
                           <c:choose>
                               <c:when test="${option.hasMicrowave}">
                                   <li id="option-item" class="option-available">
                               </c:when>
                               
                               <c:otherwise>
                                   <li id="option-item" class="option-not-available">
                               </c:otherwise>
                           </c:choose>
                           <div class="icon"><i class="fa fa-bolt fa-fw fa-2x" aria-hidden="true"></i></div>
                           <div class="status">전자레인지</div>
                           </li>

	                    </ul>
                    </div>
                </div>

                <hr/>

                <c:choose>
                  <c:when test="${empty user}">
                     <a class="btn btn-lg btn-primary btn-block" href="${pageContext.request.contextPath}/user/login" role="button">로그인</a>
                  </c:when>
                
                  <c:when test="${(host.userID eq item.hostID) or user.admin}">
                      <a class="btn btn-lg btn-info btn-block" href="#" role="button">매물수정</a>
                      <a class="btn btn-lg btn-danger btn-block" href="#" role="button">매물삭제</a>
                  </c:when>
                  
                  <c:otherwise>
                      <a class="btn btn-lg btn-primary btn-block" href="#" role="button"><i class="fa fa-envelope" aria-hidden="true"></i> 메시지 전송</a>
                  </c:otherwise>
                </c:choose>                
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