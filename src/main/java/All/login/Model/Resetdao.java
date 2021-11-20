package All.login.Model;

public class Resetdao {
    private String Uname;
    private String Upassword1;
    private String Upassword2;
    private int Checknum;

    public void setUname(String uname) {
        this.Uname = uname;
    }

    public void setChecknum(int checknum) {
        Checknum = checknum;
    }

    public int getChecknum() {
        return Checknum;
    }

    public String getUname() {
        return Uname;
    }

    public void setUpassword1(String upassword1) {
        Upassword1 = upassword1;
    }

    public void setUpassword2(String upassword2) {
        Upassword2 = upassword2;
    }

    public String getUpassword1() {
        return Upassword1;
    }

    public String getUpassword2() {
        return Upassword2;
    }
}
