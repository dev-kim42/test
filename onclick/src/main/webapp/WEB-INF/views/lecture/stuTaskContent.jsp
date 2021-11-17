<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>    
<%@ page import="com.onclick.app.domain.*" %>
<%LecVO lv = (LecVO)session.getAttribute("lv"); %>
<%TaskVO tv = (TaskVO)session.getAttribute("tv"); %>
<%S_taskDTO std = (S_taskDTO)session.getAttribute("std"); %>
<%FileVO fv = (FileVO)session.getAttribute("fv"); %>
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
		          <a class="nav-link" href="<%=request.getContextPath()%>/student/pwdCheck.do">Mypage</a>
		        </li>
		        <li class="nav-item">
		          <a class="nav-link" href="<%=request.getContextPath()%>/siteMap.do">사이트맵</a>
		        </li>
		        <li class="nav-item">
		          <a class="nav-link" href="#">English</a>
		        </li>
		        <li class="nav-item">
		          <a class="nav-link" href="<%=request.getContextPath()%>/student/stuLogout.do">LogOut</a>
		        </li>
		      </ul> 			     
        </nav>
        <div id="layoutSidenav">
            <div id="layoutSidenav_nav">
                <nav class="sb-sidenav accordion sb-sidenav-dark" id="sidenavAccordion">
                     <div class="sb-sidenav-menu">
						<div class="nav-link collapsed">
						<%=lv.getLname() %>
						<img alt="" src="../app/resources/assets/img/home.png">
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
                                    <a class="nav-link" href="<%=request.getContextPath()%>/lecture/proInfo.do">담당 교수 정보</a>
                                    <a class="nav-link" href="<%=request.getContextPath()%>/lecture/stuList.do">멤버 목록</a>
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
                           	<a class="nav-link" href="<%=request.getContextPath()%>/taskList.do?lidx=<%=lv.getLidx()%>">
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
            <!--과제 내용보기-->
            <div id="layoutSidenav_content">
	            <h2 class="mt-4 ms-3">과제 제출 완료</h2>  
	            	<ol class="breadcrumb mb-4 ms-4">
                    	<li class="breadcrumb-item active"><%=tv.getTuname() %></li>
                	</ol>              	
            	<main>
            		<!-- 학생 과제 내용보기 -->
					<% if(session.getAttribute("sidx") != null && session.getAttribute("pidx") == null) {%>
					<div class="container-fluid px-4 ">
						<table class="table mx-auto bg-light" style="width:80%">   
							<thead>
								<tr>   
			      					<td colspan="3" scope="row" style="border:0; font-weight: 700; width:90%"><strong><%=std.getTsubject() %></strong></td>
			      					<td style="border:0; width:10%; text-align:right">
							      		<div class="dropdown">
											<button class="btn btn-secondary bg-light" style="border: none; background: none; " type="button" id="dropdownMenuButton1" data-bs-toggle="dropdown" aria-expanded="false">
											    <svg xmlns="http://www.w3.org/2000/svg" width="20" height="20" fill="gray" class="bi bi-three-dots-vertical mx-auto d-block" viewBox="0 0 16 16">
												  <path d="M9.5 13a1.5 1.5 0 1 1-3 0 1.5 1.5 0 0 1 3 0zm0-5a1.5 1.5 0 1 1-3 0 1.5 1.5 0 0 1 3 0zm0-5a1.5 1.5 0 1 1-3 0 1.5 1.5 0 0 1 3 0z"/>
												</svg>
										  	</button>
												<ul class="dropdown-menu" aria-labelledby="dropdownMenuButton1">
												    <li><a class="dropdown-item" href="<%=request.getContextPath()%>/stuTaskModify.do?tidx=<%=std.getTidx()%>">수정하기</a></li>
												    <li><a class="dropdown-item" onclick="del(${std.tidx})">삭제하기</a></li>
											  	</ul>
										</div>
									</td>
			      				</tr>
							</thead>
							<tbody>
							    <tr>
							    	<td scope="row" class="text-secondary" style="border-bottom:0; text-align:left; font-weight: 700; width:10%">제출기간</td>
							      	<td colspan="3" style="width:45%">
							      		<%=tv.getTustart().substring(0, 10) %> - <%=tv.getTufin().substring(0, 10) %>
									</td>
							    </tr>
							    <tr>
							    	<td scope="row" class="text-secondary" style="border-bottom:0; text-align:left; font-weight: 700; width:10%">작성일</td>
							      	<td style="width:90%">
							      		<%=std.getTdate().substring(0, 10) %>
							      	</td>
							    </tr>
							    <tr>
							    	<td scope="row" class="text-secondary" style="border-bottom:0; text-align:left; font-weight: 700; width:10%">첨부 파일</td>
							      	<% if(std.getFidx()==0) {%>
						    			<td colspan="3" style="border-bottom:0; width:90%">-</td>
							    	<%} else {%>
							    		<td colspan="3" style="border-bottom:0; width:90%"><a href="<%=request.getContextPath()%>/stuTaskFileDownload.do?fidx=<%=fv.getFidx()%>"><%=fv.getForiginname() %></a></td>
							    	<%} %>
							    </tr>
							    <tr>
							    	<td colspan="4" style="border-bottom:0"><input type="text" style="width:100%; height:300px; border:0; solid;" value="<%=std.getTcontents() %>" readonly></td>
							    </tr>
							</tbody>
						</table>
						<div class="form-row text-center mb-2">
							<button type="button" class="btn btn-secondary btn-sm" style="width:80px"><a style="color:white; text-decoration:none;" href="<%=request.getContextPath()%>/taskList.do?lidx=<%=tv.getLidx()%>">목록</a></button>
                    	</div>
                	</div>
                	<!-- 교수 과제 내용보기 -->
					<%} else {%>
					<div class="container-fluid px-4 ">
						<table class="table mx-auto bg-light" style="width:80%">   
							<thead>
								<tr>   
			      					<td colspan="4" scope="row" style="border:0; font-weight: 700;"><strong><%=std.getTsubject() %></strong></td>
			      				</tr>
							</thead>
							<tbody>
							    <tr>
							    	<td scope="row" class="text-secondary" style="border-bottom:0; text-align:left; font-weight: 700; width:10%">제출기간</td>
							      	<td colspan="3" style="width:45%">
							      		<%=tv.getTustart().substring(0, 10) %> - <%=tv.getTufin().substring(0, 10) %>
									</td>
							    </tr>
							    <tr>
							    	<td scope="row" class="text-secondary" style="border-bottom:0; text-align:left; font-weight: 700; width:10%">작성일</td>
							      	<td style="width:90%">
							      		<%=std.getTdate().substring(0, 10) %>
							      	</td>
							    </tr>
							    <tr>
							    	<td scope="row" class="text-secondary" style="border-bottom:0; text-align:left; font-weight: 700; width:10%">첨부 파일</td>
							      	<% if(std.getFidx()==0) {%>
						    			<td colspan="3" style="border-bottom:0; width:90%">-</td>
							    	<%} else {%>
							    		<td colspan="3" style="border-bottom:0; width:90%"><a href="<%=request.getContextPath()%>/stuTaskFileDownload.do?fidx=<%=fv.getFidx()%>"><%=fv.getForiginname() %></a></td>
							    	<%} %>
							    </tr>
							    <tr>
							    	<td colspan="4" style="border-bottom:0"><input type="text" style="width:100%; height:300px; border:0; solid;" value="<%=std.getTcontents() %>" readonly></td>
							    </tr>
							</tbody>
						</table>
						<div class="form-row text-center mb-2">
							<button type="button" class="btn btn-secondary btn-sm" style="width:80px"><a style="color:white; text-decoration:none;" href="<%=request.getContextPath()%>/taskSubmitList.do?tuidx=<%=tv.getTuidx()%>">목록</a></button>
                    	</div>
                	</div>
					<%} %>
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
        <script type="text/javascript">
        	
			function del(tidx) {
				var value = confirm("삭제하시겠습니까?");
				if (value == true) {
					location = '${pageContext.request.contextPath}/stuTaskDeleteAction.do?tidx='+tidx;
				}
			}	
			
		</script>
    </body>
</html>