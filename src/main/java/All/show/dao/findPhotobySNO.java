package All.show.dao;

import All.show.model.MemberInfo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Arrays;

public class findPhotobySNO implements memberdao {
    public byte[] findBySNO(String sno){
        String sql="select * from `teamwork`.`team`" + "WHERE SNO='" + sno + "';";
        try {
            System.out.println(sql);
            Connection connection = getConnect();//��ȡ����
            Statement stmt = connection.createStatement();//ִ��sql���
            ResultSet rs=stmt.executeQuery(sql);//���ؽ����
///          memberInfo.setPhoto();
            if (rs.first())
                return rs.getBytes("photo");
            return null;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }

    }


    public static void main(String[] args){
        findPhotobySNO f=new findPhotobySNO();
        System.out.println(f.findBySNO("1234567899"));

    }
}
