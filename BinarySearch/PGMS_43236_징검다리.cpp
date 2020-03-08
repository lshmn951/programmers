#include <bits/stdc++.h>
using namespace std;

int solution(int distance, vector<int> rocks, int n) {
    int answer = 0;
    sort(rocks.begin(), rocks.end());
    
    int left = 1;
    int right = distance;
    
    while (left <= right) {
        int mid = (left + right) / 2;
        int remove = 0;
        int lastRocksIdx = -1;
        for (int i = 0; i <= rocks.size(); ++i) {
            int d = lastRocksIdx == -1 ? rocks[i] : 
            i == rocks.size() ? distance - rocks.back() : rocks[i] - rocks[lastRocksIdx];
            
            if (d < mid) {
                remove++;
            }
            else lastRocksIdx = i;
        }
        
        if (remove > n) {
            right = mid - 1;
        } else if (remove <= n) {
            left = mid + 1;
            answer = answer < mid ? mid : answer;
        }
    }
    
    return answer;
}


int main(){
    cout << solution(25,{2,14,11,21,17},2);
}