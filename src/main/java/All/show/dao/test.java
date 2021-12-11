package All.show.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class test implements memberdao {
    public byte[] findbysno(String sno){
        String sql="select * from `teamwork`.`team`" + "WHERE SNO='" + sno + "';";
        try{
            Connection connection=getConnect();//获取连接
            Statement stmt=connection.createStatement();//执行sql语句
            ResultSet rs=stmt.executeQuery(sql);//返回结果集
            if(rs.first()){
                return rs.getBytes("photo");
            }
            return null;

        }catch (Exception e){
            System.out.println(e);
            return null;

        }

    }


}
