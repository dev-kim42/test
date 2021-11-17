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
        <title>ONclick Main</title>
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
          	<button type="button"><img alt="" src="../app/resources/assets/img/alarm.png"></button>
            <!-- Navbar-->
		      <ul class="navbar-nav ms-auto ms-md-0 me-3 me-lg-4">
		        <li class="nav-item">
		          <a class="nav-link" href="#">Mypage</a>
		        </li>
		        <li class="nav-item">
		          <a class="nav-link" href="#">사이트맵</a>
		        </li>
		        <li class="nav-item">
		          <a class="nav-link" href="#">English</a>
		        </li>
		      </ul> 			     
        </nav>
        <div id="layoutSidenav">
            <div id="layoutSidenav_nav">
                <nav class="sb-sidenav accordion sb-sidenav-dark" id="sidenavAccordion">
                     <div class="sb-sidenav-menu">
						<div class="nav-link collapsed">
						<img alt="" src="../app/resources/assets/img/user.png">
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
                                    <a class="nav-link" href="<%=request.getContextPath()%>/mypage.do">정보 수정</a>
                                </nav>
                            </div>
                          	<a class="nav-link collapsed" href="#" data-bs-toggle="collapse" data-bs-target="#collapseLec" aria-expanded="false" aria-controls="collapseLec">
                                <div class="sb-nav-link-icon"><i class="fas fa-columns"></i></div>
                                	강의 목록
                                <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                            </a>
                            <div class="collapse" id="collapseLec" aria-labelledby="headingTh" data-bs-parent="#sidenavAccordion">
                                <nav class="sb-sidenav-menu-nested nav accordion" id="sidenavAccordionPages">
                                    <a class="nav-link" href="layout-static.html">강의1</a>
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
            <!--자료 내용보기 화면(교수)-->
            <div id="layoutSidenav_content">
            	<h2 class="mt-4 ms-3">자료 목록</h2>
	               	<ol class="breadcrumb mb-4 ms-4">
	                   	<li class="breadcrumb-item active">자료 제목</li>
	               	</ol>
            	<main> 
            		<div class="container-fluid px-4 ">
						<table class="table mx-auto bg-light" style="width:80%">
							<thead>    
								<tr>			      
							      	<td colspan="3" scope="row" style="border-bottom:0; width:90%;">제목</td>
							      	<td style="border-bottom:0; width:10%; text-align:right">
							      		<div class="dropdown">
											<button class="btn btn-secondary bg-light" style="border: none; background: none; " type="button" id="dropdownMenuButton1" data-bs-toggle="dropdown" aria-expanded="false">
											    <svg xmlns="http://www.w3.org/2000/svg" width="20" height="20" fill="gray" class="bi bi-three-dots-vertical" viewBox="0 0 16 16">
												  <path d="M9.5 13a1.5 1.5 0 1 1-3 0 1.5 1.5 0 0 1 3 0zm0-5a1.5 1.5 0 1 1-3 0 1.5 1.5 0 0 1 3 0zm0-5a1.5 1.5 0 1 1-3 0 1.5 1.5 0 0 1 3 0z"/>
												</svg>
										  	</button>
												<ul class="dropdown-menu" aria-labelledby="dropdownMenuButton1">
												    <li><a class="dropdown-item" href="#">수정하기</a></li>
												    <li><a class="dropdown-item" href="#">삭제하기</a></li>
											  	</ul>
										</div>
									</td>
							    </tr>
							</thead>    
							<tbody>
							    <tr>
							    	<td scope="row" class="text-secondary" style="border-bottom:0; text-align:left; width:10%">작성일</td>
							    	<td colspan="3" style="border-bottom:0; width:90%"><input class="form-control" type="date" style="border:0; black; width:300px"></td>
							    </tr>
							    <tr>
							    	<td scope="row" class="text-secondary" style="border-bottom:0; text-align:left; width:10%">첨부 파일</td>
							      	<td colspan="3" style="border-bottom:0; width:90%"><input class="form-control" id="inputLNfile" type="file" placeholder="" /></td>
							    </tr>
							    <tr>
							    	<td colspan="4" style="border-bottom:0"><input type="text" style="width:100%; height:300px; border:0; solid; black"></td>
							    </tr>
							</tbody>
						</table>
						<div class="form-row text-center mb-2">
							<button type="button" class="btn btn-secondary btn-sm" style="width:80px">이전</button>
							<button type="button" class="btn btn-secondary btn-sm" style="width:80px">목록</button>
							<button type="button" class="btn btn-secondary btn-sm" style="width:80px">다음</button>
                    	</div>
                	</div>
                </main>
                <footer class="py-4 bg-light mt-auto">
                    <div class="container-fluid px-4">
                        <div class="d-flex align-items-center justify-content-between small">
                            <div class="text-muted">Copyright &copy; Your Website 2021</div>
                            <div >
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
    </body>
</html>
