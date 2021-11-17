<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script language = "javascript">
	function check(){
	alert("test");
	if (document.frm.memberId.value =="")	{
		alert("아이디 입력하세요");
		document.frm.memberId.focus();
		return;
	}else if (document.frm.memberPwd.value==""){
		alert("비밀번호 입력하세요");
		document.frm.memberPwd.focus();
		return;
	}
		document.frm.action ="<%=request.getContextPath()%>/member/memberLoginAction.do";
		document.frm.method = "post";
		document.frm.submit();	

	return;
}
</script>
</head>
<body>
<form name="frm"> 
 <table border="1" style="text-align:left;width:800px;height:300px">
<tr>
<td>아이디</td>
<td><input type="text" name="memberId" size="30"></td>
</tr>
<tr>
<td>비밀번호</td>
<td><input type="text" name="memberPwd" size="30"></td>
</tr>
<tr>
<td colspan=2>
<input type="button" name ="button1" value="확인" onclick="check();"> 
</td>
</table>
</form>
</body>
</html>