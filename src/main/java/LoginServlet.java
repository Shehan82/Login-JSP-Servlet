import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;


@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
        String userName = req.getParameter("userName");
        String password = req.getParameter("password");

        UserCredentialsModel credentials = new UserCredentialsModel(userName, password);

        LoginDAO user = new LoginDAO();
        try {
            int userType = user.getUserType(credentials);
            if(userType == 1)
            {
                res.sendRedirect("admin.html");
            }
            else
            {
                res.sendRedirect("students.html");
            }
            res.getWriter().println(userType);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


    }
}


