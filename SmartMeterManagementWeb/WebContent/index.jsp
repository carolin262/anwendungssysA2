<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

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
				<li><a href="./verwalten">Verwaltung</a></li>
				<li><a class="activ" href="#">Startseite</a></li>
			</ul>
		</div>
	</div>

	<!-- Header -->
	<div class="heading">
		<p style="font-size: 44px">Anwendungssysteme Übung 1 SS 2017</p>
		<div class="subHeading">
			<div class="subHLeft">Eine einfache Web Applikation zum
				verwalten und überwachen von Smart Meters</div>
			<div class="subHRight">
				<a class="button" href="./verwalten">Zur Verwaltung</a>
			</div>
		</div>
	</div>

	<!-- Content Box -->
	<div class="main">
		<div class="content">
			<center>
				<h1>POWERFUL TOOLS TO HELP YOU MANAGE YOUR INTERESTS</h1>
			</center>
			<table class="landing">
				<tr>
					<td><img src="./media/detail.png"></img></td>
					<td class="landing">Ihre Webapplikation soll sowohl über eine
						Gesamtübersicht aller eingetragenen Smart Meter, als auch
						individuelle Detailsichten für jeden Smart Meter verfügen.
						Zwischen den individuellen Ansichten und der Übersichtseite muss
						navigiert werden können. Legen Sie mindestens zwei Detailansichten
						an. <br /> Auf der individuellen Detailansicht eines Smart Meters
						sollen das Produktbild des Geräts und die statischen Eigenschaften
						dargestellt sein. Beim Aufruf einer Detailansicht soll außerdem
						der aktuelle Status des Geräts angezeigt werden, d.h. anliegende
						Spannung und Stromstärke. Diese Werte sollen zufallsgeneriert
						(gleichverteilt) sein und bei jedem Aufruf neu berechnet werden.
						Die Spannung (Genauigkeit: 0.1 Volt) soll zwischen 220 und 240
						Volt liegen, die Stromstärke (Genauigkeit: 0.1 Ampere) zwischen 0
						und (der jeweiligen maximalen Belastung +5 Ampere). Sofern die
						Stromstärke oberhalb der zulässigen Maximalbelastung liegt, soll
						auf der Smart Meter-Detailseite eine Warnung angezeigt werden.
					</td>
				</tr>
				<tr>
					<td><img src="./media/edit.png"></img></td>
					<td class="landing">Beim Ablesen trägt der Nutzer Ihrer
						Webapplikation dabei seine Nutzerkennung und einen Verbrauchswert
						(in kWh) in ein Formular ein. Die Nutzerkennung besteht aus den
						Initialen des Namens des Nutzers und den letzten beiden Ziffern
						seiner Matrikelnummer. Ablesungen sollen nach dem Abschicken durch
						den Nutzer automatisch mit dem Datum des Ablesezeitpunkts versehen
						und auf der Detailansicht des jeweiligen Smart Meters in eine
						Liste oder Tabelle aufgenommen werden. <br /> Sie müssen keine
						Zugriffskontrolle oder ähnliches implementieren. Auch persistente
						Datenhaltung muss nicht implementiert werden, d.h. wenn Sie eine
						Detailansicht im Browser neu laden kann die Liste der Ablesungen
						wieder leer sein.
					</td>
				</tr>
			</table>
			<br />
			<h2>Vorgehensweise</h2>
			<hr />
			<p>
				<b>Schritt 1</b><br /> Stellen Sie konzeptionell dar, welche Seiten
				ihre Webapplikation umfassen wird, welche Funktionen jeweils auf
				diesen zur Verfügung stehen und welche Informationen und
				Interaktionselemente darauf vorhanden sein werden. Erläutern Sie
				zudem an welcher Stelle sie welche Technologie einsetzen werden.
				Überlegen Sie sich außerdem ein einfaches Design für Ihre
				Applikation. <br /> <br /> <b>Schritt 2</b><br /> Beschreiben Sie
				Ihre Seiten als HTML-Dokumente. Wählen Sie geeignete Elemente um
				Seitenbestandteile sinnvoll auszuzeichnen. Begründen Sie kurz, warum
				Sie sich für die gewählten Elemente entschieden haben. <br /> <br />
				<b>Schritt 3</b><br /> Komplettieren Sie das in Schritt 1
				entworfene Design mit Hilfe von CSS. Dokumentieren Sie ihr Vorgehen.
				<br /> <br /> <b>Schritt 4</b><br /> Implementieren Sie
				dynamische Bestandteile und Funktionen mit Hilfe von JavaScript.
				Gerne dürfen Sie jQuery verwenden. Erläutern Sie die so realisierten
				Features und ihren Ansatz für die Umsetzung. <br /> <br /> <b>Schritt
					5</b><br /> Dokumentieren Sie die Ergebnisse Ihrer Arbeit in einer
				Präsentation (Powerpoint o.ä.). Diese Präsentation muss für das
				Gesamtverständnis Ihrer Lösung genügen, daher sollten relevante
				Codeauszüge enthalten sein. In der Präsentation müssen außerdem
				mindestens vier (4) unterschiedliche Nutzerkennungen (vgl.
				Aufgabenstellung) zu sehen sein, die Ihre tatsächlichen
				Namen/Matrikelnummern der Gruppe enthalten. <br /> <br /> <b>Schritt
					6</b><br /> Exportieren Sie die Präsentation als PDF-Dokument. Packen
				Sie ihren kompletten Code und alle zugehörige Artefakte (z.B.
				Bilder) zudem als .zip oder .7z Datei. Reichen Sie die Präsentation
				und die .zip-Datei mit Hilfe des ISIS-Systems ein. Bewertet wird nur
				diese Präsentation! Der Quellcode dient dabei als Referenz und
				Nachweis der Leistung. Es genügt, wenn die Einreichung durch ein
				Gruppenmitglied erfolgt.<br /> Deadline für die Abgabe per Upload:
				<b>28.05.2017, 23:55</b>.
			</p>
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
