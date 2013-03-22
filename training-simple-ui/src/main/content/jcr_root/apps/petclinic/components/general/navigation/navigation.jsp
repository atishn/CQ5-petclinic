<%@include file="/libs/foundation/global.jsp"%><%
%><%@ page import="java.util.Iterator,
        com.day.text.Text,
        com.day.cq.wcm.api.PageFilter,
        com.day.cq.wcm.api.Page,
        com.day.cq.commons.Doctype,
        org.apache.commons.lang.StringEscapeUtils" %>

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
