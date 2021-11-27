package All.ShowBook.Controller;

import All.Model.BookInformation;
import All.ShowBook.Dao.BookChange;
import All.ShowBook.Dao.DeleteBook;
import All.ShowBook.Dao.ShowBookByBname;
import com.fasterxml.jackson.jaxrs.json.annotation.JSONP;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
public class BookManagementController {
    @RequestMapping(value = "BookManagementController")
    public String BookManagementControl(){
        return "test0";
    }
    @RequestMapping(value = "TeamWorkShowController")
    public String TeamWorkShowController(){
        return "tushu(1)";
    }
    @RequestMapping(value = "BookManagementShow", method = RequestMethod.POST)
    @ResponseBody
    public List Show(){
        ShowBookByBname show=new ShowBookByBname();
        return show.GetList();
    }
    @RequestMapping(value = "BookManagementDelete", method = RequestMethod.GET)
    public void Delete(HttpServletRequest request, HttpServletResponse response){
        new DeleteBook(request.getParameter("id")).Delete();
        System.out.println(request.getParameter("id"));
        response.setStatus(200);
    }
    @RequestMapping(value = "BookManagementChange" ,method = RequestMethod.POST)
    @ResponseBody
    public String Change(BookInformation bookInformation){
        System.out.println(bookInformation.toString());
        try {
            new BookChange(bookInformation).BookChange();
            return "Yes";
        }catch (Exception e){return "false";}
    }
}
