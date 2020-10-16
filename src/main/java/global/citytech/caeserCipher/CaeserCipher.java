package global.citytech.caeserCipher;

public class CaeserCipher {
    public void initialTesting() {
        throw new IllegalArgumentException("Testing connected");
    }

    private final String alphaString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private String shiftedString;

    public CaeserCipher() {
    }

    public CaeserCipher(int shiftIndex) {
        shiftAlphaByIndex(shiftIndex);
    }

    public void shiftAlphaByIndex(int shiftIndex) {
        this.shiftedString = alphaString.substring(shiftIndex) + alphaString.substring(0, shiftIndex);
    }

    public String getShiftedString() {
        if (shiftedString.length() > 0) {
            return shiftedString;
        } else {
            throw new NullPointerException("Cipher not setup.");
        }
    }

    public String getCipherString(char singleSting) {
        int alphaStringIndex = alphaString.indexOf(singleSting);
        try {
            return Character.toString(shiftedString.charAt(alphaStringIndex));
        } catch (StringIndexOutOfBoundsException err) {
            return Character.toString(singleSting);
        }
    }

    public String getAlphaString(char singleSting) {
        int shiftStringIndex = shiftedString.indexOf(singleSting);
        try {
            return Character.toString(alphaString.charAt(shiftStringIndex));
        } catch (StringIndexOutOfBoundsException err) {
            return Character.toString(singleSting);
        }
    }

    public String encrypt(String inputString, int shiftIndex) {
        shiftAlphaByIndex(shiftIndex);
        StringBuilder encryptedString = new StringBuilder();
        for (int k = 0; k < inputString.length(); k++) {
            encryptedString.append(getCipherString(inputString.toUpperCase().charAt(k)));
        }
        return encryptedString.toString();
    }

    public String decrypt(String inputString, int shiftIndex) {
        shiftAlphaByIndex(shiftIndex);
        StringBuilder decryptedString = new StringBuilder();
        for (int k = 0; k < inputString.length(); k++) {
            decryptedString.append(getAlphaString(inputString.toUpperCase().charAt(k)));
        }
        return decryptedString.toString();
    }
}
