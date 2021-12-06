package All.ShowBook.Dao;

import All.Dao.SQLHelper;

import java.sql.Connection;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BookingBook implements SQLHelper {
    private String Unum,Bnum;
    public BookingBook(String unum, String bnum) {
        Unum = unum;
        Bnum = bnum;
    }
    private String CreateBookingData(){
        Date BookingData = new Date();
        DateFormat df=new SimpleDateFormat("yyyy-MM-dd");
        return df.format(BookingData);
    }
    private String CreateBookingNum(){
        Date BookingNum = new Date();
        DateFormat df=new SimpleDateFormat("yyyyMMddHHmmss");
        return df.format(BookingNum);
    }
    @Override
    public Connection getConnect() throws ClassNotFoundException {
        return SQLHelper.super.getConnect();
    }
    public void Booking(){
        String sql="INSERT INTO `teamwork`.`bookinglist`" + "(`Booking_Num`,"+"`Unum`," + "`Bnum`," + "`Bookingtime`)" + "VALUES (" +'"' + CreateBookingNum() + '"' + ',' + '"' + Unum + '"' + ',' + '"' + Bnum + '"' + ',' + '"' + CreateBookingData() + '"' +')';
        try {
            Connection connection=getConnect();
            Statement stmt=connection.createStatement();
            stmt.executeUpdate(sql);

        }catch (Exception e){System.out.println(e);}
    }

    /*public static void main(String[] args) {
        BookingBook bookingBook=new BookingBook("001","004");
        bookingBook.Booking();
    }*/
}
