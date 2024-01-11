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
@WebServlet("/update.do")
public class update extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //处理编码格式
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        //接收数据 修改数据
        String sid=req.getParameter("id");
        Integer id=Integer.parseInt(sid);
        String cpu=req.getParameter("cpu");
        String gpu=req.getParameter("gpu");
        //创建对象 存值
        Computer computer=new Computer();
        computer.setId(id);
        computer.setCpu(cpu);
        computer.setGpu(gpu);
        //创建业务层
        ComputerService computerService=new ComputerServiceImpl();
        computerService.updateComputer(computer);
        //转
        req.getRequestDispatcher("/All.do").forward(req,resp);
    }
}
