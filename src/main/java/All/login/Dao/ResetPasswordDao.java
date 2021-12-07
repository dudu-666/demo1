package All.login.Dao;

import All.Dao.ToolHelper;

import java.sql.*;

public class ResetPasswordDao {
    private String Uname;
    private String Upassword;
    public ResetPasswordDao(){}

    public void setUname(String uname) {
        Uname = uname;
    }

    public void setUpassword(String upassword) {
        Upassword = upassword;
    }
    public int GetID()throws SQLException, ClassNotFoundException{
        int flag=0;
        Connection connection = ToolHelper.getConnect();
        Statement stmt = connection.createStatement();
        String url = "Select *from userInformation";
        ResultSet rs = stmt.executeQuery(url);
        while (rs.next()) {
            String s1 = rs.getString("Username");
            flag=rs.getInt("id");
            if (Uname.equals(s1)) {
                rs.close();
                stmt.close();
                connection.close();
                return flag;
            }
        }
        return flag;

    }
    public int Reset() throws SQLException, ClassNotFoundException {
        Connection connection = ToolHelper.getConnect();
        int flag=GetID();
        Statement stmt = connection.createStatement();
        String url = "UPDATE `logindata`.`userinformation`\n" +
                "SET\n" +
                "`Upassword` = "+Upassword+"\n" +
                "WHERE `id` = "+flag+";";
        int flag1=stmt.executeUpdate(url);
        if(flag1!=0){
            return 1;
        }
        return 0;

    }

}
