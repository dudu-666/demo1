package All.ShowBook.Dao;

import All.Dao.SQLHelper;

import java.sql.Connection;
import java.sql.Statement;

public class DeleteBook implements SQLHelper {
    private String Booknum;

    public DeleteBook(String booknum) {
        this.Booknum = booknum;
    }

    public void Delete() {
        String sql = "DELETE FROM `teamwork`.`booklist`" + "WHERE Bnum=" + Booknum + ";";
        try {
            Connection connection = getConnect();
            Statement stmt = connection.createStatement();
            stmt.executeUpdate(sql);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
