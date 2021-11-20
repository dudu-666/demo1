package All.login.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class NewAccountModel {
    private String Uname;
    private String Upassword;
    private String Account;

    public void setAccount(String account) {
        Account = account;
    }

    public void setUpassword(String upassword) {
        Upassword = upassword;
    }

    public void setUname(String uname) {
        Uname = uname;
    }

    public Connection Getconnect() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con;
        String url = "jdbc:mysql://localhost:3306/teamwork?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true&useSSL=false";        String user = "dudu";
        String password = "dudu";
        con = DriverManager.getConnection(url, user, password);
        return con;
    }
    public int create()throws SQLException, ClassNotFoundException{
        Connection connection = Getconnect();
        Statement stmt = connection.createStatement();
        String url = "INSERT INTO `userinformation`\n" +
                "(`Username`,\n" +
                "`Accountname`,\n" +
                "`Upassword`)\n" +
                "VALUES\n" +
                "('"+Uname+"','"+Account+"',"+Upassword+");";
        if(stmt.executeUpdate(url)==1){
            return 1;
        }
        return 0;
    }

}
