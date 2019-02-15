package FoodSpots;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegisterServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet RegisterServlet</title>");
            out.println("</head>");
            out.println("<body>");
            String name = request.getParameter("Username");
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            // String cfmpassword = request.getParameter("cfmpassword");
            String mobno = request.getParameter("mobno");
            String gender = request.getParameter("gender");

//            out.println(name);
//            out.println(email);
//            out.println(password);
//            out.println(cfmpassword);
//            out.println(gender);
//            out.println(mobno);
            String dbDriver = "com.mysql.jdbc.Driver";
            String dbURL = "jdbc:mysql://localhost:3306/";
            // Database name to access 
            String dbName = "foodspots";
            String dbUsername = "root";
            String dbPassword = "";

            //int count=100;
            try {
                Class.forName(dbDriver);
            } catch (ClassNotFoundException e) {
                out.println("error");
            }
            try {
                Connection con = DriverManager.getConnection(dbURL + dbName,
                        dbUsername,
                        dbPassword);
                String sql = "INSERT INTO USER (Password,Name,Gender,MobNo,Email) VALUES('" + password + "', '" + name + "', '" + gender + "', '" + mobno + "', '" + email + "')";
                Statement st = con.createStatement();
                st.execute(sql);

                // Close all the connections 
                st.close();
                con.close();
                response.sendRedirect("index.html");
                out.println("</body></html>");

            } catch (SQLException e) {
                out.println("Error!!!");
            }
        } catch (Exception e) {
        }
        //out.println("</body>");
        //out.println("</html>");
    }

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
