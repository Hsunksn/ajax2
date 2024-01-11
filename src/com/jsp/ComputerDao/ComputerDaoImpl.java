package com.jsp.ComputerDao;


import com.jsp.Po.Computer;
import com.jsp.utils.BaseDao;
import com.jsp.utils.PageInfo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ComputerDaoImpl implements ComputerDao {

    @Override
    public int addComputer(Computer computer) {
        String sql = "INSERT INTO Computer (id, username, password, cpu, gpu, cpuType, displaySize) VALUES(?,?,?,?,?,?,?)";
        Object data[] = {computer.getId(), computer.getUsername(), computer.getPassword(), computer.getCpu(), computer.getGpu(), computer.getCpuType(), computer.getDisplaySize()};
        return BaseDao.executeUpdate(sql, data);
    }

    @Override
    public int deleteComputer(int id) {
        String sql = "DELETE FROM Computer WHERE id=?";
        Object data[] = {id};
        return BaseDao.executeUpdate(sql, data);
    }

    @Override
    public int updateComputer(Computer computer) {
        String sql = "UPDATE Computer SET cpu=? ,gpu=? WHERE id=? ";
        Object data[] = {computer.getCpu(), computer.getGpu(), computer.getId()};
        return BaseDao.executeUpdate(sql, data);
    }

    @Override
    public List<Computer> queryComputer() {
        List<Computer> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement psa = null;
        ResultSet rs = null;
        try {
            conn = BaseDao.getConnection();
            String sql = "SELECT * FROM Computer";
            psa = conn.prepareStatement(sql);
            rs = psa.executeQuery();
            while (rs.next()) { // 检查rs.next()的返回值
                Computer computer = new Computer();
                computer.setId(rs.getInt(1));
                computer.setUsername(rs.getString(2));
                computer.setPassword(rs.getString(3));
                computer.setCpu(rs.getString(4));
                computer.setGpu(rs.getString(5));
                computer.setCpuType(rs.getString(6));
                computer.setDisplaySize(rs.getInt(7));
                list.add(computer);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 使用try-with-resources语句自动关闭资源
            try {
                if (rs != null) rs.close();
            } catch (SQLException e) { /* ignored */ }
            try {
                if (psa != null) psa.close();
            } catch (SQLException e) { /* ignored */ }
            try {
                if (conn != null) conn.close();
            } catch (SQLException e) { /* ignored */ }
        }
        return list;
    }

    @Override
    public Computer queryById(int id) {
        Connection conn = null;
        PreparedStatement psa = null;
        ResultSet rs = null;
        Computer computer = null;
        try {
            String sql = "SELECT * FROM Computer WHERE id=?";
            conn = BaseDao.getConnection(); // 获取连接并赋值给conn变量
            psa = conn.prepareStatement(sql);
            psa.setObject(1, id);
            rs = psa.executeQuery();
            if (rs.next()) { // 检查rs.next()的返回值
                computer = new Computer();
                computer.setId(rs.getInt(1));
                computer.setUsername(rs.getString(2));
                computer.setPassword(rs.getString(3));
                computer.setCpu(rs.getString(4));
                computer.setGpu(rs.getString(5));
                computer.setCpuType(rs.getString(6));
                computer.setDisplaySize(rs.getInt(7));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            BaseDao.closeAll(conn, psa, rs);
        }
        return computer; // 如果没有找到匹配的计算机，返回null
    }

    @Override
    public Computer login(String userName, String pwd) {
        Connection conn = BaseDao.getConnection();
        PreparedStatement psa = null;
        ResultSet rs = null;
        Computer computer = null;
        try {
            String sql = "SELECT *FROM Computer  where username=? and password=?";
            psa = conn.prepareStatement(sql);
            psa.setObject(1, userName);
            psa.setObject(2, pwd);
            rs = psa.executeQuery();
            while (rs.next()) {
                computer = new Computer();
                computer.setId(rs.getInt(1));
                computer.setUsername(rs.getString(2));
                computer.setPassword(rs.getString(3));
                computer.setCpu(rs.getString(4));
                computer.setGpu(rs.getString(5));
                computer.setCpuType(rs.getString(6));
                computer.setDisplaySize(rs.getInt(7));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            BaseDao.closeAll(conn, psa, rs);
        }
        return computer;
    }

    @Override
    public int getTotalCount(Computer computer) {
        int i = 0;
        Connection conn = BaseDao.getConnection();
        PreparedStatement psa = null;
        ResultSet rs = null;
        try {
            String sql = "SELECT count(*) FROM Computer";
            psa = conn.prepareStatement(sql);
            rs = psa.executeQuery();
            while (rs.next()) {
                i = rs.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            BaseDao.closeAll(conn, psa, rs);
        }
        return i;
    }

    @Override
    public List<Computer> pageQueryUser(PageInfo pageInfo, Computer computer) {
        List<Computer>list=new ArrayList<>();
        Connection conn=null;
        PreparedStatement psa=null;
        ResultSet rs=null;
        try {
            conn=BaseDao.getConnection();
            String sql="SELECT * FROM Computer  LIMIT ?,? ";
            psa=conn.prepareStatement(sql);
            int begin = (pageInfo.getPageNo()-1)*pageInfo.getPageSize();
            int end = pageInfo.getPageSize();
            psa.setObject(1,begin);
            psa.setObject(2,end);
            rs = psa.executeQuery();
            while (rs.next()){
                Computer computer1 =new Computer();
                computer.setId(rs.getInt(1));
                computer.setUsername(rs.getString(2));
                computer.setPassword(rs.getString(3));
                computer.setCpu(rs.getString(4));
                computer.setGpu(rs.getString(5));
                computer.setCpuType(rs.getString(6));
                computer.setDisplaySize(rs.getInt(7));
                list.add(computer1);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            BaseDao.closeAll(conn,psa,rs);
        }
        return list;
    }

    @Override
    public Computer ajax(String username) {
        Connection conn = null;
        PreparedStatement psa = null;
        ResultSet rs = null;
        Computer computer = null;
        try {
            String sql = "SELECT * FROM Computer WHERE username=?";
            conn = BaseDao.getConnection(); // 获取连接并赋值给conn变量
            psa = conn.prepareStatement(sql);
            psa.setObject(1, username);
            rs = psa.executeQuery();
            if (rs.next()) { // 检查rs.next()的返回值
                computer = new Computer();
                computer.setId(rs.getInt(1));
                computer.setUsername(rs.getString(2));
                computer.setPassword(rs.getString(3));
                computer.setCpu(rs.getString(4));
                computer.setGpu(rs.getString(5));
                computer.setCpuType(rs.getString(6));
                computer.setDisplaySize(rs.getInt(7));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            BaseDao.closeAll(conn, psa, rs);
        }
        return computer; // 如果没有找到匹配的计算机，返回null
    }
}

