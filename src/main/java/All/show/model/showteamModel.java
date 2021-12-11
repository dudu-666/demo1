package All.show.model;

import All.show.dao.team;

import java.nio.channels.ClosedSelectorException;
import java.sql.*;
import java.util.List;

public class showteamModel {
    private String SNO;
    private String SName;
    private String Sgrade;
    private String Ssex;
    private String SPrize;

    public showteamModel(team team)
    {
        this.SNO=team.getSNO();
        this.SName=team.getSName();
        this.Sgrade=team.getSgrade();
        this.Ssex=team.getSsex();
        this.SPrize=team.getSPrize();
    }

    public Connection Getconnect() throws SQLException,ClassNotFoundException{
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con;
        String url="jdbc:mysql://localhost:3306/teamwork?useSSl=false&serverTimeZone=UTC";
        String user="root";
        String password="root";
        con= DriverManager.getConnection(url,user,password);
        return con;
    }

    public int show() throws SQLException, ClosedSelectorException, ClassNotFoundException {
        Connection connection = Getconnect();
        Statement stmt = connection.createStatement();
        String url = "Select *from team";
        ResultSet rs = stmt.executeQuery(url);
        while (rs.next()) {
            String s1=rs.getString("SNO");
            String s2=rs.getString("SName");
            String s3=rs.getString("Sgrade");
            String s4=rs.getString("Ssex");
            String s5=rs.getString("SPrize");

        }
        return 0;
    }


}
