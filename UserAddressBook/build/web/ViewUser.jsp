<%-- 
    Document   : ViewUser
    Created on : 13 Aug, 2020, 2:51:05 PM
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
        <title>Viewing User</title>
    </head>
    <body>
        
        <%
            String id = request.getParameter("id");
            String fname = request.getParameter("fname");
            String lname = request.getParameter("lname");
            String address_book_name = request.getParameter("address_book_name");
               
            DB db = new DB();
            Connection con = db.getDbCon();

            String sq = "SELECT * FROM " + address_book_name + " WHERE id=? AND first_name=? AND last_name=?";
            PreparedStatement ps = con.prepareStatement(sq); 
            
            ps.setInt(1, Integer.parseInt(id));
            ps.setString(2, fname);
            ps.setString(3, lname);
            
            ResultSet rs = ps.executeQuery();

            if(rs.next())
            {
        %>
        <a href="UserAddressBook.jsp?address_book_name=<%= address_book_name%>" >Return To Address Book</a>
                <center>
                    <form action="" method="post">
                        <h2>User Information</h2>
                        <hr style="border: none">
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
                    </form>
                </center>
         <% } %>  
    </body>
</html>
