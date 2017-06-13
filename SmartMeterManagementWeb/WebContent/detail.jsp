<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
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

    <div class="menuBg">
        <div class="menu">
            <div class="logoFont">
                Group 46
            </div>
            <ul>
                <li><a class="activ" href="./verwalten.html">Verwaltung</a></li>
                <li><a href="./index.html">Startseite</a></li>
            </ul>
        </div>
    </div>

    <div class="heading">
        <p style="font-size:44px">Verwaltung: Smart Meter</p>
        <div class="subHeading">
            <div class="subHLeft">
                Eine einfache Web Applikation zum verwalten und Ã¼berwachen von Smart Merters
            </div>
            <div class="subHRight">
                <a class="button" href="./verwalten.html">ZurÃ¼ck zur Ãbersicht</a>
            </div>
        </div>
    </div>

    <div class="main">
        <div class="content">
            <table class="detail">
                <tr class="detail">
                    <td><img src="./media/image.png" height="340" width="340"></td>
                    <td>
                        <h2>GerÃ¤tekennung: AB12345678 </h2>
                        <table class="status">
                            <tr>
                                <td>Maximale Belastung:</td>
                                <td><p id="maxstrom">80.0</p></td>
                            </tr>
                            <tr>
                                <td>Spannung:</td>
                                <td><p id="spannung"></p></td>
                            </tr>
                            <tr>
                                <td>StromstÃ¤rke:</td>
                                <td><p id="strom"></p></td>
                            </tr>
                            <tr>
                                <td>
                                    <div id="warnung">
                                        <h3>WARNUNG!</h3>
                                        <p>Die StromstÃ¤rke liegt oberhalb der zulÃ¤ssigen Maximalbelastung</p>
                                    </div>
                                </td>
                            </tr>
                        </table>
                    </td>
                </tr>
            </table>
            <br />
            <br />
            <h2>Ablesen</h2>
            <hr />
            <form>
                Nutzererkennung:
                <br />
                <input type="text" name="nutzerkennung" maxlength="4"><br>
                Verbrauchswert (in kWh):
                <br />
                <input type="number" name="verbrauchswert">
                <br />
                <br />
                <button class="inButton" type="button" id="btnAblesen">Ablesen</button>
            </form>
            <br />
            <br />
            <h2>Alle Ablesungen</h2>
            <hr />
            <table class="event" id="tableAblesen">
                <tr>
                    <th class="event">Nutzerkennung</th>
                    <th class="event">Verbrauchswert (in kWh)</th>
                    <th class="event">Datum</th>
                </tr>
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
