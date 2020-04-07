#include <bits/stdc++.h>
using namespace std;

vector<int> solution(vector<int> arr) 
{
    vector<int> answer;
    int cur=-1;
    for(int i=0;i<arr.size();i++){
        if(arr[i]!=cur){
            cur = arr[i];
            answer.push_back(cur);
        }
    }
    return answer;
}

int main(){
    vector<int> arr = {1,1,3,3,0,1,1};
    vector<int> answer = solution(arr);
    for(int i=0;i<answer.size();i++){
        cout << answer[i] << " ";
    }
    cout << "\n";

    arr = {4,4,4,3,3};
    answer = solution(arr);
    for(int i=0;i<answer.size();i++){
        cout << answer[i] << " ";
    }
    cout << "\n";
}