package All.ShowPage.Model;

public class BookBorrowRecords {
    private String Usernum;
    private String Bookname;
    private String Cordnum;
    private String Cordingtime;

    private boolean Isreturn = false;

    public boolean isIsreturn() {
        return Isreturn;
    }

    public void setIsreturn(boolean isreturn) {
        Isreturn = isreturn;
    }

    @Override
    public String toString() {
        return "BookBorrowRecords{" +
                "Usernum='" + Usernum + '\'' +
                ", Bookname='" + Bookname + '\'' +
                ", Cordnum='" + Cordnum + '\'' +
                ", Cordingtime='" + Cordingtime + '\'' +
                ", Isreturn=" + Isreturn +
                '}';
    }

    BookBorrowRecords() {
    }

    public String getCordingtime() {
        return Cordingtime;
    }

    public void setCordingtime(String cordingtime) {
        Cordingtime = cordingtime;
    }

    public void SetBookBorrowRecords(BookBorrowRecords bookBorrowRecord) {
        Usernum = bookBorrowRecord.getUsernum();
        Bookname = bookBorrowRecord.getBookname();
        Cordnum = bookBorrowRecord.getCordnum();
        Cordingtime = bookBorrowRecord.getCordingtime();
        Isreturn=bookBorrowRecord.isIsreturn();
    }

    public String getUsernum() {
        return Usernum;
    }

    public void setUsernum(String usernum) {
        Usernum = usernum;
    }

    public String getBookname() {
        return Bookname;
    }

    public void setBookname(String bookname) {
        Bookname = bookname;
    }

    public String getCordnum() {
        return Cordnum;
    }

    public void setCordnum(String cordnum) {
        Cordnum = cordnum;
    }

}
