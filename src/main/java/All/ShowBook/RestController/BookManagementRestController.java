package All.ShowBook.RestController;

import All.Model.BookInformation;
import All.ShowBook.Dao.BookChange;
import All.ShowBook.Dao.DeleteBook;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.awt.print.Book;

@RestController
public class BookManagementRestController {
    @RequestMapping("BookManagementRestDelete")
    public String DeleteResultReturn(String id){
        StringBuilder str=new StringBuilder();
        try {
            if(new DeleteBook(id).Delete()){
                return str.append("成功删除图书!").toString();
            }
            else {
                str.append("删除失败!");
                return str.append("因为存在关于该图书的借阅记录或者预约记录!").toString();
            }
        }catch (Exception e){
            return str.append(e).toString();
        }
    }
    @RequestMapping("BookManagementRestChange")
    public String BookChangeResultReturn(BookInformation bookInformation){
        StringBuilder str=new StringBuilder();
        try {
            if(new BookChange(bookInformation).BookChange()){
                return str.append("图书更改成功!").toString();
            }else {
                return str.append("图书更改失败!").toString();
            }
        }catch (Exception e){
            return str.append(e).toString();
        }
    }
}
