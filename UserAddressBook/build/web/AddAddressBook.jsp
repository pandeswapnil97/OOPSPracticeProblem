<%-- 
    Document   : AddAddressBook
    Created on : 14 Aug, 2020, 12:39:58 PM
    Author     : juile
--%>

<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.DatabaseMetaData"%>
<%@page import="java.sql.Connection"%>
<%@page import="ConnectDB.DB"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Address Book Problem</title>
    </head>
     <style>
         .center_button
        {
            margin: 0;
            position: absolute;
            top: 600px;
            left: 50%;
            -ms-transform: translate(-50%, -50%);
            transform: translate(-50%, -50%);
        }
        .center_table
        {
            margin: 0;
            position: absolute;
            top: 500px;
            left: 50%;
            -ms-transform: translate(-50%, -50%);
            transform: translate(-50%, -50%);
        }
    </style>
    <script>
        function viewAddressBook(id)
        {
            location.href="UserAddressBook.jsp?address_book_name=" + id;
        }
        
        function deleteAddressBook(name)
        {
            location.href="DeleteAddressBook?address_book_name=" + name;
        }
        
        function updateAddressBookName(id)
        {
            var updated_address_book_name = document.getElementById("update_name").value;
            var address_book_name = id; 
            if(updated_address_book_name !== '')
            {
                location.href="UpdateAddressBook?address_book_name=" + address_book_name + "&updated_address_book_name=" + updated_address_book_name;
            }      
        }
        
        function enterNewAddressBookName(id)
        {      
            var update_address_book_info = id.split("_");

            
            var br = document.createElement('br');
            document.getElementById("button").appendChild(br);
            
            var br = document.createElement('br');
            document.getElementById("button").appendChild(br);
            
            var br = document.createElement('br');
            document.getElementById("button").appendChild(br);
            
            var lbl = document.createElement("label");
            var txtnode = document.createTextNode("Enter New Name for Address Book(" + update_address_book_info[1] + "): ");
            lbl.setAttribute("for", txtnode);
            lbl.appendChild(txtnode);
            document.getElementById("button").appendChild(lbl);
            
            var txt = document.createElement('input');
            txt.type = "text";
            txt.id = "update_name";
            txt.style="margin: 2px;";
            document.getElementById("button").appendChild(txt);
            document.getElementById("update_name").focus();
            
            var br = document.createElement('br');
            document.getElementById("button").appendChild(br);
            
            var br = document.createElement('br');
            document.getElementById("button").appendChild(br);
            
            var btn = document.createElement('input');
            btn.type = "button";
            btn.id = update_address_book_info[1];
            btn.value = "Update";
            btn.setAttribute("onclick", "updateAddressBookName(this.id)");
            document.getElementById("button").appendChild(btn);
        }
    </script>
    <body>
        <center>
            <form action="AddAddressBook" method="post">
                <h1>Address Book Problem</h1>
                <br><br><br>
                <h2>Adding New Address Book</h2>
                <br><br>
                <label> Enter New Address Book: </label>
                <input type="text" name="add_address" placeholder="Enter Name" required="true" />
                <br>
                <hr style="border: none">
                <input type="submit" value="Add Address Book" />
            </form>
            <br><br><br>
            <%
                int table_count=0;
                
                DB db = new DB();
                Connection con = db.getDbCon();
                
                String sql = "SELECT COUNT(*) AS TOTALNUMBEROFTABLES FROM INFORMATION_SCHEMA.TABLES WHERE TABLE_SCHEMA = 'addressbook'";
                PreparedStatement pst = con.prepareStatement(sql); 

                ResultSet rst = pst.executeQuery();

                while(rst.next())
                {
                    table_count=rst.getInt(1);
                }
                if (table_count == 0)
                {
            %>
                    <center><caption><h3>Currently, There are no address books</h3></caption></center>
            <%
                }
                else if (table_count >= 1)
                {        
            %>
                    <center><caption><h2>List of Address Books</h2></caption></center>
                    
                    <style>table, th, td {border: 1px solid black}</style>
                    <div class="center_table" style="height: 130px;overflow: auto">
                        <table class='tbl' style="text-align: center">
                        <tr>
                            <th>Name</th>                            
                            <th colspan="3">Actions</th>
                        </tr>
            <%    
                
                    DatabaseMetaData meta = (DatabaseMetaData) con.getMetaData();

                    ResultSet rs = meta.getTables(null, null, null, new String[] {"TABLE"});

                    while(rs.next())
                    {  
            %>
                        <tr>                                    
                            <td><%= rs.getString("TABLE_NAME")%></td>                                   
                            <td><button id="<%= rs.getString("TABLE_NAME")%>" onclick="viewAddressBook(this.id)">View</button></td>
                            <td><button id="update_<%= rs.getString("TABLE_NAME")%>" onclick="enterNewAddressBookName(this.id)">Update</button></td>
                            <td><button name="<%= rs.getString("TABLE_NAME")%>" onclick="deleteAddressBook(this.name)">Delete</button></td>
                        </tr>
            <%                
                    }
                }
            %>
                        </table>
                    </div>
                    <div id="button" class="center_button">
                        <br><br>                       
                    </div>
        </center>
    </body>
</html>