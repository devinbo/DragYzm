package com.yzm.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by xinghb on 2017/12/15.
 */
public class LoginServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String username = request.getParameter("username");
//        String password = request.getParameter("password");
        String yzm = request.getParameter("yzm");
        if(request.getSession().getAttribute("location_x") == null) {
            request.setAttribute("msg", "图形验证失败");
            request.getRequestDispatcher("/result").forward(request, response);
            return;
        }
        Integer location_x = (Integer) request.getSession().getAttribute("location_x");
        if ((Integer.valueOf(yzm) < location_x + 4) && (Integer.valueOf(yzm) > location_x - 4)) {
            request.setAttribute("msg", "登录成功");
            request.getRequestDispatcher("/result.jsp").forward(request, response);
        } else {
            request.setAttribute("msg", "图形验证失败");
            request.getRequestDispatcher("/result.jspjsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
