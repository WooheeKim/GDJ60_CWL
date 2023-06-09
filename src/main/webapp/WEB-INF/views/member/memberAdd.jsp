<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>회원가입</title>
	<c:import url="../template/common_css.jsp"></c:import>
	<link rel="stylesheet" href="/resources/css/common/style.css">
	<link rel="stylesheet" href="/resources/css/member/member.css">
	
	<!-- page-title -->
	<section class="page-title bg-cover" data-background="/resources/images/banner/page-title.jpg">
		<div class="container">
			<div class="row">
				<div class="col-12 text-center">
					<h1 class="display-1 text-white font-weight-bold font-primary">Join</h1>
				</div>
			</div>
		</div>
	</section>
</head>
<body>
	<c:import url="../template/newheader.jsp"></c:import>
<div class="wrapper">
	<form id="join_form" method="post">
	<div class="wrap">
		<div class="mt-5 mb-3 row">
			<label for="memberId" class="col-sm-2 col-form-label"><b>ID</b></label>
			<div class="col-sm-10">
				<input type="text" class="id_input form-control" name="memberId" placeholder="영문 소문자, 숫자만 사용 가능합니다.">
				<span class="id_input_re_1 mx-2 mt-2">사용 가능한 아이디입니다.</span>
				<span class="id_input_re_2 mx-2 mt-2">아이디가 이미 존재합니다.</span>					
			</div>
		</div>
		
	<!-- <div class="nickName_wrap">
				<div class="nickName_name">닉네임</div>
				<div class="nickName_input_box">
					<input class="nickName_input" name="memberNickName">
				</div>
				<span class="nickName_input_re_1">사용 가능한 닉네임입니다.</span>
				<span class="nickName_input_re_2">닉네임이 이미 존재합니다.</span>	
			</div>	 -->
			
		<div class="mb-3 row">
			<label for="memberPw" class="col-sm-2 col-form-label"><b>비밀번호</b></label>
			<div class="col-sm-10">
				<input type="password" class="pw_input form-control" id="memberPw" name="memberPw">
			</div>
		</div>
		
		<div class="mb-3 row">
			<label for="memberPw" class="col-sm-2 col-form-label"><b>비밀번호 확인</b></label>
			<div class="col-sm-10">
				<input type="password" class="pwck_input form-control" id="memberPw">
				<span class="final_pwck_ck mx-2 mt-2">비밀번호를 한 번 더 입력해 주세요.</span>
				<span class="pwck_input_re_1 mx-2 mt-2">비밀번호가 일치합니다.</span>
				<span class="pwck_input_re_2 mx-2 mt-2">비밀번호가 일치하지 않습니다.</span>
			</div>
		</div>
		
		<div class="mb-3 row">
			<label for="memberName" class="col-sm-2 col-form-label"><b>이름</b></label>
			<div class="col-sm-10">
				<input type="text" class="form-control user_input" id="memberName" name="memberName">
				<span class="final_name_ck mx-2 mt-2">이름을 입력해주세요.</span>
			</div>
		</div>
		
		<div class="mb-3 row">
			<select class="form-select" name="memberGender">
				<option selected>성별</option>
				<option value="남성">남성</option>
				<option value="여성">여성</option>
			</select>
		</div>
		
		<div class="mb-3 row">
			<label for="memberAge" class="col-sm-2 col-form-label"><b>나이</b></label>
			<div class="col-sm-10">
				<input type="number" class="form-control" id="memberAge" name="memberAge">
			</div>
		</div>
		
		<div class="mb-3 row">
			<label for="memberPhone" class="col-sm-2 col-form-label"><b>전화 번호</b></label>
			<div class="col-sm-10">
				<input type="text" class="form-control" id="memberPhone" name="memberPhone" placeholder="하이픈(-)을 포함하여 입력하세요.">
				<span class="final_phone_ck mx-2 mt-2">전화 번호를 입력해 주세요.</span>
			</div>
		</div>
		
		<div class="mb-3 row">
			<label for="memberEmail" class="col-sm-2 col-form-label"><b>이메일</b></label>
			<div class="col-sm-10">
				<input type="text" class="form-control mail_input" id="memberEmail" name="memberEmail" placeholder="email@example.com">
				<span class="final_mail_ck mx-2 mt-2">이메일을 입력해주세요.</span>
			</div>
		</div>
		
		<div class="mb-3 row">
			<label for="memberAddress1" class="col-sm-2 col-form-label"><b>주소</b></label>
			<div class="col-sm-8">
				<input class="form-control address_input_1" name="memberAddress1" readonly="readonly">
			</div>
			<div class="address_button col-auto row" onclick="execution_daum_address()">
				<span class="btn btn-point">주소 찾기</span>
			</div>
		</div>
		<div class="mb-3 row justify-content-end">
			<div class="col-sm-10">
				<input class="form-control address_input_2" name="memberAddress2" readonly="readonly">
			</div>
		</div>
		<div class="mb-3 row justify-content-end">
			<div class="col-sm-10">
				<input class="form-control address_input_3" name="memberAddress3" readonly="readonly">
				<span class="final_addr_ck mx-2 mt-2">주소를 입력해 주세요.</span>
			</div>
		</div>
		
		<div class="mb-3">
			<label for="exampleFormControlTextarea1" class="form-label"><b>자기소개</b></label>
			<textarea class="form-control" id="exampleFormControlTextarea1" rows="3" name="memberSI"></textarea>
		</div>
		
		<div class="join_button_wrap row justify-content-center my-5">
			<input type="button" class="join_button btn btn-primary btn-sm btn-default" value="가입">
		</div>
	</div>
	</form>
</div>

	<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
	<c:import url="../template/common_js.jsp"></c:import>
	<c:import url="../template/footer.jsp"></c:import>	
<script>
 /* 유효성 검사 통과유무 변수 */
 var idCheck = false;			// 아이디
 var idckCheck = false;			// 아이디 중복 검사
 var nickName = false;			// 닉네임
 //var nickNameCheck = false;		// 닉네임 중복 검사
 var pwCheck = false;			// 비번
 var pwckCheck = false;			// 비번 확인
 var pwckcorCheck = false;		// 비번 확인 일치 확인
 var nameCheck = false;			// 이름
 var addressCheck = false 		// 주소
$(document).ready(function(){
	//회원가입 버튼(회원가입 기능 작동)
	$(".join_button").click(function(){
		
		/* 입력값 변수 */
		var id = $('.id_input').val(); 				// id 입력란
		//var nickName = $('.nickName_input').val(); 	// 닉네임 입력란
		var pw = $('.pw_input').val();				// 비밀번호 입력란
		var pwck = $('.pwck_input').val();			// 비밀번호 확인 입력란
		var name = $('.user_input').val();			// 이름 입력란
		var mail = $('.mail_input').val();			// 이메일 입력란
		var addr = $('.address_input_3').val();		// 주소 입력란
		
		/* 아이디 유효성검사 */
		if(id == ""){
			$('.final_id_ck').css('display','block');
			idCheck = false;
		}else{
			$('.final_id_ck').css('display', 'none');
			idCheck = true;
		}
		
		/* 닉네임 유효성검사 */
		if(nickName == ""){
			$('.final_nickName_ck').css('display','block');
			nickNameCheck = false;
		}else{
			$('.final_nickName_ck').css('display', 'none');
			nickNameCheck = true;
		}
		
		/* 비밀번호 유효성 검사 */
		if(pw == ""){
			$('.final_pw_ck').css('display','block');
			pwCheck = false;
		}else{
			$('.final_pw_ck').css('display', 'none');
			pwCheck = true;
		}
		
		/* 비밀번호 확인 유효성 검사 */
		if(pwck == ""){
			$('.final_pwck_ck').css('display','block');
			pwckCheck = false;
		}else{
			$('.final_pwck_ck').css('display', 'none');
			pwckCheck = true;
		}
		
		/* 이름 유효성 검사 */
		if(name == ""){
			$('.final_name_ck').css('display','block');
			nameCheck = false;
		}else{
			$('.final_name_ck').css('display', 'none');
			nameCheck = true;
		}		
		
		
		
		/* 주소 유효성 검사 */
		if(addr == ""){
			$('.final_addr_ck').css('display','block');
			addressCheck = false;
		}else{
			$('.final_addr_ck').css('display', 'none');
			addressCheck = true;
		}		
		
		/* 최종 유효성 검사 */
		if(idCheck&&idckCheck&&pwCheck&&pwckCheck&&pwckcorCheck&&nameCheck&&addressCheck ){
			$("#join_form").attr("action", "/member/memberAdd");
			$("#join_form").submit();			
			
		}		
		
		return false;
	});
});
//아이디 중복검사
$('.id_input').on("propertychange change keyup paste input", function(){
	/* console.log("keyup 테스트"); */
	
	var memberId = $('.id_input').val();			// .id_input에 입력되는 값
	var data = {memberId : memberId}				// '컨트롤에 넘길 데이터 이름' : '데이터(.id_input에 입력되는 값)'
	
	$.ajax({
		type : "post",
		url : "/member/memberIdCheck",
		data : data,
		success : function(result){
			// console.log("성공 여부" + result);
			if(result != 'fail'){
				$('.id_input_re_1').css("display","inline-block");
				$('.id_input_re_2').css("display", "none");	
				idckCheck = true;
			} else {
				$('.id_input_re_2').css("display","inline-block");
				$('.id_input_re_1').css("display", "none");
				idckCheck = false;
			}	
		}// success 종료
	}); // ajax 종료	
});// function 종료

 //닉네임 중복검사
//$('.nickName_input').on("propertychange change keyup paste input", function(){
//	/* console.log("keyup 테스트"); */
//	
//	var memberNickName = $('.nickName_input').val();	// .nickName_input에 입력되는 값
//	var data = {memberNickName : memberNickName}				// '컨트롤에 넘길 데이터 이름' : '데이터(.nickName_input에 입력되는 값)'
//	
//	$.ajax({
//		type : "post",
//		url : "/member/memberNickNameCheck",
//		data : data,
//		success : function(result){
//			// console.log("성공 여부" + result);
//			if(result != 'fail'){
//				$('.nickName_input_re_1').css("display","inline-block");
//				$('.nickName_input_re_2').css("display", "none");	
//				nickNameCheck = true;
//			} else {
//				$('.nickName_input_re_2').css("display","inline-block");
//				$('.nickName_input_re_1').css("display", "none");
//				nickNameCheck = false;
//			}	
//		}// success 종료
//	}); // ajax 종료	
//});// function 종료

/* 다음 주소 연동 */
function execution_daum_address(){
	
    new daum.Postcode({
        oncomplete: function(data) {
            // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분입니다.
            
            // 각 주소의 노출 규칙에 따라 주소를 조합한다.
            // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
            var addr = ''; // 주소 변수
            var extraAddr = ''; // 참고항목 변수
            //사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
            if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
                addr = data.roadAddress;
            } else { // 사용자가 지번 주소를 선택했을 경우(J)
                addr = data.jibunAddress;
            }
            // 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
            if(data.userSelectedType === 'R'){
                // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                    extraAddr += data.bname;
                }
                // 건물명이 있고, 공동주택일 경우 추가한다.
                if(data.buildingName !== '' && data.apartment === 'Y'){
                    extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                }
                // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                if(extraAddr !== ''){
                    extraAddr = ' (' + extraAddr + ')';
                }
                // 주소변수 문자열과 참고항목 문자열 합치기
      			addr += extraAddr;
            
            } else {
                addr += ' ';
            }
            // 우편번호와 주소 정보를 해당 필드에 넣는다.
            $(".address_input_1").val(data.zonecode);
            //$("[name=memberAddr1]").val(data.zonecode);	// 대체가능
            $(".address_input_2").val(addr);
            //$("[name=memberAddr2]").val(addr);			// 대체가능
            // 상세주소 입력란 disabled 속성 변경 및 커서를 상세주소 필드로 이동한다.
            $(".address_input_3").attr("readonly",false);
            $(".address_input_3").focus();
            
        }
    }).open();   
    
}
/* 비밀번호 확인 일치 유효성 검사 */
$('.pwck_input').on("propertychange change keyup paste input", function(){
	
	var pw = $('.pw_input').val();
	var pwck = $('.pwck_input').val();
	$('.final_pwck_ck').css('display', 'none');
	
	if(pw == pwck){
		$('.pwck_input_re_1').css('display','block');
		$('.pwck_input_re_2').css('display','none');
		pwckcorCheck = true;
	}else{
		$('.pwck_input_re_1').css('display','none');
		$('.pwck_input_re_2').css('display','block');
		pwckcorCheck = false;
	}
	
	
});
</script>

</body>
</html>