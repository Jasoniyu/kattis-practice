#include <iostream>
#include <set>
#include <float.h>
#include <math.h>
#include <vector>
#include <iomanip> 

using namespace std;
long double getDistance(vector<int> a, vector<int> b);

int main() {
    int n, t, f;
    cin >> n >> t >> f;

    set<vector<int>> judgesLocations1, judgesLocations2, tarLocations, featherLocations;

    for (int i = 0; i < n; i++) {
        vector<int> location;
        int a, b;
        cin >> a;
        cin >> b;
        location.push_back(a);
        location.push_back(b);
        location.push_back(i);
        judgesLocations1.insert(location);
        judgesLocations2.insert(location);
    }

    for (int i = 0; i < t; i++) {
        vector<int> location;
        int a, b;
        cin >> a;
        cin >> b;
        location.push_back(a);
        location.push_back(b);
        location.push_back(i);
        tarLocations.insert(location);
    }

    for (int i = 0; i < f; i++) {
        vector<int> location;
        int a, b;
        cin >> a;
        cin >> b;
        location.push_back(a);
        location.push_back(b);
        location.push_back(i);
        featherLocations.insert(location);
    }

    long double totalDistance = 0;

    while (!judgesLocations1.empty()) {
        long double minDistance = DBL_MAX;
        vector<int> judgeRemoved;
        vector<int> tarRemoved;

        for (vector<int> tarLocation : tarLocations) {
            for (vector<int> judgeLocation : judgesLocations1) {
                long double distance = getDistance(tarLocation, judgeLocation);
                if (distance < minDistance) {
                    judgeRemoved = judgeLocation;
                    tarRemoved = tarLocation;
                    minDistance = distance;
                }
                else if (distance - minDistance < 1e-6) {
                    if (judgeRemoved[2] > judgeLocation[2]) {
                        judgeRemoved = judgeLocation;
                        tarRemoved = tarLocation;
                    }
                    else if (judgeRemoved[2] == judgeLocation[2] && tarRemoved[2] > tarLocation[2]) {
                        tarRemoved = tarLocation;
                    }
                }
            }
        }

        totalDistance += minDistance;
        judgesLocations1.erase(judgesLocations1.find(judgeRemoved));
        tarLocations.erase(tarLocations.find(tarRemoved));
    }
    while (!judgesLocations2.empty()) {
        long double minDistance = DBL_MAX;
        vector<int> judgeRemoved;
        vector<int> featherRemoved;

        for (vector<int> featherLocation : featherLocations) {
            for (vector<int> judgeLocation : judgesLocations2) {
                long double distance = getDistance(featherLocation, judgeLocation);
                if (distance < minDistance) {
                    judgeRemoved = judgeLocation;
                    featherRemoved = featherLocation;
                    minDistance = distance;
                }
                else if (distance - minDistance < 1e-6) {
                    if (judgeRemoved[2] > judgeLocation[2]) {
                        judgeRemoved = judgeLocation;
                        featherRemoved = featherLocation;
                    } else if (judgeRemoved[2] == judgeLocation[2] && featherRemoved[2] > featherLocation[2]) {
                        featherRemoved = featherLocation;
                    }
                }
            }
        }

        totalDistance += minDistance;
        judgesLocations2.erase(judgesLocations2.find(judgeRemoved));
        featherLocations.erase(featherLocations.find(featherRemoved));
    }
    cout << setprecision(to_string(floor(totalDistance)).length() + 10) << totalDistance << endl;
    return 0;
}

long double getDistance(vector<int> a, vector<int> b) {
    return sqrtl((long double) pow((long double) (a[0] - b[0]), 2) + pow((long double) a[1] - b[1], 2));
}
