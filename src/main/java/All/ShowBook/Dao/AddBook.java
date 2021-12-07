package All.ShowBook.Dao;

import All.Dao.ToolHelper;
import All.Model.BookInformation;

import java.sql.Connection;
import java.sql.Statement;

class AddBook {
    BookInformation bookInformation;

    AddBook(BookInformation bookInformation) {
        this.bookInformation = bookInformation;
    }

    public static void main(String[] args) {
        BookInformation bookInformation = new BookInformation();
        bookInformation.setBnum("009");
        bookInformation.setBname("测试书10号");
        bookInformation.setBauthor("测试书10号作者");
        bookInformation.setBpublichouse("测试书10号出版社");
        bookInformation.setBDetail("这本书的内容是…………");
        bookInformation.setBorrowed(false);
        System.out.println(bookInformation.getBauthor());
        AddBook addBook = new AddBook(bookInformation);
        addBook.Add();
    }

    public void Add() {
        if (bookInformation != null) {
            try {
                String sql = "INSERT INTO `teamwork`.`booklist`" + "(`Bnum`," + "`Bname`," + "`Bauthor`," + "`Bpublichouse`," + "`Bdetail`," + "`IsBorrowed`)" + "VALUES" + "(" + '"' + bookInformation.getBnum() + '"' + "," + '"' + bookInformation.getBname() + '"' + "," + '"' + bookInformation.getBauthor() + '"' + "," + '"' + bookInformation.getBpublichouse() + '"' + "," + '"' + bookInformation.getBDetail() + '"' + "," + bookInformation.isBorrowed() + ')';
                Connection connection = ToolHelper.getConnect();
                System.out.println(sql);
                Statement stmt = connection.createStatement();
                stmt.executeUpdate(sql);
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }
}
