package All.login.Dao;


import All.login.Model.Account;

import java.sql.*;

public class GMLoginModel {
    private String Uname;
    private String Upassword;
    private String Account;

    public GMLoginModel(Account account) {
        this.Uname = account.getUname();
        this.Upassword = account.getUpassword();
        this.Account = account.getAccount();
    }
    public Connection Getconnect() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con;
        String url = "jdbc:mysql://localhost:3306/logindata?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true&useSSL=false";        String user = "root";
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
            if (Uname.equals(s1) && Upassword.equals(s2) && Account.equals(s3)) {
                rs.close();
                stmt.close();
                connection.close();
                return 1;
            }
        }
        return 0;

    }
    public int NewAccount() throws SQLException, ClassNotFoundException {
        int flag = 0;
        Connection con = Getconnect();
        Statement stmt = con.createStatement();
        String url = "INSERT INTO usetest\n" + "(`Uname`,`Upassword`)\n" + "VALUES\n" + "('" + Uname + "','" + Upassword + "');";
        try {
            stmt.executeUpdate(url);
            flag = 1;
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            stmt.close();
            con.close();
        }
        return flag;
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