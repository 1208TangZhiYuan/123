package com.TangZhiYuan.week5;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
@WebServlet(name = "LoginServlet", value = "/Login")
public class LoginServlet extends HttpServlet { private static final long serialVersionUID = 1L;
    private Connection conn;
    @Override public void init() throws ServletException { super.init();
         String driver = getServletContext().getInitParameter("DRIVER");
         String url = getServletContext().getInitParameter("URL");
         String username = getServletContext().getInitParameter("USERNAME");
         String password = getServletContext().getInitParameter("PASSWORD");
         try {
             Class.forName(driver);
          conn = DriverManager.getConnection(url, username, password);
         }
         catch (ClassNotFoundException | SQLException e) { e.printStackTrace(); }
    }
    @Override protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String usernameParam = request.getParameter("username");
        String passwordParam = request.getParameter("password");
        try {  PreparedStatement statement = conn.prepareStatement("SELECT * FROM USERTABLE WHERE USERNAME=? AND PASSWORD=?"); statement.setString(1, usernameParam);
            statement.setString(2, passwordParam);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {  response.setContentType("text/html");
                PrintWriter out = response.getWriter();
                out.println("LOGIN SUCCESS!!!");
                out.print("WELCOME, " + usernameParam);
            } else { response.setContentType("text/html");
                PrintWriter out = response.getWriter();
                out.println("LOGIN ERROR!!!");
            }
        }
        catch (SQLException e) { e.printStackTrace();
        }
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

}
