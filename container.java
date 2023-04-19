


import java.io.PrintWriter;

public class container implements Comparable <container>{
private String uuid;
private String shortname;
private String longname;

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public void setShortname(String shortname) {
        this.shortname = shortname;
    }

    public void setLongname(String longname) {
        this.longname = longname;
    }

    public String getUuid() {
        return uuid;
    }

    public String getShortname() {
        return shortname;
    }

    public String getLongname() {
        return longname;
    }
    @Override
    public int compareTo(container o) {
    return switch (this.getShortname().compareTo(o.getShortname())) {
        case 1 -> 1;
        case -1 -> -1;
        default -> 0;
    };
    }

    public container() {
        this.uuid = "mohamed";
        this.shortname = "ayman";
        this.longname = "basha";
    }
   
    public void wstring(PrintWriter e){
   
e.println("    <CONTAINER"+this.getUuid()+">" );
e.println("        <SHORT-NAME>"+this.getShortname()+"</SHORT-NAME>" );
e.println("        <LONG-NAME>"+this.getLongname()+"</LONG-NAME>");     
e.println("   </CONTAINER>");
        
    }
    
}
