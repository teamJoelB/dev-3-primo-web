<%-- 
    Document   : public
    Created on : 17 juin 2021, 16:11:27
    Author     : joelg
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%@include file="menu.jsp" %>

        <div class="container mt-4">
            <h2 class="titre-perso center my-font-family">Mon espace public</h2>
            <br>
            
            <div class="mt-4">
                <div class="row">
                    <c:forEach var="n" items="${memoPublic}">
                        <div class="col-sm-4">
                            <div class="card my-font-family p-2">
                                <div class="row">
                                    <div class="col-sm-8">
                                        <p class="label-perso">Date : ${n.dateCreation} </p>
                                        <p class="text-info">${n.contenu}</p>
                                    </div>
                                    <div class="col-sm-4">
                                        <strong>${n.createur.prenom}  ${n.createur.nom}</strong>
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
