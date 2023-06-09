<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="true"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
   
<html>

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>CHAT</title>

    <c:import url="../template/common_css.jsp"></c:import>

    <!-- Google Fonts -->
    <link href="https://fonts.googleapis.com/css2?family=Open+Sans:wght@300;400;500;600;700&display=swap" rel="stylesheet">

    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.css">

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <!-- <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script> -->
    <!-- <script src="http://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.js"></script> -->

    <script src="https://cdnjs.cloudflare.com/ajax/libs/sockjs-client/1.1.5/sockjs.min.js"></script>
    <!-- <script src="//dapi.kakao.com/v2/maps/sdk.js?appkey=5211c78ede13565f054a7d30da0ff316"></script> -->
    <!-- <script async src="//dapi.kakao.com/v2/maps/sdk.js?appkey=5211c78ede13565f054a7d30da0ff316&libraries=services"></script> -->

    <!-- page-title -->
  <section class="page-title bg-cover" data-background="/resources/images/banner/page-title.jpg">
	<div class="container">
	  <div class="row">
		<div class="col-12 text-center">
		  <h1 class="display-1 text-white font-weight-bold font-primary">with Drink</h1>
		</div>
	  </div>
	</div>
	</section>
	<!-- /page-title -->

</head>
<body>
    <c:import url="../template/newheader.jsp"></c:import>


    <!-- char-area -->
    <section class="message-area">
        <div class="container">
            <div class="row">
                <div class="col-12">
                    <div class="chat-area">
                        <!-- menu -->
                        <div class="chatlist">
                            <div class="modal-dialog-scrollable">
                                <div class="modal-content">
                                    <div class="chat-header">

                                        <ul class="nav nav-tabs" id="myTab" role="tablist">
                                            <li class="nav-item" role="presentation">
                                                <button class="nav-link active" id="Open-tab" data-bs-toggle="tab"
                                                    data-bs-target="#Open" type="button" role="tab" aria-controls="Open"
                                                    aria-selected="true">Friends</button>
                                            </li>
                                            <li class="nav-item" role="presentation">
                                                <button class="nav-link" id="Closed-tab" data-bs-toggle="tab"
                                                    data-bs-target="#Closed" type="button" role="tab"
                                                    aria-controls="Closed" aria-selected="false">Chat</button>
                                            </li>
                                        </ul>
                                    </div>

                                    <div class="modal-body">
                                        <!-- list -->
                                        <div class="chat-lists">
                                            <div class="tab-content" id="myTabContent">
                                                <div class="tab-pane fade show active" id="Open" role="tabpanel"
                                                    aria-labelledby="Open-tab">
                                                    <!-- Friends-list -->
                                                    <div class="chat-list" id="chat-list">
                                                        <!-- <div class="d-flex align-items-center friend">
                                                                <div class="flex-shrink-0">
                                                                    <img class="img-fluid"
                                                                    src="https://mehedihtml.com/chatbox/assets/img/user.png"
                                                                    alt="user img">
                                                                </div>
                                                                <div class="flex-grow-1 ms-3 name">
                                                                    <h7 class="pull-right">5km</h7>
                                                                    <h3>Mehedi Hasan</h3>
                                                                    <p>안녕하세요 같이만나서 놀아요 자기소개입니다</p>
                                                                </div>
                                                            </div> -->

                                                    </div>
                                                    <!-- Friends-list -->
                                                </div>
                                                <div class="tab-pane fade" id="Closed" role="tabpanel"
                                                    aria-labelledby="Closed-tab">

                                                    <!-- chat-list -->
                                                    <div class="chat-list" id="2nd-list">
                                                        <!-- <div class="d-flex align-items-center 2ndList">
                                                            <div class="flex-shrink-0">
                                                                <img class="img-fluid"
                                                                    src="https://mehedihtml.com/chatbox/assets/img/user.png"
                                                                    alt="user img">
                                                            </div>
                                                            <div class="flex-grow-1 ms-3">
                                                                <h3>Mehedi Hasan</h3>
                                                                <p>대화내용이에요</p>
                                                            </div>
                                                        </div> -->

                                                    </div>
                                                    <!-- chat-list -->
                                                </div>
                                            </div>

                                        </div>
                                        <!-- chat-list -->
                                    </div>
                                </div>
                            </div>
                        </div>
                        <!-- menu -->

                        <!-- chatbox -->
                        <div class="chatbox">
                            <div id="map" class="modal-dialog-scrollable">
                             <!--<div class="modal-dialog-scrollable">
                                <div class="modal-content">
                                     <div class="msg-head">
                                        <div class="row">
                                            <div class="col-8">
                                                <div class="d-flex align-items-center">
                                                    <span class="chat-icon"><img class="img-fluid"
                                                            src="https://mehedihtml.com/chatbox/assets/img/arroleftt.svg"
                                                            alt="image title"></span>
                                                    <div class="flex-shrink-0">
                                                        <img class="img-fluid"
                                                            src="https://mehedihtml.com/chatbox/assets/img/user.png"
                                                            alt="user img">
                                                    </div>
                                                    <div class="flex-grow-1 ms-3">
                                                        <h3>Mehedi Hasan</h3>
                                                        <p>front end developer</p>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="col-4">
                                                <ul class="moreoption">
                                                    <li class="navbar nav-item dropdown">
                                                        <a class="nav-link dropdown-toggle" href="#" role="button"
                                                            data-bs-toggle="dropdown" aria-expanded="false"><i
                                                                class="fa fa-ellipsis-v" aria-hidden="true"></i></a>
                                                        <ul class="dropdown-menu">
                                                            <li><a class="dropdown-item" href="#">Leave Chat</a></li>
                                                        </ul>
                                                    </li>
                                                </ul>
                                            </div>
                                        </div>
                                    </div>

                                    <div class="modal-body">
                                        <div class="msg-body">
                                            <ul>
                                                <li class="sender">
                                                    <p> Hey, Are you there? </p>
                                                    <span class="time">10:06 am</span>
                                                </li>

                                                <li class="repaly">
                                                    <p>yes!</p>
                                                    <span class="time">10:20 am</span>
                                                </li>

                                            </ul>
                                        </div>
                                    </div>

                                    <div class="send-box">
                                        <form action="">
                                            <input type="text" class="form-control" aria-label="message…"
                                                placeholder="Write message…" id="txtMessage">

                                            <button type="button" id="sendButton"><i class="fa fa-paper-plane"
                                                    aria-hidden="true"></i>
                                                Send</button>
                                        </form>
                                    </div>
                                    </div>
                                </div>-->
                            </div> 
                        </div>
                        <!-- chatbox -->
                    </div>

                </div>
            </div>
        </div>
    </section>
    <!-- char-area -->


    <link href="/resources/css/chatList.css" rel="stylesheet">
    <script src="/resources/js/chatList.js"></script>
	<c:import url="../template/common_js.jsp"></c:import>


    <script >
        id='${member.memberId}'

        // console.log("로그인 아이디 :"+id);
    </script>

<!-- <script>
  kakao.maps.load(function() {
//현재 위치(위도 경도) 권한 요청 및 받아오기 
function getLocation() {
	  if (navigator.geolocation) { // GPS를 지원하면
	    navigator.geolocation.getCurrentPosition(function(position) {
        console.log(position.coords.latitude + ' ' + position.coords.longitude);
          let container = document.getElementById('map');
          let options = {
            center: new kakao.maps.LatLng(position.coords.latitude, position.coords.longitude),
            level: 3
            
          };
        

          let map = new kakao.maps.Map(container, options);

          let imageSrc = 'https://cdn-icons-png.flaticon.com/512/8830/8830938.png', // 마커이미지의 주소입니다    
          imageSize = new kakao.maps.Size(70, 70), // 마커이미지의 크기입니다
          imageOption = {offset: new kakao.maps.Point(27, 69)}; // 마커이미지의 옵션입니다. 마커의 좌표와 일치시킬 이미지 안에서의 좌표를 설정합니다.
            
          // 마커의 이미지정보를 가지고 있는 마커이미지를 생성합니다
          var markerImage = new kakao.maps.MarkerImage(imageSrc, imageSize, imageOption),
              markerPosition = new kakao.maps.LatLng(position.coords.latitude, position.coords.longitude); // 마커가 표시될 위치입니다

          // 마커를 생성합니다
          var marker = new kakao.maps.Marker({
              position: markerPosition, 
              image: markerImage // 마커이미지 설정 
          });

          // 마커가 지도 위에 표시되도록 설정합니다
          marker.setMap(map);  


	    }, function(error) {
	      console.error(error);
	    }, {
	      enableHighAccuracy: false,
	      maximumAge: 0,
	      timeout: Infinity
	    });
	  } else {
	    alert('GPS를 지원하지 않습니다');
	  }
	}
	getLocation();

  });
</script> -->
 

</body>

</html>