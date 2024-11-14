import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet
{
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username=req.getParameter("username");
        String password=req.getParameter("password");

        if(username.equals("admin") && password.equals("password"))
        {
            HttpSession session= req.getSession();
            resp.sendRedirect("LoginSuccess.jsp");
        }
        else {
            RequestDispatcher dispatcher= getServletContext().getRequestDispatcher("/login.html");
            PrintWriter out=resp.getWriter();
            out.println("<font color = red> Incorrect Username/password</font>");
            dispatcher.include(req,resp);
        }
    }
}
