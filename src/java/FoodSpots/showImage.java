package FoodSpots;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "showImage", urlPatterns = {"/showImage"})
public class showImage extends HttpServlet {

    public static Connection getMySqlConnection() throws Exception {
        String dbURL = "jdbc:mysql://localhost:3306/itemimage";
	String dbUser = "root";
	String dbPass = "";
        DriverManager.registerDriver(new com.mysql.jdbc.Driver());
        Connection conn = DriverManager.getConnection(dbURL, dbUser, dbPass);
        return conn;
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try (ServletOutputStream out2 = response.getOutputStream()) {
            Blob photo = null;
            Connection conn = null;
            Statement stmt = null;
            ResultSet rs = null;
            String query = "select * from itemimage;";
            try {
                conn = getMySqlConnection();
            } catch (Exception e) {
                out2.println("Conn Errorr!");
            }
            try {
                stmt = conn.createStatement();
                rs = stmt.executeQuery(query);

                if (rs.next()) {
                    photo = rs.getBlob("image");
                    
                    response.setContentType("image/jpg");
                    try {
                        InputStream in = photo.getBinaryStream();
                        int length = (int) photo.length();
                        int bufferSize = 1024;
                        byte[] buffer = new byte[bufferSize];

                        while ((length = in.read(buffer)) != -1) {
                            out2.write(buffer, 0, length);
                        }
                        in.close();
                        out2.flush();
                    } catch (ExceptionInInitializerError e) {
                        out2.println(e.getMessage());
                    }
                } else {
                    out2.println("No Image!");
                }
            } catch (Exception e) {
                out2.println("Query Error!!");
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
