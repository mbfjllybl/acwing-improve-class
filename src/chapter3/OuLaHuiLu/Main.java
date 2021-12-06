package chapter3.OuLaHuiLu;

import java.io.*;

/**
 * @author mbfjllybl
 * @version 1.0
 * @description: TODO
 * @date 2021/12/6 下午3:02
 */
public class Main {
    public static int n, m, type;
    public static int idx;
    public static int[] h = new int[100010], ne = new int[400010], e = new int[400010];
    public static boolean[] st = new boolean[400010];
    public static int[] in = new int[100010], out = new int[100010];
    public static int cnt;
    public static int[] res = new int[400010];

    public static void dfs(int u) {
        for (int i = h[u]; i != -1; i=h[u]) {
            if (st[i]) {
                h[u] = ne[i];
                continue;
            }
            int tmp = 0;
            if (type == 1) {
                st[i ^ 1] = true;
                tmp = i / 2 + 1;
                if ((i & 1) == 1) tmp *= -1;
            } else {
                tmp = i + 1;
            }
            int v = e[i];
            h[u] = ne[i];

            dfs(v);
            res[cnt++] = tmp;

        }
    }

    public static void main(String args[]) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        type = Integer.parseInt(reader.readLine());
        String[] strs = reader.readLine().split(" ");
        n = Integer.parseInt(strs[0]);
        m = Integer.parseInt(strs[1]);
        for (int i = 1; i <= n; i++) h[i] = -1;
        for (int i = 1; i <= m; i++) {
            int a, b;
            strs = reader.readLine().split(" ");
            a = Integer.parseInt(strs[0]);
            b = Integer.parseInt(strs[1]);
            add(a, b);
            if (type == 1) add(b, a);
            in[b]++;
            out[a]++;
        }

        if (type == 1) {
            for (int i = 1; i <= n; i++) {
                if (((in[i] + out[i]) & 1) == 1) {
                    System.out.println("NO");
                    return;
                }
            }
        } else {
            for (int i = 1; i <= n; i++) {
                if (in[i] != out[i]) {
                    System.out.println("NO");
                    return;
                }
            }
        }
        for (int i = 1; i <= n; i++) {
            if (h[i] != -1) {
                dfs(i);
                break;
            }
        }

        if (cnt != m) {
            System.out.println("NO");
            return;
        } else {
            System.out.println("YES");
            for (int i = cnt - 1; i >= 0; i--) {
                System.out.print(res[i] + " ");
            }
        }
        reader.close();
    }

    private static void add(int a, int b) {
        ne[idx] = h[a];
        e[idx] = b;
        h[a] = idx++;
    }
}



