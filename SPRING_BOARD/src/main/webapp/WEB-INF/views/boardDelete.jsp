<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% int bidx = (Integer)request.getAttribute("bidx");%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script language = "javascript">
	function check(){
	alert("test");
	if (document.frm.bpassword.value =="")	{
		alert("비밀번호를 입력하세요");
		document.frm.bpassword.focus();
		return;
	}
		document.frm.action ="<%=request.getContextPath()%>/board/boardDeleteAction.do";
		document.frm.method = "post";
		document.frm.submit();	

	return;
}
</script>
</head>
<body>
<form name="frm"> 
<input type="hidden" name="bidx" value="<%=bidx%>">
 <table border="1" style="text-align:left;width:800px;height:300px">
<tr>
<td>비밀번호</td>
<td><input type="password" name="bpassword" size="30"></td>
</tr>
<tr>
<td colspan=2>
<input type="button" name ="button1" value="저장" onclick="check();"> 
</td>
</table>
</body>
</html>