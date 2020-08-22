package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import ConnectDB.DB;
import java.sql.Connection;

public final class UserAddressBook_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Simple Address Book</title>\n");
      out.write("    </head>\n");
      out.write("    <style>\n");
      out.write("        .center_button\n");
      out.write("        {\n");
      out.write("            margin: 0;\n");
      out.write("            position: absolute;\n");
      out.write("\n");
      out.write("            left: 50%;\n");
      out.write("            -ms-transform: translate(-50%, -50%);\n");
      out.write("            transform: translate(-50%, -50%);\n");
      out.write("        }\n");
      out.write("        .center_table\n");
      out.write("        {\n");
      out.write("            margin: 0;\n");
      out.write("            position: absolute;\n");
      out.write("            top: 620px;\n");
      out.write("            left: 50%;\n");
      out.write("            -ms-transform: translate(-50%, -50%);\n");
      out.write("            transform: translate(-50%, -50%);\n");
      out.write("        }\n");
      out.write("    </style>\n");
      out.write("    <script>\n");
      out.write("        function viewUser(id)\n");
      out.write("        {\n");
      out.write("            var user_info=id.split(\"#\");\n");
      out.write("            \n");
      out.write("            location.href=\"ViewUser.jsp?id=\" + user_info[0] + \"&fname=\" + user_info[1] + \"&lname=\" + user_info[2];\n");
      out.write("        }\n");
      out.write("        \n");
      out.write("        function updateUser(id)\n");
      out.write("        {\n");
      out.write("            var user_info=id.split(\"-\");\n");
      out.write("            \n");
      out.write("            location.href=\"UpdateUser.jsp?id=\" + user_info[0] + \"&fname=\" + user_info[1] + \"&lname=\" + user_info[2];\n");
      out.write("        }\n");
      out.write("        \n");
      out.write("        function deleteUser(id)\n");
      out.write("        {\n");
      out.write("            var user_info=id.split(\"_\");\n");
      out.write("            \n");
      out.write("            location.href=\"DeleteUser?id=\" + user_info[0] + \"&fname=\" + user_info[1] + \"&lname=\" + user_info[2];\n");
      out.write("        }\n");
      out.write("        \n");
      out.write("        function sortTableByName()\n");
      out.write("        {\n");
      out.write("            var filterTable, rows, sorted, i, sortFlag;\n");
      out.write("            \n");
      out.write("            filterTable = document.querySelector(\".tbl\");            \n");
      out.write("            sorted = true;\n");
      out.write("            while (sorted) \n");
      out.write("            {\n");
      out.write("               sorted = false;\n");
      out.write("               rows = filterTable.rows;\n");
      out.write("               \n");
      out.write("               for (i=1;i<=rows.length-1;i++)\n");
      out.write("               {\n");
      out.write("                    sortFlag = false;\n");
      out.write("                    last_name = rows[i].getElementsByTagName(\"TD\")[1];\n");
      out.write("                    last_name1 = rows[i+1].getElementsByTagName(\"TD\")[1];\n");
      out.write("\n");
      out.write("                    if (last_name.innerHTML.toLowerCase() === last_name1.innerHTML.toLowerCase())\n");
      out.write("                    {\n");
      out.write("                        first_name = rows[i].getElementsByTagName(\"TD\")[0];\n");
      out.write("                        first_name1 = rows[i+1].getElementsByTagName(\"TD\")[0];\n");
      out.write("                        \n");
      out.write("                        if (first_name.innerHTML.toLowerCase() > first_name1.innerHTML.toLowerCase())\n");
      out.write("                        {\n");
      out.write("                                sortFlag = true;\n");
      out.write("                                break;                         \n");
      out.write("                        }\n");
      out.write("                    }\n");
      out.write("                    else if (last_name.innerHTML.toLowerCase() > last_name1.innerHTML.toLowerCase())\n");
      out.write("                    {\n");
      out.write("                        sortFlag = true;\n");
      out.write("                        break;\n");
      out.write("                    }\n");
      out.write("               }\n");
      out.write("               if (sortFlag) \n");
      out.write("               {\n");
      out.write("                  rows[i].parentNode.insertBefore(rows[i+1], rows[i]);\n");
      out.write("                  sorted = true;\n");
      out.write("               }\n");
      out.write("            }\n");
      out.write("        }\n");
      out.write("        \n");
      out.write("        function sortTableByZip()\n");
      out.write("        {\n");
      out.write("            var filterTable, rows, sorted, i, sortFlag;\n");
      out.write("            \n");
      out.write("            filterTable = document.querySelector(\".tbl\");            \n");
      out.write("            sorted = true;\n");
      out.write("            while (sorted) \n");
      out.write("            {\n");
      out.write("               sorted = false;\n");
      out.write("               rows = filterTable.rows;\n");
      out.write("               \n");
      out.write("               for (i=1;i<=rows.length-1;i++)\n");
      out.write("               {\n");
      out.write("                    sortFlag = false;\n");
      out.write("                    zip = rows[i].getElementsByTagName(\"TD\")[2];\n");
      out.write("                    zip1 = rows[i+1].getElementsByTagName(\"TD\")[2];\n");
      out.write("                    \n");
      out.write("                    if (zip.innerHTML.toLowerCase() === zip1.innerHTML.toLowerCase())\n");
      out.write("                    {\n");
      out.write("                        first_name = rows[i].getElementsByTagName(\"TD\")[0];\n");
      out.write("                        first_name1 = rows[i + 1].getElementsByTagName(\"TD\")[0];\n");
      out.write("                        \n");
      out.write("                        if (first_name.innerHTML.toLowerCase() > first_name1.innerHTML.toLowerCase())\n");
      out.write("                        {\n");
      out.write("                                sortFlag = true;\n");
      out.write("                                break;                         \n");
      out.write("                        }\n");
      out.write("                    }\n");
      out.write("                    else if (zip.innerHTML.toLowerCase() > zip1.innerHTML.toLowerCase())\n");
      out.write("                    {\n");
      out.write("                        sortFlag = true;\n");
      out.write("                        break;\n");
      out.write("                    }\n");
      out.write("               }\n");
      out.write("               if (sortFlag) \n");
      out.write("               {\n");
      out.write("                  rows[i].parentNode.insertBefore(rows[i + 1], rows[i]);\n");
      out.write("                  sorted = true;\n");
      out.write("               }\n");
      out.write("            }\n");
      out.write("        } \n");
      out.write("        \n");
      out.write("        function searchUser()\n");
      out.write("        {\n");
      out.write("            var search_user=document.getElementById(\"search_name\").value;\n");
      out.write("            if(search_user !== '')\n");
      out.write("            {\n");
      out.write("                //console.log(search_name);\n");
      out.write("                location.href=\"SearchUser.jsp?search_user=\" + search_user;\n");
      out.write("            }      \n");
      out.write("        }\n");
      out.write("        \n");
      out.write("        function enterUserName()\n");
      out.write("        {            \n");
      out.write("            var br = document.createElement('br');\n");
      out.write("            document.getElementById(\"button\").appendChild(br);\n");
      out.write("            \n");
      out.write("            var br = document.createElement('br');\n");
      out.write("            document.getElementById(\"button\").appendChild(br);\n");
      out.write("            \n");
      out.write("            var br = document.createElement('br');\n");
      out.write("            document.getElementById(\"button\").appendChild(br);\n");
      out.write("            \n");
      out.write("            var lbl = document.createElement(\"label\");\n");
      out.write("            var txtnode = document.createTextNode(\"Enter First Name:\");\n");
      out.write("            lbl.setAttribute(\"for\", txtnode);\n");
      out.write("            lbl.appendChild(txtnode);\n");
      out.write("            document.getElementById(\"button\").appendChild(lbl);\n");
      out.write("            \n");
      out.write("            var txt = document.createElement('input');\n");
      out.write("            txt.type = \"text\";\n");
      out.write("            txt.id = \"search_name\";\n");
      out.write("            txt.style=\"margin: 2px;\";\n");
      out.write("            document.getElementById(\"button\").appendChild(txt);\n");
      out.write("            document.getElementById(\"search_name\").focus();\n");
      out.write("            \n");
      out.write("            var br = document.createElement('br');\n");
      out.write("            document.getElementById(\"button\").appendChild(br);\n");
      out.write("            \n");
      out.write("            var br = document.createElement('br');\n");
      out.write("            document.getElementById(\"button\").appendChild(br);\n");
      out.write("            \n");
      out.write("            var btn = document.createElement('input');\n");
      out.write("            btn.type = \"button\";\n");
      out.write("            btn.id = \"search_button\";\n");
      out.write("            btn.value = \"Search\";\n");
      out.write("            btn.setAttribute(\"onclick\", \"searchUser()\");\n");
      out.write("            document.getElementById(\"button\").appendChild(btn);\n");
      out.write("        }\n");
      out.write("        \n");
      out.write("    </script>\n");
      out.write("    <body>\n");
      out.write("        <center>\n");
      out.write("            <form action=\"AddUser\" method=\"post\">\n");
      out.write("                <h1>Address Book</h1>\n");
      out.write("                <hr style=\"border: none\">\n");
      out.write("                <br><br><br>\n");
      out.write("                <label> First Name: </label>\n");
      out.write("                <input type=\"text\" name=\"fname\" placeholder=\"First Name\" required=\"true\" />\n");
      out.write("                <br>\n");
      out.write("                <hr style=\"border: none\">\n");
      out.write("                <label> Last Name: </label>\n");
      out.write("                <input type=\"text\" name=\"lname\" placeholder=\"Last Name\" required=\"true\" />\n");
      out.write("                <br>\n");
      out.write("                <hr style=\"border: none\">\n");
      out.write("                <label> Address: </label>\n");
      out.write("                <input type=\"text\" name=\"addr\" placeholder=\"Address\" required=\"true\" />\n");
      out.write("                <br>\n");
      out.write("                <hr style=\"border: none\">\n");
      out.write("                <label> City: </label>\n");
      out.write("                <input type=\"text\" name=\"city\" placeholder=\"City\" required=\"true\" />\n");
      out.write("                <br>\n");
      out.write("                <hr style=\"border: none\">\n");
      out.write("                <label> State: </label>\n");
      out.write("                <input type=\"text\" name=\"state\" placeholder=\"State\" required=\"true\" />\n");
      out.write("                <br>\n");
      out.write("                <hr style=\"border: none\">\n");
      out.write("                <label> Zip Code: </label>\n");
      out.write("                <input type=\"text\" name=\"zip\" placeholder=\"Zip Code\" pattern=\"\\d{6}\" required=\"true\" />\n");
      out.write("                <br>\n");
      out.write("                <hr style=\"border: none\">\n");
      out.write("                <label> Phone Number: </label>\n");
      out.write("                <input type=\"text\" name=\"phno\" placeholder=\"Phone Number\" pattern=\"^[6-9]{1}[0-9]{9}\" required=\"true\" />\n");
      out.write("                <br>\n");
      out.write("                <hr style=\"border: none\">\n");
      out.write("                <input type=\"submit\" value=\"Add\" />\n");
      out.write("            </form>\n");
      out.write("            <br><br><br>\n");
      out.write("            ");

                int table_count=0;
                
                DB db = new DB();
                Connection con = db.getDbCon();
                
                String sq = "SELECT COUNT(*) FROM addrbook";
                PreparedStatement ps = con.prepareStatement(sq); 

                ResultSet rs = ps.executeQuery();

                while(rs.next())
                {
                    table_count=rs.getInt(1);
                }
                
                if (table_count >= 1)
                {        
            
      out.write("\n");
      out.write("                    <center><caption><h2>List of Users</h2></caption></center>\n");
      out.write("                    \n");
      out.write("                    <style>table, th, td {border: 1px solid black}</style>\n");
      out.write("                    <div class=\"center_table\" style=\"height: 130px;overflow: auto\">\n");
      out.write("                        <table class='tbl' style=\"text-align: center\">\n");
      out.write("                        <tr>\n");
      out.write("                            <!--<th>ID</th>-->\n");
      out.write("                            <th>First Name</th>\n");
      out.write("                            <th>Last Name</th>\n");
      out.write("                            ");
      out.write("\n");
      out.write("                            <th>Zip</th>                    \n");
      out.write("                            ");
      out.write("\n");
      out.write("                            <th colspan=\"3\">Actions</th>\n");
      out.write("                        </tr>\n");
      out.write("                        ");

                            String sql = "SELECT * FROM addrbook";
                            PreparedStatement pst = con.prepareStatement(sql); 

                            ResultSet rst = pst.executeQuery();

                            while(rst.next())
                            {
                        
      out.write("\n");
      out.write("                                <tr>\n");
      out.write("                                    ");
      out.write("\n");
      out.write("                                    <td>");
      out.print( rst.getString("first_name"));
      out.write("</td>\n");
      out.write("                                    <td>");
      out.print( rst.getString("last_name"));
      out.write("</td>\n");
      out.write("                                    ");
      out.write("\n");
      out.write("                                    <td>");
      out.print( rst.getString("zip"));
      out.write("</td>\n");
      out.write("                                    ");
      out.write("\n");
      out.write("                                    <td><button id=\"");
      out.print( rst.getInt("id"));
      out.write('#');
      out.print( rst.getString("first_name"));
      out.write('#');
      out.print( rst.getString("last_name"));
      out.write("\" onclick=\"viewUser(this.id)\">View</button></td>\n");
      out.write("                                    <td><button id=\"");
      out.print( rst.getInt("id"));
      out.write('-');
      out.print( rst.getString("first_name"));
      out.write('-');
      out.print( rst.getString("last_name"));
      out.write("\" onclick=\"updateUser(this.id)\">Update</button></td>\n");
      out.write("                                    <td><button id=\"");
      out.print( rst.getInt("id"));
      out.write('_');
      out.print( rst.getString("first_name"));
      out.write('_');
      out.print( rst.getString("last_name"));
      out.write("\" onclick=\"deleteUser(this.id)\">Delete</button></td>\n");
      out.write("                                </tr>\n");
      out.write("                ");
                
                            }
                    }
                
      out.write("\n");
      out.write("                        </table>\n");
      out.write("                    </div>\n");
      out.write("                ");
                
                    if (table_count > 1)
                    {
                
      out.write("                    \n");
      out.write("                    <div>    ");
      out.write("                    \n");
      out.write("                        <br><br><br><br><br><br><br><br><br>              \n");
      out.write("                        <input type=\"button\" value=\"Sort By Name\" onclick=\"sortTableByName()\" />\n");
      out.write("                        &nbsp;&nbsp;\n");
      out.write("                        <input type=\"button\" value=\"Sort By Zip\" onclick=\"sortTableByZip()\" />\n");
      out.write("                        &nbsp;&nbsp;\n");
      out.write("                        <input type=\"button\" value=\"Search User\" onclick=\"enterUserName()\" />\n");
      out.write("                        <div id=\"button\" class=\"center_button\">\n");
      out.write("                            <br><br>                       \n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                 ");
 } 
      out.write("\n");
      out.write("        </center>\n");
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
