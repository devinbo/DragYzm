package com.yzm.servlet;

import com.alibaba.fastjson.JSON;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by xinghb on 2017/12/15.
 */
public class CheckServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String point = request.getParameter("point");
        Integer location_x = (Integer) request.getSession().getAttribute("location_x");
        if ((Integer.valueOf(point) < location_x + 4) && (Integer.valueOf(point) > location_x - 4)) {
            //说明验证通过，
            outData(response, "success");
        } else {
            outData(response, "error");
        }
    }

    private void outData(HttpServletResponse response, Object data) throws IOException {
        PrintWriter out = response.getWriter();
        try {
            out = response.getWriter();
            response.setContentType("application/json-rpc;charset=UTF-8");
            out.println(JSON.toJSONString(data));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(out != null) {
                out.close();
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
