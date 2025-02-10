package org.tvd;

import org.tvd.abstracts.D;
import org.tvd.abstracts.C;

public class DiceCombinations {
    public static void main(String[] args) {
    
        C c = new D("D");

        D d = (D) c;
        System.out.println(d.getName());
    }
}
