package All.ShowPage.Controller;

import All.ShowPage.Dao.ShowBookByBname;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.List;

@Controller
public class BookManagementController {
    @RequestMapping(value = "BookManagementController")
    public String BookManagementControl(){
        return "test";
    }
    @RequestMapping(value = "BookManagementShow")
    @ResponseBody
    public List BookManagementShow(){
        ShowBookByBname show=new ShowBookByBname();
        List list=show.GetList();
        return list;
    }
}
