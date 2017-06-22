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
				verwalten und überwachen von Smart Meters</div>
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
							<h2>Gerätekennung: <%=smartmeter.getGeraetekennung()%></h2>
							<tr>
								<td>Maximale Belastung:</td>
								<td><%=smartmeter.getMaxBelastung()%> Ampere</td>
							</tr>
							<tr>
								<td>Spannung:</td>
								<td><%=smartmeter.getSpannung()%> Volt</td>
							</tr>
							<tr>
								<td>Stromstärke:</td>
								<td><%=smartmeter.getStrom()%> Ampere</td>
							</tr>
						</table>
						<%=smartmeter.currentStatus()%>
					</td>
				</tr>
			</table>
			<%
				if (request.getAttribute("user") != null) {
					User user = (User) request.getAttribute("user");
			%>
			<%=user.ablesenForm()%>
			<%
				}
			%>
			<br />
			<h2>Alle Ablesungen</h2>
			<hr />
			<table class="event">
				<tr>
					<th class="event">Nutzerkennung</th>
					<th class="event">Verbrauchswert (in kWh)</th>
					<th class="event">Uhrzeit, Datum</th>
				</tr>
				<%
					List<Record> allRecords = smartmeter.getSmartmeterRecords();
					if (allRecords != null) {
						for (Record record : allRecords) {
				%>
				<tr>
					<td><%=record.getUser()%></td>
					<td><%=record.getRecord()%></td>
					<td><%=record.getFormattedDate()%></td>
				</tr>
				<%
					}
					}
				%>
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