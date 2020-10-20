package global.citytech.caeserCipher;

public class CaeserCipher {
    public void initialTesting() {
        throw new IllegalArgumentException("Testing connected");
    }

    private final String alphaString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private String shiftedFirstString;
    private String shiftedSecondString;

    public CaeserCipher() {
    }

    public CaeserCipher(int shiftIndex) {
        shiftAlphaBySingleIndex(shiftIndex);
    }

    public CaeserCipher(int shiftIndex, int shiftIndex2) {
        shiftAlphaByDoubleIndex(shiftIndex, shiftIndex2);
    }

    private void shiftAlphaBySingleIndex(int shiftIndex) {
        this.shiftedFirstString = alphaString.substring(shiftIndex) + alphaString.substring(0, shiftIndex);
    }

    private void shiftAlphaByDoubleIndex(int shiftIndex, int shiftIndex2) {
        this.shiftedFirstString = alphaString.substring(shiftIndex) + alphaString.substring(0, shiftIndex);
        this.shiftedSecondString = alphaString.substring(shiftIndex2) + alphaString.substring(0, shiftIndex2);
    }

    private String getShiftedString() {
        if (shiftedFirstString.length() > 0) {
            return shiftedFirstString;
        } else {
            throw new NullPointerException("Cipher not setup.");
        }
    }

    private String getFirstCipherString(char singleSting) {
        int alphaStringIndex = alphaString.indexOf(singleSting);
        try {
            return Character.toString(shiftedFirstString.charAt(alphaStringIndex));
        } catch (StringIndexOutOfBoundsException err) {
            return Character.toString(singleSting);
        }
    }

    private String getSecondCipherString(char singleSting) {
        int alphaStringIndex = alphaString.indexOf(singleSting);
        try {
            return Character.toString(shiftedSecondString.charAt(alphaStringIndex));
        } catch (StringIndexOutOfBoundsException err) {
            return Character.toString(singleSting);
        }
    }

    private String getFirstAlphaString(char singleSting) {
        int shiftStringIndex = shiftedFirstString.indexOf(singleSting);
        try {
            return Character.toString(alphaString.charAt(shiftStringIndex));
        } catch (StringIndexOutOfBoundsException err) {
            return Character.toString(singleSting);
        }
    }

    private String getSecondAlphaString(char singleSting) {
        int shiftStringIndex = shiftedSecondString.indexOf(singleSting);
        try {
            return Character.toString(alphaString.charAt(shiftStringIndex));
        } catch (StringIndexOutOfBoundsException err) {
            return Character.toString(singleSting);
        }
    }

    public String encrypt(String inputString, int shiftIndex) {
        shiftAlphaBySingleIndex(shiftIndex);
        StringBuilder encryptedString = new StringBuilder();
        for (int k = 0; k < inputString.length(); k++) {
            char inputCharacter = inputString.charAt(k);
            if (Character.isUpperCase(inputCharacter)) {
                encryptedString.append(getFirstCipherString(Character.toUpperCase(inputCharacter)));
            } else {
                encryptedString.append(getFirstCipherString(Character.toUpperCase(inputCharacter)).toLowerCase());
            }
        }
        return encryptedString.toString();
    }

    public String encrypt2(String inputString, int shiftIndex1, int shiftIndex2) {
        shiftAlphaByDoubleIndex(shiftIndex1, shiftIndex2);
        StringBuilder encryptedString = new StringBuilder();
        for (int k = 0; k < inputString.length(); k++) {
            char inputCharacter = inputString.charAt(k);
            if (k % 2 == 0) {
                if (Character.isUpperCase(inputCharacter)) {
                    encryptedString.append(getFirstCipherString(Character.toUpperCase(inputCharacter)));
                } else {
                    encryptedString.append(getFirstCipherString(Character.toUpperCase(inputCharacter)).toLowerCase());
                }
            } else {
                if (Character.isUpperCase(inputCharacter)) {
                    encryptedString.append(getSecondCipherString(Character.toUpperCase(inputCharacter)));
                } else {
                    encryptedString.append(getSecondCipherString(Character.toUpperCase(inputCharacter)).toLowerCase());
                }
            }
        }
        return encryptedString.toString();
    }

    public String decrypt(String inputString, int shiftIndex) {
        shiftAlphaBySingleIndex(shiftIndex);
        StringBuilder decryptedString = new StringBuilder();
        for (int k = 0; k < inputString.length(); k++) {
            decryptedString.append(getFirstAlphaString(inputString.toUpperCase().charAt(k)));
        }
        return decryptedString.toString();
    }

    public String decrypt2(String inputString, int shiftIndex1, int shiftIndex2) {
        shiftAlphaByDoubleIndex(shiftIndex1, shiftIndex2);
        StringBuilder decryptedString = new StringBuilder();
        for (int k = 0; k < inputString.length(); k++) {
            char inputCharacter = inputString.charAt(k);
            if (k % 2 == 0) {
                if (Character.isUpperCase(inputCharacter)) {
                    decryptedString.append(getFirstAlphaString(Character.toUpperCase(inputCharacter)));
                } else {
                    decryptedString.append(getFirstAlphaString(Character.toUpperCase(inputCharacter)).toLowerCase());
                }
            } else {
                if (Character.isUpperCase(inputCharacter)) {
                    decryptedString.append(getSecondAlphaString(Character.toUpperCase(inputCharacter)));
                } else {
                    decryptedString.append(getSecondAlphaString(Character.toUpperCase(inputCharacter)).toLowerCase());
                }
            }
        }
        return decryptedString.toString();
    }
}
