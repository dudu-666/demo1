package All.ShowBook.Dao;

import All.Model.BookInformation;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class BookChange implements BookDao{
    private BookInformation bookInformation;
    public BookChange(BookInformation bookInformation1){
        bookInformation=bookInformation1;
    };
    @Override
    public Connection getConnect() throws ClassNotFoundException {
        return BookDao.super.getConnect();
    }
    public void BookChange(){
        String sql="UPDATE `teamwork`.`booklist` SET\n" +
                "`Bnum` = '"+bookInformation.getBnum()+"',\n" +
                "`Bname` = '"+bookInformation.getBname()+"',\n" +
                "`Bauthor` = '"+bookInformation.getBauthor()+"',\n" +
                "`Bpublichouse` ='"+bookInformation.getBpublichouse()+"',\n" +
                "`Bdetail` = '"+bookInformation.getBDetail()+"',\n" +
                "`IsBorrowed` = "+bookInformation.isBorrowed()+"\n" +
                "WHERE `Bnum` = '"+bookInformation.getBnum()+"';";
        try {
            Connection connection=getConnect();
            Statement stmt=connection.createStatement();
            stmt.executeUpdate(sql);
        }catch (Exception e){System.out.println(e);}
    }

    public static void main(String[] args) {
        BookInformation bookInformation = new BookInformation();
        bookInformation.setBnum("006");
        bookInformation.setBname("测试书7号");
        bookInformation.setBauthor("测试书8号作者");
        bookInformation.setBpublichouse("测试书6号出版社");
        bookInformation.setBDetail("这本书的内容是…………");
        bookInformation.setBorrowed(true);
        BookChange bookChange=new BookChange(bookInformation);
        bookChange.BookChange();
    }
}