<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.*,de.tub.as.smm.models.*"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="de">

<head>
<title>AnwSys DemoApp</title>
<link rel="stylesheet" type="text/css" href="./style.css">
<script src="./js.cookie.js"></script>
<script type="text/javascript" >
	function cook(){
		var loginname = Cookies.get("loginname");
	}
</script>
</head>

<body onload="cook()">

	<!-- Navigation Menu -->
	<div class="menuBg">
		<div class="menu">
			<div class="logoFont">Group 46</div>
			<ul>
				<li><a class="activ" href="./verwalten">Verwaltung</a></li>
				<li><a href="./">Startseite</a></li>
			</ul>
		</div>
	</div>

	<!-- Header -->
	<div class="heading">
		<p style="font-size: 44px">Verwaltung: Smart Meter</p>
		<div class="subHeading">
			<div class="subHLeft">Eine einfache Web Applikation zum
				verwalten und überwachen von Smart Merters</div>
			<div class="subHRight">
				<a class="button" href="./verwalten">Zurück zur Übersicht</a>
			</div>
		</div>
	</div>
	<%
		SmartMeter smartmeter = (SmartMeter) request.getAttribute("smartmeter");
	%>
	<!-- Content Box -->
	<div class="main">
		<div class="content">
			<table class="detail">
				<tr class="detail">
					<td><img src="./media/image.png" height="340" width="340"></td>
					<td>
						<table class="status">
							<h2>Gerätekennung: <%=smartmeter.geraetekennung%></h2>
							<tr>
								<td>Maximale Belastung:</td>
								<td><%=smartmeter.maxBelastung%> Ampere</td>
							</tr>
							<tr>
								<td>Spannung:</td>
								<td><%=smartmeter.spannung%> Volt</td>
							</tr>
							<tr>
								<td>Stromstärke:</td>
								<td><%=smartmeter.strom%> Ampere</td>
							</tr>
						</table>
						<%=smartmeter.currentStatus()%>
					</td>
				</tr>
			</table>
			<br />
			<h2>Ablesen</h2>
			<hr />
			<form>
				Verbrauchswert (in kWh):
				<input type="number" name="verbrauchswert">
				<input type="hidden" name="id" value="<%=smartmeter.id%>">
				<input class="inButton" type="submit" value="Ablesen">
			</form>
			<br />
			<h2>Alle Ablesungen</h2>
			<hr />
			<table class="event" id="tableAblesen">
				<tr>
					<th class="event" id="loginname">Benutzername</th>
					<th class="event" id="verbrauchswert">Verbrauchswert (in kWh)</th>
					<th class="event" id="datum">Datum</th>
				</tr>
			</table>
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
