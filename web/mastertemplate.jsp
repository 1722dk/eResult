<%-- 
    Document   : mastertemplate
    Created on : Aug 23, 2013, 12:20:46 PM
    Author     : ASUS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:genericpage>
    <jsp:attribute name="header">
        <h1>Welcome</h1>
    </jsp:attribute>
    <jsp:attribute name="footer">
        <p id="copyright">Copyright © 2013 by Juthi Inc. All Rights Reserved.</p>
    </jsp:attribute>
    <jsp:body>
        <p>Hi I'm the heart of the message</p>
    </jsp:body>
</t:genericpage>
