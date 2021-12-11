package All.show.controller;

import All.show.dao.*;
import All.show.model.MemberInfo;
import All.show.model.showteamModel;
import com.mysql.cj.xdevapi.JsonArray;
import org.junit.jupiter.api.Test;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@Controller
public class showcontroller {

    @RequestMapping(path="showController")
    public String showgrmp() {return "test0";}
    @RequestMapping(path="returnlogin")
    public String UserLogin(){
        return "UserLogin";
    }

      /** @RequestMapping(path="UserLoginController",method = RequestMethod.POST)
        public String UserLogin() {return "UserLogin";}*/
      @RequestMapping(value = "showteam")
      @ResponseBody
      public List showteam()
      {
          showmember show=new showmember();
          return show.Getlist();
      }
    /**
     *查询图片
     */
    @RequestMapping(path="showteam/img")
    public void findphotoBysno(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
        response.setHeader("Pragma", "No-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);
        //response.setHeader()  设置响应报头，在这里设置为不可缓存
        byte[] photo = null;//通过一个byte[]来接收图片
        String sno=request.getParameter("sno");
        MemberInfo mem  = new MemberInfo();
        photo=mem.getPhoto();
        //OutputStream 以流的形式将图片信息返回给页面
        OutputStream outputStream = response.getOutputStream();
        outputStream.write(photo);
        outputStream.flush();//排出流中所有数据
        outputStream.close();//关闭流
    }

    @RequestMapping(path="memberdelete",method = RequestMethod.GET)
      public String del(HttpServletRequest request){
          String id=request.getParameter("id");
          deletemember deletemember=new deletemember(id);
         deletemember.Delete();
         System.out.println(id);
         return "redirect:test0";
     }
     @RequestMapping(path="memberupdate",method =RequestMethod.POST)
     @ResponseBody
     public String update(MemberInfo memberInfo) {

         System.out.println(memberInfo.toString());
         try {
             new updatemember(memberInfo).Update();
             return "Y";

         } catch (Exception e) {
             return "F";
         }
     }
}
