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
        String testEncrypted = cs.encrypt("Write the method  breakCaesarCipher  that has one String parameter namedinput . This method should figure out which key was used to encrypt thismessage (in a similar manner as the previous lesson), then create aCaesarCipher  object with that key and decrypt the message.", 19);
        assertEquals("Pkbmx max fxmahw  ukxtdVtxltkVbiaxk  matm atl hgx Lmkbgz itktfxmxk gtfxwbginm . Mabl fxmahw " +
                "lahnew ybznkx hnm pabva dxr ptl nlxw mh xgvkrim mablfxlltzx (bg t lbfbetk ftggxk tl max ikxobhnl exllhg), maxg vkxtmx tVtxltkVbiaxk  hucxvm pbma matm dxr tgw wxvkrim max fxlltzx.", testEncrypted);
    }

    @Test
    public void doDecryptionTesting() {
        String testDecrypted = cs.decrypt("B TF UTM", 19);
        assertEquals("I AM BAT", testDecrypted);
    }

    @Test
    public void doEncryption2Testing() {
        String testEncrypted = cs.encrypt2("First Legion", 23, 17);
        assertEquals("Czojq Ivdzle", testEncrypted);
    }

    @Test
    public void doDecryptionNoKeyTesting() {
        Answers testDecrypted = cs.decrypt("Pkbmx max fxmahw  ukxtdVtxltkVbiaxk  matm atl hgx Lmkbgz itktfxmxk gtfxwbginm" +
                " . Mabl fxmahw lahnew ybznkx hnm pabva dxr ptl nlxw mh xgvkrim mablfxlltzx (bg t lbfbetk ftggxk tl max ikxobhnl exllhg), maxg vkxtmx tVtxltkVbiaxk  hucxvm pbma matm dxr tgw wxvkrim max fxlltzx.");
        assertEquals("Write the method  breakCaesarCipher  that has one String parameter namedinput . This method " +
                "should figure out which key was used to encrypt thismessage (in a similar manner as the previous " +
                "lesson), then create aCaesarCipher  object with that key and decrypt the message.", testDecrypted.getAnswer());
    }

    @Test
    public void doDecryption2Testing() {
        String testEncrypted = cs.decrypt2("Quxe Cbmcugee Fcveacr Qecaetzeat Oieevvej", 22,9);
        assertEquals("Zalch wqh pnwqrm  eahjnLdnvjuLlyknu  ckjw kjv rwh Vcurqp ydadvhcha wdvhmlwsdw . Wqlb vhckxg vqrdom olpxah rdw zqllk nnb zjv xbhm cr hwfabyw wqlbpnvbdph (rq d vrproju pjqwha jv wqh sahelxxb uhbvxq), wqhw lundch dLdnvjuLlyknu  xeshlw zrwq ckjw nnb dwg gnfabyw wqh pnvbdph.", testEncrypted);
    }

    @Test
    public void doDecryption2NoKeyTesting() {
        String testEncrypted = cs.decrypt2("Zalch wqh pnwqrm  eahjnLdnvjuLlyknu  ckjw kjv rwh Vcurqp ydadvhcha wdvhmlwsdw . Wqlb vhckxg vqrdom olpxah rdw zqllk nnb zjv xbhm cr hwfabyw wqlbpnvbdph (rq d vrproju pjqwha jv wqh sahelxxb uhbvxq), wqhw lundch dLdnvjuLlyknu  xeshlw zrwq ckjw nnb dwg gnfabyw wqh pnvbdph.");
        assertEquals("Write the method  breakCaesarCipher  that has one String parameter namedinput . This method should figure out which key was used to encrypt thismessage (in a similar manner as the previous lesson), then create aCaesarCipher  object with that key and decrypt the message.", testEncrypted);
    }
}
