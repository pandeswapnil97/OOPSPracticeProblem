<%-- 
    Document   : UserAddressBook
    Created on : 10 Aug, 2020, 4:12:19 PM
    Author     : juile
--%>

<%@page import="java.sql.Statement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="ConnectDB.DB"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Simple Address Book</title>
    </head>
    <style>
        .center_button
        {
            margin: 0;
            position: absolute;
            left: 50%;
            -ms-transform: translate(-50%, -50%);
            transform: translate(-50%, -50%);
        }
        .center_table
        {
            margin: 0;
            position: absolute;
            top: 790px;
            left: 50%;
            -ms-transform: translate(-50%, -50%);
            transform: translate(-50%, -50%);
        }
    </style>
    <script>
        function viewUser(id)
        {
            var user_info=id.split("#");
            
            location.href="ViewUser.jsp?id=" + user_info[0] + "&fname=" + user_info[1] + "&lname=" + user_info[2] + "&address_book_name=" + user_info[3];
        }
        
        function updateUser(id)
        {
            var user_info=id.split("-");
            
            location.href="UpdateUser.jsp?id=" + user_info[0] + "&fname=" + user_info[1] + "&lname=" + user_info[2] + "&address_book_name=" + user_info[3];
        }
        
        function deleteUser(id)
        {
            var user_info=id.split("_");
            
            location.href="DeleteUser?id=" + user_info[0] + "&fname=" + user_info[1] + "&lname=" + user_info[2] + "&address_book_name=" + user_info[3];
        }
        
        function sortTableByName()
        {
            var filterTable, rows, sorted, i, sortFlag;
            
            filterTable = document.querySelector(".tbl");            
            sorted = true;
            while (sorted) 
            {
               sorted = false;
               rows = filterTable.rows;
               
               for (i=1;i<=rows.length-1;i++)
               {
                    sortFlag = false;
                    last_name = rows[i].getElementsByTagName("TD")[1];
                    last_name1 = rows[i+1].getElementsByTagName("TD")[1];

                    if (last_name.innerHTML.toLowerCase() === last_name1.innerHTML.toLowerCase())
                    {
                        first_name = rows[i].getElementsByTagName("TD")[0];
                        first_name1 = rows[i+1].getElementsByTagName("TD")[0];
                        
                        if (first_name.innerHTML.toLowerCase() > first_name1.innerHTML.toLowerCase())
                        {
                                sortFlag = true;
                                break;                         
                        }
                    }
                    else if (last_name.innerHTML.toLowerCase() > last_name1.innerHTML.toLowerCase())
                    {
                        sortFlag = true;
                        break;
                    }
               }
               if (sortFlag) 
               {
                  rows[i].parentNode.insertBefore(rows[i+1], rows[i]);
                  sorted = true;
               }
            }
        }
        
        function sortTableByZip()
        {
            var filterTable, rows, sorted, i, sortFlag;
            
            filterTable = document.querySelector(".tbl");            
            sorted = true;
            while (sorted) 
            {
               sorted = false;
               rows = filterTable.rows;
               
               for (i=1;i<=rows.length-1;i++)
               {
                    sortFlag = false;
                    zip = rows[i].getElementsByTagName("TD")[2];
                    zip1 = rows[i+1].getElementsByTagName("TD")[2];
                    
                    if (zip.innerHTML.toLowerCase() === zip1.innerHTML.toLowerCase())
                    {
                        first_name = rows[i].getElementsByTagName("TD")[0];
                        first_name1 = rows[i + 1].getElementsByTagName("TD")[0];
                        
                        if (first_name.innerHTML.toLowerCase() > first_name1.innerHTML.toLowerCase())
                        {
                                sortFlag = true;
                                break;                         
                        }
                    }
                    else if (zip.innerHTML.toLowerCase() > zip1.innerHTML.toLowerCase())
                    {
                        sortFlag = true;
                        break;
                    }
               }
               if (sortFlag) 
               {
                  rows[i].parentNode.insertBefore(rows[i + 1], rows[i]);
                  sorted = true;
               }
            }
        } 
        
        function searchUser()
        {
            var search_user=document.getElementById("search_name").value;
            var address_book_name = document.getElementsByName("address_book")[0].value; 
            if(search_user !== '')
            {
                location.href="SearchUser.jsp?search_user=" + search_user + "&address_book_name=" + address_book_name;
            }      
        }
        
        function enterUserName()
        {            
            var br = document.createElement('br');
            document.getElementById("button").appendChild(br);
            
            var br = document.createElement('br');
            document.getElementById("button").appendChild(br);
            
            var br = document.createElement('br');
            document.getElementById("button").appendChild(br);
            
            var lbl = document.createElement("label");
            var txtnode = document.createTextNode("Enter First Name:");
            lbl.setAttribute("for", txtnode);
            lbl.appendChild(txtnode);
            document.getElementById("button").appendChild(lbl);
            
            var txt = document.createElement('input');
            txt.type = "text";
            txt.id = "search_name";
            txt.style="margin: 2px;";
            document.getElementById("button").appendChild(txt);
            document.getElementById("search_name").focus();
            
            var br = document.createElement('br');
            document.getElementById("button").appendChild(br);
            
            var br = document.createElement('br');
            document.getElementById("button").appendChild(br);
            
            var btn = document.createElement('input');
            btn.type = "button";
            btn.id = "search_button";
            btn.value = "Search";
            btn.setAttribute("onclick", "searchUser()");
            document.getElementById("button").appendChild(btn);
        }       
    </script>
    <body>
        <a href="AddAddressBook.jsp">Return To Home Page</a>
        <center>
            <form action="AddUser" method="post">
            <%
                String address_book_name = request.getParameter("address_book_name");
            %>
                <h1>Address Book</h1>
                
                <h2><u><%= address_book_name%></u></h2>
                <hr style="border: none">
                <br><br><br>
                <center><caption><h3>Add New Users</h3></caption></center>
                <br><br>
                <label> First Name: </label>
                <input type="text" name="fname" placeholder="First Name" required="true" />
                <br>
                <hr style="border: none">
                <label> Last Name: </label>
                <input type="text" name="lname" placeholder="Last Name" required="true" />
                <br>
                <hr style="border: none">
                <label> Address: </label>
                <input type="text" name="addr" placeholder="Address" required="true" />
                <br>
                <hr style="border: none">
                <label> City: </label>
                <input type="text" name="city" placeholder="City" required="true" />
                <br>
                <hr style="border: none">
                <label> State: </label>
                <input type="text" name="state" placeholder="State" required="true" />
                <br>
                <hr style="border: none">
                <label> Zip Code: </label>
                <input type="text" name="zip" placeholder="Zip Code" pattern="\d{6}" required="true" />
                <br>
                <hr style="border: none">
                <label> Phone Number: </label>
                <input type="text" name="phno" placeholder="Phone Number" pattern="^[6-9]{1}[0-9]{9}" required="true" />
                <br>
                <hr style="border: none">
                <input type="submit" value="Add" />
                <input type="hidden" name="address_book" value="<%= address_book_name%>">
            </form>
            <br><br><br>
            <%
                int table_count=0;
                
                DB db = new DB();
                Connection con = db.getDbCon();
                
                String sq = "SELECT COUNT(*) FROM " + address_book_name;
                PreparedStatement ps = con.prepareStatement(sq); 

                ResultSet rs = ps.executeQuery();

                while(rs.next())
                {
                    table_count=rs.getInt(1);
                }
                
                if (table_count == 0)
                {
            %>
                    <center><caption><h3>Currently, There are no users in <%= address_book_name%></h3></caption></center>
            <%
                }
                else if (table_count >= 1)
                {        
            %>
                    <center><caption><h3>List of Users</h3></caption></center>                    
                    <style>table, th, td {border: 1px solid black}</style>
                    <div class="center_table" style="height: 130px;overflow: auto">
                        <table class='tbl' style="text-align: center">
                        <tr>
                            <th>First Name</th>
                            <th>Last Name</th>
                            <th>Zip</th>                    
                            <th colspan="3">Actions</th>
                        </tr>
                        <%
                            String sql = "SELECT * FROM " + address_book_name;
                            PreparedStatement pst = con.prepareStatement(sql); 

                            ResultSet rst = pst.executeQuery();

                            while(rst.next())
                            {
                        %>
                                <tr>
                                    <td><%= rst.getString("first_name")%></td>
                                    <td><%= rst.getString("last_name")%></td>
                                    <td><%= rst.getString("zip")%></td>
                                    <td><button id="<%= rst.getInt("id")%>#<%= rst.getString("first_name")%>#<%= rst.getString("last_name")%>#<%= address_book_name%>" onclick="viewUser(this.id)">View</button></td>
                                    <td><button id="<%= rst.getInt("id")%>-<%= rst.getString("first_name")%>-<%= rst.getString("last_name")%>-<%= address_book_name%>" onclick="updateUser(this.id)">Update</button></td>
                                    <td><button id="<%= rst.getInt("id")%>_<%= rst.getString("first_name")%>_<%= rst.getString("last_name")%>_<%= address_book_name%>" onclick="deleteUser(this.id)">Delete</button></td>
                                </tr>
                <%                
                            }
                    }
                %>
                        </table>
                    </div>
                <%                
                    if (table_count > 1)
                    {
                %>                    
                    <div>                    
                        <br><br><br><br><br><br><br><br><br>              
                        <input type="button" value="Sort By Last Name" onclick="sortTableByName()" />
                        &nbsp;&nbsp;
                        <input type="button" value="Sort By Zip" onclick="sortTableByZip()" />
                        &nbsp;&nbsp;
                        <input type="button" value="Search User" onclick="enterUserName()" />
                        <div id="button" class="center_button">
                            <br><br>                       
                        </div>
                    </div>
                 <% } %>
        </center>
    </body>
</html>