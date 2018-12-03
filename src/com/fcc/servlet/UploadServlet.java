package com.fcc.servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

/**
 * @Description:
 * @Author: CC.F
 * @Date: 17:44 2018/12/3
 */
//urlPatterns = "/upload"必须带/
@WebServlet(urlPatterns = "/upload")
@MultipartConfig(location = "F:\\java_code",maxFileSize = -1L,maxRequestSize = -1L)
public class UploadServlet extends HttpServlet {
    @Override
    public void init() throws ServletException {
    }

    @Override
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        String basePath = this.getServletContext().getRealPath("/");
        Part p=request.getPart("file");
        p.write("F:\\java_code\\"+p.getSubmittedFileName());
    }

    @Override
    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }

    @Override
    public void destroy() {
        super.destroy();
    }

}
