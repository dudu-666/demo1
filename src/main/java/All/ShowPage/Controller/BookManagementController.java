package All.ShowPage.Controller;

import All.ShowPage.Dao.ShowBookByBname;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class BookManagementController {
    @RequestMapping(value = "BookManagementController")
    public String BookManagementControl(){
        return "test2";
    }
    @RequestMapping(value = "BookManagementShow")
    @ResponseBody
    public Map<String,Object> BookManagementShow(){
        ShowBookByBname show=new ShowBookByBname();
        Map<String,Object> map=new HashMap<>();
        map.put("BookList",show.GetList());
        return map;
    }
}
