package All.login.Model;

import All.login.Dao.AESUtil;

public class NewAccountModel {
    private String UserName;
    private String Email;
    private String PassWord;
    private String Sex;
    private String Phone;
    private String Loginaccountname;
    public String getPhone() {
        return Phone;
    }
    public void setPhone(String phone) {
        Phone = phone;
    }
    public String getLoginaccountname() {
        return Loginaccountname;
    }
    public String getUserName() {
        return UserName;
    }
    public void setUserName(String userName) {
        UserName = userName;
    }
    public String getEmail() {
        return Email;
    }
    public void setEmail(String email) {
        Email = email;
        Loginaccountname=email;
    }
    public String getPassWord() {
        return PassWord;
    }
    public void setPassWord(String passWord) {
        AESUtil aesUtil=new AESUtil();
        try {
            PassWord=aesUtil.encryptByAES(FirstSet(passWord));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private String FirstSet(String passWord) {
        if(passWord.length()!=16) {
            StringBuilder str=new StringBuilder(passWord);
            while (str.length()!=16){
                str.append(" ");
            }
            return str.toString();
        }else {
            return passWord;
        }
    }
    public String getSex() {
        return Sex;
    }
    public void setSex(String sex) {
        Sex = sex;
    }
}
