package exercise.servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "HelloServlet", urlPatterns = "/hello")
public class HelloServlet extends HttpServlet {
    // BEGIN

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse res) throws ServletException, IOException {
        String name = request.getParameter("name");
        res.setContentType("text/plain");
        res.getWriter().write("Hello, " + name + "!");
    }
    // END
}
