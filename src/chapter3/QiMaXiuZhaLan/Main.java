package chapter3.QiMaXiuZhaLan;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author mbfjllybl
 * @version 1.0
 * @description: TODO
 * @date 2021/12/10 上午10:48
 */
public class Main {
    public static int n = 500;
    public static final int N = 510;
    public static int[][] g = new int[N][N];
    public static int idx = 0, cnt = 0;
    public static int[] d = new int[N];
    public static int[] res = new int[N * 3];
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int m = Integer.parseInt(reader.readLine());
        while (m-- > 0) {
            String[] strs = reader.readLine().split(" ");
            int a = Integer.parseInt(strs[0]), b = Integer.parseInt(strs[1]);
            g[a][b]++;
            g[b][a]++;
            d[a]++;
            d[b]++;
        }
        int start = 1;
        while (d[start] == 0) start++;
        for (int i = 1; i <= n; i++) {
            if (d[i] % 2 == 1) {
                start = i;
                break;
            }
        }
        dfs(start);
        for (int i = cnt - 1; i >= 0; i--) {
            System.out.println(res[i]);
        }
        reader.close();
    }

    public static void dfs(int start) {
        for (int i = 1; i <= n; i++) {
            if (g[start][i] != 0) {
                g[start][i]--;
                g[i][start]--;
                dfs(i);
            }

        }
        res[cnt++] = start;
    }
}

