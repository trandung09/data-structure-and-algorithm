package org.tvd.study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Lap1 {
    
    static int n;
    static int[] a = new int[25];
    static boolean[] ok = new boolean[25];
    static int dem = 0;

    public static void TRY(int i) {
        for (int k = 1; k <= n; k++) {
            if (!ok[k] && (k + a[i - 1]) % 4 != 0) {
                a[i] = k;
                ok[k] = true;

                if (i == n) {
                    ok[k] = false;
                    for (int l = 1; l <= n; l++) {
                        System.out.print(a[l] + " ");
                    }
                    System.out.println();
                    dem++;
                } else {
                    TRY(i + 1);
                    ok[k] = false;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // Đọc đầu vào từ BufferedReader
        n = Integer.parseInt(br.readLine());

        for (int i = 1; i <= n; i++) {
            a[1] = i;
            ok[i] = true;
            TRY(2);
            ok[i] = false;
        }

        System.out.println(dem);
    }
}
