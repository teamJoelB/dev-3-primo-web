<%-- 
    Document   : home
    Created on : 17 juin 2021, 14:01:59
    Author     : joelg
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>DEV-3</title>
    </head>
    <body>
        <%@include file="menu.jsp" %>
        <div class="container mt-4">
            <br>
            <h2 class="titre-perso center my-font-family">Mon espace privé</h2>
            <br>

            <div class="mt-4">
                <br><br>
                <div class="row">
                    <c:forEach var="n" items="${memoPrive}">
                        <div class="col-sm-4">
                            <div class="card my-font-family p-2 card-shadow">
                                <div class="row">
                                    <div class="col-sm-10">
                                        <p class="label-perso">Date : ${n.dateCreation} </p>
                                        <p class="text-info">${n.contenu}</p>
                                    </div>
                                    <div class="col-sm-2">
                                        <c:choose>
                                            <c:when test="${n.prive == true}">
                                                <i style="color: tomato" class="fa fa-eye-slash fa-2x"></i>
                                            </c:when>
                                            <c:otherwise>
                                                <i style="color: chartreuse" class="fa fa-eye fa-2x"></i>
                                            </c:otherwise>
                                        </c:choose>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </c:forEach>

                </div>
            </div>
        </div>

    </body>
</html>
