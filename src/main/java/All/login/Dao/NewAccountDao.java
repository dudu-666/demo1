package All.login.Dao;

import All.Dao.SQLHelper;
import All.login.Model.NewAccountModel;

import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class NewAccountDao implements SQLHelper {
    private NewAccountModel model;
    NewAccountDao(NewAccountModel Mod){
        model=Mod;
    }
    private String CreateNum(){
        Date CreateNum=new Date();
        DateFormat df=new SimpleDateFormat("yyyyMMddHHmmss");
        return df.format(CreateNum);
    }
    @Override
    public Connection getConnect() throws ClassNotFoundException {
        return SQLHelper.super.getConnect();
    }
    public boolean create(String type)throws SQLException, ClassNotFoundException {
        String GM = "gm", User = "user";
        String result = type.equals("GM") ? GM : User;
        String Usersql = "INSERT INTO `teamwork`.`" + result + "`\n" +
                "(`Unum`,\n" +
                "`Loginaccountname`,\n" +
                "`Upassword`,\n" +
                "`Uname`,\n" +
                "`Usex`,\n" +
                "`Uphone`,\n" +
                "`Uemail`)\n" +
                "VALUES\n" +
                "('" + CreateNum() + "','" + model.getLoginaccountname() + "','" + model.getPassWord() + "','" +model.getUserName()+ "','" +model.getSex()+ "','" +model.getPhone()+ "','" +model.getEmail()+ "');";
        String Gmsql =  "INSERT INTO `teamwork`.`" + result + "`\n" +
                "(`Gnum`,\n" +
                "`Loginaccountname`,\n" +
                "`Gpassword`,\n" +
                "`Gname`,\n" +
                "`Gsex`,\n" +
                "`Gphone`,\n" +
                "`Gemail`)\n" +
                "VALUES\n" +
                "('" + CreateNum() + "','" + model.getLoginaccountname() + "','" + model.getPassWord() + "','" +model.getUserName()+ "','" +model.getSex()+ "','" +model.getPhone()+ "','" +model.getEmail()+ "');";
        String sql= type.equals("GM") ? Gmsql : Usersql;
        ResultSet rs = getConnect().createStatement().executeQuery("select * from teamwork." + result + "where `Loginaccountname` =" + "'" + model.getLoginaccountname() + "';");
        if (rs.next()) {
            return false;
        } else {
            if (getConnect().createStatement().executeUpdate(sql)==1) {
                return true;
            }else {
                return false;
            }
        }
    }
}
