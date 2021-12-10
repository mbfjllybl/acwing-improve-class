#include <bits/stdc++.h>
using namespace std;
const int N = 510;
int n = 500;
int ans[N * 3];
int d[N];
int cnt;
int g[N][N];

void dfs(int u) {
    for (int i = 1; i <= n; i++) {
        if (g[u][i]) {
            g[u][i]--;
            g[i][u]--;
            dfs(i);
        }
    }
    ans[cnt++] = u;
}

int main() {
    int m;
    cin >> m;
    while (m--) {
        int a, b;
        cin >> a >> b;
        g[a][b]++, g[b][a]++;
        d[a]++, d[b]++;
    }
    int start = 1;
    while (!d[start]) start++;
    for (int i = 1; i <= n; i++) {
        if (d[i] % 2) {
            start = i;
            break;
        }
    }
    dfs(start);
    for (int i = cnt - 1; i >= 0; i--) {
        cout << ans[i] << endl;
    }
    return 0;
}