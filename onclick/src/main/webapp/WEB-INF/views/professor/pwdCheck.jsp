<!-- 211027 jhr 작업 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>정보 수정-비밀번호 확인</title>
        <link href="https://cdn.jsdelivr.net/npm/simple-datatables@latest/dist/style.css" rel="stylesheet" />
        <link href="../resources/css/styles.css" rel="stylesheet" />
        <script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/js/all.min.js" crossorigin="anonymous"></script>
    </head>
    <body class="sb-nav-fixed">
        <nav class="sb-topnav navbar navbar-expand navbar-dark bg-dark">
            <!-- Navbar Brand-->
            <a class="navbar-brand ps-3" href="<%=request.getContextPath()%>">
           	<img alt="" src="../resources/assets/img/ex.png" id="logo">
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
          <button type="button"><img alt="" src="../resources/assets/img/alarm.png"></button>
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
						<img alt="" src="../resources/assets/img/user.png">
							홍길동님
						</div>
                        <div class="nav">
                            <div class="sb-sidenav-menu-heading">Interface</div>
                            <a class="nav-link collapsed" href="#" data-bs-toggle="collapse" data-bs-target="#collapseLayouts" aria-expanded="false" aria-controls="collapseLayouts">
                                <div class="sb-nav-link-icon"><i class="fas fa-columns"></i></div>
                                MyPage
                                <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                            </a>
                            <div class="collapse" id="collapseLayouts" aria-labelledby="headingOne" data-bs-parent="#sidenavAccordion">
                                <nav class="sb-sidenav-menu-nested nav">
                                     <a class="nav-link" href="<%=request.getContextPath()%>/professor/pwdCheck.do">정보 수정</a>
                                </nav>
                            </div>
                          	<a class="nav-link collapsed" href="#" data-bs-toggle="collapse" data-bs-target="#collapseLec" aria-expanded="false" aria-controls="collapseLec">
                                <div class="sb-nav-link-icon"><i class="fas fa-columns"></i></div>
                                	강의 목록
                                <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                            </a>
                           <div class="collapse" id="collapseLec" aria-labelledby="headingTh" data-bs-parent="#sidenavAccordion">
                                <nav class="sb-sidenav-menu-nested nav accordion" id="sidenavAccordionPages">
                                    <a class="nav-link" href="<%=request.getContextPath()%>/lecture/home.do">강의1</a>
                                    <a class="nav-link" href="layout-static.html">강의1</a>
                                    <a class="nav-link" href="layout-static.html">강의1</a>
                                </nav>
                            </div>
                             <a class="nav-link collapsed" href="#" data-bs-toggle="collapse" data-bs-target="#collapsePages" aria-expanded="false" aria-controls="collapsePages">
                                <div class="sb-nav-link-icon"><i class="fas fa-book-open"></i></div>
                                Zoom 다운로드
                                <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                            </a>
                            <div class="collapse" id="collapsePages" aria-labelledby="headingTh" data-bs-parent="#sidenavAccordion">
                                <nav class="sb-sidenav-menu-nested nav accordion" id="sidenavAccordionPages">
                                    <a class="nav-link collapsed" href="#" data-bs-toggle="collapse" data-bs-target="#pagesCollapseAuth" aria-expanded="false" aria-controls="pagesCollapseAuth">
 									다운로드 링크
                                    </a>
                                </nav>
                            </div>
                        </div>
                    </div>
                    <div class="sb-sidenav-footer">
                        <div class="small">Logged in as:</div>
                        Start Bootstrap
                    </div>
                </nav>
            </div>
            <div id="layoutSidenav_content">
                <main>
                    <div class="container-fluid px-4">
                        <h1 class="mt-4">Mypage</h1>
                        <ol class="breadcrumb mb-4">
                            <li class="breadcrumb-item active">정보 수정</li>
                        </ol>
                        <form name="pwdCheck">
                        	<div class="row justify-content-center py-5">
							    <div class="col-2">
									<label>비밀번호 확인 </label>
							    </div>
								<div class="col-4">
									<input class="form-control" type="password" id="pwd" placeholder="비밀번호를 입력하세요" />
									<span class="pwdNok">비밀번호가 올바르지 않습니다.</span>
								</div>
								<div class="col-4">
									<button type="button" class="btn btn-secondary" id="check">확인</button>
								</div>
							</div>
                        </form>                     
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
        <script src="../resources/js/scripts.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.min.js" crossorigin="anonymous"></script>
        <script src="../resources/assets/demo/chart-area-demo.js"></script>
        <script src="../resources/assets/demo/chart-bar-demo.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/simple-datatables@latest" crossorigin="anonymous"></script>
        <script src="../resources/js/datatables-simple-demo.js"></script>
        <!-- jquery 3.3.1 라이브러리 활용 -->
		<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
        <script type="text/javascript">    
        $(function(){
	        $("#check").click(function(){ // 확인버튼을 클릭하면 
	        	var pwd = $('#pwd').val();
	        	$.ajax({
	        		url:"<%=request.getContextPath()%>/professor/pwdCheckAction.do",
	        		type:'post',
	        		data:{"pwd" : pwd},
	        		success:function(cnt){
	        			if(cnt==1){
	        				//비밀번호가 올바르며 수정페이지로 전환 
	        				location.href="<%=request.getContextPath()%>/professor/proModify.do";
	        			}else{
							 $('.pwdNok').css("display","inline-block");	        				
	        			}
	        		},
	        		error:function(){
	        			alert("에러입니다.");
	        		}
	        	});
	        });
        });
        </script>
    </body>
</html>
