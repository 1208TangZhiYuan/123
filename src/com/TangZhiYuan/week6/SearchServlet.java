package com.TangZhiYuan.week6;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/search")
public class SearchServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // 获取参数：输入框文本内容和搜索引擎选择
        String txt = request.getParameter("txt");
        String search = request.getParameter("search");

        // 检查输入框内容是否为空
        if(txt == null || txt.trim().equals("")) {
            // 重定向到首页
            response.sendRedirect("index.jsp"); }
        else {  if(search.equals("baidu")) {  response.sendRedirect("https://www.baidu.com/s?wd=" + txt); }
            else if(search.equals("bing")) {  response.sendRedirect("https://cn.bing.com/search?q=" + txt); } else if(search.equals("google"))
            { response.sendRedirect("https://www.google.com/search?q=" + txt); }
            }
            }
}
