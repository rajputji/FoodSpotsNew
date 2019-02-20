package FoodSpots;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "User", urlPatterns = {"/User"})
public class User extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            RequestDispatcher rd = request.getRequestDispatcher("headlinks.html");
            rd.include(request, response);

            out.println("<body>");
            
            rd = request.getRequestDispatcher("header2.html");
            rd.include(request, response);

            rd = request.getRequestDispatcher("userProfile/user.html");
            rd.include(request, response);

            rd = request.getRequestDispatcher("footer.html");
            rd.include(request, response);

            rd = request.getRequestDispatcher("footlinks.html");
            rd.include(request, response);

            out.println("</body>");
            out.println("</html>");
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
}
