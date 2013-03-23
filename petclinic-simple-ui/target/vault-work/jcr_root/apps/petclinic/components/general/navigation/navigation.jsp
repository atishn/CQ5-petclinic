<%@ taglib prefix="petclinicTag" uri="http://www.example.com/taglibs/petclinic/1.0" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@include file="/apps/petclinic/global.jsp"%>
<%@ page import="java.util.Iterator,
        com.day.text.Text,
        com.day.cq.wcm.api.PageFilter,
        com.day.cq.wcm.api.Page,
        com.day.cq.commons.Doctype,
        org.apache.commons.lang.StringEscapeUtils,
        com.petclinic.HelloPetService" %>


<petclinicTag:petclinicTag><c:out value="Hi" /></petclinicTag:petclinicTag>

<%
    HelloPetService service = sling.getService(com.petclinic.HelloPetService.class);
%>
<%= service.getMessage("Dude Guy") %>


<%
        if (currentPage != null) {
        Iterator<Page> children = currentPage.listChildren(new PageFilter(request));
%> <ul>  <%
    while (children.hasNext()) {
        Page child = children.next();
%>
    <li>
        <a href="<%= child.getPath() %>.html">
            <%= StringEscapeUtils.escapeXml(child.getTitle())%> </a>
    </li>
    <%
        }
    %> </ul>  <%
    }
%>
