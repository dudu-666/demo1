package All.show.model;

import sun.jvm.hotspot.runtime.Bytes;

import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.Statement;

public class MemberInfo {
    private String SNO;
    private String SName;
    private String Sgrade;
    private String Ssex;
    private String SPrize;
    private byte[] photo;
    public String toString()
    {
      return  "memberInfo{"+
      "SNO='"+SNO+'\''+
      ",SName='"+SName+'\''+
      ",Sgrade='"+Sgrade+'\''+
      ",Ssex='"+Ssex+'\''+
      ",SPrize='"+SPrize+'\''+
      '}';
    }
    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }
    public String getSNO() {
        return SNO;
    }
    public void setSNO(String sno) {
        SNO = new String(sno.getBytes(StandardCharsets.UTF_8),StandardCharsets.UTF_8);
    }
    public String getSName() {
        return SName;
    }
    public void setSName(String sname) {
        SName = new String(sname.getBytes(StandardCharsets.UTF_8),StandardCharsets.UTF_8);
    }

    public String getSgrade() {
        return Sgrade;
    }
    public void setSgrade(String sgrade) {
        Sgrade = new String(sgrade.getBytes(StandardCharsets.UTF_8),StandardCharsets.UTF_8);
    }

    public String getSsex() {
        return Ssex;
    }
    public void setSsex(String ssex) {
        Ssex = new String(ssex.getBytes(StandardCharsets.UTF_8),StandardCharsets.UTF_8);
    }

    public String getSPrize() { return SPrize;}
    public void setSPrize(String sprize) {
        SPrize = new String(sprize.getBytes(StandardCharsets.UTF_8),StandardCharsets.UTF_8);
    }


    public void SetMemberInfo(MemberInfo memberInfo)
    {
        this.SNO=memberInfo.getSNO();
        this.SName=memberInfo.getSName();
        this.Sgrade=memberInfo.getSgrade();
        this.Ssex=memberInfo.getSsex();
        this.SPrize=memberInfo.getSPrize();

    }

    public MemberInfo() {
        SNO="";
        SName="";
        Sgrade="";
        Ssex="";
        SPrize="";



    }
    public void Delete(){

    }
}
