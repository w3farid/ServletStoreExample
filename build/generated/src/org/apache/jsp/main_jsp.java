package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.store.Book;
import java.util.*;

public final class main_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(2);
    _jspx_dependants.add("/header.jsp");
    _jspx_dependants.add("/footer.jsp");
  }

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

      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <title>Book Store</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <h1>Welcome to the Book store.</h1>\n");
      out.write("        <br>");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<table>\n");

    HashMap map = (HashMap) application.getAttribute("books");
    Iterator it = map.values().iterator();
    while (it.hasNext()) {
        Book book = (Book) it.next();


      out.write("\n");
      out.write("<tr>\n");
      out.write("    <td>");
      out.print( book.getName());
      out.write("</td>\n");
      out.write("    <td>");
      out.print( book.getPrice());
      out.write("</td>\n");
      out.write("    <td><a href=\"CartAction?add=true&id=");
      out.print( book.getId());
      out.write("\">Add to Cart</a></td>\n");
      out.write("</tr>\n");
}
      out.write("\n");
      out.write("<table>\n");
      out.write("<br>\n");
      out.write("<table>\n");
      out.write("    <tr>\n");
      out.write("        <td><a href=\"CartAction?add=false\">Display Cart</a></td>\n");
      out.write("        <td><a href=\"CheckOutAction\">Check out</a></td>\n");
      out.write("    </tr>\n");
      out.write("</table>\n");
      out.write("    </body>\n");
      out.write("</html>");
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
