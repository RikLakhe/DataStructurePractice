package global.citytech.caeserCipher;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class CaeserCipherTest {
    CaeserCipher cs = new CaeserCipher();

    @Test(expected = IllegalArgumentException.class)
    public void doInitialCaeserCipherTesting() {
        cs.initialTesting();
    }

    @Test
    public void doEncryptionTesting() {
        String testEncrypted = cs.encrypt("I am BAT",19);
        assertEquals("B tf UTM",testEncrypted);
    }

    @Test
    public void doDecryptionTesting() {
        String testDecrypted = cs.decrypt("B TF UTM",19);
        assertEquals("I AM BAT",testDecrypted);
    }

    @Test
    public void doEncryption2Testing() {
        String testEncrypted = cs.encrypt2("First Legion",23,17);
        assertEquals("Czojq Ivdzle",testEncrypted);
    }

    @Test
    public void doDecryption2Testing() {
        String testEncrypted = cs.decrypt2("Czojq Ivdzle",23,17);
        assertEquals("First Legion",testEncrypted);
    }
}
