package All.show.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class test implements memberdao {
    public byte[] findbysno(String sno){
        String sql="select * from `teamwork`.`team`" + "WHERE SNO='" + sno + "';";
        try{
            Connection connection=getConnect();//��ȡ����
            Statement stmt=connection.createStatement();//ִ��sql���
            ResultSet rs=stmt.executeQuery(sql);//���ؽ����
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
