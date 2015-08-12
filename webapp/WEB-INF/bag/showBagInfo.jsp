<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="/WEB-INF/header.jsp"%>
<link rel="stylesheet" type="text/css" href="/css/showBagInfo.css">
<container>
<div class="bagArea">
	<div class="info">머니백 정보: ${bag.info}</div>

	<div class="billArea">
		<c:forEach var="bill" items="${billList}">
			<div class="bill" bill_id="${bill.bill_id}">
				<div class="bag" id="${bill.id}" style="background-image:url(/bill_img/${bill.fileName}); ">
				<!-- 이부분 imgsrc로 하는게 낫나?? -->
				<div class="bill_info">
					<p class="billName">${bill.billName}</p>
					<p class="usedMoney">${bill.usedMoney}</p>
					<p class="createdDate">${bill.createdDate}</p>
				</div>
			</div>

		</c:forEach>
	</div>


</div>
</container>
<script src="../js/ajax.js"></script>
<script>
	var bills = document.querySelectorAll(".bill");

	var len = bills.length;
	for (var i = 0; i < len; i++) {
		bills[i].addEventListener("click", function() {
			var oAjax = new ajax("GET", "/api/showBillDetail?bill_id="
					+ this.getAttribute("bill_id"), function(response) {
				alert(response);
			});
			oAjax.service();
		});
	}
</script>
<%@ include file="/WEB-INF/bag/showbagInfoMenu.jsp"%>