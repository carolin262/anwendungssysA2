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
            <p style="font-size:44px">Verwaltung: Ãœbersicht</p>
            <div class="subHeading">
                <div class="subHLeft">
                    Eine einfache Web Applikation zum verwalten und Ã¼berwachen von Smart Merters
                </div>
                <div class="subHRight">
                    <a class="button" href="./index.html">ZurÃ¼ck zur Startseite</a>
                </div>
            </div>
        </div>

    </div>

    <div class="main">
        <div class="content">
            <h2>Ãœbersicht</h2>
            <hr />
            <table class="overview">
                <tr>
                    <th>GerÃ¤tetyp</th>
                    <th>GerÃ¤tekennung</th>
                    <th>Optionen</th>
                </tr>
                <tr class="overview">
                    <td><img src="./media/image.png" height="100px" width="100px"></img></td>
                    <td>AB12345678</td>
                    <td><a class="detailButton" href="./detail1.html">Zur Detailansicht</a></td>
                </tr>
                <tr class="overview">
                    <td><img src="./media/image.png" height="100px" width="100px"></img></td>
                    <td>AB32942628</td>
                    <td><a class="detailButton" href="./detail2.html">Zur Detailansicht</a></td>
                </tr>
                <tr class="overview">
                    <td><img src="./media/image.png" height="100px" width="100px"></img></td>
                    <td>AB78988293</td>
                    <td><a class="detailButton" href="./detail3.html">Zur Detailansicht</a></td>
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