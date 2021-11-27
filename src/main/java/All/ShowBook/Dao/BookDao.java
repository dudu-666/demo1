package All.ShowBook.Dao;

import java.sql.Connection;
import java.sql.DriverManager;

public interface BookDao {
    default Connection getConnect() throws ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = null;
        String url = "jdbc:mysql://localhost:3306/teamwork?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true&useSSL=false&useUnicode=true&characterEncoding=GBK";
        String user = "dudu";
        String password = "dudu";
        try {
            con = DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            System.out.println(e);
        }
        return con;
    }
}
