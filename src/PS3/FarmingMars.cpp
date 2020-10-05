#include <iostream>
#include <vector>
#include <unordered_map> 

using namespace std;

int main()
{
    int n = 0, m = 0, l = 0, r = 0;
    double k = 0;
    cin >> n;
    cin >> m;
    vector<double> farmland;
    bool majorityFound;

    for (int i = 0; i < n; i++) {
        cin >> k;
        farmland.push_back(k);
    }

    for (int i = 0; i < m; i++) {
        majorityFound = false;
        cin >> l;
        cin >> r;
        if (l == r) {
            cout << "usable" << endl;
            majorityFound = true;
        }
        else {
            unordered_map<double, int> umap;
            int maj = (r - l + 1) / 2 + 1;
            for (int j = l - 1; j < r; j++) {
                if (umap.find(farmland[j]) != umap.end()) {
                    int count = umap[farmland[j]] + 1;
                    if (count >= maj) {
                        cout << "usable" << endl;
                        majorityFound = true;
                    }
                    else {
                        umap[farmland[j]] = count;
                    }
                }
                else {
                    umap[farmland[j]] = 1;
                }
            }
            if (!majorityFound) {
                cout << "unusable" << endl;
            }
        }

    }

    return 0;
}