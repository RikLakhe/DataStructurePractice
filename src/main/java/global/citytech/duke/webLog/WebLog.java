package global.citytech.duke.webLog;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.MatchResult;
import java.util.regex.Pattern;

public class WebLog {

    private String ipAddress;
    private Date date;
    private String req;
    private int status;
    private int bytes;

    public WebLog(String ipAddress, Date date, String req, int status, int bytes) {
        this.ipAddress = ipAddress;
        this.date = date;
        this.req = req;
        this.status = status;
        this.bytes = bytes;
    }

    public WebLog(String longLog) throws ParseException {
        String[] allNeedLogItems = Pattern.compile("^((\\d+.){0,})|(\\[.+\\])|(\\\".+\\\")|(\\d{0,})")
                .matcher(longLog)
                .results()
                .map(MatchResult::group)
                .toArray(String[]::new);
        String[] dateSplit = allNeedLogItems[5].substring(1, allNeedLogItems[5].length()-1).split(" |:|/");
        this.ipAddress = allNeedLogItems[0];
        this.date =
                new SimpleDateFormat("dd/MMM/yyyy:HH:mm:ss")
                        .parse(dateSplit[0]+"/"+dateSplit[1]+"/"+dateSplit[2]+":"+dateSplit[3]+":"+dateSplit[4]+":"+dateSplit[5]);;
        this.req = allNeedLogItems[7].substring(1, allNeedLogItems[7].length()-1);;
        this.status = Integer.parseInt(allNeedLogItems[9]);
        this.bytes = Integer.parseInt(allNeedLogItems[11]);
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public Date getDate() {
        return date;
    }

    public String getReq() {
        return req;
    }

    public int getStatus() {
        return status;
    }

    public int getBytes() {
        return bytes;
    }

    @Override
    public String toString() {
        return "WebLog{" +
                "ipAddress='" + ipAddress + '\'' +
                ", date=" + date +
                ", req='" + req + '\'' +
                ", status=" + status +
                ", bytes=" + bytes +
                '}';
    }
}
