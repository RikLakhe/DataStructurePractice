package global.citytech.caeserCipher;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class CaeserCipherTest {
    CaeserCipher cs = new CaeserCipher();

    @Test(expected = IllegalArgumentException.class)
    public void doInitialCaeserCipherTesting() {
        cs.initialTesting();
    }

    @Test(expected = NullPointerException.class)
    public void doGetShiftedStringTesting() {
        cs.getShiftedString();
    }

    @Test
    public void doEncryptionAfterShiftTesting() {
        cs.shiftAlphaByIndex(19);
        String testShiftString = cs.getShiftedString();
        assertEquals("TUVWXYZABCDEFGHIJKLMNOPQRS",testShiftString);
    }

    @Test
    public void doEncryptionTesting() {
        String testEncrypted = cs.encrypt("I AM BAT",19);
        assertEquals("B TF UTM",testEncrypted);
    }

    @Test
    public void doDecryptionTesting() {
        String testDecrypted = cs.decrypt("B TF UTM",19);
        assertEquals("I AM BAT",testDecrypted);
    }
}
