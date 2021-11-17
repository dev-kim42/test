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
        <title>Login</title>
        <link href="<%=request.getContextPath() %>/resources/css/styles.css" rel="stylesheet" />
        <script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/js/all.min.js" crossorigin="anonymous"></script>    
    </head>
    <body class="bg-light">
         <nav class="sb-topnav navbar navbar-expand navbar-dark bg-dark p-3">
            <!-- Navbar Brand-->
            <a class="navbar-brand ps-4" href="index.html">학교로고  | ONclick</a>
         </nav>   
      <div id="univPhoto" class="bg-secondary" >
      		<h4 class="text-light">학교사진</h4>
      </div>
      <div id="layoutLogin" class="position-absolute top-50 end-0 translate-middle-y bg-light" >
		<main>
               <div id="layoutLogin_contents" style=" border-radius:0px" >
	               <div class="card  border-0 rounded-0 mt-5 ">
	                   <h3 class="text-center font-weight-light my-3">Login</h3>
	                   		<ul class="nav nav-tabs "role="tablist">
								<li class="nav-item" role="presentation">
								   <button class="nav-link active" id="home-tab" data-bs-toggle="tab" data-bs-target="#stuLogin" type="button" role="tab" aria-controls="stuJoin" aria-selected="true">학생</button>
								</li>
								<li class="nav-item" role="presentation">
								  <button class="nav-link" id="profile-tab" data-bs-toggle="tab" data-bs-target="#proLogin" type="button" role="tab" aria-controls="proJoin" aria-selected="false">교수</button>
								</li>
							</ul>
					<div class="tab-content">
						<!-- 학생 로그인 -->
	                   	<div class="card-body tab-pane fade show active" id="stuLogin" role="tabpanel" aria-labelledby="stuLogin">
	                    	<form name="sfrm">
                                <div class="form-floating mb-3">
                                     <input class="form-control" name="stuId" type="text" placeholder="Id"  />
                                     <label>학번</label>
                                </div>
                                 <div class="form-floating mb-3">
                                     <input class="form-control" name="stuPwd" type="password" placeholder="Password" />
                                     <label>비밀번호</label>
                                 </div>
                                 <div class="form-check mb-3">
                                     <input class="form-check-input" name="stuRememId" type="checkbox" value="" />
                                     <label class="form-check-label">학번 저장</label>
                                 </div>
							</form>
                                 <div class="d-flex align-items-center justify-content-end mt-4 mb-0">
                                     <a class="btn btn-primary" onclick="stuCheck(); return false;">로그인</a>
                                 </div>
                   	   	</div>
                   	   	<!-- 교수 로그인 -->
                   	   	<div class="card-body tab-pane fade" id="proLogin" role="tabpanel" aria-labelledby="proLogin">
	                    	<form name="pfrm">
                                <div class="form-floating mb-3">
                                     <input class="form-control" name="pidx" type="text" placeholder="Id"  />
                                     <label>사번</label>
                                </div>
                                 <div class="form-floating mb-3">
                                     <input class="form-control" name="ppwd" type="password" placeholder="Password" />
                                     <label>비밀번호</label>
                                 </div>
                                 <div class="form-check mb-3">
                                     <input class="form-check-input" name="proRememID" type="checkbox" value="" />
                                     <label class="form-check-label">사번 저장</label>
                                 </div>
							</form>
                                 <div class="d-flex align-items-center justify-content-end mt-4 mb-0">
                                     <a class="btn btn-primary" onclick="proCheck(); return false;">로그인</a>
                                 </div>
                   	   	</div>
                    </div>
	                         <div class="card-footer text-center py-3" >
	                             <div class="small"><a href="<%=request.getContextPath()%>/join.do">회원가입</a> | <a href="<%=request.getContextPath()%>/find.do">아이디/비밀번호 찾기</a></div>
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
    	<script type="text/javascript">
    	
	        var msg = '${loginNok}';
	        if(msg != ""){
	        	//로그인 실패시 알림창
	        	alert(msg);
	        }
	        
	        var msg = '${joinOk}';
	        if(msg != ""){
	        	//회원가입 성공시 알림창
	        	alert(msg);
	        }
	        
			//학생 로그인 
        	function stuCheck(){
			
				var sfm = document.sfrm;
				
				if (sfm.stuId.value == ""){
					alert("학번을 입력하세요");
				    sfm.stuId.focus();
				    return false;		
				}else if (sfm.stuPwd.value ==""){
					alert("비밀번호를 입력하세요");
					sfm.stuPwd.focus();
					return false;
				}
				
				sfm.action="<%=request.getContextPath()%>/student/stuLogin.do";
				sfm.method="post";
				sfm.submit();	
				return;
			}
        	
        	//교수 로그인 
        	function proCheck(){
    			
				var pfm = document.pfrm;
				
				if (pfm.pidx.value == ""){
					alert("사번을 입력하세요");
				    pfm.proId.focus();
				    return false;		
				}else if (pfm.ppwd.value ==""){
					alert("비밀번호를 입력하세요");
					pfm.proPwd.focus();
					return false;
				}
				
				pfm.action="<%=request.getContextPath()%>/professor/proLogin.do";
				pfm.method="post";
				pfm.submit();	
				return;
			}
		</script>
    </body>
</html>

