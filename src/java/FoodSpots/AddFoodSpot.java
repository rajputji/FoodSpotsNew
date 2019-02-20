
package FoodSpots;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class AddFoodSpot extends HttpServlet {

  
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            RequestDispatcher rd = request.getRequestDispatcher("headlinks.html");
            rd.include(request, response);

            out.println("<body>");
           
            rd = request.getRequestDispatcher("header.html");
            rd.include(request, response);
            
             rd = request.getRequestDispatcher("headlinks.html");
            rd.include(request, response);
            
            
            rd = request.getRequestDispatcher("AddFoodSpot.html");
            rd.include(request, response);

            rd = request.getRequestDispatcher("footer.html");
            rd.include(request, response);

            rd = request.getRequestDispatcher("footlinks.html");
            rd.include(request, response);
            
            String msg = request.getParameter("msg");
            if (msg != null || msg == "") {
                out.println("<script>alert('" + msg + "')</script>");
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