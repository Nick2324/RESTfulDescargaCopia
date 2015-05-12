<%@page import="java.util.Enumeration"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="javax.swing.JFileChooser"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Escoger ruta</title>
    </head>
    <body  onload='document.getElementById("send").click();'>
        <form action="index.jsp" method="post">
        <%
            JFileChooser fc = new JFileChooser();
            if(request.getParameter("opcion").contains("destino"))
                fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            else
                fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
            if(fc.showSaveDialog(null) == JFileChooser.APPROVE_OPTION)
                out.print("<input type='hidden' name='"+request.getParameter("opcion")+"' value='"+fc.getSelectedFile().getAbsolutePath()+"'/>");
            for(Enumeration e = request.getParameterNames();e.hasMoreElements();){
                String name = (String)e.nextElement();
                if(!name.contains("opcion") && !request.getParameter(name).equals("null"))
                    out.print("<input type='hidden' name='"+name+"' value='"+request.getParameter(name)+"' />");
            }
            out.print("<input type='submit' id='send'/>");
        %>
        </form>
    </body>
</html>
