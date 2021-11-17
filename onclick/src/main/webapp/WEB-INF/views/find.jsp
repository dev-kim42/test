<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>Login - SB Admin</title>
        
        <link href="<%=request.getContextPath() %>/resources/css/styles.css" rel="stylesheet" />
        <script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/js/all.min.js" crossorigin="anonymous"></script>
    
    
    <style>
    
   
    
    
    </style>
    
    
    </head>
    
    <body class="bg-light">
         <nav class="sb-topnav navbar navbar-expand navbar-dark bg-dark p-3">
            <!-- Navbar Brand-->
            <a class="navbar-brand ps-4" href="index.html">학교로고  | ONclick</a>
         </nav>
        
		
		<div id="layoutJoin" style="height: 100px; max-width : 100 %">
            <div id="layoutAuthentication_content"  style="height: 100px">
                <main>
                    
                        <div class="row justify-content-center" style="height: 100px">
                            <div class="col-lg-max" style="height: 100px">
                                <div class="card border-0 rounded-lg mt-2" >
                                    <div class="card-header bg-light"><h3 class="text-center font-weight-light my-4">비밀번호 찾기</h3></div>
                                    <div class="card-body text-center" >
                                        <form>
                                        	
                                        	<div class="row">
	                                                <div class="row">
	                                                	<div class="dropdown col-md-9 mb-3 p-4">
														  <button class="btn btn-secondary dropdown-toggle" type="button" id="select" data-bs-toggle="dropdown" aria-expanded="false">
														  학생 또는 교수 중 하나를 선택하세요
														  </button>
														  <ul class="dropdown-menu" aria-labelledby="dropdownMenuButton1">
														    <li><a class="dropdown-item" href="#">학생</a></li>
														    <li><a class="dropdown-item" href="#">교수</a></li>
														  </ul>
														</div>
	                                                </div>   
	                                        </div>
                                        
                                            <div class="row">
	                                                <div class="row">
	                                                    <div class="col-md-3 mb-4 p-4">
	                                                    	<label for="StuNum">학번 / 사번</label>
	                                                    </div>
	                                                    <div class="col-md-3">	
	                                                        <input class="form-control" id="inputStuNum" type="text" placeholder="학번 또는 사번을 입력하세요" />  
	                                                    </div>
	                                                   
	                                                </div>   
	                                         </div>
	                                         
	                                         <div class="row">
	                                                <div class="row">
	                                                    <div class="col-md-3 mb-4 p-4">
	                                                    	<label for="StuEmail">이메일</label>
	                                                    </div>
	                                                    <div class="col-md-3">	
	                                                        <input class="form-control" id="inputStuEmail" type="email" placeholder="가입 시 입력한 이메일을 입력하세요" />
	                                                    </div>
	                                                    
	                                                </div>   
	                                         </div>
                                            <p class="py-1"> 입력하신 이메일로 임시 비밀번호가 전송됩니다.</p>
                                           
                                           <div class="d-grid gap-2 d-md-block p-2"><a class="btn btn-secondary btn-block" href="login.html">비밀번호 찾기</a></div>
                                        
                                        </form>
                                    </div>
                                    
                                   
                                </div>
                            </div>
                        </div>
                    
                </main>
            </div>
         
    
            
            
            
            
            
            
         	<div id="layoutAuthentication_footer" class="fixed-bottom bg-dark">
                <footer class="py-4 mt-auto bg-dark">
                    <div class="container-fluid px-4 bg-dark">
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
        
        
        
        
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
        <script src="<%=request.getContextPath() %>/resources/js/scripts.js"></script>
    </body>
</html>

