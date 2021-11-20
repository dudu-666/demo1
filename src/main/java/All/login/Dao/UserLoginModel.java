package All.login.Dao;

import All.login.Model.User;

import java.sql.*;

public class UserLoginModel {
    private String Account;
    private String Upassword;
    public UserLoginModel(User user) {
        this.Upassword = user.getUpassword();
        this.Account = user.getAccount();
    }
    public Connection Getconnect() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con;
        String url = "jdbc:mysql://localhost:3306/logindata?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true&useSSL=false";
        String user = "dudu";
        String password = "dudu";
        con = DriverManager.getConnection(url, user, password);
        return con;
    }
    public int Login() throws SQLException, ClassNotFoundException {
        Connection connection = Getconnect();
        Statement stmt = connection.createStatement();
        String url = "Select *from userInformation";
        ResultSet rs = stmt.executeQuery(url);
        while (rs.next()) {
            String s1 = rs.getString("Username");
            String s2 = rs.getString("Upassword");
            String s3 = rs.getString("Accountname");
            if (Upassword.equals(s2) && Account.equals(s3)) {
                rs.close();
                stmt.close();
                connection.close();
                return 1;
            }
        }
        return 0;

    }

}
