package All.login.Dao;


import All.Dao.SQLHelper;
import All.login.Model.LoginModel;

import java.sql.*;

public class GMLoginDao implements SQLHelper {
    private String LoginAccountName;
    private String Password;
    public GMLoginDao(LoginModel loginModel) {
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
/*建表语句:
create table logindata.UserInformation(
        id int primary key auto_increment,
        Username varchar(20) not null,
        Accountname varchar(20) not null,
        Upassword varchar (20) not null
        )ENGINE=InnoDB DEFAULT CHARSET=utf8;*/
/*插入语句:
INSERT INTO `logindata`.`userinformation`
(`Username`,
`Accountname`,
`Upassword`)
VALUES
('杜梓豪','dudu',123456);
 */
/*更新语句:
UPDATE `logindata`.`userinformation`
SET
`id` = 1,
`Username` = '杜梓豪',
`Accountname` = 'dudu',
`Upassword` = 1234567
WHERE `id` = 1;
 */
/*删除语句:
DELETE FROM `logindata`.`userinformation`
WHERE id=2;
SELECT * FROM logindata.userinformation;DELETE FROM `logindata`.`userinformation`

 */