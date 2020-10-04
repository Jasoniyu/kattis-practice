#include <iostream>
#include <vector>
using namespace std;

int main() {
    int n=0, k=0, counter=0, spot=0;
    vector<int> picks;
    vector<int> prof;
    cin >> n;

    for (int i = 0; i < n; i++) {
        cin >> k;
        picks.push_back(k);
        prof.push_back(i+1);
    }
    while (picks.size() > 1) {counter = (picks[spot]-1) % picks.size();
        picks.erase(picks.begin() + (spot + counter) % picks.size());
        prof.erase(prof.begin() + (spot + counter) % prof.size());
        spot = (spot + counter) % (picks.size()+1);
        spot %= prof.size();
        counter %= picks.size();
    }
    cout << prof[0] << endl;

    return 0;
}
