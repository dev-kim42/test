<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> 게시판 글쓰기</title>
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
	}else if (fm.pwd.value == ""){
		alert("비밀번호를 입력하세요");
		fm.pwd.focus();
		return false;
	}
	fm.action = "<%=request.getContextPath()%>/board/boardWriteAction.do";		
	fm.method = "post";
	//fm.enctype="multipart/form-data"
	fm.submit();
	
	return;
	
}
</script>
</head>
<body>
<form name="frm">
	<table  style="padding-top:50px" align = center width=700 border=0 cellpadding=2 >
	<tr>
		<td height=20 align= center bgcolor=gray><font color=white> 글쓰기</font></td>
	</tr>
	<tr>
	<td bgcolor=white>
	<table class = "table2">
	<tr>
		<td><font color=gray>제목</font></td>		
		<td><input type = text name ="subject" size=80></td>
	</tr> 
	<tr>
		<td><font color=gray>내용</font></td>		
		<td><textarea name = "contents" cols=85 rows=15></textarea></td>
	</tr> 
	<tr>
		<td><font color=gray>작성자</font></td>		
		<td><input type = text name="writer"> </td>
	</tr>
	<tr>
		<td><font color=gray>비밀번호</font></td>
		<td><input type="password" name="pwd"></td>
	</tr>
	<tr>
		<td><font color=gray>파일</font></td>
		<td><input type="file" name="filename"></td>
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