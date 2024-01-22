<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%
int dan = 2;
int limit = 9;
String color = "black";

try {
	dan = Integer.parseInt(request.getParameter("dan").trim());
} catch (Exception e) {

}
try {
	limit = Integer.parseInt(request.getParameter("limit").trim());
} catch (Exception e) {

}

if (request.getParameter("color") != null && request.getParameter("color").trim().length() > 0) {
	color = request.getParameter("color");
}

String url = request.getRequestURL().toString();
%>
<style>
.body, ul, li {
	margin: 0;
	padding: 0;
	list-style: none;
}

a {
	color: inherit;
	text-decoration: none;
}

.topbar {
	display: flex;
	width: 1024px;
	margin: 0 auto;
	justify-content: space-between;
	background-color: gray;
}

.topbar>div {
	width: 20%;
}

.topbar>div>a {
	display: flex;
	width: 100%;
	padding: 20px 0px;
	justify-content: center;
}

.topbar>nav {
	width: 60%;
}

.topbar>nav>ul {
	display: flex;
	width: 100%;
	justify-content: space-around;
}

.topbar>nav>ul>li {
	width: 15%;
	position: relative;
	
}

.topbar>nav>ul a {
	display: flex;
	width: 100%;
	background-: gray;
	padding: 20px 0px;
	justify-content: center;
}

.topbar>nav ul>li:hover>a {
	background-color: black;
	color: white;
}

.topbar>nav>ul ul {
	display: none;
}
.topbar>nav>ul ul>li{
	background-color: gray;
}



.topbar>nav ul>li:hover>ul {
	display: block;
	position: absolute;
	width: 100%;
}

main {
	width: 1000px;
	margin: auto;
	display: flex;
	justify-content: center;
}

main h3 {
	text-shadow: 1px 1px 3px gray;
	color: <%=color%>;
}

main li {
	text-align: center;
	text-shadow: 1px 1px 3px gray;
	color: <%=color%>;
}
</style>

</head>
<body>
	<div class="topbar">
		<div>
			<a href="./printDan">구구단</a>
		</div>
		<nav class="menu">
			<ul>
				<li><a href="./printDan?dan=2&color=<%=color%>">2단</a>
					<ul>
						<%
						for (int i = 1; i <= 9; i++) {
						%>
						<li><a href="./printDan?dan=2&limit=<%=i%>&color=<%=color%>">2*<%=i%>까지
						</a></li>
						<%
						}
						%>
					</ul></li>
				<li><a href="./printDan?dan=3&color=<%=color%>">3단</a>
					<ul>
						<%
						for (int i = 1; i <= 9; i++) {
						%>
						<li><a href="./printDan?dan=3&limit=<%=i%>&color=<%=color%>">3*<%=i%>까지
						</a></li>
						<%
						}
						%>
					</ul></li>
				<li><a href="./printDan?dan=4">4단</a>
					<ul>
						<%
						for (int i = 1; i <= 9; i++) {
						%>
						<li><a href="./printDan?dan=4&limit=<%=i%>&color=<%=color%>">4*<%=i%>까지
						</a></li>
						<%
						}
						%>
					</ul></li>
				<li><a href="./printDan?dan=5">5단</a>
					<ul>
						<%
						for (int i = 1; i <= 9; i++) {
						%>
						<li><a href="./printDan?dan=5&limit=<%=i%>&color=<%=color%>">5*<%=i%>까지
						</a></li>
						<%
						}
						%>
					</ul></li>
				<li><a href="./printDan?dan=6">6단</a>
					<ul>
						<%
						for (int i = 1; i <= 9; i++) {
						%>
						<li><a href="./printDan?dan=6&limit=<%=i%>&color=<%=color%>">6*<%=i%>까지
						</a></li>
						<%
						}
						%>
					</ul></li>
				<li><a href="./printDan?dan=7">7단</a>
					<ul>
						<%
						for (int i = 1; i <= 9; i++) {
						%>
						<li><a href="./printDan?dan=7&limit=<%=i%>&color=<%=color%>">7*<%=i%>까지
						</a></li>
						<%
						}
						%>
					</ul></li>
				<li><a href="./printDan?dan=8">8단</a>
					<ul>
						<%
						for (int i = 1; i <= 9; i++) {
						%>
						<li><a href="./printDan?dan=8&limit=<%=i%>&color=<%=color%>">8*<%=i%>까지
						</a></li>
						<%
						}
						%>
					</ul></li>
				<li><a href="./printDan?dan=9">9단</a>
					<ul>
						<%
						for (int i = 1; i <= 9; i++) {
						%>
						<li><a href="./printDan?dan=9&limit=<%=i%>&color=<%=color%>">9*<%=i%>까지
						</a></li>
						<%
						}
						%>
					</ul></li>
			</ul>
		</nav>
	</div>
	<main>
		<ul>
			<h3>
				==<%=dan%>단==
			</h3>
			<%
			for (int i = 1; i <= limit; i++) {
			%>
			<li><%=dan%> * <%=i%> = <%=dan * i%></li>
			<%
			}
			%>
		</ul>
	</main>
</body>
</html>