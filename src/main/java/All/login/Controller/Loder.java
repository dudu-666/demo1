package All.login.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Loder {
    @RequestMapping(path ="Login")
    public String Login(){
        return "Login";
    }
    @RequestMapping(path = "UserLogin" )
    public String UserLogin(){
        return "UserLogin";
    }
    @RequestMapping(path = "ResetPassword")
    public String ResetPassword(){
        return "ResetPassword";
    }
    @RequestMapping(path = "GMLogin")
    public String GMLogin(){
        return "GMLogin";
    }
    @RequestMapping(path = "NewAccount" )
    public String NewAccount(){
        return "NewAccount(1)";
    }
}
