<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "com.ezen.myapp.domain.*" %>
<% BoardVo bv = (BoardVo) request.getAttribute("bv"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> 게시판 답변</title>
<script type="text/javascript">

function check() {
	//alert("test");
	var fm = document.frm;
	if(fm.subject.value == ""){
		alert("제목을 입력하세요.")
		fm.subject.focus();
		return false;
	}else if(fm.contents.value == ""){
		alert("내용을 입력하세요.")
		fm.contents.focus();
		return false;
	}else if(fm.writer.value == ""){
		alert("작성자를 입력하세요.")
		fm.writer.focus();
		return false;
	}else if(fm.pwd.value == ""){
		alert("비밀번호를 입력하세요.")
		fm.pwd.focus();
		return false;
	}
	
	fm.action="<%=request.getContextPath()%>/board/boardReplyAction.do";		
	fm.method = "post";
	fm.submit();
	
	return;
	
}
</script>
</head>
<body>
<form name="frm">
<input type="hidden" name="bidx" value="<%=bv.getBidx()%>">
<input type="hidden" name="originbidx" value="<%=bv.getOriginbidx()%>">
<input type="hidden" name="depth" value="<%=bv.getDepth()%>">
<input type="hidden" name="nlevel" value="<%=bv.getNlevel()%>">

<table  style="padding-top:30px" align = center width=500 border=0 cellpadding=2 >
	<tr>
		<td height=20 align= center bgcolor=gray><font color=white> 답글</font></td>
	</tr>
	<tr>
	<td bgcolor=white>
	<table class = "table2" border = 1 style = "width:500px">
	<tr>
		<td>댓글제목</td>		
		<td><input type = text name ="subject"></td>
	</tr> 
	<tr>
		<td>댓글내용</td>		
		<td><textarea name = "contents" cols=50 rows=10></textarea></td>
	</tr> 
		<tr>
		<td>작성자</td>		
		<td><input type = text name="writer"> </td>
	</tr>
	<tr>
		<td>비밀번호</td>
		<td><input type="password" name="pwd"></td>
	</tr> 
	</table>
		<center>
			<button name="btn1" onClick="check();return false;">확인</button>
			<button name="btn2" onClick="reset();">리셋</button>
		</center>
	</td>
	</tr>
</table>
</form>
</body>
</html>