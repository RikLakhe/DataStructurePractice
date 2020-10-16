import java.util.Scanner;
import java.time.LocalTime;

class Time {

    int hour;
    int minute;
    int second;

    Time(int hour, int minute, int second){
        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }

    public static Time noon() {
        // write your code here
        return new Time(12,0,0);
    }

    public static Time midnight() {
        // write your code here
        return new Time(0,0,0);
    }

    public static Time ofSeconds(long seconds) {
        // write your code here
        int hours= (int) seconds / 3600 % 24;
        int minutes = (int) (seconds % 3600) / 60;
        int sec = (int) seconds % 60;
        return new Time(hours,minutes,sec);
    }

    public static Time of(int hour, int minute, int second) {
        // write your code here
        if(hour<=23 && minute<=59 && second<=59){
            return new Time(hour,minute,second);
        }else{
            return null;
        }
    }
}

/* Do not change code below */
public class TestDrive {

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        final String type = scanner.next();
        Time time = null;

        switch (type) {
            case "noon":
                time = Time.noon();
                break;
            case "midnight":
                time = Time.midnight();
                break;
            case "hms":
                int h = scanner.nextInt();
                int m = scanner.nextInt();
                int s = scanner.nextInt();
                time = Time.of(h, m, s);
                break;
            case "seconds":
                time = Time.ofSeconds(scanner.nextInt());
                break;
            default:
                time = null;
                break;
        }

        if (time == null) {
            System.out.println(time);
        } else {
            System.out.println(String.format("%s %s %s", time.hour, time.minute, time.second));
        }
    }
}
