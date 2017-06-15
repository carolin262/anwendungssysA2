<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@page import="java.util.*,de.tub.as.smm.models.*"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="de">

<head>
<title>AnwSys DemoApp</title>
<link rel="stylesheet" type="text/css" href="./style.css">
</head>

<body>

	<!-- Navigation Menu -->
	<div class="menuBg">
		<div class="menu">
			<div class="logoFont">Group 46</div>
			<ul>
				<li><a class="activ" href="#">Verwaltung</a></li>
				<li><a href="./">Startseite</a></li>
			</ul>
		</div>
	</div>

	<!-- Header -->
	<div class="heading">
		<p style="font-size: 44px">Verwaltung: Übersicht</p>
		<div class="subHeading">
			<div class="subHLeft">Eine einfache Web Applikation zum
				verwalten und überwachen von Smart Merters</div>
			<div class="subHRight">
				<a class="button" href="./">Zurück zur Startseite</a>
			</div>
		</div>
	</div>

	<!-- Content Box -->
	<div class="main">
		<div class="content">
			<h2>Alle registrierten Geräte</h2>
			<hr />
			<table class="overview">
				<tr>
					<th>Gerätetyp</th>
					<th>Gerätekennung</th>
					<th>Optionen</th>
				</tr>
				<%
					@SuppressWarnings("unchecked")
					List<SmartMeter> smartmeters = (List<SmartMeter>) request.getAttribute("smartmeter");
					if (smartmeters != null) {
						for (SmartMeter smartmeter : smartmeters) {
				%>
				<tr class="overview">
					<td><img src="./media/image.png" height="100px" width="100px"></img></td>
					<td><%=smartmeter.geraetekennung%></td>
					<td>
						<form method="GET" action="detail">
							<input type="hidden" name="id" value="<%=smartmeter.id%>">
							<a href="./detail"><input class="inButton" type="submit" value="Zur Detailansicht" /></a>
						</form>
					</td>
				</tr>
				<%
					}
					}
				%>
			</table>
			<br />
			<h2>Geräte hinzufügen</h2>
			<hr />
			<form method="POST" action="verwalten">
				Gerätekennung: 
				<input type="text" name="geraetekennung" /> 
				Maximale Belastung (in Ampere): 
				<input type="number" name="maxbel" /> 
				<input class="inButton" type="submit" value="Hinzufügen" />
			</form>
		</div>
	</div>

	<!-- Footer -->
	<div class="footerBg">
		<div class="footer">
			<div class="copyright">
				© Copyright 2017 by <b class="footerFont">Group 46</b>
			</div>
			<div class="toTop">
				<a class="ttop" href="#">Go to top</a>
			</div>
		</div>
	</div>

</body>

</html>
