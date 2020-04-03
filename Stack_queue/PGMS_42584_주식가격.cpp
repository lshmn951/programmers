#include <bits/stdc++.h>
using namespace std;

vector<int> solution(vector<int> prices) {
    vector<int> answer;
    int count;
    for(int i=0;i<prices.size()-1;i++){
        count =0;
        for(int j=i+1;j<prices.size();j++){
            count++;
            if(prices[i]>prices[j]){
                answer.push_back(count);
                break;
            }
            else if(j==prices.size()-1){
                answer.push_back(count);
            }
        }
    }
    answer.push_back(0);
    return answer;
}

int main(){
    vector<int> answer = solution({1,2,3,2,3});
    for(auto a: answer){
        cout << a << " ";
    }
}