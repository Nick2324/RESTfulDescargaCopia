<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="style.css">
        <title>Servicios Parcial</title>
        <script>
            function referenciarPagina(form){
                var hidden = document.createElement("input");
                hidden.setAttribute("type","hidden");
                hidden.setAttribute("name","ref");
                hidden.setAttribute("value",location.href);
                document.getElementById(form).appendChild(hidden);
            }
        </script>
    </head>
    <body>
        <div id="header" name="encabezado">
        <h1>Web Services con Restful</h1>
        </div>
        <div id="service1" class="service" name="servicio1">
            <h2>Servicio de copiado de una ruta r1 a una ruta r2</h2>
            <form id="form_copiado" action="http://localhost:44397/ParcialServer/webresources/copiador" method="get">
                <%
                    if(request.getParameter("origen1") != null)
                        out.print("<input id='origen1' class='text' type='text' name='origen' value='"+request.getParameter("origen1")+"'/>");
                    else
                        out.print("<input id='origen1' class='text' type='text' name='origen' placeholder='Origen'/>");
                %>
                <input type="button" class="button" value="Buscar" onclick="location.href='http://localhost:44397/ParcialClient/escogedor.jsp?opcion=origen1&destino1='+document.getElementById('destino1').getAttribute('value')"/></br>
                <%
                    if(request.getParameter("destino1") != null)
                        out.print("<input id='destino1' class='text' type='text' name='destino' value='"+request.getParameter("destino1")+"'/>");
                    else
                        out.print("<input id='destino1' class='text' type='text' name='destino' placeholder='Destino'/>");
                %>
                <input type="button" class="button" value="Buscar" onclick="location.href='http://localhost:44397/ParcialClient/escogedor.jsp?opcion=destino1&origen1='+document.getElementById('origen1').getAttribute('value')"/></br>
                <input type="submit" class="button" value="Copiar"</br>
                <script>referenciarPagina('form_copiado');</script>
            </form>
        </div>
        <div id="service2" class="service" name="servicio2">
            <h2>Servicio de descarga de una url</h2>
            <form id="form_descarga" action="http://localhost:44397/ParcialServer/webresources/descargador" method="get">
                <%
                    if(request.getParameter("url1") != null)
                        out.print("<input type='text' id='url1' name='url' value="+request.getParameter("url1")+"/></br>");
                    else
                        out.print("<input type='text' id='url1' name='url' placeholder='URL de imagen'/></br>");
                %>
                <%
                    if(request.getParameter("destino2") != null)
                        out.print("<input type='text' class='text' name='destino' value='"+request.getParameter("destino2")+"'/>");
                    else
                        out.print("<input type='text' class='text' name='destino' placeholder='Destino'/>");
                %>
                <input type="button" class="button" value="Buscar" onclick="alert(document.getElementById('url1').getAttribute('value'));location.href='http://localhost:44397/ParcialClient/escogedor.jsp?opcion=destino2&url1='+document.getElementById('url1').getAttribute('value');"/></br>
                <input type="submit" class="button" value="Descargar"/></br>
                <script>referenciarPagina('form_descarga');</script>
            </form>
        </div>
    </body>
</html>
