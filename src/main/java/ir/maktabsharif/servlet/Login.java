package ir.maktabsharif.servlet;

import ir.maktabsharif.db.DataBase;
import ir.maktabsharif.model.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "login", value = "/login")
public class Login extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.println("""
                <!DOCTYPE html>
                <html>
                <body>
                <form method="get" action="/login" >
                    <label>Username</label>
                    <input type="text" name="username" required><br>
                    <label>Password</label>
                    <input type="password" name="password" required><br>
                    <button type="submit">Login</button>
                
                </form>
                </body>
                </html>
                """);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        DataBase.addUser(new User(username, password));
    }
}
