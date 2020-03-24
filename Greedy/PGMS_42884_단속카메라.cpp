#include <bits/stdc++.h>
using namespace std;

bool compare(vector<int> v1,vector<int> v2){
    return v1[1]<v2[1];
}

int solution(vector<vector<int>> routes) {
    int answer = 0;
    sort(routes.begin(),routes.end(),compare);
    while(!routes.empty()){
        int che = routes[0][1];
        answer++;
        for(int i=0;i<routes.size();i++){
            if(routes[i][0]<=che){
                routes.erase(routes.begin()+i);
                i--;
            }
        }
    }
    return answer;
}

int main(){
    cout << solution({{-20,15},{-14,-5},{-18,-13},{-5,-3}});

}