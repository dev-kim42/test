<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import ="com.ezen.team.domain.BoardVo" %>    
<% BoardVo bv = (BoardVo)request.getAttribute("bv"); %>    
    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script language = "javascript">
	function check(){
//	alert("test");
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
		document.frm.action ="<%=request.getContextPath()%>/board/boardModifyAction.do";
		document.frm.method = "post";
		document.frm.submit();	

	return;
}
</script>
</head>
<body>
<form name="frm"> 
 <table border="1" style="text-align:left;width:800px;height:300px">
 <input type="hidden" name=bidx value="<%=bv.getBidx() %>">
<tr>
<td>제목</td>
<td><input type="text" name="bsubject" size="30" value="<%=bv.getBsubject() %>"></td>
</tr>
<tr>
<td>내용</td>
<td><textarea name="bcontents" rows="10" cols="100"><%=bv.getBcontents() %></textarea>
</td>
</tr>
<tr>
<td>작성자</td>
<td><input type="text" name="bwriter" size="30" value="<%=bv.getBwriter() %>"></td>
</tr>
<tr>
<td colspan=2>
<input type="button" name ="button1" value="저장" onclick="check();"> 
</td>
</table>
</body>
</html>