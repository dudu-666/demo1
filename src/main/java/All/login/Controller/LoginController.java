package All.login.Controller;

import All.login.Model.NewAccountModel;
import All.login.Dao.GMLoginDao;
import All.login.Model.LoginModel;
import All.login.Dao.UserLoginDao;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.sql.SQLException;

@Controller
public class LoginController {
    @RequestMapping(value = "GMLoginController",method = RequestMethod.POST)
    public String GMLogin(LoginModel loginModel) {
        GMLoginDao loginDao = new GMLoginDao(loginModel);
        try {
            if (loginDao.Login()) {
                return "MainPage";
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return "GMLogin";
    }
    @RequestMapping(value = "UserLoginController",method = RequestMethod.POST)
    public String UserLogin(LoginModel loginModel){
        UserLoginDao userLoginDao =new UserLoginDao(loginModel);
        try {
            if (userLoginDao.Login()) {
                return "MainPage";
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return "UserLogin";
    }
    @RequestMapping(value = "Back")
    public String Back(){
        return "MainPage";
    }
    /*@RequestMapping(value = "ResetController",method = RequestMethod.POST)
    public String Reset(Resetdao resetdao){
        ResetPasswordDao resetPasswordModel=new ResetPasswordDao();
        resetPasswordModel.setUname(resetdao.getUname());
        resetPasswordModel.setUpassword(resetdao.getUpassword1());
        if(resetdao.getChecknum()%2==0){
            if(resetdao.getUpassword1().equals(resetdao.getUpassword2())) {
                try {
                    if(resetPasswordModel.Reset()==1)
                        return "Login";
                } catch (SQLException | ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }else System.out.println(resetdao.getUpassword1().equals(resetdao.getUpassword2()));
        }else System.out.println(resetdao.getChecknum()%2);
        return "ResetPassword";
    }*/
    @RequestMapping(value = "NewAccountController",method = RequestMethod.POST)
    public String NewAccount(NewAccountModel account){
        /*NewAccountDao newAccountModel=new NewAccountDao();
        newAccountModel.setUname(account.getUname());
        newAccountModel.setAccount(account.getAccount());
        if(account.getUpassword1().equals(account.getUpassword2())) {
            newAccountModel.setUpassword(account.getUpassword1());
            try {
                if(newAccountModel.create()==1)
                    return "Login";
            } catch (SQLException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }*/
        return "ResetPassword";
    }
}
