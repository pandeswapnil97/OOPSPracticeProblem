/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import ConnectDB.DB;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author juile
 */
public class AddUser extends HttpServlet
{

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     * @throws java.sql.SQLException
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException 
    {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter())
        {
            String fname=request.getParameter("fname");
            String lname=request.getParameter("lname");
            String address=request.getParameter("addr");
            String city=request.getParameter("city");
            String state=request.getParameter("state");
            String zip=request.getParameter("zip");
            String phno=request.getParameter("phno");
            String address_book_name = request.getParameter("address_book");
            
            
            out.println(fname);
            out.println("<br>");
            
            
            DB db = new DB();
            Connection con = db.getDbCon();
            
            String sq = "SELECT * FROM " + address_book_name + " WHERE first_name=? AND last_name=? AND address=? AND city=? AND state=? AND zip=? AND phone_number=?";
            PreparedStatement ps = con.prepareStatement(sq); 
            
            ps.setString(1, fname);
            ps.setString(2, lname);
            ps.setString(3, address);
            ps.setString(4, city);
            ps.setString(5, state);
            ps.setString(6, zip);
            ps.setString(7, phno);
            
            
            ResultSet rs = ps.executeQuery();
            
            if(rs.next())
            {               
                out.println("<script type=\"text/javascript\">");
                out.println("alert('User: " + fname + " Already Exists');");
                out.println("location='UserAddressBook.jsp?address_book_name=" + address_book_name + "';");
                out.println("</script>");
            }
            else
            {              
                String sql = "INSERT INTO " + address_book_name + " VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
                PreparedStatement pst = con.prepareStatement(sql);

                pst.setInt(1, 0);
                pst.setString(2, fname);
                pst.setString(3, lname);
                pst.setString(4, address);
                pst.setString(5, city);
                pst.setString(6, state);
                pst.setString(7, zip);
                pst.setString(8, phno);


                pst.executeUpdate();

                out.println("<script type=\"text/javascript\">");
                out.println("alert('User Added Successfully');");
                out.println("location='UserAddressBook.jsp?address_book_name=" + address_book_name + "';");
                out.println("</script>");
            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(AddUser.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(AddUser.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
