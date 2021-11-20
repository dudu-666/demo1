package All.ShowPage.Dao;
import All.Model.BookInformation;

import java.sql.Connection;
import java.sql.Statement;

class AddBook implements BookDao{
    BookInformation bookInformation;
    AddBook(BookInformation bookInformation){this.bookInformation=bookInformation;}
    public void Add(){
        if(bookInformation != null){
            try {
                String sql="INSERT INTO `teamwork`.`booklist`" + "(`Bnum`," + "`Bname`," + "`Bauthor`," + "`Bpublichouse`," + "`Bdetail`,"+ "`IsBorrowed`)" + "VALUES" + "("+'"'+bookInformation.getBnum()+'"'+","+'"'+bookInformation.getBname()+'"'+","+'"'+bookInformation.getBauthor()+'"'+","+'"'+bookInformation.getBpublichouse()+'"'+","+'"'+bookInformation.getDetail()+'"'+","+bookInformation.isBorrowed()+')';
                Connection connection=getConnect();
                System.out.println(sql);
                Statement stmt=connection.createStatement();
                stmt.executeUpdate(sql);
            }catch (Exception e){
                System.out.println(e);
            }
        }
    }

    public static void main(String[] args) {
        BookInformation bookInformation=new BookInformation();
        bookInformation.setBnum("006");
        bookInformation.setBname("测试书6号");
        bookInformation.setBauthor("测试书6号作者");
        bookInformation.setBpublichouse("测试书6号出版社");
        bookInformation.setDetail("这本书的内容是…………");
        bookInformation.setBorrowed(false);
        System.out.println(bookInformation.getBauthor());
        AddBook addBook=new AddBook(bookInformation);
        addBook.Add();
    }
}
