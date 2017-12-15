package com.yzm.servlet;

import com.alibaba.fastjson.JSON;
import com.yzm.utils.DragYzm;
import org.apache.commons.lang.StringUtils;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

/**
 * Created by xinghb on 2017/12/15.
 */
public class YzmServlet extends HttpServlet {

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        DragYzm.init(config.getServletContext());
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String imgname = request.getParameter("imgname");
        if(!StringUtils.isEmpty(imgname)) {
            imgname = imgname.substring(imgname.lastIndexOf("/")+1, imgname.lastIndexOf("png")+3);
        }
        PrintWriter out = null;
        try {
            DragYzm resourImg = new DragYzm();
            Map<String, String> result = resourImg.create(request, imgname);
            out = response.getWriter();
            response.setContentType("application/json-rpc;charset=UTF-8");
            out.println(JSON.toJSONString(result));
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
