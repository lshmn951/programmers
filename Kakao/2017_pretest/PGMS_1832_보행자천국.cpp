#include <bits/stdc++.h>
using namespace std;

int MOD = 20170805;
int arr[500][500];
int find(int r,int c,int d,vector<vector<int>> &city_map){
    if(d==0){//왼쪽에서 오른쪽
        int temp = 0;
        for(int i=c;i>=0;i--){
            if(city_map[r][i]!=2){
                temp = arr[r][i];
                break;
            }
        }
        return temp;
    }
    if(d==1){//위에서 아래
        int temp = 0;
        for(int i=r;i>=0;i--){
            if(city_map[i][c]!=2){
                temp = arr[i][c];
                break;
            }
        }
        return temp;
    }
}

int solution(int m, int n, vector<vector<int>> city_map) {
    for(int i=0;i<m;i++){
        fill(arr[i],arr[i]+n,0);//전역 변수 초기화
    }
    if(m==1 && n==1){
        return 1;
    }
    arr[0][0] = 1;
    for(int i=1;i<n;i++){//가장 윗줄
        if(city_map[0][i]==1){
            arr[0][i] = 0;
        }
        else {
            arr[0][i] = arr[0][i-1];
        }
    }
    for(int i=1;i<m;i++){//가장 왼쪽줄
        if(city_map[i][0]==1){
            arr[i][0] = 0;
        }
        else {
            arr[i][0] = arr[i-1][0];
        }
    }
    for(int i=1;i<m;i++){
        for(int j=1;j<n;j++){
            if(city_map[i][j]==1){//1이면 갈 수 있는 방법이 0개
                arr[i][j]=0;
            }
            else {
                int x = find(i-1,j,1,city_map);//위에서 현재 위치로 올 수 있는 방법 수
                int y = find(i,j-1,0,city_map);//왼쪽에서 현재 위치로 올 수 있는 방법 수
                arr[i][j] = (x+y)%MOD;
            }
        }
    }
    return arr[m-1][n-1];
}

int main(void){
    cout << solution(3,3,{{0,0,0},{0,0,0},{0,0,0}});
    cout << "\n";
    cout << solution(3,6,{{0,2,0,0,0,2},{0,0,2,0,1,0},{1,0,0,2,2,0}});
}
