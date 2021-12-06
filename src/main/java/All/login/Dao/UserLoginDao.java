package All.login.Dao;

import All.Dao.SQLHelper;
import All.login.Model.LoginModel;

import java.sql.*;

public class UserLoginDao implements SQLHelper {
    private String LoginAccountName;
    private String Password;
    public UserLoginDao(LoginModel loginModel) {
        this.Password = loginModel.getPassword();
        this.LoginAccountName = loginModel.getLoginAccountName();
    }

    @Override
    public Connection getConnect() throws ClassNotFoundException {
        return SQLHelper.super.getConnect();
    }

    public Boolean Login() throws SQLException, ClassNotFoundException {
        Connection connection = getConnect();
        Statement stmt = connection.createStatement();
        String url = "Select *from teamwork.user where `Uloginaccountname` ="+"'"+LoginAccountName+"'";
        ResultSet rs = stmt.executeQuery(url);
        while (rs.next()) {
            String s2 = rs.getString("Upassword");
            if (Password.equals(s2)) {
                return true;
            }
        }
        return false;

    }

}
