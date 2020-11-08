package global.citytech.duke.genes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Genes2 {
    private final HashMap<String, Integer> codonMap = new HashMap<>();
    private final String dnaFrame;

    public Genes2(String dnaFrame) {
        this.dnaFrame = dnaFrame;
    }

    public void findCodons(Integer pointer) {
        System.out.println("Point === >" + pointer);
        System.out.println(dnaFrame);
        for (int k = pointer; k < dnaFrame.length(); k = k + 3) {
            try{
                StringBuilder sm = new StringBuilder();
                sm.append(dnaFrame.charAt(k));
                sm.append(dnaFrame.charAt(k+1));
                sm.append(dnaFrame.charAt(k+2));
                if(codonMap.containsKey(sm.toString())){
                    codonMap.put(sm.toString(), codonMap.get(sm.toString())+1);
                }else{
                    codonMap.put(sm.toString(),1);
                }



            }catch (StringIndexOutOfBoundsException err){
                break;
            }
        }

        codonMap.forEach((key, value) -> {
//            if(value==7){
                System.out.println("ket="+key+"value="+value);
//            }
        });
        System.out.println("unique===>"+codonMap.size());

    }
}
