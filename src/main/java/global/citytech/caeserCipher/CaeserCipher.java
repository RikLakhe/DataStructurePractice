package global.citytech.caeserCipher;

class Answers {
    private String answer;
    private int key;

    public Answers(String encryptDecrypt, int key) {
        this.answer = encryptDecrypt;
        this.key = key;
    }

    public String getAnswer() {
        return answer;
    }

    public int getKey() {
        return key;
    }
}

public class CaeserCipher {
    public void initialTesting() {
        throw new IllegalArgumentException("Testing connected");
    }

    private final String alphaString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private String shiftedFirstString;
    private String shiftedSecondString;
    private String firstString;
    private String secondString;

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

    private int[] countLetters(String inputString) {
        int[] letterCount = new int[26];
        for (int k = 0; k < inputString.length(); k++) {
            int alphaStringIndex = alphaString.indexOf(inputString.toUpperCase().charAt(k));
            if (alphaStringIndex != -1) {
                letterCount[alphaStringIndex] += 1;
            }
        }
        return letterCount;
    }

    private int findMaxIndex(int[] letterArray) {
        int maxIndex = 0;
        int maxCount = 0;
        for (int k = 0; k < letterArray.length; k++) {
            if (letterArray[k] > maxCount) {
                maxCount = letterArray[k];
                maxIndex = k;
            }
        }
        return maxIndex;
    }

    public Answers decrypt(String inputString) {
        int[] freq = countLetters(inputString);
        int maxIndex = findMaxIndex(freq);
        int dKey = maxIndex - 4;
        if (maxIndex < 4) {
            dKey = 26 - (4 - maxIndex);
        }
        Answers ans = new Answers(encrypt(inputString, 26 - dKey), 26 - dKey);
        return ans;
    }

    public String decrypt(String inputString, int shiftIndex) {
        shiftAlphaBySingleIndex(shiftIndex);
        StringBuilder decryptedString = new StringBuilder();
        for (int k = 0; k < inputString.length(); k++) {
            decryptedString.append(getFirstAlphaString(inputString.toUpperCase().charAt(k)));
        }
        return decryptedString.toString();
    }

    public String decrypt2(String inputString) {
        StringBuilder encryptedFirst = new StringBuilder();
        StringBuilder encryptedSecond = new StringBuilder();
        for (int k = 0; k < inputString.length(); k++) {
            char inputCharacter = inputString.toUpperCase().charAt(k);
            if (k % 2 == 0) {
                encryptedFirst.append(inputCharacter);
            } else {
                encryptedSecond.append(inputCharacter);
            }
        }
        this.firstString = encryptedFirst.toString();
        this.secondString = encryptedSecond.toString();
        Answers a1 = decrypt(this.firstString);
        Answers a2 = decrypt(this.secondString);
        System.out.println(a1.getKey()+"   "+a2.getKey());
        return encrypt2(inputString, a1.getKey(), a2.getKey());
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
