package com.jsp.Action;

import com.jsp.ComputerService.ComputerService;
import com.jsp.ComputerService.ComputerServicempl.ComputerServiceImpl;
import com.jsp.Po.Computer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
@WebServlet("/login.do")
public class login extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //处理编码格式
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        //登陆  验证前端数据
        String username=req.getParameter("userName");
        String pwd=req.getParameter("pwd");
        PrintWriter out=resp.getWriter();
        //创建业务层
        ComputerService computerService=new ComputerServiceImpl();
        //调用方法
         Computer  computer=computerService.login(username,pwd);
         //判断
        if (computer == null) {
            out.println("登陆失败");
        }else {
            req.getRequestDispatcher("/All.do").forward(req,resp);
        }
    }
}
