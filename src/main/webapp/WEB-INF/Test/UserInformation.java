package All.Model;
import java.*;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;

public class UserInformation {
    private String Unum;
    private String Uloginaccountname;
    private String Upassword;
    private String Uname;
    private String Usex;
    public UserInformation(){Unum="";Uloginaccountname="";Upassword="";Uname="";Usex="";};
    public String getUemail() {
        return Uemail;
    }
    public void setUemail(String uemail) throws UnsupportedEncodingException {
        Uemail = new String(uemail.getBytes(StandardCharsets.UTF_8), StandardCharsets.UTF_8);
    }
    public String getUphone() {
        return Uphone;
    }
    public void setUphone(String uphone) {
        Uphone = new String(uphone.getBytes(StandardCharsets.UTF_8), StandardCharsets.UTF_8);
    }
    public String getUsex() {
        return Usex;
    }
    public void setUsex(String usex) {
        Usex = new String(usex.getBytes(StandardCharsets.UTF_8), StandardCharsets.UTF_8);
    }
    public String getUname() {
        return Uname;
    }
    public void setUname(String uname) {
        Uname = new String(uname.getBytes(StandardCharsets.UTF_8), StandardCharsets.UTF_8);
    }
    private String Uphone;
    public String getUpassword() {
        return Upassword;
    }
    public void setUpassword(String upassword) {
        Upassword = new String(upassword.getBytes(StandardCharsets.UTF_8), StandardCharsets.UTF_8);
    }
    public String getUloginaccountname() {
        return Uloginaccountname;
    }
    public void setUloginaccountname(String uloginaccountname) {
        Uloginaccountname = new String(uloginaccountname.getBytes(StandardCharsets.UTF_8), StandardCharsets.UTF_8);
    }
    private String Uemail;
    public String getUnum() {
        return Unum;
    }
    public void setUnum(String unum) {
        Unum = new String(unum.getBytes(StandardCharsets.UTF_8), StandardCharsets.UTF_8);
    }
    public void SetUserInformation(UserInformation userInformation){
        this.Unum=userInformation.getUnum();
        this.Uname=userInformation.getUname();
        this.Uloginaccountname=userInformation.getUloginaccountname();
        this.Upassword=userInformation.getUpassword();
        this.Usex=userInformation.getUsex();
    }
}
