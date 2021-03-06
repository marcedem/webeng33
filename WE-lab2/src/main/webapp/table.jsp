<%@page contentType="text/html" pageEncoding="UTF-8"%>

<jsp:useBean id="gameInfo" class="service.GameService" scope="session" />

<?xml version="1.0" ?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1//EN"
    "http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd">
<%----

<jsp:useBean id="gameInfo" class="service.GameService" scope="session"/> 
<jsp:setProperty name="gameInfo" property="*"/>
<jsp:useBean id="wuerfel" class="beans.Dice" scope="session"/>
<jsp:setProperty name="wuerfel" property="*"/>
<jsp:useBean id="fieldMap" class="beans.Field" scope="session"/>
<jsp:setProperty name="fieldMap" property="*"/>

--%>

<html xmlns="http://www.w3.org/1999/xhtml"  xml:lang="de" lang="de">
    <head>

        <title xml:lang="de">Formel 0 - Spielen</title>
        <meta http-equiv="content-type" content="text/html; charset=ISO-8859-1" />
        <link rel="stylesheet" type="text/css" href="styles/screen.css" />
        <script src="js/jquery.js" type="text/javascript"></script>
                             
    </head>
    <body>
        <div id="container">
            <div id="bordercontainer">
                <div id="header">
                    <div id="header_left"><h1 class="accessibility">Formel 0</h1></div>
                    <div id="header_right"></div>
                </div>
                <div id="navigation">
                    <h2 class="accessibility">Navigation</h2>
                    <ul title="Navigation">
                        <li><a id="startNewGame" href="#" tabindex="1">Neues Spiel</a></li>
                        <li><a href="#" tabindex="2">Ausloggen</a></li>
                    </ul>
                </div>
                <div id="main-area">
                    <div class="info">

                        <form action="servlet.GameServlet" method="get">
                            
                                <% if (gameInfo.isGameOver()) { %>
                                <input type="submit" name="reset" value="Restart Game" />
                                <%}%>
                          
                        </form>

                        <h2>Spielinformationen</h2>
                        <table summary="Diese Tabelle zeigt Informationen zum aktuellen Spiel">
                            <tr>
                                <th id="leaderLabel" class="label">F&uuml;hrender</th>
                              
                                <% if (gameInfo.getLeader() != null) {%>
                                        <td><%= gameInfo.getLeader().getName() %></td>
                                <% } else { %>
                                    <td id="mehr" class="data">mehrere</td>
                                <% }%>

                            </tr>

                            <tr>
                                <th id="roundLabel" class="label">Runde</th>
                                <td id="round" class="data"><%= gameInfo.getRound()%></td>
                            </tr>

                            <tr>
                                <th id="timeLabel" class="label">Zeit</th>
                                <td id="time" class="data"><%= gameInfo.getTime().toString()%></td>
                            </tr>

                            <tr>
                                <th id="computerScoreLabel" class="label">W&uuml;rfelergebnis <em>Super C</em></th>

                                <td id="computerScore" class="data"><%= gameInfo.getDiceService().getComputerDice().getLastRoll()%></td>
                            </tr>

                        </table>  
                        <h2>Spieler</h2>
                        <table summary="Diese Tabelle listet die Namen der Spieler auf">
                           
                            <tr><th id="player1NameLabel" class="label">Spieler 1</th><td id="player1Name" class="data">Super Mario</td></tr>
                            <tr><th id="player2NameLabel" class="label">Spieler 2</th><td id="player2Name" class="data">Super C</td></tr>
                        
                        </table>    	  
                    </div>

                    <div class="field">
                        <h2 class="accessibility">Spielbereich</h2>
                        <ol id="road">
                           
                            <li id="start_road">
                                <span class="accessibility"><%=gameInfo.getFieldService().getStartField()%></span>
                            </li>
                            <li class="empty_road" id="road_1">
                                <span class="accessibility">Feld 2</span>
                            </li>
                            <li class="oil_road" id="road_2">
                                <span class="accessibility">Feld 3</span>
                                <span id="player1">
                                    <span class="accessibility"><em>Spieler 1</em></span>
                                </span>
                            </li>
                            <li class="empty_road" id="road_3">
                                <span class="accessibility">Feld 4</span>
                            </li>
                            <li class="empty_road" id="road_4">
                                <span class="accessibility">Feld 5</span>
                                <span id="player2">
                                    <span class="accessibility"><em>Spieler 2</em></span>
                                </span>
                            </li>
                            <li class="oil_road" id="road_5">
                                <span class="accessibility">Feld 6</span>
                            </li>
                            <li id="finish_road">
                                 <span class="accessibility"><%= gameInfo.getFieldService().getFinishField()%></span>
                                <!--span class="accessibility">Zielfeld</span-->
                            </li>
                        </ol>
                    </div>
                    <div class="player">
                        <h2 class="accessibility">W&uuml;rfelbereich</h2>
                        <span class="accessibility">An der Reihe ist</span><div id="currentPlayerName">Super Mario</div>
                        <span title='aktueller Spieler'><%= gameInfo.getCurrentPlayer() %></span>
                            <form action="GameServlet" method="get">
                                <fieldset>
                                    <% if (!gameInfo.isGameOver()) {
                                    %>
                                    <input type="image" name="wuerfel" title="W&uuml;rfel" src="<%= gameInfo.getDiceService().getPlayerDice().getImgPath() %>" alt="W&uuml;rfel"/>
                                    <%
                                    } else {
                                    %>
                                    <img name="wuerfel" title="W&uuml;rfel" src="img/wuerfel0.png" alt="W&uuml;rfel"/>
                                    <%
                                    }
                                    %>
                                 </fieldset>
                           </form>   
                    </div>
                </div>
            </div>
            <div id="footer">
                &copy; 2013 Formel 0
            </div>
        </div>

        <script type="text/javascript">
            //<![CDATA[

            // call this function once before starting the animations
            function prepareAnimation() {
                $("#animationDone").remove();
            }

            // call this function once after all animations have finished
            function completeAnimation() {
                var div = $(document.createElement('div'));
                div.attr('id', 'animationDone');
                div.addClass('hide');
                $("body").append(div);
            }

            $("#dice").click(function() {
                prepareAnimation();
                $("#player1").fadeOut(700, function() {
                    $("#player1").appendTo("#start_road");
                    $("#player1").fadeIn(700, completeAnimation);
                });
                return false;
            });
            //]]>
        </script>

    </body>
</html>
