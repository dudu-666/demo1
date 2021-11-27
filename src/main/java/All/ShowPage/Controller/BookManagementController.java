package All.ShowPage.Controller;

import All.Model.BookInformation;
import All.ShowPage.Dao.ShowBookByBname;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class BookManagementController {
    @RequestMapping(value = "BookManagementController")
    public String BookManagementControl(){
        return "test1";
    }
    @RequestMapping(value = "TeamWorkShowController")
    public String TeamWorkShowController(){
        return "tushu";
    }
    @RequestMapping(value = "BookManagementShow", method = RequestMethod.POST)
    @ResponseBody
    public List Show(){
        ShowBookByBname show=new ShowBookByBname();
        return show.GetList();
    }
}
