<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.onclick.app.domain.*" %>
<%ProfessorVO pv = (ProfessorVO)request.getAttribute("pv");%>
<%LecVO lv = (LecVO)session.getAttribute("lv"); %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>교수정보</title>
        <link href="https://cdn.jsdelivr.net/npm/simple-datatables@latest/dist/style.css" rel="stylesheet" />
        <link href="../resources/css/styles.css" rel="stylesheet" />
        <script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/js/all.min.js" crossorigin="anonymous"></script>
    </head>
    <body class="sb-nav-fixed">
       <nav class="sb-topnav navbar navbar-expand navbar-dark bg-dark">
       <!-- Navbar Brand-->
       <a class="navbar-brand ps-3" href="<%=request.getContextPath()%>/">
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
                        <img src="../app/resources/assets/img/upload.svg" alt="Bootstrap" width="32" height="32"> 
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
							<%=lv.getLname() %>
						<img alt="" src="../resources/assets/img/home.png">
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
                           	<a class="nav-link" href="#">
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
            <div id="layoutSidenav_content">
				<div class="card mb-3 mx-auto my-auto" style="width:50%">
				  <div class="row g-0">
				    <div class="col-md-2">
				      <img src="../resources/assets/img/profess.png" class="img-fluid rounded-start">
				    </div>
				    <div class="col-md-7">
				      <div class="card-body">
				         <label for="colFormLabelSm" class="col-sm-2 col-form-label col-form-label-sm">성함</label>
						<div class="col-sm-10">
						<input type="text" class="form-control form-control-sm" value="<%=pv.getPname() %>">
						</div>
						 <label for="colFormLabelSm" class="col-sm-2 col-form-label col-form-label-sm">연락처</label>
						<div class="col-sm-10">
						  <input type="text" class="form-control form-control-sm" value="<%=pv.getPphone() %>">
						</div>
						 <label for="colFormLabelSm" class="col-sm-2 col-form-label col-form-label-sm">이메일</label>
						<div class="col-sm-10">
						  <input type="text" class="form-control form-control-sm" value="<%=pv.getPemail() %>">
						</div>
						 <label for="colFormLabelSm" class="col-sm-2 col-form-label col-form-label-sm">연구실</label>
						<div class="col-sm-10">
						  <input type="text" class="form-control form-control-sm" value="<%=pv.getPlab() %>" >
						</div>
				      </div>
				    </div>
				</div>
			</div>				
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
    </body>
</html>
