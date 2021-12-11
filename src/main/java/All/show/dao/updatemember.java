package All.show.dao;

import All.show.model.MemberInfo;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class updatemember implements memberdao {
    private MemberInfo memberInfo;
    public updatemember(MemberInfo memberInfo1){
        memberInfo=memberInfo1;
    }

    @Override
    public Connection getConnect() throws ClassNotFoundException {
        return memberdao.super.getConnect();
    }

    public void Update(){
        String sql="UPDATE `teamwork`.`team` SET\n" +
                "`SNO` = '"+memberInfo.getSNO()+"',\n" +
                "`SPrize` = '"+memberInfo.getSPrize()+"'\n" +
                "WHERE `SNO` = '"+memberInfo.getSNO()+"';";
        try {
            Connection connection = getConnect();
            Statement stmt = connection.createStatement();
            stmt.executeUpdate(sql);
        }catch (Exception e){
            System.out.println(e);
        }
    }
   /* public static void main(String[] args){
        MemberInfo memberInfo=new MemberInfo();
        memberInfo.setSNO("0932543724");
        memberInfo.setSPrize("java");
        updatemember updatemember=new updatemember(memberInfo);
        updatemember.Update();

    }*/

}
