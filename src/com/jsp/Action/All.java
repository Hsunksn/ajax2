package com.jsp.Action;

import com.jsp.ComputerService.ComputerService;
import com.jsp.ComputerService.ComputerServicempl.ComputerServiceImpl;
import com.jsp.Po.Computer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.io.IOException;
import java.util.List;
@WebServlet("/All.do")
public class All extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //处理编码格式
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        //查询所有数据 存起来 显示
        ComputerService computerService=new ComputerServiceImpl();
        List<Computer> list= computerService.queryComputer();
        //存
        req.setAttribute("sbq",list);
        //转
        req.getRequestDispatcher("/All.jsp").forward(req,resp);
    }
}
