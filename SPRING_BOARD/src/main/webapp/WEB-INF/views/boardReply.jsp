<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%	int bidx = (Integer)request.getAttribute("bidx");
	int orginbidx = (Integer)request.getAttribute("orginbidx");
	int updown = (Integer)request.getAttribute("updown");
	int leftright  = (Integer)request.getAttribute("leftright");
%>  
    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script language = "javascript">
	function check(){
	alert("test");
	if (document.frm.bsubject.value =="")	{
		alert("제목 입력");
		document.frm.bsubject.focus();
		return;
	}else if (document.frm.bcontents.value==""){
		alert("내용 입력");
		document.frm.bcontents.focus();
		return;
	}else if (document.frm.bwriter.value==""){
		alert("작성자 입력");
		document.frm.bwriter.focus();
		return;
	}
		document.frm.action ="<%=request.getContextPath()%>/board/boardReplyAction.do";
		document.frm.method = "post";
		document.frm.submit();	

	return;
}
</script>
</head>
<body>
<form name="frm"> 
<input type="hidden" name="bidx" value="<%=bidx%>">
<input type="hidden" name="orginbidx" value="<%=orginbidx%>">
<input type="hidden" name="updown" value="<%=updown%>">
<input type="hidden" name="leftright" value="<%=leftright%>">
 <table border="1" style="text-align:left;width:800px;height:300px">
<tr>
<td>제목</td>
<td><input type="text" name="bsubject" size="30"></td>
</tr>
<tr>
<td>내용</td>
<td><textarea name="bcontents" rows="10" cols="100"></textarea>
</td>
</tr>
<tr>
<td>작성자</td>
<td><input type="text" name="bwriter" size="30"></td>
</tr>
<tr>
<td>비밀번호</td>
<td><input type="text" name="bpassword" size="30"></td>
</tr>
<tr>
<td colspan=2>
<input type="button" name ="button1" value="저장" onclick="check();"> 
</td>
</table>
</body>
</html>