package com.jsp.ComputerService;

import com.jsp.Po.Computer;
import com.jsp.utils.PageInfo;

import java.util.List;

public interface ComputerService {
    //增加
    public  int addComputer(Computer computer);
    //删除
    public  int deleteComputer(int id);
    //修改
    public  int  updateComputer(Computer computer);
    //查询
    public  List<Computer> queryComputer();
    //通过id查询
    public Computer queryById(int id);
    //登陆
    public Computer login(String userName, String pwd );
    //查询总条数
    public   int getTotalCount(Computer computer);
    //分页查询
    public  List<Computer> pageQueryUser(PageInfo pageInfo, Computer computer);
    public  Computer  ajax(String username);
}
