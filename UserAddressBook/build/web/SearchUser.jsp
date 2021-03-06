<%-- 
    Document   : SearchUser
    Created on : 13 Aug, 2020, 7:38:37 PM
    Author     : juile
--%>


<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="ConnectDB.DB"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Searched User Information</title>
    </head>
    <body>
        <%
            
            String search_user_name = request.getParameter("search_user");            
            String address_book_name = request.getParameter("address_book_name");
            
            int flag = 1;
        %>
            <a href="UserAddressBook.jsp?address_book_name=<%= address_book_name%>" >Return To Address Book</a>   
            <center>
                <h2>User Information</h2>
                <hr style="border: none">
                <br><br>
            </center>            
        <%
            DB db = new DB();
            Connection con = db.getDbCon();

            String sq = "SELECT * FROM " + address_book_name + " WHERE first_name=?";
            PreparedStatement ps = con.prepareStatement(sq); 
                       
            ps.setString(1, search_user_name);

            ResultSet rs = ps.executeQuery();

            while(rs.next())
            {            
                flag = 0;
        %>
                          
                <center>                  
                    <div>  
                        <br><br>
                        <input type="hidden" name="id" value="<%= rs.getInt("id")%>" />
                        <label> First Name: </label>
                        <input type="text" name="fname" value="<%= rs.getString("first_name")%>" disabled="true" />
                        <br>
                        <hr style="border: none">
                        <label> Last Name: </label>
                        <input type="text" name="lname" value="<%= rs.getString("last_name")%>" disabled="true" />
                        <br>
                        <hr style="border: none">
                        <label> Address: </label>
                        <input type="text" name="addr" value="<%= rs.getString("address")%>" disabled="true" />
                        <br>
                        <hr style="border: none">
                        <label> City: </label>
                        <input type="text" name="city" value="<%= rs.getString("city")%>" disabled="true" />
                        <br>
                        <hr style="border: none">
                        <label> State: </label>
                        <input type="text" name="state" value="<%= rs.getString("state")%>" disabled="true" />
                        <br>
                        <hr style="border: none">
                        <label> Zip Code: </label>
                        <input type="text" name="zip" value="<%= rs.getString("zip")%>" pattern="\d{6}" disabled="true" />
                        <br>
                        <hr style="border: none">
                        <label> Phone Number: </label>
                        <input type="text" name="phno" value="<%= rs.getString("phone_number")%>" pattern="^[6-9]{1}[0-9]{9}" disabled="true" />
                        <br>                        
                    </div>
                </center>
                <br><br>
                <hr style="border-width: 2px">
        <%                 
            }   
            if (flag == 1)
            {   
                out.println("<script type=\"text/javascript\">");
                out.println("alert('User Does Not Found');");
                out.println("location='UserAddressBook.jsp?address_book_name=" + address_book_name + "';");
                out.println("</script>");              
            }     
      %>               
    </body>
</html>