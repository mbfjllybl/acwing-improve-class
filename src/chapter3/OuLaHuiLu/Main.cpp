#include <bits/stdc++.h>
using namespace std;
const int N = 100010, M = 400010;
int st[M], in[N], out[N];
int idx, e[M], ne[M], h[N];
int res[M], cnt;

void ex(bool flag) {
    if (flag) cout << "YES" << endl;
    else {
        cout << "NO" << endl;
        exit(0);
    }
}

int n, m;
int type;

void add(int a, int b) {
    e[idx] = b, ne[idx] = h[a], h[a] = idx++;
}

void dfs(int u) {
    for (int &i = h[u]; ~i; ) {
        if (st[i]) {
            i = ne[i];
            continue;
        }
        int tmp = 0;
        if (type == 1) {
            tmp = i / 2 + 1;
            if (i & 1) tmp = -tmp;
        } else {
            tmp = i + 1;
        }
        st[i] = true;
        if (type == 1) st[i ^ 1] = true;
        int vr = e[i];
        i = ne[i];
        dfs(vr);
        res[cnt++] = tmp;
    }
}

int main() {
    cin >> type >> n >> m;
    for (int i = 1; i <= n; i++) h[i] = -1;
    for (int i = 1; i <= m; i++) {
        int a, b;
        cin >> a >> b;
        add(a, b);
        if (type == 1) add(b, a);
        out[a]++, in[b]++;
    }
    if (type == 1) {
        for (int i = 1; i <= n; i++)
            if ((in[i] + out[i]) & 1)
                ex(false);
    } else {
        for (int i = 1; i <= n; i++)
            if (in[i] != out[i])
                ex(false);
    }

    for (int i = 1; i <= n; i++) {
        if (h[i] != -1) {
            dfs(i);
            break;
        }
    }

    if (cnt != m) ex(false);
    else {
        ex(true);
        for (int i = cnt - 1; i >= 0; i--) {
            cout << res[i] << " ";
        }
    }
    return 0;
}