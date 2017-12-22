<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<c:if test="${empty user}">
    <c:redirect url="/user/login" />
</c:if>
<c:if test="${not user.host}">
    <c:redirect url="/" />
</c:if>

<!doctype html>
<html lang="ko">

<head>
    <title>JAVA HOUSE - 매물 수정</title>
    
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
        
        <!-- 등록 폼 시작 -->
        <div class="container">
          <div class="form-wrapper animated bounceIn">
            <form id="form-signin" method="post" action="${pageContext.request.contextPath}/item/edit">       
                <h2 class="form-signin-heading">매물 수정</h2>
                
                    <input type="hidden" id="item_id" name="item_id" value="${item.itemID}" />
                 
                <div class="input-group">
                    <input type="text" class="form-control" id="name" name="name" placeholder="매물 명" value="${item.itemTitle}" required/>
                </div>
                <div class="input-group">
                    <input type="text" class="form-control" id="desc" name="desc" placeholder="설명" value="${item.itemDesc}" required/>
                </div>
                
                <div class="input-group">
                    <input type="datetime-local" class="form-control" id="contract_start_date" name="contract_start_date" placeholder="시작 YYYY-MM-DD" value="<fmt:formatDate pattern = "yyyy-MM-dd" value = "${item.contractStartDate}" />" required/>
                    <input type="datetime-local" class="form-control" id="contract_end_date" name="contract_end_date" placeholder="종료 YYYY-MM-DD" value="<fmt:formatDate pattern = "yyyy-MM-dd" value = "${item.contractEndDate}" />" required/>
                </div>
                
                <div class="input-group">
                    <label class="custom-control custom-checkbox">
                      <input type="checkbox" class="custom-control-input" id="is_available" name="is_available" value="${item.available}">
                      <span class="custom-control-indicator"></span>
                      <span class="custom-control-description">매물이 사용가능하면 체크해주세요.</span>
                    </label>
                </div>
                
                <span>주소</span>
                
                <div class="input-group address-input">
                    <div class="input-group-addon"><i class="fa fa-home" aria-hidden="true"></i></div>
                    <input type="text" class="form-control disabled" id="address" name="address" placeholder="주소" value="${item.address}" required readonly/>
                </div>
                <div class="input-group address-input">
                    <div class="input-group-addon"><i class="fa fa-home" aria-hidden="true"></i></div>
                    <input type="text" class="form-control" id="address_detail" name="address_detail" placeholder="상세 주소" value="${item.addressDetail}" required />
                </div>
                    
                <div class="input-group">
                    <a class="btn-block" href="javascript:getAddress()"><input type="button" class="btn btn-lg btn-outline-info btn-block" value="주소찾기" /></a>
                </div>
                
                <span>주택타입</span>
                <div class="input-group">
                     <select class="form-control" id="housing_type" name="housing_type">
                        <c:forEach var="i" items="${housingTypes}">
                            <option <c:if test="${item.housingTypeID eq i.housingTypeID}">selected</c:if> value="${i.housingTypeID}">${i.name}</option>
                        </c:forEach>
                     </select>
                </div>
                
                <div class="input-group">
                     <select class="form-control" id="residence_type" name="residence_type">
                        <c:forEach var="i" items="${residenceTypes}">
                            <option <c:if test="${item.residenceTypeID eq i.residenceTypeID}">selected</c:if> value="${i.residenceTypeID}">${i.name}</option>
                        </c:forEach>
                     </select>
                </div>

                <div class="input-group">
                    <div class="input-group-addon"><i class="fa fa-ticket" aria-hidden="true"></i></div>
                    <input type="number" class="form-control" id="deposit" name="deposit" placeholder="보증금 (단위: 만원)" value="${item.deposit}" required/>
                </div>
                <div class="input-group">
                    <div class="input-group-addon"><i class="fa fa-money" aria-hidden="true"></i></div>
                    <input type="number" class="form-control" id="price" name="price" placeholder="가격 (단위: 만원)" value="${item.price}" required/>
                </div>
                
                <span>계약종류</span>
                <div class="input-group">
                     <select class="form-control" id="contract_type" name="contract_type">
                        <c:forEach var="i" items="${contractTypes}">
                            <option <c:if test="${item.contractTypeID eq i.contractTypeID}">selected</c:if> value="${i.contractTypeID}">${i.name}</option>
                        </c:forEach>
                     </select>
                </div>
                
                <span>지불방법</span>
                <div class="input-group">
                     <select class="form-control" id="payment_type" name="payment_type">
                        <c:forEach var="i" items="${paymentTypes}">
                            <option <c:if test="${item.paymentTypeID eq i.paymentTypeID}">selected</c:if> value="${i.paymentTypeID}">${i.name}</option>
                        </c:forEach>
                     </select>
                </div>
                
                <span>옵션 선택</span>
                <div class="input-group">
                    <label class="custom-control custom-checkbox">
                      <input type="checkbox" class="custom-control-input" id="has_tv" name="has_tv" value="true" <c:if test="${options.hasTV}">checked</c:if>>
                      <span class="custom-control-indicator"></span>
                      <span class="custom-control-description">TV</span>
                    </label>
                    <label class="custom-control custom-checkbox">
                      <input type="checkbox" class="custom-control-input" id="has_ac" name="has_ac" value="true" <c:if test="${options.hasAC}">checked</c:if>>
                      <span class="custom-control-indicator"></span>
                      <span class="custom-control-description">에어컨</span>
                    </label>
                    <label class="custom-control custom-checkbox">
                      <input type="checkbox" class="custom-control-input" id="has_washing_machine" name="has_washing_machine" value="true" <c:if test="${options.hasWashingMachine}">checked</c:if>>
                      <span class="custom-control-indicator"></span>
                      <span class="custom-control-description">세탁기</span>
                    </label>
                </div>
                <div class="input-group">
                    <label class="custom-control custom-checkbox">
                      <input type="checkbox" class="custom-control-input" id="has_bed" name="has_bed" value="true" <c:if test="${options.hasBed}">checked</c:if>>
                      <span class="custom-control-indicator"></span>
                      <span class="custom-control-description">침대</span>
                    </label>
                    <input type="number" class="form-control" id="bed_cnt" name="bed_cnt" placeholder="침대개수" value="${options.bedCnt}"/>
                </div>
                <div class="input-group">
                    <label class="custom-control custom-checkbox">
                      <input type="checkbox" class="custom-control-input" id="has_kitchen" name="has_kitchen" value="true" <c:if test="${options.hasKitchen}">checked</c:if>>
                      <span class="custom-control-indicator"></span>
                      <span class="custom-control-description">주방</span>
                    </label>
                    <label class="custom-control custom-checkbox">
                      <input type="checkbox" class="custom-control-input" id="has_refrigerator" name="has_refrigerator" value="true" <c:if test="${options.hasRefrigerator}">checked</c:if>>
                      <span class="custom-control-indicator"></span>
                      <span class="custom-control-description">냉장고</span>
                    </label>
                    <label class="custom-control custom-checkbox">
                      <input type="checkbox" class="custom-control-input" id="has_microwave" name="has_microwave" value="true" <c:if test="${options.hasMicrowave}">checked</c:if>>
                      <span class="custom-control-indicator"></span>
                      <span class="custom-control-description">전자레인지</span>
                    </label>
                </div>
                <div class="input-group">
                    <label class="custom-control custom-checkbox">
                      <input type="checkbox" class="custom-control-input" id="has_bathroom" name="has_bathroom" value="true" <c:if test="${options.hasBathroom}">checked</c:if>>
                      <span class="custom-control-indicator"></span>
                      <span class="custom-control-description">화장실</span>
                    </label>
                    <label class="custom-control custom-checkbox">
                      <input type="checkbox" class="custom-control-input" id="is_public_bathroom" name="is_public_bathroom" value="true" <c:if test="${options.publicBathroom}">checked</c:if>>
                      <span class="custom-control-indicator"></span>
                      <span class="custom-control-description">공동 화장실일 경우 체크해주세요.</span>
                    </label>
                </div>

                <button class="btn btn-lg btn-primary btn-block" type="submit">등록</button>   
                
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