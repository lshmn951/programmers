#include <bits/stdc++.h>

using namespace std;

void check(vector<vector<int>> &temp,int cur,bool *visit,int &num){
    for(int i=0;i<temp[cur].size();i++){
        int des = temp[cur][i];
        if(!visit[des]){
            visit[des] = true;
            num++;
            check(temp,des,visit,num);
        }
    }
}
int solution(int n, vector<vector<int>> results) {
    int answer = 0;
    vector<vector<int>> win(n+1);
    vector<vector<int>> lose(n+1);
    for(int i=0;i<results.size();i++){
        int w = results[i][0];
        int l = results[i][1];
        win[w].push_back(l);
        lose[l].push_back(w);
    }
    bool visit[n+1];
    int num;
    for(int i=1;i<=n;i++){
        fill(visit,visit+n+1,false);
        num = 0;
        visit[i] = true;
        check(win,i,visit,num);
        check(lose,i,visit,num);
        if(num==n-1){
            answer++;
        }
    }
    return answer;
}

int main(){
    int n = 5;
    vector<vector<int>> results = {{4,3},{4,2},{3,2},{1,2},{2,5}};
    //vector<vector<int>> results={{1,2},{2,3},{3,4},{4,5},{5,6},{6,7},{7,8}};
    int res = solution(n,results);
    cout << res;

}
