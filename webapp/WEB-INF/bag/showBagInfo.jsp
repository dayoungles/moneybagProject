<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="/WEB-INF/header.jsp"%>
<link rel="stylesheet" type="text/css" href="/css/showBagInfo.css">
<container>
<div class="bagArea">
	<div class="info">머니백 정보: ${bag.info}</div>
	
	<a href="/bill/form/${bag.id}" class="register">새로운 사용내역 등록하기</a>
	<a href="/moneybagPayCheck/${bag.id}" class="register">지불체크</a>
	
	<div class="billArea" >
		<c:forEach var="bill" items="${billList}">
			<div class="bill" style="background-image: url(/bill_img/${bill.fileName}); background-size:100% 100%">
				이름: ${bill.billName}<br/>
				날짜: ${bill.createdDate}<br /> 
				사용금액: ${bill.usedMoney }<br />
			</div>
			
		</c:forEach>
	</div>


</div>
</container>

<%@ include file="/WEB-INF/footer.jsp"%>