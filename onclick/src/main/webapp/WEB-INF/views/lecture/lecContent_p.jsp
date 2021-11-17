<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.onclick.app.domain.*" %>
<%LecVO lv = (LecVO)session.getAttribute("lv"); %>
<%int sidx =(Integer)session.getAttribute("sidx");%>
<%VideoAttenDto vd =(VideoAttenDto)request.getAttribute("vd"); %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>강의 내용 </title>
        <link href="https://cdn.jsdelivr.net/npm/simple-datatables@latest/dist/style.css" rel="stylesheet" />
        <link href="../app/resources/css/styles.css" rel="stylesheet" />
        <script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/js/all.min.js" crossorigin="anonymous"></script>
    </head>
    <body class="sb-nav-fixed">
        <nav class="sb-topnav navbar navbar-expand navbar-dark bg-dark">
            <!-- Navbar Brand-->
            <a class="navbar-brand ps-3" href="<%=request.getContextPath()%>/">
           	<img alt="" src="../app/resources/assets/img/ex.png" id="logo">
            | ONclick 
            <span class="fs-6">online non-contact system</span>
            </a>
            <!-- Sidebar Toggle-->
            <button class="btn btn-link btn order-lg-1" id="sidebarToggle" href="#!"><i class="fas fa-bars"></i></button>
            <!-- Navbar Search-->
            <form class="d-none d-md-inline-block form-inline ms-auto me-0 me-md-3 my-2 my-md-0">
                <div class="input-group">
                    <input class="form-control" type="text" placeholder="강의 이동" aria-label="Search for..." aria-describedby="btnNavbarSearch" />
                    <button class="btn btn-primary" id="btnNavbarSearch" type="button"><i class="fas fa-search"></i></button>
                </div>
            </form>
            <!-- heyri1019 alarm -->
          	<!-- Nav Item - Alerts -->
          	<div class="dropdown">
				<a class="nav-link dropdown-toggle" href="#" role="button" id="dropdownMenuLink" data-bs-toggle="dropdown" aria-expanded="false">
				    <i class="fas fa-bell fa-fw"></i>
				    <!-- Counter - Alerts -->
				    <span class="badge badge-danger badge-counter">3+</span>
				</a>
				<!-- Dropdown - Alerts -->
				<ul class="dropdown-menu" aria-labelledby="dropdownMenuLink">
				<h6 class="dropdown-header">Alerts</h6>
				<a class="dropdown-item d-flex align-items-center" href="#">
                    <div class="mr-3">
                        <div class="icon-circle bg-secondary">
                           <img src="../resources/assets/img/upload.svg" alt="Bootstrap" width="32" height="32"> 
                        </div>
                    </div>
                    <div>
                        <div class="small text-gray-500">December 12, 2019</div>
                        <span class="font-weight-bold">A new monthly report is ready to download!</span>
                    </div>
                </a>
				</ul>     
			</div>
            <!-- Navbar-->
		      <ul class="navbar-nav ms-auto ms-md-0 me-3 me-lg-4">
				<li class="nav-item">
					<a class="nav-link" href="<%=request.getContextPath()%>/professor/pwdCheck.do">Mypage</a>
				</li>
				<li class="nav-item">
					<a class="nav-link" href="<%=request.getContextPath()%>/siteMap.do">사이트맵</a>
				</li>
				<li class="nav-item">
					<a class="nav-link" href="#">English</a>
				 </li>
				<li class="nav-item">
					<a class="nav-link" href="<%=request.getContextPath()%>/professor/proLogout.do">LogOut</a>
				</li>
		      </ul> 			     
        </nav>
        <div id="layoutSidenav">
            <div id="layoutSidenav_nav">
                <nav class="sb-sidenav accordion sb-sidenav-dark" id="sidenavAccordion">
                     <div class="sb-sidenav-menu">
						<div class="nav-link collapsed">
						<img alt="" src="../app/resources/assets/img/home.png">
							<%=lv.getLname() %>
						</div>
                        <div class="nav">
                            <div class="sb-sidenav-menu-heading"></div>
                            <a class="nav-link collapsed" href="#" data-bs-toggle="collapse" data-bs-target="#collapseLecInfo" aria-expanded="false" aria-controls="collapseLecInfo">
                                <div class="sb-nav-link-icon"><i class="fas fa-columns"></i></div>
                                	강의정보
                                <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                            </a>
                            <div class="collapse" id="collapseLecInfo" aria-labelledby="headingOne" data-bs-parent="#sidenavAccordion">
                                <nav class="sb-sidenav-menu-nested nav">
                                    <a class="nav-link" href="layout-static.html">강의계획서</a>
                                    <a class="nav-link" href="<%=request.getContextPath()%>/professor/proInfo.do?pidx=<%=lv.getPidx()%>">담당 교수 정보</a>
                                    <a class="nav-link" href="<%=request.getContextPath()%>/stuList.do?lidx=<%=lv.getLidx()%>">멤버 목록</a>
                                </nav>
                            </div>
                          	<a class="nav-link" href="#" >
                                <div class="sb-nav-link-icon"><i class="fas fa-columns"></i></div>
                                	출석 관리
                                <div class="sb-sidenav-collapse-arrow"></div>
                            </a>
                           	<a class="nav-link" href="<%=request.getContextPath()%>/lecContent.do">
                                <div class="sb-nav-link-icon"><i class="fas fa-columns"></i></div>
                                	강좌 목록
                                <div class="sb-sidenav-collapse-arrow"></div>
                            </a>
                           	<a class="nav-link" href="#">
                               <div class="sb-nav-link-icon"><i class="fas fa-columns"></i></div>
                               		과제
                               <div class="sb-sidenav-collapse-arrow"></div>
                            </a>
                           	<a class="nav-link " href="#">
                              <div class="sb-nav-link-icon"><i class="fas fa-columns"></i></div>
                              		자료
                              <div class="sb-sidenav-collapse-arrow"></div>
                            </a>
                             <a class="nav-link collapsed" href="<%=request.getContextPath()%>/noticeList.do?lidx=<%=lv.getLidx()%>">
                              <div class="sb-nav-link-icon"><i class="fas fa-columns"></i></div>
                              		공지사항
                              <div class="sb-sidenav-collapse-arrow"></div>
                            </a>
                        </div>
                    </div>
                    <div class="sb-sidenav-footer">
                        <div class="small">Logged in as:</div>
                        Start Bootstrap
                    </div>
                </nav>
            </div>
            <!-- 강의 내용보기(교수님) -->
            <div id="layoutSidenav_content">
	            <h2 class="mt-4 ms-3">강의명</h2>
                	<ol class="breadcrumb mb-4 ms-4">
                    	<li class="breadcrumb-item active">강의 제목</li>
                	</ol>
            	<main>
					<div class="container-fluid px-4" style="width:90%; height:700px;">
						<div class="row m-0" style="width:100%; height:100%">
						    <div class="col-md-8">
						
						      
						      <!-- 동영상 -->
						      <!-- 211110 동영상 넣기 수정중 jhr-->
						      <!-- 다운로드 방지를 위해 controlsList="nodownload" 추가 -->
								<video  id="myVideo" style="width:100%; height:450px" controlsList="nodownload" controls>
								  <source src="https://cdn.jbnu.khub.kr/data/28358/%EC%98%A8%EB%9D%BC%EC%9D%B82020_10_27%EB%94%94%ED%86%B516(1).mp4" type="video/mp4">

								</video>


								<!-- 재생 상태 -->
								<p>동영상 재생 <span id="videoProgress">0 / 0</span></p>

								
									
						      <div class="text-center mt-2">
						      	<button type="button" class="btn" style="width:100px;">강의 목록</button>
						      	 | 
						      	<button type="button" class="btn" style="width:100px">시청 기록</button>
						      </div>
						    </div>
						    <div class="col">
						      	강의자료
						    </div>
						</div>
                	</div>
                	<div class="container-fluid px-4" style="width:80%; height:100px;">
	                	<div class="row" >
	                		<div class="col-md-1 text-center">
	                			<svg xmlns="http://www.w3.org/2000/svg" width="30" height="30" fill="gray" class="bi bi-person-circle" viewBox="0 0 16 16">
								  <path d="M11 6a3 3 0 1 1-6 0 3 3 0 0 1 6 0z"/>
								  <path fill-rule="evenodd" d="M0 8a8 8 0 1 1 16 0A8 8 0 0 1 0 8zm8-7a7 7 0 0 0-5.468 11.37C3.242 11.226 4.805 10 8 10s4.757 1.225 5.468 2.37A7 7 0 0 0 8 1z"/>
								</svg>
	                		</div>
	                		<div class="col-md-9">
	                			<input class="form-control" id="input" type="text" placeholder="댓글을 입력하세요" />
	                		</div>
	                		<div class="col-md-2">
	                			<button type="button" class="btn btn-secondary btn-sm" style="width:50px">등록</button>
	                		</div>
		                </div>
	                </div>	
                </main>
                <footer class="py-4 bg-light mt-auto">
                    <div class="container-fluid px-4">
                        <div class="d-flex align-items-center justify-content-between small">
                            <div class="text-muted">Copyright &copy; Your Website 2021</div>
                            <div>
                                <a href="#">Privacy Policy</a>
                                &middot;
                                <a href="#">Terms &amp; Conditions</a>
                            </div>
                        </div>
                    </div>
                </footer>
            </div>
        </div>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
        <script src="../app/resources/js/scripts.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.min.js" crossorigin="anonymous"></script>
        <script src="../app/resources/assets/demo/chart-area-demo.js"></script>
        <script src="../app/resources/assets/demo/chart-bar-demo.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/simple-datatables@latest" crossorigin="anonymous"></script>
        <script src="../app/resources/js/datatables-simple-demo.js"></script>
         <!-- jquery 3.3.1 라이브러리 활용 -->
		<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
        <script type="text/javascript">
      //동영상 총 시간 출력 
		var video1 = document.getElementById("myVideo");
		var startTime=<%=vd.getVend()%>;
		var endTime;
		var videoFulltime;

   	 	//video data 로딩이 끝나기 않은 상태에서 duration 호출시 Nan값이 나옴 
    	//로딩이 끝난 후 시점에 duration값을 호출하고 싶다면 vdieo에 eventlistener를 이용
		video1.addEventListener('loadedmetadata', function() {
			//이전 시청종료시점부터 
			video1.currentTime=startTime;
			
			//전체 재생 시간 (초 단위 절삭)
		    videoFulltime = Math.floor(video1.duration);
		    console.log(videoFulltime);
		});
		
		//동영상 재생 시간이 바뀌면 호출되는 이벤트
		video1.addEventListener('timeupdate', function(e){
			//현재 재생 시간 (초 단위 절삭)
			var playtime = Math.floor(video1.currentTime);
		//상태 표시
		$("#videoProgress").html(playtime + " / " + videoFulltime);
		}, false);
		
		//동영상 재생되면 호출되는 이벤트
		video1.addEventListener('play', function(e){
			//현재 재생 시간 (초 단위 절삭)
			startTime = Math.floor(video1.currentTime);
			console.log("startTime :" + startTime);
		}, false);

		
		//동영상 정지되면 호출되는 이벤트
		video1.addEventListener('pause', function(e){
			//현재 재생 시간 (초 단위 절삭)
			endTime = Math.floor(video1.currentTime);
			console.log("endTime :" + endTime);	
		
			$.ajax({
        		url:"<%=request.getContextPath()%>/videoEnd.do?sidx=<%=sidx%>",
        		type:'post',
        		data:{"vend" : endTime, 
        			"vstart": startTime,
        			"vfull":videoFulltime,
        			"cidx":1},
        		success:function(cnt){
        			//alert("성공입니다.");
        		},
        		error:function(){
        			alert("에러입니다.");
        		}
        	});
			
		}, false);
		

		 //재생이 종료되었을때 발생하는 이벤트
		video1.addEventListener('ended', function(e){
			alert("강의 수강이 완료되었습니다.");
		}, false);


        </script>

    </body>
</html>
