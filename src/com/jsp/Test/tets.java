package com.jsp.Test;

import com.jsp.ComputerService.ComputerService;
import com.jsp.ComputerService.ComputerServicempl.ComputerServiceImpl;
import com.jsp.Po.Computer;

public class tets {
    public static void main(String[] args) {
        ComputerService computerService=new ComputerServiceImpl();
        Computer computer=computerService.ajax("user1");
        System.out.println(computer);
    }
}
