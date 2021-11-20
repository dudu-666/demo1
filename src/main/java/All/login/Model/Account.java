package All.login.Model;

public class Account {
    private String Uname;
    private String Account;
    private String Upassword;
    public void setUname(String uname) {
        this.Uname = uname;
    }
    public void setUpassword(String upassword) {
        this.Upassword = upassword;
    }
    public void setAccount(String account) {this.Account = account;}
    public String getAccount() {return Account;}
    public String getUname() {
        return Uname;
    }
    public String getUpassword() {
        return Upassword;
    }
}
