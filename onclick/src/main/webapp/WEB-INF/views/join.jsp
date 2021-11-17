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
        <title>ONclick Main</title>
        <link href="<%=request.getContextPath() %>/resources/css/styles.css" rel="stylesheet" />
        <script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/js/all.min.js" crossorigin="anonymous"></script>
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
                               <div class="card-header bg-light"><h3 class="text-center font-weight-light my-4">회원가입</h3></div>
                               <div class="card-body text-center" >
									<ul class="nav nav-tabs" role="tablist">
										<li class="nav-item" role="presentation">
										   <button class="nav-link active" id="home-tab" data-bs-toggle="tab" data-bs-target="#stuJoin" type="button" role="tab" aria-controls="stuJoin" aria-selected="true">학생</button>
										</li>
										<li class="nav-item" role="presentation">
										  <button class="nav-link" id="profile-tab" data-bs-toggle="tab" data-bs-target="#proJoin" type="button" role="tab" aria-controls="proJoin" aria-selected="false">교수</button>
										</li>
									</ul>
								<div class="tab-content">
								  <div class="tab-pane fade show active" id="stuJoin" role="tabpanel" aria-labelledby="stuJoin">
								  <!-- 학생 회원가입 -->
								  <form name="frm">
								  	 <div class="row">
                                        <div class="col-md-3 mb-4 p-2">
                                        	<label>학번</label>
                                        </div>
                                        <div class="col-md-3">	
                                            <!-- 학번 중복 체크 -->
                                            <input class="form-control" id="studentId" name="sidx" type="number" placeholder="학번을 입력하세요"  required oninput="checkId()"/>  
                                            <span class="sidUseOk">사용 가능한 학번입니다.</span>
                                            <span class="sidUseNok">등록되지 않은 학번입니다.</span>
                                        </div> 
                                     </div>
                                     <div class="row">
                                         <div class="col-md-3 mb-4 p-2">
                                         	<label>비밀번호</label>
                                         </div>
                                         <div class="col-md-3">	
                                             <input class="form-control" name="spwd" type="password" placeholder="비밀번호를 입력하세요" />
                                         </div>
                                     </div>
                                     <div class="row">
                                         <div class="col-md-3 mb-4 p-2">
                                         	<label>비밀번호 확인</label>
                                         </div>
                                         <div class="col-md-3">	
                                             <input class="form-control" name="spwd2" type="password" placeholder="비밀번호를 입력하세요" />
                                         </div>
                                     </div>   
                                     <div class="row">
                                         <div class="col-md-3 mb-4 p-2">
                                         	<label>이름</label>
                                         </div>
                                         <div class="col-md-3">	
                                             <input class="form-control" name="sname" type="text" placeholder="이름을 입력하세요" />
                                         </div>	                                                    
                                     </div>
                                     <div class="row">
                                          <div class="col-md-3 mb-4 p-2">
                                          	<label>연락처</label>
                                          </div>
                                          <div class="col-md-3">	
                                              <input class="form-control" name="sphone" type="text" placeholder="전화번호를 입력하세요" />
                                          </div>	                                                    
                                      </div>
									  <div class="row">
                                          <div class="col-md-3 mb-4 p-2">
                                          	<label>이메일</label>
                                          </div>
                                          <div class="col-md-3">	
                                              <input class="form-control" name="semail" type="text" placeholder="이메일을 입력하세요" />
                                          </div>   
                                     </div>
                               		<div class="d-grid gap-2 d-md-block">
                                		<button class="btn btn-secondary btn-block" onclick="check();return false;">
                                		회원가입</button>
                               		</div>
                                   </form> 
								  </div>
								  <div class="tab-pane fade" id="proJoin" role="tabpanel" aria-labelledby="proJoin">
								  <form name="frm2">
								  <!-- 교수 회원가입 -->
								  	<div class="row">
                                        <div class="col-md-3 mb-4 p-2">
                                        	<label>사번</label>
                                        </div>
                                        <div class="col-md-3">	
                                             <!-- 사번 중복 체크 -->
                                            <input class="form-control" id="professorId" name="pidx" type="text" placeholder="사번을 입력하세요"  required oninput="checkId2()"/>  
                                            <span class="pidUseOk">사용 가능한 사번입니다.</span>
                                            <span class="pidUseNok">등록되지 않은 사번입니다.</span>  
                                        </div>
                                     </div>
                                     <div class="row">
                                         <div class="col-md-3 mb-4 p-2">
                                         	<label>비밀번호</label>
                                         </div>
                                         <div class="col-md-3">	
                                             <input class="form-control" name="ppwd" type="password" placeholder="비밀번호를 입력하세요" />
                                         </div>
                                     </div>
                                     <div class="row">
                                         <div class="col-md-3 mb-4 p-2">
                                         	<label>비밀번호 확인</label>
                                         </div>
                                         <div class="col-md-3">	
                                             <input class="form-control"  name="ppwd2" type="password" placeholder="비밀번호를 입력하세요" />
                                         </div>
                                     </div>   
                                     <div class="row">
                                         <div class="col-md-3 mb-4 p-2">
                                         	<label>이름</label>
                                         </div>
                                         <div class="col-md-3">	
                                             <input class="form-control" name="pname" type="text" placeholder="이름을 입력하세요" />
                                         </div>	                                                    
                                     </div>
                                     <div class="row">
                                          <div class="col-md-3 mb-4 p-2">
                                          	<label>연락처</label>
                                          </div>
                                          <div class="col-md-3">	
                                              <input class="form-control" name="pphone" type="text" placeholder="전화번호를 입력하세요" />
                                          </div>	                                                    
                                      </div>
									  <div class="row">
                                          <div class="col-md-3 mb-4 p-2">
                                          	<label>이메일</label>
                                          </div>
                                          <div class="col-md-3">	
                                              <input class="form-control" name="pemail" type="text" placeholder="이메일을 입력하세요" />
                                          </div>   
                                     </div>
                                     <div class="d-grid gap-2 d-md-block">
                                		<button class="btn btn-secondary btn-block" onclick="check2();return false;">
                                		회원가입</button>
                               		</div>
                                   </form> 
								  </div>
								</div>
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
		<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
		<script type="text/javascript">
		var idCheck=0;
		var idCheck2=0;
		function check() {
			var fm= document.frm;
			if(fm.sidx.value == "" || idCheck==0){
				fm.sidx.focus();
				alert("학번을 확인하세요");
				return false;
			}else if(fm.spwd.value == ""){
				fm.spwd.focus();
				alert("비밀번호를 입력하세요");
				return false;
			}else if(fm.spwd2.value == ""){
				fm.spwd2.focus();
				alert("비밀번호 확인를 입력하세요");
				return false;
			}else if(fm.sname.value == ""){
				fm.sname.focus();
				alert("이름을 입력하세요");
				return false;
			}else if(fm.semail.value == ""){
				fm.semail.focus();
				alert("이메일을 입력하세요");
				return false;
			}else if(fm.sphone.value == ""){
				fm.sphone.focus();
				alert("연락처를 입력하세요");
				return false;
			}
				fm.action="<%=request.getContextPath()%>/student/joinAction.do";
				fm.method = "post";
				fm.submit();
				return;
		};
		
		function check2() {
			var fm= document.frm2;
			if(fm.pidx.value == "" || idCheck2==0){
				fm.pidx.focus();
				alert("사번을 확인하세요");
				return false;
			}else if(fm.ppwd.value == ""){
				fm.ppwd.focus();
				alert("비밀번호를 입력하세요");
				return false;
			}else if(fm.ppwd2.value == ""){
				fm.ppwd2.focus();
				alert("비밀번호 확인를 입력하세요");
				return false;
			}else if(fm.pname.value == ""){
				fm.pname.focus();
				alert("이름을 입력하세요");
				return false;
			}else if(fm.pemail.value == ""){
				fm.pemail.focus();
				alert("이메일을 입력하세요");
				return false;
			}else if(fm.pphone.value == ""){
				fm.pphone.focus();
				alert("연락처를 입력하세요");
				return false;
			}
				fm.action="<%=request.getContextPath()%>/professor/joinAction.do";
				fm.method = "post";
				fm.submit();
				return;
		};
		
		function checkId(){
			var sidx = $('#studentId').val(); //id값이 "id"인 입력란의 값을 저장
	        $.ajax({
	            url:'<%=request.getContextPath()%>/student/idCheck.do', //Controller에서 인식할 주소
	            type:'post', //POST 방식으로 전달
	            data:{"sidx":sidx},
	            success:function(cnt){
	            	idCheck=cnt;
	            	if(cnt == 1){ //cnt가 1인 경우 -> 사용 가능한 아이디 
	                    $('.sidUseOk').css("display","inline-block"); 
	                    $('.sidUseNok').css("display", "none");
	                } else { // cnt가 0일 경우 -> 등록되지 않은 아이디
	                    $('.sidUseNok').css("display","inline-block");
	                    $('.sidUseOk').css("display", "none");
	                }
	            },
	            error:function(){
	                alert("에러입니다");
	            }
	        });
	    };
	    
	    function checkId2(){
			var pidx = $('#professorId').val(); //id값이 "id"인 입력란의 값을 저장
	        $.ajax({
	            url:'<%=request.getContextPath()%>/professor/idCheck.do', //Controller에서 인식할 주소
	            type:'post', //POST 방식으로 전달
	            data:{"pidx":pidx},
	            success:function(cnt){
	            	idCheck2=cnt;
	            	alert(idCheck2);
	            	if(cnt == 1){ //cnt가 1인 경우 -> 사용 가능한 아이디 
	                    $('.pidUseOk').css("display","inline-block"); 
	                    $('.pidUseNok').css("display", "none");
	                } else { // cnt가 0일 경우 -> 등록되지 않은 아이디
	                    $('.pidUseNok').css("display","inline-block");
	                    $('.pidUseOk').css("display", "none");
	                }
	            },
	            error:function(){
	                alert("에러입니다");
	            }
	        });
	    };
	  
		</script>

    </body>
</html>

