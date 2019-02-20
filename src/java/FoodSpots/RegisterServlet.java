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
                out.println("<script>alert('Sorry..Connection cannot Established!!');</script>");
                //out.println("error");
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
               // out.println("<script>alert('Thanku for Registration');</script>");
                response.sendRedirect("Index.php?msg=Thanku for Registration...");
                //out.println("</body></html>");

            } catch (SQLException e) {
//                out.println("<script>alert('Already Registerd User....');</script>");
                response.sendRedirect("Index.php?msg=Already Registerd User!");
                //out.println("Error!!!");
            }
        out.println("</body>");
        out.println("</html>");
         }  
        catch (Exception e) {
        }
    }   

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
