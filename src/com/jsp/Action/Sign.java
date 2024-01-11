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
@WebServlet("/Sign.do")
public class Sign extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //处理编码格式
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        //接收数据 添加数据     var userName=document.getElementById("userName").value;
        //            var pwd=document.getElementById("pwd").value;
        //            var id=document.getElementById("id").value;
        //            var cpu=document.getElementById("cpu").value;
        //            var cpuType=document.getElementById("cpuType").value;
        //            var gpu=document.getElementById("gpu").value;
        //            var display=document.getElementById("displaySize").value;
        String userName=req.getParameter("userName");
        String pwd=req.getParameter("pwd");
        String sid=req.getParameter("id");
        Integer id=Integer.parseInt(sid);
        String cpu=req.getParameter("cpu");
        String gpu=req.getParameter("gpu");
        String cpuType=req.getParameter("cpuType");
        String displaySize1=req.getParameter("displaySize");
        Integer displaySize=Integer.parseInt(displaySize1);
        //创建对象
        Computer computer=new Computer();
        computer.setUsername(userName);
        computer.setGpu(gpu);
        computer.setCpu(cpu);
        computer.setId(id);
        computer.setCpuType(cpuType);
        computer.setDisplaySize(displaySize);
        computer.setPassword(pwd);
        //创建业务层
        ComputerService computerService=new ComputerServiceImpl();
        computerService.addComputer(computer);
        //转
        req.getRequestDispatcher("/All.do").forward(req,resp);

    }
}
