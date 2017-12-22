<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<c:if test="${not empty user}">
    <c:redirect url="/" />
</c:if>

<!doctype html>
<html lang="ko">

<head>
    <title>JAVA HOUSE - 회원가입</title>
    
    <!-- Required meta tags -->
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
    
    <!-- Bootstrap, Fontawesome, fonts and other libraries -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css" />
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css" />
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/3.5.2/animate.css" />
    <link rel="stylesheet" href="https://cdn.rawgit.com/openhiun/hangul/14c0f6faa2941116bb53001d6a7dcd5e82300c3f/nanumbarungothic.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" />
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
            <form id="form-signin" method="post" action="${pageContext.request.contextPath}/user/join">       
                <h2 class="form-signin-heading">회원가입</h2>
                
                <span>계정</span>
                
                <div class="input-group">
                    <div class="input-group-addon"><i class="fa fa-envelope" aria-hidden="true"></i></div>
                    <input type="email" class="form-control" id="email" name="email" placeholder="이메일" value="<c:out value="${requestScope.vo.email}"/>" required/>
                </div>
                <div class="input-group">
                    <div class="input-group-addon"><i class="fa fa-key" aria-hidden="true"></i></div>
                    <input type="password" class="form-control" id="password" name="password" placeholder="비밀번호 (8자이상)" required/>
                </div>
                
                <div class="input-group">
                    <label class="custom-control custom-checkbox">
                      <input type="checkbox" class="custom-control-input" id="is_host" name="is_host" value="true">
                      <span class="custom-control-indicator"></span>
                      <span class="custom-control-description">호스트로 가입하시려면 체크 해주세요.</span>
                    </label>
                </div>
                
                <span>주소</span>
                
                <div class="input-group address-input">
                    <div class="input-group-addon"><i class="fa fa-home" aria-hidden="true"></i></div>
                    <input type="text" class="form-control disabled" id="address" name="address" placeholder="주소" value="<c:out value="${requestScope.vo.address}"/>" required readonly/>
                </div>
                <div class="input-group address-input">
                    <div class="input-group-addon"><i class="fa fa-home" aria-hidden="true"></i></div>
                    <input type="text" class="form-control" id="address_detail" name="address_detail" value="<c:out value="${requestScope.vo.addressDetail}"/>" placeholder="상세 주소" required />
                </div>
                    
                <div class="input-group">
                    <a class="btn-block" href="javascript:getAddress()"><input type="button" class="btn btn-lg btn-outline-info btn-block" value="주소찾기" /></a>
                </div>
                
                <span>개인정보</span>
                
                <div class="input-group">
                    <div class="input-group-addon"><i class="fa fa-user" aria-hidden="true"></i></div>
                    <input type="text" class="form-control" id="firstname" name="firstname" placeholder="성" value="<c:out value="${requestScope.vo.firstName}"/>" required/>
                    <input type="text" class="form-control" id="lastname" name="lastname" placeholder="이름" value="<c:out value="${requestScope.vo.lastName}"/>" required/>
                </div>
                <div class="input-group">
                    <div class="input-group-addon"><i class="fa fa-birthday-cake" aria-hidden="true"></i></div>
                    <input type="datetime-local" class="form-control" id="birthday" name="birthday" placeholder="생일 (YYYY-MM-DD)" value="<fmt:formatDate pattern = "yyyy-MM-dd" value = "${requestScope.vo.birthday}" />" required/>
                </div>
                <div class="input-group">
                    <div class="input-group-addon"><i class="fa fa-phone" aria-hidden="true"></i></div>
                    <input type="tel" class="form-control" id="phone_no" name="phone_no" placeholder="휴대폰 번호 (-없이)" value="<c:out value="${requestScope.vo.phoneNo}"/>" required/>
                </div>    
                <div class="input-group">
                    <div class="input-group-addon"><i class="fa fa-user-secret" aria-hidden="true"></i></div>
                    <input type="text" class="form-control" id="ssn" name="ssn" placeholder="주민번호 (-없이)" value="<c:out value="${requestScope.vo.ssn}"/>" required/>
                </div>  

                <button class="btn btn-lg btn-primary btn-block" type="submit">회원가입</button>   
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
    <script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
    
    <!-- 다음 지도 스크립트 -->
    <script>
        function getAddress() {
        	new daum.Postcode({
                oncomplete: function(data) {
                	document.getElementById('address').value = data.address;
                	document.getElementById('address_detail').focus();
                	console.log(data.autoRoadAddress);
                },
                onclose: function(state) {
                    if(state === 'FORCE_CLOSE'){
                    	document.getElementById('address').value = "";
                    	document.getElementById('address_detail').value = "";
                    }
                },
            }).open();
        }
	</script>
</body>
</html>