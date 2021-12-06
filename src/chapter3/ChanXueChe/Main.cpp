#include <bits/stdc++.h>
using namespace std;

int main() {
    double x1, y1, x2, y2;
    cin >> x1 >> y1;
    double path = 0;
    while (cin >> x1 >> y1 >> x2 >> y2) {
        path += sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2)) * 2;
    }
    int mins = round(path / 1000 / 20 * 60);
    int hours = mins / 60;
    mins %= 60;
    printf("%d:%02d\n", hours, mins);
    return 0;
}
