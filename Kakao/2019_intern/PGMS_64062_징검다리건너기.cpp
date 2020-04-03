#include <bits/stdc++.h>
using namespace std;

bool check(int mid,vector<int> &stones,int k,int size){
    int cnt=0;
    for(int i=0;i<size;i++){
        if(stones[i]-mid+1<=0){
            cnt++;
        }
        else{
            cnt=0;
        }
        if(cnt>=k){
            return false;
        }
    }
    return true;
}

int solution(vector<int> stones, int k) {
    int size = stones.size();
    int left = 0;
    int right = 200000000;
    int mid;
    while(left<right){
        mid = (left+right)/2;
        if(check(mid,stones,k,size)){
            left = mid+1;
        }
        else{
            right = mid;
        }
    }
    return --left;
}

int main(){
    vector<int> stones = {2, 4, 5, 3, 2, 1, 4, 2, 5, 1};
    cout << solution(stones,3);
}