package com.TangZhiYuan.week5;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.ServletException;


@WebServlet(name = "LoginServlet", value = "/Login")


public class LoginServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

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

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {


        // 获取上下文参数
        String driver = getServletContext().getInitParameter("DRIVER");
        String url = getServletContext().getInitParameter("URL");
        String username = getServletContext().getInitParameter("USERNAME");
        String password = getServletContext().getInitParameter("PASSWORD");

        // 获取请求参数
        String usernameParam = request.getParameter("username");
        String passwordParam = request.getParameter("password");

        try {
            // 获取JDBC连接
            Class.forName(driver);
            Connection connection = DriverManager.getConnection(url, username, password);

            // 验证用户
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM USERTABLE WHERE USERNAME=? AND PASSWORD=?");
            statement.setString(1, usernameParam);
            statement.setString(2, passwordParam);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                // 用户名和密码验证成功
                response.setContentType("text/html");
                PrintWriter out = response.getWriter();
                out.println("LOGIN SUCCESS!!!");
                out.print("WELCOME, " + usernameParam);
            } else {
                // 用户名和密码验证失败
                response.setContentType("text/html");
                PrintWriter out = response.getWriter();
                out.println("LOGIN ERROR!!!");
            }

            connection.close();



