#include <bits/stdc++.h>
using namespace std;

long long count(long long mid,vector<int> &times){
    long long cnt=0;
    for(int i=0;i<times.size();i++){
        if(times[i]>mid){
            break;
        }
        else{
            cnt += mid/(long long)times[i];
        }
    }
    return cnt;
}

long long solution(int n, vector<int> times) {
    sort(times.begin(),times.end());
    long long start = 1;
    long long end = (long long)times.back() * (long long)n;
    long long mid;
    while(start<end){
        mid = (start+end)/2;
        if(count(mid,times)>=n){
            end = mid;
        }
        else{
            start = mid+1;
        }
    }
    return start;
}

int main(){
    cout << solution(6,{7,10});
}