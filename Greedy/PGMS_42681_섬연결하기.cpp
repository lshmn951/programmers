#include <bits/stdc++.h>
using namespace std;

int find(int x,int p[]){
    if(p[x]==x) {
        return x;
    }
    else { 
        return p[x] = find(p[x],p);
    }
}

bool is_group(int x,int y,int p[]){
    int u = find(x,p);
    int v = find(y,p);
    if(u==v) {
        return true;
    }
    p[v] = p[u];
    return false;
}

bool compare(vector<int> a,vector<int> b){
    return a[2]<b[2];
}

int solution(int n, vector<vector<int>> costs) {
    int answer = 0;
    int p[n];
    for(int i=0;i<n;i++){
        p[i] = i;
    }
    sort(costs.begin(),costs.end(),compare);
    int size = costs.size();
    for(int i=0;i<size;i++){
        if(!is_group(costs[i][0],costs[i][1],p)){
            answer+=costs[i][2];
        }
    }
    return answer;
}

int main(){
    cout << solution(4,{{0,1,1},{0,2,2},{1,2,5},{1,3,1},{2,3,8}});
}