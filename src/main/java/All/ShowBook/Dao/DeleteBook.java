package All.ShowBook.Dao;

import All.Dao.ToolHelper;

import java.sql.Connection;
import java.sql.Statement;

public class DeleteBook implements ToolHelper {
    private String Booknum;

    public DeleteBook(String booknum) {
        this.Booknum = booknum;
    }

    public boolean Delete() {
        String sql = "DELETE FROM `teamwork`.`booklist`" + "WHERE Bnum=" + Booknum + ";";
        try {
            Connection connection = ToolHelper.getConnect();
            Statement stmt = connection.createStatement();
            stmt.executeUpdate(sql);
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }
}
