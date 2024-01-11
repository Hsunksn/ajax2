package com.jsp.Action;

import com.jsp.ComputerService.ComputerService;
import com.jsp.ComputerService.ComputerServicempl.ComputerServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/delete.do")
public class delete extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //处理编码格式
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        //删除数据 接收前端数据 然后通过id删除
        String sid=req.getParameter("id");
        Integer id=Integer.parseInt(sid);
        //创建业务层
        ComputerService computerService=new ComputerServiceImpl();
        computerService.deleteComputer(id);
        //转
        req.getRequestDispatcher("/All.do").forward(req,resp);
    }
}
