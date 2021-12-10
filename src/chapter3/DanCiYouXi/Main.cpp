#include <bits/stdc++.h>
using namespace std;
const int N = 30;
int n;
int in[N], out[N], p[N];
bool st[N];

int find(int x) {
    if (p[x] != x) p[x] = find(p[x]);
    return p[x];
}

void cas() {
    string s;
    cin >> n;
    memset(in, 0, sizeof in);
    memset(out, 0, sizeof out);
    memset(st, 0, sizeof st);
    for (int i = 0; i < 26; i++) {
        p[i] = i;
    }
    for (int i = 0; i < n; i++) {
        cin >> s;
        int len = s.size();
        int a = s[0] - 'a', b = s[len - 1] - 'a';
        st[a] = st[b] = true;
        out[a]++;
        in[b]++;
        p[find(a)] = find(b);
    }
    int start = 0, end = 0;
    bool success = true;
    for (int i = 0; i < 26; i++) {
        if (in[i] != out[i]) {
            if (in[i] == out[i] + 1) end++;
            else if (in[i] + 1 == out[i]) start++;
            else {
                success = false;
                break;
            }
        }
    }
    if (success && !(!start && !end || start == 1 && end == 1)) success = false;
    int rep = -1;
    for (int i = 0; i < 26; i++) {
        if (st[i]) {
            if (rep == -1) rep = find(i);
            else if (rep != find(i)) {
                success = false;
                break;
            }
        }
    }
    if (success) puts("Ordering is possible.");
    else puts("The door cannot be opened.");
}

int main() {

    int t;
    cin >> t;
    while (t--) {
        cas();
    }
    return 0;
}