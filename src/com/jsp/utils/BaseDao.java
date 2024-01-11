package com.jsp.utils;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

public class BaseDao {
    /**
     * 先创建一个resources 的文件夹
     * 在把文件夹修改为 资源根文件jquery-3.3.1.js
     * 在创建一个文件  命名为 db.properties
     */
    private  static  String driverName;
    public static  String url;
    public static  String userName;
    public static  String pwd;
    static {
        init();
    }

    private static void init() {
        //创建properties对象
        Properties ps=new Properties();
        //拿到文件路径
        String path="db.properties";
        //通过输入流读取到properties 中的数据
        InputStream is=BaseDao.class.getClassLoader().getResourceAsStream(path);
        try {
            //把读取到的数据添加到 properties对象中
            ps.load(is);
        }catch (Exception e){
            e.printStackTrace();
        }
        //赋值
        driverName= (String) ps.get("db.driverName");
        pwd= (String) ps.get("db.pwd");
        url= (String) ps.get("db.url");
        userName= (String) ps.get("db.userName");
    }
    //建立连接
    public  static Connection getConnection(){
        Connection conn=null;
        try {
            //加载驱动
            Class.forName(driverName);
            //建立连接
            conn= DriverManager.getConnection(url,userName,pwd);
        }catch (Exception e){
            e.printStackTrace();
        }
        return  conn;
    }

    public static void main(String[] args) {
        System.out.println(BaseDao.getConnection());
    }

    //释放资源
    public  static  void closeAll(Connection conn, PreparedStatement psa, ResultSet rs){
        try {
            if(rs!=null){
                rs.close();
            }
            if(psa!=null){
                psa.close();
            }
            if(conn!=null){
                conn.close();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    //sql
    public  static  int executeUpdate(String sql,Object args[]){
        int num=0;
        //定义变量
        Connection conn=null;
        PreparedStatement psa=null;
        try {
            //建立连接
            conn=BaseDao.getConnection();
            //处理预编预
            psa=conn.prepareStatement(sql);
            for(int i=0;i<args.length;i++){
                psa.setObject(i+1,args[i]);
            }
            num=psa.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            BaseDao.closeAll(conn,psa,null);
        }
        return  num;
    }
}
