package chapter3.DanCiYouXi;

import java.io.*;
import java.util.*;

public class Main {
    static int N = 30;
    static int[] p = new int[N];
    static boolean[] s = new boolean[N];
    static int[] din = new int[N];
    static int[] dout = new int[N];

    static int find(int x) {
        if (x != p[x]) p[x] = find(p[x]);
        return p[x];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(in.readLine());

        while (t-- > 0) {
            Arrays.fill(din, 0);
            Arrays.fill(dout, 0);
            Arrays.fill(s, false);

            int n = Integer.parseInt(in.readLine());

            for (int i = 0; i < 26; i++) p[i] = i;

            for (int i = 0; i < n; i++) {
                String str = in.readLine();
                int len = str.length();
                int a = str.charAt(0) - 'a';
                int b = str.charAt(len - 1) - 'a';
                dout[a]++;
                din[b]++;
                s[a] = true;
                s[b] = true;
                p[find(a)] = find(b);
            }

            boolean suc = true;
            int rep = -1;
            for (int i = 0; i < 26; i++) {
                if (s[i]) {
                    if (rep == -1) rep = find(i);
                    else if (rep != find(i)) {
                        suc = false;
                        break;
                    }
                }
            }

            int st = 0;
            int ed = 0;
            for (int i = 0; i < 26; i++) {
                if (din[i] != dout[i]) {
                    if (din[i] == dout[i] - 1) st++;
                    else if (din[i] == dout[i] + 1) ed++;
                    else {
                        suc = false;
                        break;
                    }
                }
            }

            if (suc && !((st == 0 && ed == 0) || (st == 1 && ed == 1))) suc = false;

            if (suc) System.out.println("Ordering is possible.");
            else System.out.println("The door cannot be opened.");
        }
    }
}