<%@page import="java.util.Locale"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath %>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>	
	<%
		request.setAttribute("date",new Date());
		request.setAttribute("salay", 123456.55);
		String locale = request.getParameter("locale");
		if(locale != null){
			if("zh".equals(locale)){
				session.setAttribute("locale", Locale.CHINA);
			}else if("en".equals(locale)){
				session.setAttribute("locale",Locale.US);
			}
		};
	%>
	<c:if test="${sessionScope.locale != null}">
		<fmt:setLocale value="${sessionScope.locale}"/>
	</c:if>
	<fmt:setBundle basename="i18n"/>
	<fmt:message key="date"></fmt:message>:<fmt:formatDate value="${requestScope.date}" dateStyle="FULL"/>,
	<fmt:message key="salay"></fmt:message>:<fmt:formatNumber type="currency" value="${requestScope.salay }"></fmt:formatNumber>
	<br>
	<a href="index.jsp?locale=zh">中文</a>
	<a href="index.jsp?locale=en">English</a>
</body>
</html>