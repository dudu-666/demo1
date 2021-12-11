package All.show.dao;

import All.show.model.MemberInfo;
import sun.jvm.hotspot.runtime.Bytes;

import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class showmember implements memberdao{
   private MemberInfo[]MemList;
   private List<MemberInfo> ml=new ArrayList<>();

   public int getCount(){
      int count=0;
      ResultSet rs;
      String sql="Select count(*) as totalCount from teamwork.team";
      try{
         Connection connection=getConnect();
         Statement stmt=connection.createStatement();
         rs=stmt.executeQuery(sql);
         if(rs.next()){
            count=rs.getInt("totalCount");
         }

      }catch (Exception e){System.out.println(e);}
      return count;
   }
   public List<MemberInfo>Getlist(){
      ResultSet rs;
      String sql="Select * from teamwork.team";
      try{
         Connection connection=getConnect();
         Statement stmt=connection.createStatement(ResultSet.TYPE_FORWARD_ONLY,ResultSet.CONCUR_READ_ONLY);
         rs=stmt.executeQuery(sql);
         while(rs.next())
         {
            MemberInfo MemberInfo=new MemberInfo();
            MemberInfo.setSNO(rs.getString("SNO"));
            MemberInfo.setSName(rs.getString("SName"));
            MemberInfo.setSgrade(rs.getString("Sgrade"));
            MemberInfo.setSsex(rs.getString("Ssex"));
            MemberInfo.setSPrize(rs.getString("SPrize"));
            ml.add(MemberInfo);
         }
      }catch (Exception e){System.out.println(e);}
      return ml;
   }

   public static void main(String[] args){
      showmember showmember=new showmember();
      System.out.println(showmember.getCount());
      MemberInfo memberInfo=new MemberInfo();
      List<MemberInfo> memberInfoList;
      memberInfoList=showmember.Getlist();
      System.out.println(memberInfoList.size());
      Object []res=memberInfoList.toArray();
      System.out.println(res.length);
      for(Object re:res){
         System.out.println(re.toString());
      }

      }
   }





