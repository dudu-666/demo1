package All.Model;
import java.nio.charset.StandardCharsets;
public class BookInformation {
    private String Bnum;
    private String Bname;
    private String Bauthor;
    private String Bpublichouse;
    private String Detail;
    public boolean isBorrowed() {
        return IsBorrowed;
    }
    public void setBorrowed(boolean borrowed) {
        IsBorrowed = borrowed;
    }
    private boolean IsBorrowed=false;

    @Override
    public String toString() {
        return "BookInformation{" +
                "Bnum='" + Bnum + '\'' +
                ", Bname='" + Bname + '\'' +
                ", Bauthor='" + Bauthor + '\'' +
                ", Bpublichouse='" + Bpublichouse + '\'' +
                ", Detail='" + Detail + '\'' +
                ", IsBorrowed=" + IsBorrowed +
                '}';
    }

    public BookInformation(){
        Bnum="";
        Bname="";
        Bauthor="";
        Bpublichouse="";
        Detail="";
    };
    public void SetBookInformation(BookInformation bookInformation){
        this.Bnum=bookInformation.getBnum();
        this.Bname=bookInformation.getBname();
        this.Bauthor=bookInformation.getBauthor();
        this.Bpublichouse=bookInformation.getBpublichouse();
        this.Detail=bookInformation.getDetail();
    }
    public String getBnum() {
        return Bnum;
    }
    public void setBnum(String bnum) {
        Bnum = new String(bnum.getBytes(StandardCharsets.UTF_8), StandardCharsets.UTF_8);
    }
    public String getBname() {
        return Bname;
    }
    public void setBname(String bname) {
        Bname = new String(bname.getBytes(StandardCharsets.UTF_8), StandardCharsets.UTF_8);
    }
    public String getBauthor() {
        return Bauthor;
    }
    public void setBauthor(String bauthor){
        Bauthor = new String(bauthor.getBytes(StandardCharsets.UTF_8), StandardCharsets.UTF_8);
    }
    public String getBpublichouse() {
        return Bpublichouse;
    }
    public void setBpublichouse(String bpublichouse) {
        Bpublichouse = new String(bpublichouse.getBytes(StandardCharsets.UTF_8), StandardCharsets.UTF_8);
    }
    public String getDetail() {
        return Detail;
    }
    public void setDetail(String detail) {
        Detail = new String(detail.getBytes(StandardCharsets.UTF_8), StandardCharsets.UTF_8);
    }
}
