package All.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public interface ToolHelper {
    static Connection getConnect() throws ClassNotFoundException {
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
    static String CreateTimeNum(String Type){
        //Type指的是需要什么返回值   num为数字字符串   date指的是返回日期字符串
        Date CreateTimeNum = new Date();
        DateFormat df1=new SimpleDateFormat("yyyyMMddHHmmss");
        DateFormat df2=new SimpleDateFormat("yyyy-MM-dd HH:mm");
        return Type.toLowerCase(Locale.ROOT).equals("num")?df1.format(CreateTimeNum):df2.format(CreateTimeNum);
    }
}
