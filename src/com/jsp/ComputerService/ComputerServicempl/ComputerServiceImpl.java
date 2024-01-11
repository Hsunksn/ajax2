package com.jsp.ComputerService.ComputerServicempl;

import com.jsp.ComputerDao.ComputerDao;
import com.jsp.ComputerDao.ComputerDaoImpl;
import com.jsp.ComputerService.ComputerService;
import com.jsp.Po.Computer;
import com.jsp.utils.PageInfo;

import java.util.List;

public class ComputerServiceImpl implements ComputerService {
    ComputerDao computerDao=new ComputerDaoImpl();

    @Override
    public int addComputer(Computer computer) {
        return computerDao.addComputer(computer);
    }

    @Override
    public int deleteComputer(int id) {
        return computerDao.deleteComputer(id);
    }

    @Override
    public int updateComputer(Computer computer) {
        return computerDao.updateComputer(computer);
    }

    @Override
    public List<Computer> queryComputer() {
        return computerDao.queryComputer();
    }

    @Override
    public Computer queryById(int id) {
        return computerDao.queryById(id);
    }

    @Override
    public Computer login(String userName, String pwd) {
        return computerDao.login(userName,pwd);
    }

    @Override
    public int getTotalCount(Computer computer) {
        return computerDao.getTotalCount(computer);
    }

    @Override
    public List<Computer> pageQueryUser(PageInfo pageInfo, Computer computer) {
        return computerDao.pageQueryUser(pageInfo,computer);
    }

    @Override
    public Computer ajax(String username) {
        return computerDao.ajax(username);
    }
}
