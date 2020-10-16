package global.citytech.caeserCipher;

public class TestDrive {
    public static void main(String[] args) {
        CaeserCipher cs = new CaeserCipher();
//        String data = cs.encrypt("A BAT.", 19);
        String data = cs.decrypt("B TF UTM.", 19);
        System.out.print(data);
    }
}