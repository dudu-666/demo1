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
                return str.append("�ɹ�ɾ��ͼ��!").toString();
            }
            else {
                str.append("ɾ��ʧ��!");
                return str.append("��Ϊ���ڹ��ڸ�ͼ��Ľ��ļ�¼����ԤԼ��¼!").toString();
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
                return str.append("ͼ����ĳɹ�!").toString();
            }else {
                return str.append("ͼ�����ʧ��!").toString();
            }
        }catch (Exception e){
            return str.append(e).toString();
        }
    }
}
