package All.ShowBook.Dao;

import All.Model.BookInformation;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;

public class ShowBookByBname implements BookDao{
    private BookInformation[]BnameList;
    private List<BookInformation> bl=new ArrayList<>() ;
    public int getCount(){
        int count=0;
        ResultSet rs;
        String sql="Select count(*) as totalCount from teamwork.booklist";
        try {
            Connection connection=getConnect();
            Statement stmt=connection.createStatement();
            rs= stmt.executeQuery(sql);
            if(rs.next()){
                count=rs.getInt("totalCount");
            }
        }catch (Exception e){System.out.println(e);}
        return count;
    }
    public BookInformation[] GetArray(){
        BookInformation BookInformation=new BookInformation();
        ResultSet rs;
        int count=0;
        BnameList=new BookInformation[getCount()];
        String sql="Select * from teamwork.booklist";
        try {
            Connection connection=getConnect();
            Statement stmt=connection.createStatement();
            rs=stmt.executeQuery(sql);
            while(rs.next()){
                BnameList[count]=new BookInformation();
                BookInformation.setBnum(rs.getString("Bnum"));
                BookInformation.setBname(rs.getString("Bname"));
                BookInformation.setBauthor(rs.getString("Bauthor"));
                BookInformation.setBpublichouse(rs.getString("Bpublichouse"));
                BookInformation.setBDetail(rs.getString("Bdetail"));
                BookInformation.setBorrowed(rs.getBoolean("IsBorrowed"));
                BnameList[count].SetBookInformation(BookInformation);
                count++;
                System.out.println(count);
            }
        }catch (Exception e){System.out.println(e);}
        return BnameList;
    }
    public List<BookInformation> GetList(){
        ResultSet rs;
        String sql="Select * from teamwork.booklist";
        try {
            Connection connection=getConnect();
            Statement stmt=connection.createStatement(ResultSet.TYPE_FORWARD_ONLY,ResultSet.CONCUR_READ_ONLY);
            rs=stmt.executeQuery(sql);
            while(rs.next()){
                BookInformation BookInformation=new BookInformation();
                BookInformation.setBnum(rs.getString("Bnum"));
                BookInformation.setBname(rs.getString("Bname"));
                BookInformation.setBauthor(rs.getString("Bauthor"));
                BookInformation.setBpublichouse(rs.getString("Bpublichouse"));
                BookInformation.setBDetail(rs.getString("Bdetail"));
                BookInformation.setBorrowed(rs.getBoolean("IsBorrowed"));
                bl.add(BookInformation);
            }
        }catch (Exception e){System.out.println(e);}
        return bl;
    }

   public static void main(String[] args) {
        ShowBookByBname showBookByBname=new ShowBookByBname();
                            System.out.println(showBookByBname.getCount());        //测试读取表行数;
        BookInformation bookInformation=new BookInformation();
        List<BookInformation> bookInformationList;
        bookInformationList=showBookByBname.GetList();
                   //for(int i=0;i<=bookInformationList.length-1;i++){            //测试返回对象数组是否正常
                     //       bookInformation.SetBookInformation(bookInformationList[i]);
                       //     System.out.println(bookInformation.getBnum()+bookInformation.getBname()+bookInformation.getBauthor()+bookInformation.getBpublichouse()+bookInformation.getDetail());
                        //}
       System.out.println(bookInformationList.size());
       Object []res=bookInformationList.toArray();
       System.out.println(res.length);
       for (Object re : res) {
           System.out.println(re.toString());
       }
       BookInformation[] ba= showBookByBname.GetArray();
       for(BookInformation bb:ba){
           System.out.println(bb.toString());
       }
    }

}
