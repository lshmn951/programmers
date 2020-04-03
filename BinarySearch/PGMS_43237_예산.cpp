#include <bits/stdc++.h>
using namespace std;

bool sums(vector<int> &budgets,int num,int M){
    int size = budgets.size();
    for(int i=0;i<size;i++){
        if(budgets[i]<num){
            M-=budgets[i];
        }
        else{
            M-=num;
        }

        if(M<0){
            return false;
        }
    }
    return true;
}

int solution(vector<int> budgets, int M) {
    sort(budgets.begin(),budgets.end());
    if(sums(budgets,M,M)){
        return budgets.back();
    }
    int st = 1;
    int end = budgets.back();
    int mid;
    while(st<end){
        mid = (st+end)/2;
        if(!sums(budgets,mid,M)){
            end = mid;
        }
        else{
            st = mid+1;
        }
    }
    return --st;
}

int main(){
    cout << solution({120,110,140,150},485);
}