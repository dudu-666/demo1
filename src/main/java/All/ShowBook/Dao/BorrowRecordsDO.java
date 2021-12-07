package All.ShowBook.Dao;

import All.Dao.ToolHelper;

import java.sql.Connection;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
public class BorrowRecordsDO implements ToolHelper {
    /*private UserInformation userInformation=new UserInformation();
    private BookInformation bookInformation=new BookInformation();
    BorrowRecordsDO(UserInformation userInformation_1,BookInformation bookInformation_1){
        userInformation.SetUserInformation(userInformation_1);
        bookInformation.SetBookInformation(bookInformation_1);
    }*///对象传参
    private String Usernum;          //直接传参
    private String Booknum;
    private boolean Isreturn = false;
    BorrowRecordsDO(String usernum, String booknum) {
        this.Usernum = usernum;
        this.Booknum = booknum;
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
            Connection connection = ToolHelper.getConnect();
            Statement stmt = connection.createStatement();
            stmt.executeUpdate(sql);
        }catch (Exception e){System.out.println(e);}
    }
    public void AddRecords(){
        String sql="INSERT INTO `teamwork`.`borrowing_records`" + "(`Cordnum`," + "`Unum`," + "`Bnum`," + "`Cordingtime`," + "`Isreturn`) VALUES ("+'"'+ ToolHelper.CreateTimeNum("num") +'"'+','+'"'+Usernum+'"'+','+'"'+Booknum+'"'+','+'"'+ToolHelper.CreateTimeNum("date")+'"'+','+Isreturn+')';
        try {
            Connection connection= ToolHelper.getConnect();
            Statement stmt=connection.createStatement();
            stmt.executeUpdate(sql);
            DataUpdate("Add");
        }catch (Exception e){System.out.println(e);}
    }
    public void DeleteRecords(){
        String sql="DELETE FROM `teamwork`.`borrowing_records`" + "WHERE `Unum`="+Usernum+" and `Bum`="+Booknum;
        System.out.println(sql);
        try {
            Connection connection= ToolHelper.getConnect();
            Statement stmt=connection.createStatement();
            stmt.executeUpdate(sql);
        }catch (Exception e){System.out.println(e);}
        DataUpdate("Delete");
    }
    public static void main(String[] args) {
        BorrowRecordsDO borrowRecordsDO =new BorrowRecordsDO("001","005");
        borrowRecordsDO.DeleteRecords();
    }
}
