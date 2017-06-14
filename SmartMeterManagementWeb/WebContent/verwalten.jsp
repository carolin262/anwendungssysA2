<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.*,de.tub.as.smm.models.*"%>	
<!DOCTYPE html>
<html lang="de">

<head>
    <meta charset="UTF-8">
    <title>AnwSys DemoApp</title>
    <link rel="stylesheet" type="text/css" href="./style.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script type="text/javascript" src="./script.js" async></script>
</head>

<body>

    <div class="headerBg">
        <div class="menuBg">
            <div class="menu">
                <div class="logoFont">
                    Group 46
                </div>
                <ul>
                    <li><a class="activ" href="#">Verwaltung</a></li>
                    <li><a href="./index.html">Startseite</a></li>
                </ul>
            </div>
        </div>
        <div class="heading">
            <p style="font-size:44px">Verwaltung: Übersicht</p>
            <div class="subHeading">
                <div class="subHLeft">
                    Eine einfache Web Applikation zum verwalten und Überwachen von Smart Meters
                </div>
                <div class="subHRight">
                    <a class="button" href="./index.html">Zurück zur Startseite</a>
                </div>
            </div>
        </div>

    </div>

    <div class="main">
        <div class="content">
            <h2>Übersicht</h2>
            <hr />
            <form method="POST" action="SmartMeterServlet">
			Name: <input type="text" name="geraetekennung" /> 
			maxbel: <input type="text" name="maxbel" /> <input type="submit"
			value="Add" />
			</form>
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
                    <td><%=smartmeter.geraetekennung %></td>
                    <td><a class="detailButton" href="./detail1.jsp">Zur Detailansicht</a></td>
                </tr>
		<%
			}
			}
		%>
            </table>

        </div>
    </div>

    <div class="footerBg">
        <div class="footer">
            <div class="copyright">
                Â© Copyright 2017 by <b class="footerFont">Group 46</b>
            </div>
            <div class="toTop">
                <a class="ttop" href="#">Go to top</a>
            </div>
        </div>
    </div>

</body>

</html>