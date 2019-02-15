
package FoodSpots;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class LoginServlet extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet LoginServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            String email=request.getParameter("uname");
            String password=request.getParameter("psw");
            
            String dbDriver = "com.mysql.jdbc.Driver";
            String dbURL = "jdbc:mysql://localhost:3306/";
            String dbName = "foodspots";
            String dbUsername = "root";
            String dbPassword = "";
            try {
                Class.forName(dbDriver);
            } catch (ClassNotFoundException e) {
                out.println("ERRRORR!");
            }

            try {
                Connection con = DriverManager.getConnection(dbURL + dbName,
                        dbUsername,
                        dbPassword);
              
                String sql = "SELECT * from user WHERE ( Email='"+email+"' and Password='"+password+"')";
                
                Statement st = con.createStatement();
                  
                ResultSet rs = st.executeQuery(sql);
                //out.println("hi");
                if(rs.next())
                {
                    response.sendRedirect("single-post.html");
                           
                }
                else
                {
                    response.sendRedirect("Index.php?msg=Invalid Credentials!!");
                }
                // Close all the connections 
                
                st.close();
                con.close();
              

            } catch (SQLException e) {
                out.println("Error!!!");
            }
            out.println("</body>");
            out.println("</html>");
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
        processRequest(request, response);
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
        processRequest(request, response);
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
