package All.show.dao;

import All.show.model.MemberInfo;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class addmember implements memberdao {
    MemberInfo memberInfo;
    PreparedStatement ps=null;
    addmember(MemberInfo memberInfo){this.memberInfo=memberInfo;}
    public void add(){
        if(memberInfo!=null){
            try{

               // String sql="INSERT INTO `teamwork`.`team`" + "(`SNO`," +  "`SName`,"+ "`Sgrade`"+"`Ssex`"+"`SPrize`"+"`photo`)" + "VALUES" + "("+'"'+memberInfo.getSNO()+'"'+","+'"'+memberInfo.getSName()+'"'+","+'"'+memberInfo.getSgrade()+'"'+","+'"'+memberInfo.getSsex()+'"'+","+'"'+memberInfo.getSPrize()+'"'+","+memberInfo.getPhoto()+')';
                String sql="insert into team(SNO,SName,Sgrade,Ssex,SPrize,photo) values (?,?,?,?,?,?)";
                Connection connection=getConnect();
                ps=connection.prepareStatement(sql);
                ps.setString(1,memberInfo.getSNO());
                ps.setString(2,memberInfo.getSName());
                ps.setString(3,memberInfo.getSgrade());
                ps.setString(4,memberInfo.getSsex());
                ps.setString(5,memberInfo.getSPrize());
                ps.setBytes(6,memberInfo.getPhoto());
                ps.execute();
                System.out.println(sql);


            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }
   public static void main(String[] args){
        MemberInfo memberInfo=new MemberInfo();
        memberInfo.setSNO("9887654321");
        memberInfo.setSName("уе");
        memberInfo.setSgrade("19");
        memberInfo.setSsex("m");
        memberInfo.setSPrize("нч");
        findPhotobySNO findPhotobySNO=new findPhotobySNO();
        //findPhotobySNO.findBySNO("2362483567");
        byte[] photo;
        photo=findPhotobySNO.findBySNO("1234567899");
        memberInfo.setPhoto(photo);
        addmember addmember=new addmember(memberInfo);
        addmember.add();


    }





}
