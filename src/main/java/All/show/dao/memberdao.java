package All.show.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public interface memberdao {
    default Connection getConnect()throws ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = null;
        String url = "jdbc:mysql://localhost:3306/teamwork?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT%2B8&useSSL=false";

        String user = "root";
        String password = "dudu";
        try {
            con = DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            System.out.println(e);

        }
        return  con;
    }
}
