package FoodSpots;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Index extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            RequestDispatcher rd = request.getRequestDispatcher("headlinks.html");
            rd.include(request, response);

//Added this comment
            out.println("<body>");
            rd = request.getRequestDispatcher("header.html");
            rd.include(request, response);

            rd = request.getRequestDispatcher("index.html");
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
