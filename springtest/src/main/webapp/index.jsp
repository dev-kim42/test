<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인 화면</title>
</head>
<body>
<a href ="<%=request.getContextPath()%>/board/boardWrite.do">게시판 글쓰기</a>
<a href ="<%=request.getContextPath()%>/board/boardList.do">게시판 리스트 가기</a>
<a href ="<%=request.getContextPath()%>/member/memberLogin.do">로그인하기</a>
</body>
</html>