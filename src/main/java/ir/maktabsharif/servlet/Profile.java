package ir.maktabsharif.servlet;

import ir.maktabsharif.db.DataBase;
import ir.maktabsharif.model.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import javax.xml.crypto.Data;
import java.io.IOException;
import java.io.PrintWriter;
@WebServlet(name = "profile" , urlPatterns = "/profile")
public class Profile extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("""
                <html>
                 <body>
                 <h2>user's Info</h2>
                """);
        for (User u : DataBase.getUsers()) {
            out.println(u);
        }

    }
}
