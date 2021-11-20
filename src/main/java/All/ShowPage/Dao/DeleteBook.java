package All.ShowPage.Dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

class DeleteBook implements BookDao{
    private String Booknum;
    DeleteBook(String booknum){
        this.Booknum=booknum;
    }
    public void Delete(){
        String sql="DELETE FROM `teamwork`.`booklist`" + "WHERE Bnum="+Booknum+";";
        try {
            Connection connection=getConnect();
            Statement stmt=connection.createStatement();
            stmt.executeUpdate(sql);
        }catch (Exception e){System.out.println(e);}
    }
}
