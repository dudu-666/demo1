package All.ShowPage.Dao;
import java.sql.Connection;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
public class AddBookBorrowRecords implements BookDao{
    /*private UserInformation userInformation=new UserInformation();
    private BookInformation bookInformation=new BookInformation();
    AddBookBorrowRecords(UserInformation userInformation_1,BookInformation bookInformation_1){
        userInformation.SetUserInformation(userInformation_1);
        bookInformation.SetBookInformation(bookInformation_1);
    }*///对象传参
    private String Usernum;          //直接传参
    private String Booknum;
    private String Cordnum="002";
    private Date Nowdate = new Date();
    private String Cordingtime;
    private boolean Isreturn = false;
    private DateFormat df1 = new SimpleDateFormat("yyyy-MM-dd");
    private DateFormat df2=new SimpleDateFormat("yyyyMMddHHmmss");
    AddBookBorrowRecords(String usernum, String booknum) {
        this.Usernum = usernum;
        this.Booknum = booknum;
        CordingtimeCreate();
        CordnumCreate();
    }
    public void CordingtimeCreate(){
        Cordingtime=df1.format(Nowdate);
    }
    public void CordnumCreate(){
        Cordnum=df2.format(Nowdate);
    }
    public void AddRecords(){
        String sql="INSERT INTO `teamwork`.`borrowing_records`" + "(`Cordnum`," + "`Unum`," + "`Bnum`," + "`Cordingtime`," + "`Isreturn`) VALUES ("+'"'+Cordnum+'"'+','+'"'+Usernum+'"'+','+'"'+Booknum+'"'+','+'"'+Cordingtime+'"'+','+Isreturn+')';
        try {
            Connection connection=getConnect();
            Statement stmt=connection.createStatement();
            stmt.executeUpdate(sql);
            DataUpdate("Add");
        }catch (Exception e){System.out.println(e);}
    }
    public void DataUpdate(String type){
        boolean func=true;
        if(type.equals("Add")){
            func=true;
        }
        if(type.equals("Delete")){
            func=false;
        }
        String sql="UPDATE `teamwork`.`booklist` SET"+"`IsBorrowed`= "+func+" Where `Bnum`="+'"'+Booknum+'"';
        try {System.out.println(sql);
            Connection connection = getConnect();
            Statement stmt = connection.createStatement();
            stmt.executeUpdate(sql);
        }catch (Exception e){System.out.println(e);}
    }
    public void DeleteRecords(){
        String sql="DELETE FROM `teamwork`.`borrowing_records`" + "WHERE `Unum`="+Usernum+" and `Bum`="+Booknum;
        System.out.println(sql);
        DataUpdate("Delete");
    }
    public static void main(String[] args) {
        AddBookBorrowRecords addBookBorrowRecords=new AddBookBorrowRecords("001","005");
        addBookBorrowRecords.DeleteRecords();
    }
}
