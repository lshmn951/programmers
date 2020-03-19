#include <bits/stdc++.h>
using namespace std;

int solution(int K, vector<vector<int>> travel) {
    int answer = 0;
    int size = travel.size();
    int visit[size][K+1];
    for(int i=0;i<size;i++){
        fill(visit[i],visit[i]+K+1,-1);
    }
    visit[0][travel[0][0]] = travel[0][1];
    visit[0][travel[0][2]] = travel[0][3];
    for(int i=1;i<size;i++){
        for(int j=0;j<=K;j++){
            if(visit[i-1][j]==-1){
                continue;
            }
            if(j+travel[i][0]<=K){
                visit[i][j+travel[i][0]] = max(visit[i][j+travel[i][0]],visit[i-1][j]+travel[i][1]);
                answer = max(answer,visit[i][j+travel[i][0]]);
            }
            if(j+travel[i][2]<=K){
                visit[i][j+travel[i][2]] = max(visit[i][j+travel[i][2]],visit[i-1][j]+travel[i][3]);
                answer = max(answer,visit[i][j+travel[i][2]]);
            }
        }
    }
    return answer;
}

int main(void){
    cout << solution(1650,{{500,200,200,100},{800,370,300,120},{700,250,300,90}}) <<"\n";
    cout << solution(3000,{{1000,2000,300,700},{1100,1900,400,900},{900,1800,400,700},{1200,2300,500,1200}}) <<"\n";
}