package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"style.css\">\n");
      out.write("        <title>Servicios Parcial</title>\n");
      out.write("        <script>\n");
      out.write("            function referenciarPagina(form){\n");
      out.write("                var hidden = document.createElement(\"input\");\n");
      out.write("                hidden.setAttribute(\"type\",\"hidden\");\n");
      out.write("                hidden.setAttribute(\"name\",\"ref\");\n");
      out.write("                hidden.setAttribute(\"value\",location.href);\n");
      out.write("                document.getElementById(form).appendChild(hidden);\n");
      out.write("            }\n");
      out.write("        </script>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div id=\"header\" name=\"encabezado\">\n");
      out.write("        <h1>Web Services con Restful</h1>\n");
      out.write("        </div>\n");
      out.write("        <div id=\"service1\" class=\"service\" name=\"servicio1\">\n");
      out.write("            <h2>Servicio de copiado de una ruta r1 a una ruta r2</h2>\n");
      out.write("            <form id=\"form_copiado\" action=\"http://localhost:44397/ParcialServer/webresources/copiador\" method=\"get\">\n");
      out.write("                ");

                    if(request.getParameter("origen1") != null)
                        out.print("<input id='origen1' class='text' type='text' name='origen' value='"+request.getParameter("origen1")+"'/>");
                    else
                        out.print("<input id='origen1' class='text' type='text' name='origen' placeholder='Origen'/>");
                
      out.write("\n");
      out.write("                <input type=\"button\" class=\"button\" value=\"Buscar\" onclick=\"location.href='http://localhost:44397/ParcialClient/escogedor.jsp?opcion=origen1&destino1='+document.getElementById('destino1').getAttribute('value')\"/></br>\n");
      out.write("                ");

                    if(request.getParameter("destino1") != null)
                        out.print("<input id='destino1' class='text' type='text' name='destino' value='"+request.getParameter("destino1")+"'/>");
                    else
                        out.print("<input id='destino1' class='text' type='text' name='destino' placeholder='Destino'/>");
                
      out.write("\n");
      out.write("                <input type=\"button\" class=\"button\" value=\"Buscar\" onclick=\"location.href='http://localhost:44397/ParcialClient/escogedor.jsp?opcion=destino1&origen1='+document.getElementById('origen1').getAttribute('value')\"/></br>\n");
      out.write("                <input type=\"submit\" class=\"button\" value=\"Copiar\"</br>\n");
      out.write("                <script>referenciarPagina('form_copiado');</script>\n");
      out.write("            </form>\n");
      out.write("        </div>\n");
      out.write("        <div id=\"service2\" class=\"service\" name=\"servicio2\">\n");
      out.write("            <h2>Servicio de descarga de una url</h2>\n");
      out.write("            <form id=\"form_descarga\" action=\"http://localhost:44397/ParcialServer/webresources/descargador\" method=\"get\">\n");
      out.write("                ");

                    if(request.getParameter("url1") != null)
                        out.print("<input type='text' id='url1' name='url' value="+request.getParameter("url1")+"/></br>");
                    else
                        out.print("<input type='text' id='url1' name='url' placeholder='URL de imagen'/></br>");
                
      out.write("\n");
      out.write("                ");

                    if(request.getParameter("destino2") != null)
                        out.print("<input type='text' class='text' name='destino' value='"+request.getParameter("destino2")+"'/>");
                    else
                        out.print("<input type='text' class='text' name='destino' placeholder='Destino'/>");
                
      out.write("\n");
      out.write("                <input type=\"button\" class=\"button\" value=\"Buscar\" onclick=\"alert(document.getElementById('url1').getAttribute('value'));location.href='http://localhost:44397/ParcialClient/escogedor.jsp?opcion=destino2&url1='+document.getElementById('url1').getAttribute('value');\"/></br>\n");
      out.write("                <input type=\"submit\" class=\"button\" value=\"Descargar\"/></br>\n");
      out.write("                <script>referenciarPagina('form_descarga');</script>\n");
      out.write("            </form>\n");
      out.write("        </div>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
